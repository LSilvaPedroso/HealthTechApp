using Fiap.RestFul.Connections;
using Fiap.RestFul.Models;
using Oracle.ManagedDataAccess.Client;

namespace Fiap.RestFul.Repository
{
    public class MedicoRepository
    {
        private readonly IConfiguration _configuration;
        private readonly OracleDatabase _dbConnection;

        public MedicoRepository(IConfiguration configuration, OracleDatabase dbConnection)
        {
            _configuration = configuration;
            _dbConnection = dbConnection;
        }
        public List<MedicoModel> FindAll()
        {
            HospitalModel Hospital = new HospitalModel();
            Hospital.HospitalId = 1;
            Hospital.HospitalName = "Hospital Adam Sandler II";
            Hospital.Cnpj = 123456761;
            Hospital.HospitalEndereco = "Rua Edivaldo Augusto, 32";
            Hospital.Estado = "São Paulo";
            Hospital.Cidade = "São Paulo";
            Hospital.Uf = "SP";
            Hospital.Cep = 060010;

            HospitalModel HospitalDois = new HospitalModel();
            HospitalDois.HospitalId = 2;
            HospitalDois.HospitalName = "Hospital Adam Sandler III";
            HospitalDois.Cnpj = 123476757;
            HospitalDois.HospitalEndereco = "Rua Lucio Alcantara, 962";
            HospitalDois.Estado = "São Paulo";
            HospitalDois.Cidade = "Ibiuna";
            HospitalDois.Uf = "SP";
            HospitalDois.Cep = 060011;

            MedicoModel Medico = new MedicoModel();
            Medico.MedicoId = 1;
            Medico.MedicoName = "John Carmack";
            Medico.Crm = 123456;
            Medico.Hospital = Hospital;

            MedicoModel MedicoDois = new MedicoModel();
            MedicoDois.MedicoId = 2;
            MedicoDois.MedicoName = "John Cena";
            MedicoDois.Crm = 123457;
            MedicoDois.Hospital = HospitalDois;

            List<MedicoModel> listaMedicos = new List<MedicoModel>();
            listaMedicos.Add(Medico);
            listaMedicos.Add(MedicoDois);

            return listaMedicos;
        }

        public void AdicionarMedico(string nome, int idade)
        {
            try
            {
                _dbConnection.OpenConnection();

                // Crie uma instrução SQL de inserção para adicionar uma pessoa à tabela
                string sqlInsert = "INSERT INTO SuaTabela (Nome, Idade) VALUES (:nome, :idade)";

                using (OracleCommand command = new OracleCommand(sqlInsert, _dbConnection.GetConnection()))
                {
                    command.Parameters.Add(new OracleParameter(":nome", OracleDbType.Varchar2, nome, System.Data.ParameterDirection.Input));
                    command.Parameters.Add(new OracleParameter(":idade", OracleDbType.Int32, idade, System.Data.ParameterDirection.Input));

                    int rowsAffected = command.ExecuteNonQuery();
                    Console.WriteLine($"Linhas afetadas: {rowsAffected}");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Erro ao adicionar pessoa: " + ex.Message);
            }
            finally
            {
                _dbConnection.CloseConnection();
            }
        }

        // public List<MedicoModel> FindAll()
        //{
        //    List<MedicoModel> pessoas = new List<MedicoModel>();

        //    try
        //    {
        //        _dbConnection.OpenConnection();

        //        // Crie uma instrução SQL para recuperar todas as pessoas da tabela
        //        string sqlQuery = "SELECT ID_MEDICO, NM_MEDICO, NR_CRM, DT_CONTRATACAO, DT_NASCIMENTO FROM t_medico;"; 

        //        using (OracleCommand command = new OracleCommand(sqlQuery, _dbConnection.GetConnection()))
        //        {
        //            using (OracleDataReader reader = command.ExecuteReader())
        //            {
        //                while (reader.Read())
        //                {
        //                    // Mapear os resultados para objetos Pessoa
        //                    MedicoModel pessoa = new MedicoModel
        //                    {
        //                        MedicoId = Convert.ToInt32(reader["ID_MEDICO"]),
        //                        MedicoName = reader["NM_MEDICO"].ToString(),
        //                        Crm = Convert.ToInt32(reader["NR_CRM"]),
        //                        DataNascimento = Convert.ToDateTime(reader["DT_NASCIMENTO"]),
        //                        DataContratacao = Convert.ToDateTime(reader["DT_CONTRATACAO"]),
        //                    };
        //                    pessoas.Add(pessoa);
        //                }
        //            }
        //        }
        //    }
        //    catch (Exception ex)
        //    {
        //        Console.WriteLine("Erro ao obter todas as pessoas: " + ex.Message);
        //    }
        //    finally
        //    {
        //        _dbConnection.CloseConnection();
        //    }

        //    return pessoas;
        //}
    }
}
