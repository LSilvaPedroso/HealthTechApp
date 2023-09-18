using Fiap.RestFul.Models;
using Fiap.RestFul.Repository;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Fiap.RestFul.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class HospitalController : ControllerBase
    {
        private readonly HospitalRepository hospitalRepository;

        public HospitalController()
        {
            hospitalRepository = new HospitalRepository();
        }
        // GET: api/<HospitalController>
        [HttpGet]
        public ActionResult<IEnumerable<HospitalModel>> Get()
        {
            var listaMed = hospitalRepository.FindAll();
            return Ok(listaMed);
        }

        // GET api/<HospitalController>/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value";
        }

        // POST api/<HospitalController>
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/<HospitalController>/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/<HospitalController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
