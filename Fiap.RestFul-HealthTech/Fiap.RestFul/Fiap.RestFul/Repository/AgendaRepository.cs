using Fiap.RestFul.Models;

namespace Fiap.RestFul.Repository
{
    public class AgendaRepository
    {
        public List<AgendaModel> FindAll()
        {
            AgendaModel Agenda = new AgendaModel();
            Agenda.AgendaId = 1;
            Agenda.PacienteId = 1;
            Agenda.MedicoId = 1;
            DateTime? date = DateTime.Parse("22/04/2023");
            Agenda.DataEntrada = (DateTime)date;
            

            AgendaModel AgendaDois = new AgendaModel();
            AgendaDois.AgendaId = 2;
            AgendaDois.PacienteId = 2;
            AgendaDois.MedicoId = 1;
            DateTime? dateDois = DateTime.Parse("04/04/2023");
            AgendaDois.DataEntrada = (DateTime)dateDois;
            DateTime? dateTres = DateTime.Parse("04/04/2023");
            AgendaDois.DataSaida = (DateTime)dateTres;

            AgendaModel AgendaTres = new AgendaModel();
            AgendaTres.AgendaId = 3;
            AgendaTres.PacienteId = 3;
            AgendaTres.MedicoId = 2;
            AgendaTres.DataEntrada = (DateTime)date;

            AgendaModel AgendaQuatro = new AgendaModel();
            Agenda.AgendaId = 4;
            Agenda.PacienteId = 4;
            Agenda.MedicoId = 1;
            Agenda.DataEntrada = (DateTime)date;

            List<AgendaModel> listaHospitais = new List<AgendaModel>();
            listaHospitais.Add(Agenda);
            listaHospitais.Add(AgendaDois);
            listaHospitais.Add(AgendaTres);
            listaHospitais.Add(AgendaQuatro);

            return listaHospitais;
        }
    }
}
