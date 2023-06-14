package service;

import org.springframework.jdbc.core.JdbcTemplate;
import connection.MySql;

public class QueryMySql {
    MySql sql = new MySql();
        JdbcTemplate con = sql.getConnection();
        
        public void setRegistro(Integer componente1, Integer componente2, Integer componente3, Integer hardware, Integer unidade, 
                Integer cliente, Integer modelo1, Integer modelo2, Integer modelo3, Double cpu, Double memoria, Double disco){
            con.update("insert into metrica (fkComponente, fkHardware, fkUnidade, fkCliente, fkModeloComponente, porcentagemUso, dtHora) values "
                + "(?, ?, ?, ?, ?, ?, current_timestamp),"
                + "(?, ?, ?, ?, ?, ?, current_timestamp),"
                + "(?, ?, ?, ?, ?, ?, current_timestamp);",
                componente1, hardware, unidade, cliente, modelo1, cpu,
                componente2, hardware, unidade, cliente, modelo2, memoria,
                componente3, hardware, unidade, cliente, modelo3, disco);   
        }
}
