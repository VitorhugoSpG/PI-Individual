package model;

public class Hardware {
    private Integer idHardware;
    private Integer fkUnidade;
    private Integer fkCliente;
    private String numeroSerie;
    private String so;

    public Hardware(Integer idHardware, Integer fkUnidade, Integer fkCliente, String numeroSerie, String so) {
        this.idHardware = idHardware;
        this.fkUnidade = fkUnidade;
        this.fkCliente = fkCliente;
        this.numeroSerie = numeroSerie;
        this.so = so;
    }

    public Hardware() {
    }
    
    public Integer getIdHardware() {
        return idHardware;
    }

    public void setIdHardware(Integer idHardware) {
        this.idHardware = idHardware;
    }

    public Integer getFkUnidade() {
        return fkUnidade;
    }

    public void setFkUnidade(Integer fkUnidade) {
        this.fkUnidade = fkUnidade;
    }

    public Integer getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Integer fkCliente) {
        this.fkCliente = fkCliente;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    @Override
    public String toString() {
        return "Hardware{" + "idHardware=" + idHardware + ", fkUnidade=" + fkUnidade + ", fkCliente=" + fkCliente + ", numeroSerie=" + numeroSerie + ", so=" + so + '}';
    }
    
}
