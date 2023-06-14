package mapper;

import model.Hardware;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class HardwareRowMapper implements RowMapper<Hardware> {
        
    @Override
    public Hardware mapRow(ResultSet rs, int rowNum) throws SQLException {
        Hardware hardware = new Hardware();
        hardware.setIdHardware(rs.getInt("id_hardware"));
        hardware.setFkUnidade(rs.getInt("fk_unidade"));
        hardware.setFkCliente(rs.getInt("fk_cliente"));
        hardware.setNumeroSerie(rs.getString("numero_serie"));
        hardware.setSo(rs.getString("so"));
        return hardware;
    }
}
