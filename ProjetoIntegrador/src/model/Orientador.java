package model;

import java.util.Date;

/**
 *
 * @author Giseli e Keyve
 */
public class Orientador {

    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private String titulacao;
    private String telefone;
    private String email;
    private boolean status;
    private Date dataEntrada;
    private Endereco endereco;
    private ContaBancaria contaBancaria;

    public Orientador(int id, String nome, String cpf, String rg, String titulacao, String telefone, String email, boolean status, Date dataEntrada, Endereco endereco, ContaBancaria contaBancaria) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.titulacao = titulacao;
        this.telefone = telefone;
        this.email = email;
        this.status = status;
        this.dataEntrada = dataEntrada;
        this.endereco = endereco;
        this.contaBancaria = contaBancaria;
    }

    public Orientador(String nome, String cpf, String rg, String titulacao, String telefone, String email, boolean status, Date dataEntrada, Endereco endereco, ContaBancaria contaBancaria) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.titulacao = titulacao;
        this.telefone = telefone;
        this.email = email;
        this.status = status;
        this.dataEntrada = dataEntrada;
        this.endereco = endereco;
        this.contaBancaria = contaBancaria;
    }

    public Orientador() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
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
        final Orientador other = (Orientador) obj;
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
