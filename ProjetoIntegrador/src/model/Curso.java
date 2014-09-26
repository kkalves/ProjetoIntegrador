package model;

/**
 *
 * @author Giseli e Keyve
 */
public class Curso {

    private int id;
    private String nome;
    private String descricao;
    private String eixoTecnologico;
    private String cargaHoraria;
    private boolean status;

    public Curso(int id, String nome, String descricao, String eixoTecnologico, String cargaHoraria, boolean status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.eixoTecnologico = eixoTecnologico;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
    }

    public Curso(String nome, String descricao, String eixoTecnologico, String cargaHoraria, boolean status) {
        this.nome = nome;
        this.descricao = descricao;
        this.eixoTecnologico = eixoTecnologico;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
    }

    public Curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEixoTecnologico() {
        return eixoTecnologico;
    }

    public void setEixoTecnologico(String eixoTecnologico) {
        this.eixoTecnologico = eixoTecnologico;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
