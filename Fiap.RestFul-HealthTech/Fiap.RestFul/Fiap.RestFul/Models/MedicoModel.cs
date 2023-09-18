namespace Fiap.RestFul.Models
{
    public class MedicoModel
    {
        public int MedicoId { get; set; }
        public string MedicoName { get; set; }
        public int Crm { get; set; }
        public DateTime DataNascimento { get; set; }
        public DateTime DataContratacao { get; set; }
        public HospitalModel Hospital { get; set; }

        public MedicoModel(int medicoId, string medicoName, int crm, DateTime dataNascimento, DateTime dataContratacao)
        {
            MedicoId = medicoId;
            MedicoName = medicoName;
            Crm = crm;
            DataNascimento = dataNascimento;
            DataContratacao = dataContratacao;
        }

        public MedicoModel(string medicoName, int crm, DateTime dataNascimento, DateTime dataContratacao)
        {
            MedicoName = medicoName;
            Crm = crm;
            DataNascimento = dataNascimento;
            DataContratacao = dataContratacao;
        }

        public MedicoModel()
        {
        }

        public MedicoModel(int medicoId, string medicoName, int crm, DateTime dataNascimento, DateTime dataContratacao, HospitalModel hospital) : this(medicoId, medicoName, crm, dataNascimento, dataContratacao)
        {
            Hospital = hospital;
        }
    }
}
 
