using Fiap.RestFul.Models;
using Fiap.RestFul.Repository;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Fiap.RestFul.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AgendaController : ControllerBase
    {
        private readonly AgendaRepository agendaRepository;

        public AgendaController()
        {
            agendaRepository = new AgendaRepository();
        }
        // GET: api/<AgendaController>
        [HttpGet]
        public ActionResult<IEnumerable<AgendaModel>> Get()
        {
            var listaMed = agendaRepository.FindAll();
            return Ok(listaMed);
        }

        // GET api/<AgendaController>/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value";
        }

        // POST api/<AgendaController>
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/<AgendaController>/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/<AgendaController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
