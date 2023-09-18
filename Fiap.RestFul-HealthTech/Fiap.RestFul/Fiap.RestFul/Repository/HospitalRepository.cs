using Fiap.RestFul.Models;

namespace Fiap.RestFul.Repository
{
    public class HospitalRepository
    {
        public List<HospitalModel> FindAll()
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

            List<HospitalModel> listaHospitais = new List<HospitalModel>();
            listaHospitais.Add(Hospital);
            listaHospitais.Add(HospitalDois);

            return listaHospitais;
        }
    }
}
