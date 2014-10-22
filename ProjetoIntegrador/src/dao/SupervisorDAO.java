package dao;

import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ContaBancaria;
import model.Endereco;
import model.Supervisor;

/**
 *
 * @author Giseli e Keyve
 */
public class SupervisorDAO {

    public boolean cadastrar(Supervisor supervisor) throws SQLException {
        int idEndereco = inserirEndereco(supervisor);
        int idContaBancaria = inserirContaBancaria(supervisor);
        PreparedStatement pstm;
        String sqlSupervisor = "INSERT INTO supervisor "
                + "(nome, cpf, rg, titulacao, telefone, email, dataEntrada, status, idEndereco, idContaBancaria)"
                + " VALUES (?, ?, ?, ?, ?, ?,?,?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlSupervisor);
        pstm.setString(1, supervisor.getNome());
        pstm.setString(2, supervisor.getCpf());
        pstm.setString(3, supervisor.getRg());
        pstm.setString(4, supervisor.getTitulacao());
        pstm.setString(5, supervisor.getTelefone());
        pstm.setString(6, supervisor.getEmail());
        pstm.setDate(7, new java.sql.Date(supervisor.getDataEntrada().getTime()));
        pstm.setBoolean(8, supervisor.isStatus());
        pstm.setInt(9, idEndereco);
        pstm.setInt(10, idContaBancaria);
        pstm.execute();
        pstm.close();
        DBConnection.close();
        return true;
    }

    private int inserirEndereco(Supervisor supervisor) throws SQLException {
        PreparedStatement pstm;
        String sqlEndereco = "INSERT INTO endereco (rua, numero, bairro, estado, cidade)"
                + " VALUES (?, ?, ?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlEndereco);
        pstm.setString(1, supervisor.getEndereco().getRua());
        pstm.setInt(2, supervisor.getEndereco().getNumero());
        pstm.setString(3, supervisor.getEndereco().getBairro());
        pstm.setString(4, supervisor.getEndereco().getEstado());
        pstm.setString(5, supervisor.getEndereco().getCidade());
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

    private int inserirContaBancaria(Supervisor supervisor) throws SQLException {
        PreparedStatement pstm;
        String sqlContaBancaria = "INSERT INTO contabancaria (nomeBanco, agencia, numero)"
                + " VALUES (?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlContaBancaria);
        pstm.setString(1, supervisor.getContaBancaria().getNomeBanco());
        pstm.setInt(2, supervisor.getContaBancaria().getAgencia());
        pstm.setInt(3, supervisor.getContaBancaria().getNumeroConta());
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

    public void atualizar(Supervisor supervisor) throws SQLException {
        PreparedStatement pstm;
        String sql;
        sql = "UPDATE supervisor o, endereco e, contabancaria cb SET o.nome = ?, o.cpf = ?, o.rg = ?, o.titulacao = ?, "
                + "o.telefone = ?, o.email = ?, o.dataEntrada = ?, o.status = ?, "
                + "e.rua = ?, e.numero = ?, e.bairro = ?, e.estado = ?, e.cidade = ?, "
                + "cb.nomeBanco = ?, cb.agencia = ?, cb.numero = ? "
                + "WHERE o.idSupervisor = ? AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";

        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setString(1, supervisor.getNome());
        pstm.setString(2, supervisor.getCpf());
        pstm.setString(3, supervisor.getRg());
        pstm.setString(4, supervisor.getTitulacao());
        pstm.setString(5, supervisor.getTelefone());
        pstm.setString(6, supervisor.getEmail());
        pstm.setDate(7, new java.sql.Date(supervisor.getDataEntrada().getTime()));
        pstm.setBoolean(8, supervisor.isStatus());

        pstm.setString(9, supervisor.getEndereco().getRua());
        pstm.setInt(10, supervisor.getEndereco().getNumero());
        pstm.setString(11, supervisor.getEndereco().getBairro());
        pstm.setString(12, supervisor.getEndereco().getEstado());
        pstm.setString(13, supervisor.getEndereco().getCidade());

        pstm.setString(14, supervisor.getContaBancaria().getNomeBanco());
        pstm.setInt(15, supervisor.getContaBancaria().getAgencia());
        pstm.setInt(16, supervisor.getContaBancaria().getNumeroConta());

        pstm.setInt(17, supervisor.getId());
        pstm.execute();

        DBConnection.close();
    }

    public void remover(Supervisor supervisor) throws SQLException {
        PreparedStatement pstm;
        String sql = "DELETE FROM supervisor WHERE idSupervisor = ?";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, supervisor.getId());
        pstm.execute();
        pstm.close();
        DBConnection.close();
    }

    public Supervisor buscarPorNome(String nome) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorNome = "SELECT * FROM Supervisor o, Endereco e, ContaBancaria cb "
                + "WHERE o.Nome LIKE \"" + nome + "%\" "
                + "AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorNome);
        rs = pstm.executeQuery();
        Supervisor supervisor;
        while (rs.next()) {
            supervisor = transformarResultSet(rs);
            return supervisor;
        }
        return null;
    }

    public Supervisor buscarPorCpf(String cpf) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorCpf = "SELECT * FROM Supervisor o, Endereco e, ContaBancaria cb "
                + "WHERE o.cpf = \"" + cpf + "\" "
                + "AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorCpf);
        rs = pstm.executeQuery();
        Supervisor supervisor;
        while (rs.next()) {
            supervisor = transformarResultSet(rs);
            return supervisor;
        }
        return null;
    }

    public Supervisor buscarPorRg(String rg) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorRg = "SELECT * FROM Supervisor o, Endereco e, ContaBancaria cb "
                + "WHERE o.rg = \"" + rg + "\" "
                + "AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorRg);
        rs = pstm.executeQuery();
        Supervisor supervisor;
        while (rs.next()) {
            supervisor = transformarResultSet(rs);
            return supervisor;
        }
        return null;
    }

    public Supervisor buscarPorId(int idSupervisor) throws SQLException {
        String sql = "SELECT * FROM Supervisor o, Endereco e, ContaBancaria cb "
                + "WHERE o.idSupervisor = ? "
                + "AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, idSupervisor);
        pstm.execute();
        ResultSet rs = pstm.getResultSet();
        Supervisor supervisor;
        if (rs.first()) {
            supervisor = transformarResultSet(rs);
            return supervisor;
        } else {
            return null;
        }
    }

    public List<Supervisor> listarTodos() throws SQLException {
        String sql = "SELECT * FROM supervisor o, endereco e, contabancaria cb;";
        List<Supervisor> listaSupervisor = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Supervisor supervisor;
        while (rs.next()) {
            supervisor = transformarResultSet(rs);
            listaSupervisor.add(supervisor);
        }
        return listaSupervisor;
    }

    public Supervisor transformarResultSet(ResultSet rs) throws SQLException {
        Supervisor supervisor = new Supervisor(
                rs.getInt("o.idSupervisor"),
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
        return supervisor;
    }

    public List<Supervisor> consultarSQL(String sql) throws SQLException {
        PreparedStatement pstm;
        List<Supervisor> supervisores = new ArrayList<>();
        pstm = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Supervisor supervisor = new Supervisor(
                    rs.getInt("o.idSupervisor"),
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
            supervisores.add(supervisor);
        }
        pstm.close();
        DBConnection.close();
        return supervisores;
    }
}
