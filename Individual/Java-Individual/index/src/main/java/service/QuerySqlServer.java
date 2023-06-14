package service;

import api.LoocaApi;
import connection.Sql;
import java.util.List;
import mapper.ComponenteRowMapper;
import mapper.GestaoAcessoRowMapper;
import model.Componente;
import model.GestaoAcesso;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class QuerySqlServer {
    private final Sql sql = new Sql();
    private final JdbcTemplate con = sql.getConnection();
    private Componente c1;
    private Componente c2;
    private Componente c3;
    private String numSerie;
    private final LoocaApi loocaApi = new LoocaApi();
    private GestaoAcesso user;

    public GestaoAcesso getUser() {
        return user;
    }
    
    public void setUser(GestaoAcesso user){
        this.user = user;
    }

    public Componente getC1() {
        return c1;
    }

    public Componente getC2() {
        return c2;
    }

    public Componente getC3() {
        return c3;
    }
    
    public Boolean verificarLogin(String email, String senha){
        
        try{
            List<GestaoAcesso>acessos = con.query("exec realizar_login ?, ?",
            new GestaoAcessoRowMapper(), email, senha);
            user = acessos.get(0);
            return true;
        }catch(DataAccessException e){
            System.out.println(e);
            return false;
        }
  
    }
    
    public void getInfoComponentes(){
        numSerie = loocaApi.getNumSerie();
        
        List<Componente>componentes = con.query(
                "select c.id_componente, c.fk_hardware, c.fk_unidade, c.fk_cliente, c.fk_modelo_componente"
                + " from componente as c join hardware on id_hardware = c.fk_hardware where numero_serie = ?", 
                new ComponenteRowMapper(), numSerie);
        
        if(componentes.isEmpty()){
            con.update("exec inserir_hardware ?, ?, ?, ?, ?, ?, ?, ?, ?, ?;",
                    user.getIdCliente(), user.getIdUnidade(), numSerie, loocaApi.getSistemaOperacional(),
                    loocaApi.getModeloCpu(), loocaApi.getModeloDisco(), loocaApi.getModeloMemoria(),
                    loocaApi.getCapacidadeCpu(), loocaApi.getCapacidadeDisco(), loocaApi.getCapacidadeMemoria());
            
            List<Componente>componentesCadastrados = con.query(
                "select c.id_componente, c.fk_hardware, c.fk_unidade, c.fk_cliente, c.fk_modelo_componente"
                + " from componente as c join hardware on id_hardware = c.fk_hardware where numero_serie = ?", 
                new ComponenteRowMapper(), numSerie);
            
            c1 = componentesCadastrados.get(0);
            c2 = componentesCadastrados.get(1);
            c3 = componentesCadastrados.get(2);
            
            System.out.println("Novo hardware cadastrado no banco!");
        }else{
            c1 = componentes.get(0);
            c2 = componentes.get(1);
            c3 = componentes.get(2);
            
            System.out.println("Hardware já existente no banco!");
        }
    }
    
    public void setRegistros(Double cpu, Double memoria, Double disco){
        con.update("insert into metrica (fk_componente, fk_hardware, fk_unidade, fk_cliente, fk_modelo_componente, porcentagem_uso, dt_hora) values "
            + "(?, ?, ?, ?, ?, ?, dateadd(hour, -3, getdate())),"
            + "(?, ?, ?, ?, ?, ?, dateadd(hour, -3, getdate())),"
            + "(?, ?, ?, ?, ?, ?, dateadd(hour, -3, getdate()));",
            c1.getIdComponente(), c1.getFkHardware(), c1.getFkUnidade(), c1.getFkCliente(), c1.getFkModeloComponente(), cpu,
            c2.getIdComponente(), c2.getFkHardware(), c2.getFkUnidade(), c2.getFkCliente(), c2.getFkModeloComponente(), disco,
            c3.getIdComponente(), c3.getFkHardware(), c3.getFkUnidade(), c3.getFkCliente(), c3.getFkModeloComponente(), memoria
        );
    }
    
    public void setRegistrosRede(Double download, Double upload){
        con.update("insert into capturas_rede values "
                + "(?, ?, ?, ?, ?, dateadd(hour, -3, getdate()));",
                c1.getFkHardware(), c1.getFkUnidade(), c1.getFkCliente(), download, upload);
    }
    
}
