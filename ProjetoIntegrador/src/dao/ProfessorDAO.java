package dao;

import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ContaBancaria;
import model.Endereco;
import model.Professor;

/**
 *
 * @author Giseli e Keyve
 */
public class ProfessorDAO {

    public boolean cadastrar(Professor professor) throws SQLException {
        int idEndereco = inserirEndereco(professor);
        int idContaBancaria = inserirContaBancaria(professor);
        PreparedStatement pstm;
        String sqlProfessor = "INSERT INTO professor "
                + "(nome, cpf, rg, titulacao, telefone, email, dataEntrada, status, idEndereco, idContaBancaria)"
                + " VALUES (?, ?, ?, ?, ?, ?,?,?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlProfessor);
        pstm.setString(1, professor.getNome());
        pstm.setString(2, professor.getCpf());
        pstm.setString(3, professor.getRg());
        pstm.setString(4, professor.getTitulacao());
        pstm.setString(5, professor.getTelefone());
        pstm.setString(6, professor.getEmail());
        pstm.setDate(7, new java.sql.Date(professor.getDataEntrada().getTime()));
        pstm.setBoolean(8, professor.isStatus());
        pstm.setInt(9, idEndereco);
        pstm.setInt(10, idContaBancaria);
        pstm.execute();
        pstm.close();
        DBConnection.close();
        return true;
    }

    private int inserirEndereco(Professor professor) throws SQLException {
        PreparedStatement pstm;
        String sqlEndereco = "INSERT INTO endereco (rua, numero, bairro, estado, cidade)"
                + " VALUES (?, ?, ?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlEndereco);
        pstm.setString(1, professor.getEndereco().getRua());
        pstm.setInt(2, professor.getEndereco().getNumero());
        pstm.setString(3, professor.getEndereco().getBairro());
        pstm.setString(4, professor.getEndereco().getEstado());
        pstm.setString(5, professor.getEndereco().getCidade());
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

    private int inserirContaBancaria(Professor professor) throws SQLException {
        PreparedStatement pstm;
        String sqlContaBancaria = "INSERT INTO contabancaria (nomeBanco, agencia, numero)"
                + " VALUES (?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlContaBancaria);
        pstm.setString(1, professor.getContaBancaria().getNomeBanco());
        pstm.setInt(2, professor.getContaBancaria().getAgencia());
        pstm.setInt(3, professor.getContaBancaria().getNumeroConta());
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

    public void atualizar(Professor professor) throws SQLException {
        PreparedStatement pstm;
        String sql;
        sql = "UPDATE professor o, endereco e, contabancaria cb SET o.nome = ?, o.cpf = ?, o.rg = ?, o.titulacao = ?, "
                + "o.telefone = ?, o.email = ?, o.dataEntrada = ?, o.status = ?, "
                + "e.rua = ?, e.numero = ?, e.bairro = ?, e.estado = ?, e.cidade = ?, "
                + "cb.nomeBanco = ?, cb.agencia = ?, cb.numero = ? "
                + "WHERE o.idProfessor = ? AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";

        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setString(1, professor.getNome());
        pstm.setString(2, professor.getCpf());
        pstm.setString(3, professor.getRg());
        pstm.setString(4, professor.getTitulacao());
        pstm.setString(5, professor.getTelefone());
        pstm.setString(6, professor.getEmail());
        pstm.setDate(7, new java.sql.Date(professor.getDataEntrada().getTime()));
        pstm.setBoolean(8, professor.isStatus());

        pstm.setString(9, professor.getEndereco().getRua());
        pstm.setInt(10, professor.getEndereco().getNumero());
        pstm.setString(11, professor.getEndereco().getBairro());
        pstm.setString(12, professor.getEndereco().getEstado());
        pstm.setString(13, professor.getEndereco().getCidade());

        pstm.setString(14, professor.getContaBancaria().getNomeBanco());
        pstm.setInt(15, professor.getContaBancaria().getAgencia());
        pstm.setInt(16, professor.getContaBancaria().getNumeroConta());

        pstm.setInt(17, professor.getId());
        pstm.execute();

        DBConnection.close();
    }

    public void remover(Professor professor) throws SQLException {
        PreparedStatement pstm;
        String sql = "DELETE FROM professor WHERE idProfessor = ?";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, professor.getId());
        pstm.execute();
        pstm.close();
        DBConnection.close();
    }

    public Professor buscarPorNome(String nome) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorNome = "SELECT * FROM Professor o, Endereco e, ContaBancaria cb "
                + "WHERE o.Nome LIKE \"" + nome + "%\" "
                + "AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorNome);
        rs = pstm.executeQuery();
        Professor professor;
        while (rs.next()) {
            professor = transformarResultSet(rs);
            return professor;
        }
        return null;
    }

    public Professor buscarPorCpf(String cpf) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorCpf = "SELECT * FROM Professor o, Endereco e, ContaBancaria cb "
                + "WHERE o.cpf = \"" + cpf + "\" "
                + "AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorCpf);
        rs = pstm.executeQuery();
        Professor professor;
        while (rs.next()) {
            professor = transformarResultSet(rs);
            return professor;
        }
        return null;
    }

    public Professor buscarPorRg(String rg) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorRg = "SELECT * FROM Professor o, Endereco e, ContaBancaria cb "
                + "WHERE o.rg = \"" + rg + "\" "
                + "AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorRg);
        rs = pstm.executeQuery();
        Professor professor;
        while (rs.next()) {
            professor = transformarResultSet(rs);
            return professor;
        }
        return null;
    }

    public Professor buscarPorId(int idProfessor) throws SQLException {
        String sql = "SELECT * FROM Professor o, Endereco e, ContaBancaria cb "
                + "WHERE o.idProfessor = ? "
                + "AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, idProfessor);
        pstm.execute();
        ResultSet rs = pstm.getResultSet();
        Professor professor;
        if (rs.first()) {
            professor = transformarResultSet(rs);
            return professor;
        } else {
            return null;
        }
    }

    public List<Professor> listarTodos() throws SQLException {
        String sql = "SELECT * FROM professor o, endereco e, contabancaria cb;";
        List<Professor> listaProfessor = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Professor professor;
        while (rs.next()) {
            professor = transformarResultSet(rs);
            listaProfessor.add(professor);
        }
        return listaProfessor;
    }

    public Professor transformarResultSet(ResultSet rs) throws SQLException {
        Professor professor = new Professor(
                rs.getInt("o.idProfessor"),
                rs.getString("o.nome"),
                rs.getString("o.cpf"),
                rs.getString("o.rg"),
                rs.getString("o.titulacao"),
                rs.getString("o.telefone"),
                rs.getString("o.email"),
                rs.getBoolean("o.status"),
                rs.getDate("o.dataEntrada"),
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
        return professor;
    }

    public List<Professor> consultarSQL(String sql) throws SQLException {
        PreparedStatement pstm;
        List<Professor> professores = new ArrayList<>();
        pstm = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Professor professor = new Professor(
                    rs.getInt("o.idProfessor"),
                    rs.getString("o.nome"),
                    rs.getString("o.cpf"),
                    rs.getString("o.rg"),
                    rs.getString("o.titulacao"),
                    rs.getString("o.telefone"),
                    rs.getString("o.email"),
                    rs.getBoolean("o.status"),
                    rs.getDate("o.dataEntrada"),
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
            professores.add(professor);
        }
        pstm.close();
        DBConnection.close();
        return professores;
    }
}
