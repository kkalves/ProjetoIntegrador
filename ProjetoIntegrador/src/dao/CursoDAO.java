package dao;

import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
import table.FormatoTabela;

/**
 *
 * @author Giseli e Keyve
 */
public class CursoDAO {

    public boolean cadastrar(Curso curso) throws SQLException {
        PreparedStatement pstm;
        String sqlInserir = "INSERT INTO curso (nome, descricao, eixoTecnologico, cargaHoraria, status)"
                + " VALUES (?, ?, ?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlInserir);
        pstm.setString(1, curso.getNome());
        pstm.setString(2, curso.getDescricao());
        pstm.setString(3, curso.getEixoTecnologico());
        pstm.setString(4, curso.getCargaHoraria());
        pstm.setBoolean(5, curso.isStatus());
        pstm.executeUpdate();
        pstm.close();
        DBConnection.close();
        System.out.println("Cadastrado com sucesso!");
        return true;
    }

    public void atualizar(Curso curso) throws SQLException {
        PreparedStatement pstm;
        String sqlAtualizar = "UPDATE curso SET nome = ?, descricao = ?, eixoTecnologico = ?, cargaHoraria = ?, status = ?"
                + " WHERE idCurso = ?;";
        pstm = DBConnection.getConnection().prepareStatement(sqlAtualizar);
        pstm.setString(1, curso.getNome());
        pstm.setString(2, curso.getDescricao());
        pstm.setString(3, curso.getEixoTecnologico());
        pstm.setString(4, curso.getCargaHoraria());
        pstm.setBoolean(5, curso.isStatus());
        pstm.setInt(6, curso.getId());
        pstm.executeUpdate();
        pstm.close();
        DBConnection.close();
        System.out.println("Atualizado com sucesso!");
    }

    public void remover(int id) throws SQLException {
        PreparedStatement pstm;
        String sqlRemover = "DELETE FROM curso WHERE idCurso = ?;";
        pstm = DBConnection.getConnection().prepareStatement(sqlRemover);
        pstm.setInt(1, id);
        pstm.executeUpdate();
        pstm.close();
        DBConnection.close();
        System.out.println("Removido com sucesso!");
    }

    public Curso buscarPorNome(String nome) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlBuscar = "SELECT * FROM curso WHERE nome LIKE '" + nome + "%';";
        pstm = DBConnection.getConnection().prepareStatement(sqlBuscar);
        rs = pstm.executeQuery();
        while (rs.next()) {
            Curso curso = new Curso(rs.getInt("idCurso"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getString("eixoTecnologico"),
                    rs.getString("cargaHoraria"),
                    rs.getBoolean("status"));
            return curso;
        }
        return null;
    }

    public Curso buscarPorId(int idCurso) throws SQLException {
        String sqlCurso = "SELECT * FROM curso c WHERE c.idCurso = ?;";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sqlCurso);
        pstm.setInt(1, idCurso);
        // Executamos a instrução de consulta do registro
        pstm.execute();
        // Colocamos o resultado da consulta em objeto específico
        ResultSet rs = pstm.getResultSet();
        Curso curso;
        if (rs.first()) {
            curso = new Curso(
                    rs.getInt("c.idCurso"),
                    rs.getString("c.nome"),
                    rs.getString("c.descricao"),
                    rs.getString("c.eixoTecnologico"),
                    rs.getString("c.cargaHoraria"),
                    rs.getBoolean("c.status")
            );
            return curso;
        } else {
            return null;
        }
    }

    public List<Curso> listarTodos() throws SQLException {
        PreparedStatement pstm;
        List<Curso> cursos = new ArrayList<>();
        ResultSet rs;
        String sqlListar = "SELECT * FROM curso ORDER BY nome;";
        pstm = DBConnection.getConnection().prepareStatement(sqlListar);
        rs = pstm.executeQuery();
        while (rs.next()) {
            Curso curso = new Curso(rs.getInt("idCurso"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getString("eixoTecnologico"),
                    rs.getString("cargaHoraria"),
                    rs.getBoolean("status"));
            cursos.add(curso);
        }
        pstm.close();
        DBConnection.close();
        return cursos;
    }

    public FormatoTabela consultarSQL(String sql) throws SQLException {
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.execute();

        ResultSet rs = pstm.getResultSet();
        ResultSetMetaData rsmd = rs.getMetaData();

        FormatoTabela tabela = new FormatoTabela();

        //Extrair o nome da coluna
        //Extrair o nome da coluna
        int qtdColunas = rsmd.getColumnCount();
        for (int i = 1; i < qtdColunas; i++) {
            tabela.getCabecalho().add(rsmd.getColumnName(i));
        }
        String[] linha;
        while (rs.next()) {
            //Inicializar o vetor linha
            linha = new String[qtdColunas];
            for (int i = 1; i <= qtdColunas; i++) {
                linha[i - 1] = rs.getString(i);
            }
            //Adiciona a linha ao dados a serem adicionados na tabela
            tabela.getDados().add(linha);
        }
        DBConnection.close();
        return tabela;
    }
}
