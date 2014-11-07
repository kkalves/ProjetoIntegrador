/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.ContaBancaria;
import model.Endereco;

/**
 *
 * @author Giseli e Keyve
 */
public class AlunoDAO {

    public boolean cadastrar(Aluno aluno) throws SQLException {
        int idEndereco = inserirEndereco(aluno);
        int idContaBancaria = inserirContaBancaria(aluno);
        PreparedStatement pstm;
        String sqlAluno = "INSERT INTO aluno "
                + "(nome, cpf, rg, telefone, email, escolaridade, observacao, situacao, dataNascimento, idEndereco, idContaBancaria)"
                + " VALUES (?, ?, ?, ?, ?, ?,?,?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlAluno);
        pstm.setString(1, aluno.getNome());
        pstm.setString(2, aluno.getCpf());
        pstm.setString(3, aluno.getRg());
        pstm.setString(4, aluno.getTelefone());
        pstm.setString(5, aluno.getEmail());
        pstm.setString(6, aluno.getEscolaridade());
        pstm.setString(7, aluno.getObservacoes());
        pstm.setDate(8, new java.sql.Date(aluno.getDataNascimento().getTime()));
        pstm.setString(9, aluno.getSituacao());
        pstm.setInt(10, idEndereco);
        pstm.setInt(11, idContaBancaria);
        pstm.execute();
        pstm.close();
        DBConnection.close();
        return true;
    }

    private int inserirEndereco(Aluno aluno) throws SQLException {
        PreparedStatement pstm;
        String sqlEndereco = "INSERT INTO endereco (rua, numero, bairro, estado, cidade)"
                + " VALUES (?, ?, ?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlEndereco);
        pstm.setString(1, aluno.getEndereco().getRua());
        pstm.setInt(2, aluno.getEndereco().getNumero());
        pstm.setString(3, aluno.getEndereco().getBairro());
        pstm.setString(4, aluno.getEndereco().getEstado());
        pstm.setString(5, aluno.getEndereco().getCidade());
        pstm.execute();
        ResultSet rs;
        int id = -1;
        String sqlPesquisa = "SELECT MAX(idEndereco) FROM Endereco;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisa);
        rs = pstm.executeQuery();
        if (rs.next()) {
            id = rs.getInt("MAX(idEndereco)");
        }
        return id;
    }

    private int inserirContaBancaria(Aluno aluno) throws SQLException {
        PreparedStatement pstm;
        String sqlContaBancaria = "INSERT INTO contabancaria (nomeBanco, agencia, numero)"
                + " VALUES (?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlContaBancaria);
        pstm.setString(1, aluno.getContaBancaria().getNomeBanco());
        pstm.setInt(2, aluno.getContaBancaria().getAgencia());
        pstm.setInt(3, aluno.getContaBancaria().getNumeroConta());
        pstm.execute();
        ResultSet rs;
        int id = -1;
        String sqlPesquisa = "SELECT MAX(idContaBancaria) FROM contabancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisa);
        rs = pstm.executeQuery();
        if (rs.next()) {
            id = rs.getInt("MAX(idContaBancaria)");
            return id;
        }
        return id;
    }

    public void atualizar(Aluno aluno) throws SQLException {
        PreparedStatement pstm;
        String sql = "UPDATE aluno a, endereco e, contabancaria cb SET a.nome = ?, a.cpf = ?, a.rg = ?, a.telefone = ?, "
                + "a.email = ?, a.escolaridade = ?, a.observacao = ?, a.situacao = ?, a.dataNascimento "
                + "e.rua = ?, e.numero = ?, e.bairro = ?, e.estado = ?, e.cidade = ?, "
                + "cb.nomeBanco = ?, cb.agencia = ?, cb.numero = ? "
                + "WHERE a.idAluno = ? AND a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;";

        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setString(1, aluno.getNome());
        pstm.setString(2, aluno.getCpf());
        pstm.setString(3, aluno.getRg());
        pstm.setString(4, aluno.getTelefone());
        pstm.setString(5, aluno.getEmail());
        pstm.setString(6, aluno.getEscolaridade());
        pstm.setString(7, aluno.getObservacoes());
        pstm.setDate(8, new java.sql.Date(aluno.getDataNascimento().getTime()));
        pstm.setString(9, aluno.getSituacao());

        pstm.setString(9, aluno.getEndereco().getRua());
        pstm.setInt(10, aluno.getEndereco().getNumero());
        pstm.setString(11, aluno.getEndereco().getBairro());
        pstm.setString(12, aluno.getEndereco().getEstado());
        pstm.setString(13, aluno.getEndereco().getCidade());

        pstm.setString(14, aluno.getContaBancaria().getNomeBanco());
        pstm.setInt(15, aluno.getContaBancaria().getAgencia());
        pstm.setInt(16, aluno.getContaBancaria().getNumeroConta());

        pstm.setInt(17, aluno.getId());
        pstm.execute();

        DBConnection.close();
    }

    public void remover(Aluno aluno) throws SQLException {
        PreparedStatement pstm;
        String sql = "DELETE FROM aluno WHERE idAluno = ?";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, aluno.getId());
        pstm.execute();
        pstm.close();
        DBConnection.close();
    }

    public Aluno buscarPorNome(String nome) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorNome = "SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                + "WHERE a.Nome LIKE \"" + nome + "%\" "
                + "AND a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorNome);
        rs = pstm.executeQuery();
        Aluno aluno;
        while (rs.next()) {
            aluno = transformarResultSet(rs);
            return aluno;
        }
        return null;
    }

    public Aluno buscarPorCpf(String cpf) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorCpf = "SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                + "WHERE a.cpf = \"" + cpf + "\" "
                + "AND a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorCpf);
        rs = pstm.executeQuery();
        Aluno aluno;
        while (rs.next()) {
            aluno = transformarResultSet(rs);
            return aluno;
        }
        return null;
    }

    public Aluno buscarPorRg(String rg) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorRg = "SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                + "WHERE a.rg = \"" + rg + "\" "
                + "AND a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorRg);
        rs = pstm.executeQuery();
        Aluno aluno;
        while (rs.next()) {
            aluno = transformarResultSet(rs);
            return aluno;
        }
        return null;
    }

    public Aluno buscarPorId(int idAluno) throws SQLException {
        String sql = "SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                + "WHERE a.idAluno = ? "
                + "AND a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, idAluno);
        pstm.execute();
        ResultSet rs = pstm.getResultSet();
        Aluno aluno;
        if (rs.first()) {
            aluno = transformarResultSet(rs);
            return aluno;
        } else {
            return null;
        }
    }

    public List<Aluno> listarTodos() throws SQLException {
        String sql = "SELECT * FROM aluno a, endereco e, contabancaria cb;";
        List<Aluno> listaAluno = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Aluno aluno;
        while (rs.next()) {
            aluno = transformarResultSet(rs);
            listaAluno.add(aluno);
        }
        return listaAluno;
    }

    public Aluno transformarResultSet(ResultSet rs) throws SQLException {
        Aluno aluno = new Aluno(
                rs.getInt("a.idAluno"),
                rs.getString("a.nome"),
                rs.getString("a.cpf"),
                rs.getString("a.rg"),
                rs.getString("a.telefone"),
                rs.getString("a.email"),
                rs.getString("a.escolaridade"),
                rs.getString("a.observacao"),
                rs.getString("a.situacao"),
                rs.getDate("a.dataEntrada"),
                new Endereco(
                        rs.getInt("e.idEndereco"),
                        rs.getString("e.rua"),
                        rs.getInt("e.numero"),
                        rs.getString("e.bairro"),
                        rs.getString("e.estado"),
                        rs.getString("e.cidade")
                ),
                new ContaBancaria(
                        rs.getInt("cb.idContaBancaria"),
                        rs.getString("cb.nomeBanco"),
                        rs.getInt("cb.agencia"),
                        rs.getInt("cb.numero")
                )
        );
        return aluno;
    }

    public List<Aluno> consultarSQL(String sql) throws SQLException {
        PreparedStatement pstm;
        List<Aluno> alunos = new ArrayList<>();
        pstm = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Aluno aluno = new Aluno(
                    rs.getInt("a.idAluno"),
                    rs.getString("a.nome"),
                    rs.getString("a.cpf"),
                    rs.getString("a.rg"),
                    rs.getString("a.telefone"),
                    rs.getString("a.email"),
                    rs.getString("a.escolaridade"),
                    rs.getString("a.observacao"),
                    rs.getString("a.situacao"),
                    rs.getDate("a.dataEntrada"),
                    new Endereco(
                            rs.getInt("e.idEndereco"),
                            rs.getString("e.rua"),
                            rs.getInt("e.numero"),
                            rs.getString("e.bairro"),
                            rs.getString("e.estado"),
                            rs.getString("e.cidade")
                    ),
                    new ContaBancaria(
                            rs.getInt("cb.idContaBancaria"),
                            rs.getString("cb.nomeBanco"),
                            rs.getInt("cb.agencia"),
                            rs.getInt("cb.numero")
                    )
            );
            alunos.add(aluno);
        }
        pstm.close();
        DBConnection.close();
        return alunos;
    }
}
