namespace Fiap.RestFul.Models
{
    public class PacienteModel
    {
        public int PacienteId { get; set; }
        public string PacienteName { get; set; }
        public long Cpf{ get; set; }
        public string PacienteEmail { get; set; }
        public string PacienteSenha { get; set; }

        public PacienteModel(int pacienteId, string pacienteName, int cpf, string pacienteEmail, string pacienteSenha)
        {
            PacienteId = pacienteId;
            PacienteName = pacienteName;
            Cpf = cpf;
            PacienteEmail = pacienteEmail;
            PacienteSenha = pacienteSenha;
        }

        public PacienteModel(string pacienteName, int cpf, string pacienteEmail, string pacienteSenha)
        {
            PacienteName = pacienteName;
            Cpf = cpf;
            PacienteEmail = pacienteEmail;
            PacienteSenha = pacienteSenha;
        }

        public PacienteModel()
        {
        }
    }
}
