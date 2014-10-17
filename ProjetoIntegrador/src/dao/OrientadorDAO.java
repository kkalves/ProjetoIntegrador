package dao;

import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ContaBancaria;
import model.Endereco;
import model.Orientador;

/**
 *
 * @author Giseli e Keyve
 */
public class OrientadorDAO {

    public boolean cadastrar(Orientador orientador) throws SQLException {
        int idEndereco = inserirEndereco(orientador);
        int idContaBancaria = inserirContaBancaria(orientador);
        PreparedStatement pstm;
        String sqlOrientador = "INSERT INTO orientador "
                + "(nome, cpf, rg, titulacao, telefone, email, dataEntrada, status, idEndereco, idContaBancaria)"
                + " VALUES (?, ?, ?, ?, ?, ?,?,?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlOrientador);
        pstm.setString(1, orientador.getNome());
        pstm.setString(2, orientador.getCpf());
        pstm.setString(3, orientador.getRg());
        pstm.setString(4, orientador.getTitulacao());
        pstm.setString(5, orientador.getTelefone());
        pstm.setString(6, orientador.getEmail());
        pstm.setDate(7, new java.sql.Date(orientador.getDataEntrada().getTime()));
        pstm.setBoolean(8, orientador.isStatus());
        pstm.setInt(9, idEndereco);
        pstm.setInt(10, idContaBancaria);
        pstm.execute();
        pstm.close();
        DBConnection.close();
        return true;
    }

    private int inserirEndereco(Orientador orientador) throws SQLException {
        PreparedStatement pstm;
        String sqlEndereco = "INSERT INTO endereco (rua, numero, bairro, estado, cidade)"
                + " VALUES (?, ?, ?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlEndereco);
        pstm.setString(1, orientador.getEndereco().getRua());
        pstm.setInt(2, orientador.getEndereco().getNumero());
        pstm.setString(3, orientador.getEndereco().getBairro());
        pstm.setString(4, orientador.getEndereco().getEstado());
        pstm.setString(5, orientador.getEndereco().getCidade());
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

    private int inserirContaBancaria(Orientador orientador) throws SQLException {
        PreparedStatement pstm;
        String sqlContaBancaria = "INSERT INTO contabancaria (nomeBanco, agencia, numero)"
                + " VALUES (?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlContaBancaria);
        pstm.setString(1, orientador.getContaBancaria().getNomeBanco());
        pstm.setInt(2, orientador.getContaBancaria().getAgencia());
        pstm.setInt(3, orientador.getContaBancaria().getNumeroConta());
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

    public void atualizar(Orientador orientador) throws SQLException {
        PreparedStatement pstm;
        String sql;
        sql = "UPDATE orientador o, endereco e, contabancaria cb SET o.nome = ?, o.cpf = ?, o.rg = ?, o.titulacao = ?, "
                + "o.telefone = ?, o.email = ?, o.dataEntrada = ?, o.status = ?, "
                + "e.rua = ?, e.numero = ?, e.bairro = ?, e.estado = ?, e.cidade = ?, "
                + "cb.nomeBanco = ?, cb.agencia = ?, cb.numero = ? "
                + "WHERE o.idOrientador = ? AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";

        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setString(1, orientador.getNome());
        pstm.setString(2, orientador.getCpf());
        pstm.setString(3, orientador.getRg());
        pstm.setString(4, orientador.getTitulacao());
        pstm.setString(5, orientador.getTelefone());
        pstm.setString(6, orientador.getEmail());
        pstm.setDate(7, new java.sql.Date(orientador.getDataEntrada().getTime()));
        pstm.setBoolean(8, orientador.isStatus());

        pstm.setString(9, orientador.getEndereco().getRua());
        pstm.setInt(10, orientador.getEndereco().getNumero());
        pstm.setString(11, orientador.getEndereco().getBairro());
        pstm.setString(12, orientador.getEndereco().getEstado());
        pstm.setString(13, orientador.getEndereco().getCidade());

        pstm.setString(14, orientador.getContaBancaria().getNomeBanco());
        pstm.setInt(15, orientador.getContaBancaria().getAgencia());
        pstm.setInt(16, orientador.getContaBancaria().getNumeroConta());

        pstm.setInt(17, orientador.getId());
        pstm.execute();

        DBConnection.close();
    }

    public void remover(Orientador orientador) throws SQLException {
        PreparedStatement pstm;
        String sql = "DELETE FROM orientador WHERE idOrientador = ?";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, orientador.getId());
        pstm.execute();
        pstm.close();
        DBConnection.close();
    }

    public Orientador pesquisarPorCpf(String cpf) throws SQLException {
        ResultSet rs;
        PreparedStatement pstm;
        String sqlPesquisaPorCpf = "SELECT * FROM Orientador o, Endereco e, ContaBancaria cb "
                + "WHERE o.cpf ='" + cpf + "' "
                + "AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisaPorCpf);
        rs = pstm.executeQuery();
        Orientador orientador;
        while (rs.next()) {
            orientador = transformarResultSet(rs);
            return orientador;
        }
        return null;
    }

    public Orientador PesquisarPorId(int idOrientador) throws SQLException {
        String sql = "SELECT * FROM Orientador o, Endereco e, ContaBancaria cb "
                + "WHERE o.idOrientador = ? "
                + "AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, idOrientador);
        ResultSet rs = pstm.getResultSet();
        Orientador orientador;
        if (rs.first()) {
            orientador = transformarResultSet(rs);
            return orientador;
        } else {
            return null;
        }
    }

    public List<Orientador> listarTodos() throws SQLException{
        String sql = "SELECT * FROM orientador o, endereco e, contabancaria cb;";
        List<Orientador> listaOrientador = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Orientador orientador;
        while (rs.next()) {
            orientador = transformarResultSet(rs);
            listaOrientador.add(orientador);
        }
        return listaOrientador;
    }

    public Orientador transformarResultSet(ResultSet rs) throws SQLException {
        Orientador orientador = new Orientador(
                rs.getInt("o.idOrientador"),
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
        return orientador;
    }
    
    public List<Orientador> consultarSQL(String sql) throws SQLException {
        List<Orientador> orientadores = new ArrayList<>();
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Orientador orientador = transformarResultSet(rs);
            orientadores.add(orientador);
        }
        pstm.close();
        DBConnection.close();
        return orientadores;
    }
}