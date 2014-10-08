package model;

/**
 *
 * @author Giseli e Keyve
 */
public class ContaBancaria {

    private int id;

    private String nomeBanco;
    private int agencia;
    private int numeroConta;

    public ContaBancaria(int id, String banco, int agencia, int numeroConta) {
        this.id = id;
        this.nomeBanco = banco;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
    }

    public ContaBancaria(String banco, int agencia, int numeroConta) {
        this.nomeBanco = banco;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
    }

    public ContaBancaria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

}
