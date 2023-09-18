namespace Fiap.RestFul.Models
{
    public class HospitalModel
    {
        public int HospitalId { get; set; }
        public string HospitalName { get; set; }
        public string HospitalEndereco { get; set; }
        public int Cnpj { get; set; }
        public int Cep { get; set; }
        public string Cidade { get; set; }
        public string Estado { get; set; }
        public string Uf { get; set; }

        public HospitalModel(int hospitalId, string hospitalName, string hospitalEndereco, int cnpj)
        {
            HospitalId = hospitalId;
            HospitalName = hospitalName;
            HospitalEndereco = hospitalEndereco;
            Cnpj = cnpj;
        }

        public HospitalModel()
        {
        }

        public HospitalModel(string hospitalName, string hospitalEndereco, int cnpj)
        {
            HospitalName = hospitalName;
            HospitalEndereco = hospitalEndereco;
            Cnpj = cnpj;
        }

        public HospitalModel(int hospitalId, string hospitalName, string hospitalEndereco, int cnpj, int cep, string cidade, string estado, string uf) : this(hospitalId, hospitalName, hospitalEndereco, cnpj)
        {
            Cep = cep;
            Cidade = cidade;
            Estado = estado;
            Uf = uf;
        }
    }
}
