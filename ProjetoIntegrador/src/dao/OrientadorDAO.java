package dao;

import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Orientador;
import model.ContaBancaria;
import model.Endereco;

public class OrientadorDAO {
    
    public boolean cadastrar(Orientador orientador) throws SQLException{
        int idEndereco = inserirEndereco(orientador);
        int idContaBancaria = inserirContaBancaria(orientador);
        PreparedStatement pstm = null;
        System.out.println("Chegou para cadastrar orientador");
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
        System.out.println(" Cadastrado com sucesso!");
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
        ResultSet rs = null;
        int id = -1;
        String sqlPesquisa = "SELECT MAX(idEndereco) FROM Endereco;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisa);
        rs = pstm.executeQuery();
        if (rs.next()) {
            id = rs.getInt("MAX(idEndereco)");
        }
        System.out.println("Inseriu Endereço!!!");
        return id;
    }

    private int inserirContaBancaria(Orientador orientador) throws SQLException{
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
        System.out.println("Inseriu Conta Bancaria!!!");
        return id;
    }

    public void atualizar(Orientador orientador) throws SQLException{
        PreparedStatement pstm;
        String sql;
        sql = "UPDATE orientador o, endereco e, contabancaria cb"
                + " SET o.nome = ?, o.cpf = ?, o.rg = ?, o.titulacao = ?, o.telefone = ?, o.email = ?, o.dataEntrada = ?,"
                + " o.status = ?, e.rua = ?, e.numero = ?, e.bairro = ?, e.estado = ?, e.cidade = ?, cb.nomeBanco = ?,"
                + " cb.agencia = ?, cb.numero = ?"
                + " WHERE o.idOrientador = ? AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;";
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
        pstm.close();
        DBConnection.close();
        System.out.println("Atualização realizada com sucesso!");
    }

    public void remover(int idOrientador) throws SQLException{
        PreparedStatement pstm;
        String sql = "DELETE FROM orientador WHERE idOrientador = ?;";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, idOrientador);
        pstm.execute();
        pstm.close();
        DBConnection.close();
        System.out.println("Removido com sucesso!");
    }

    public Orientador pesquisarPorCPF(String cpf) throws SQLException{
        PreparedStatement pstm;
        ResultSet rs;
        pstm = DBConnection.getConnection().prepareStatement("SELECT * FROM Orientador o, Endereco e, ContaBancaria cb "
                + "WHERE o.cpf = ? AND o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");
        pstm.setString(1, cpf);
        pstm.execute();
        rs = pstm.getResultSet();
        while (rs.next()) {
            Orientador orientador = new Orientador(
                    rs.getInt("o.idOrientador"),
                    rs.getString("o.nome"),
                    rs.getString("o.cpf"),
                    rs.getString("o.rg"),
                    rs.getString("o.titulacao"),
                    rs.getDate("o.dataEntrada"),
                    rs.getString("o.telefone"),
                    rs.getString("o.email"),
                    rs.getBoolean("o.status"),
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
        return null;
    }

    public List<Orientador> trazerTodosOrientador() throws SQLException{
        String sql = "SELECT * FROM ORIENTADOR";
        List<Orientador> listaOrientador = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Orientador a = Orientador(rs);
            listaOrientador.add(a);
        }
        return listaOrientador;
    }

    private Orientador Orientador(ResultSet rs) {
        Orientador orientador = new Orientador();
        Endereco endereco = new Endereco();
        ContaBancaria contaBancaria = new ContaBancaria();

        try {
            endereco.setId(rs.getInt("idEndereco"));
            endereco.setRua(rs.getString("Rua"));
            endereco.setNumero(rs.getInt("numero"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setEstado(rs.getString("estado"));

            contaBancaria.setId(rs.getInt("idContaBancaria"));
            contaBancaria.setNomeBanco(rs.getString("nomeBanco"));
            contaBancaria.setNumeroConta(rs.getInt("numeroConta"));
            contaBancaria.setAgencia(rs.getInt("agencia"));

            orientador.setId(rs.getInt("id"));
            orientador.setStatus(rs.getBoolean("Status"));
            orientador.setNome(rs.getString("nome"));
            orientador.setCpf(rs.getString("cpf"));
            orientador.setRg(rs.getString("rg"));
            orientador.setTitulacao(rs.getString("titulacao"));
            orientador.setTelefone(rs.getString("telefone"));
            orientador.setEmail(rs.getString("email"));
            orientador.setDataEntrada(rs.getDate("DataEntrada"));
            orientador.setEndereco(endereco);
            orientador.setContaBancaria(contaBancaria);
        } catch (SQLException ex) {
            System.out.println("ERRO");
        }
        return orientador;
    }

    @Override
    public String toString() {
        return "GerenciadorOrientador{" + '}';
    }

}
