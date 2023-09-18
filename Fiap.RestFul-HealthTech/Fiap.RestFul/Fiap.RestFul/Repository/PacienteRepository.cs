using Fiap.RestFul.Models;

namespace Fiap.RestFul.Repository
{
    public class PacienteRepository
    {
        public List<PacienteModel> FindAll()
        {
            PacienteModel Paciente = new PacienteModel();
            Paciente.PacienteId = 1;
            Paciente.PacienteName = "Rob Schneider";
            Paciente.PacienteSenha = "Password123";
            Paciente.PacienteEmail = "Rob.Schneider@email.com";
            Paciente.Cpf = 6002892212;

            PacienteModel PacienteDois = new PacienteModel();
            PacienteDois.PacienteId = 2;
            PacienteDois.PacienteName = "Kevin James";
            PacienteDois.PacienteSenha = "PasswordSenha";
            PacienteDois.PacienteEmail = "Kevin.James@email.com";
            PacienteDois.Cpf = 7002892222;

            PacienteModel PacienteTres = new PacienteModel();
            PacienteTres.PacienteId = 3;
            PacienteTres.PacienteName = "Luciano Doug";
            PacienteTres.PacienteSenha = "P@ssw0rd";
            PacienteTres.PacienteEmail = "Luciano.Doug@email.com";
            PacienteTres.Cpf = 4002892098;

            PacienteModel PacienteQuatro = new PacienteModel();
            PacienteQuatro.PacienteId = 4;
            PacienteQuatro.PacienteName = "Almir Monteiro";
            PacienteQuatro.PacienteSenha = "12345678";
            PacienteQuatro.PacienteEmail = "Almir.Monteiro@email.com";
            PacienteQuatro.Cpf = 4002892873;

            PacienteModel PacienteCinco = new PacienteModel();
            PacienteCinco.PacienteId = 5;
            PacienteCinco.PacienteName = "Hilano Rodrigues";
            PacienteCinco.PacienteSenha = "9019129120912902190";
            PacienteCinco.PacienteEmail = "Hilano.Rodrigues@email.com";
            PacienteCinco.Cpf = 5402892212;

            List<PacienteModel> listaPacientes = new List<PacienteModel>();
            listaPacientes.Add(Paciente);
            listaPacientes.Add(PacienteDois);
            listaPacientes.Add(PacienteTres);
            listaPacientes.Add(PacienteQuatro);
            listaPacientes.Add(PacienteCinco);


            return listaPacientes;
        }

        public PacienteModel FindByEmail(string email)
        {
            PacienteModel Paciente = new PacienteModel();
            Paciente.PacienteId = 1;
            Paciente.PacienteName = "Rob Schneider";
            Paciente.PacienteSenha = "Password123";
            Paciente.PacienteEmail = "Rob.Schneider@email.com";
            Paciente.Cpf = 6002892212;

            PacienteModel PacienteDois = new PacienteModel();
            PacienteDois.PacienteId = 2;
            PacienteDois.PacienteName = "Kevin James";
            PacienteDois.PacienteSenha = "PasswordSenha";
            PacienteDois.PacienteEmail = "Kevin.James@email.com";
            PacienteDois.Cpf = 7002892222;

            PacienteModel PacienteTres = new PacienteModel();
            PacienteTres.PacienteId = 3;
            PacienteTres.PacienteName = "Luciano Doug";
            PacienteTres.PacienteSenha = "P@ssw0rd";
            PacienteTres.PacienteEmail = "Luciano.Doug@email.com";
            PacienteTres.Cpf = 4002892098;

            PacienteModel PacienteQuatro = new PacienteModel();
            PacienteQuatro.PacienteId = 4;
            PacienteQuatro.PacienteName = "Almir Monteiro";
            PacienteQuatro.PacienteSenha = "12345678";
            PacienteQuatro.PacienteEmail = "Almir.Monteiro@email.com";
            PacienteQuatro.Cpf = 4002892873;

            PacienteModel PacienteCinco = new PacienteModel();
            PacienteCinco.PacienteId = 5;
            PacienteCinco.PacienteName = "Hilano Rodrigues";
            PacienteCinco.PacienteSenha = "9019129120912902190";
            PacienteCinco.PacienteEmail = "Hilano.Rodrigues@email.com";
            PacienteCinco.Cpf = 5402892212;

            List<PacienteModel> listaPacientes = new List<PacienteModel>();
            listaPacientes.Add(Paciente);
            listaPacientes.Add(PacienteDois);
            listaPacientes.Add(PacienteTres);
            listaPacientes.Add(PacienteQuatro);
            listaPacientes.Add(PacienteCinco);

            PacienteModel paciente = listaPacientes.Find(x => x.PacienteEmail == email);

            return paciente;
        }
    }
}
