namespace Fiap.RestFul.Models
{
    public class AgendaModel
    {
        public int AgendaId { get; set; }
        public int PacienteId { get; set; }
        public int MedicoId { get; set; }
        public DateTime DataEntrada { get; set; }
        public DateTime DataSaida { get; set;}

        public AgendaModel(int agendaId, int pacienteId, int medicoId, DateTime dataEntrada, DateTime dataSaida)
        {
            AgendaId = agendaId;
            PacienteId = pacienteId;
            MedicoId = medicoId;
            DataEntrada = dataEntrada;
            DataSaida = dataSaida;
        }

        public AgendaModel(int pacienteId, int medicoId, DateTime dataEntrada, DateTime dataSaida)
        {
            PacienteId = pacienteId;
            MedicoId = medicoId;
            DataEntrada = dataEntrada;
            DataSaida = dataSaida;
        }

        public AgendaModel()
        {
        }
    }
}
