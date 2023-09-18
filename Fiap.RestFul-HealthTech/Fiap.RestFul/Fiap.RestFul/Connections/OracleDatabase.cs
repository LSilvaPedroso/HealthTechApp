using Oracle.ManagedDataAccess.Client;
using System;
using System.Data;

namespace Fiap.RestFul.Connections
{
    public class OracleDatabase
    {
        private readonly IConfiguration _configuration;
        private OracleConnection _connection;

        public OracleDatabase(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        public void OpenConnection()
        {
            string connectionString = _configuration.GetConnectionString("OracleConnectionString");
            _connection = new OracleConnection(connectionString);
            _connection.Open();
        }

        public void CloseConnection()
        {
            if (_connection != null && _connection.State == ConnectionState.Open)
            {
                _connection.Close();
                _connection.Dispose();
            }
        }

        public OracleConnection GetConnection()
        {
            if (_connection != null && _connection.State == ConnectionState.Open)
            {
                return _connection;
            }
            else
            {
                throw new InvalidOperationException("A conexão com o banco de dados não está aberta.");
            }
        }
    }


}
