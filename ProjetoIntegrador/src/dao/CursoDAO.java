package dao;

import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Curso;

/**
 *
 * @author Giseli e Keyve
 */
public class CursoDAO {

    public boolean cadastrar(Curso curso) throws SQLException {
        PreparedStatement pstm;
        String sqlInserir = "INSERT INTO Curso (nome, descricao, eixoTecnologico, cargaHoraria, status)"
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
        return true;
    }

    public void atualizar(Curso curso) throws SQLException {
        PreparedStatement pstm;
        String sqlAtualizar = "UPDATE Curso c SET c.nome = ?, c.descricao = ?, c.eixoTecnologico = ?,"
                + " c.cargaHoraria = ?, c.status = ?"
                + " WHERE c.idCurso = ?;";
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
    }

    public void remover(Curso curso) throws SQLException {
        PreparedStatement pstm;
        String sqlRemover = "DELETE FROM Curso WHERE idCurso = ?;";
        pstm = DBConnection.getConnection().prepareStatement(sqlRemover);
        pstm.setInt(1, curso.getId());
        pstm.executeUpdate();
        pstm.close();
        DBConnection.close();
    }

    public Curso buscarPorNome(String nome) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlBuscar = "SELECT * FROM Curso c WHERE nome LIKE '" + nome + "%';";
        pstm = DBConnection.getConnection().prepareStatement(sqlBuscar);
        rs = pstm.executeQuery();
        Curso curso;
        while (rs.next()) {
            curso = transformarResultSet(rs);
            return curso;
        }
        return null;
    }

    public Curso buscarPorId(int idCurso) throws SQLException {
        PreparedStatement pstm;
        String sqlCurso = "SELECT * FROM Curso c WHERE c.idCurso = ?;";
        pstm = DBConnection.getConnection().prepareStatement(sqlCurso);
        pstm.setInt(1, idCurso);
        pstm.execute();
        ResultSet rs = pstm.getResultSet();
        Curso curso;
        if (rs.first()) {
            curso = transformarResultSet(rs);
            return curso;
        } else {
            return null;
        }
    }

    public List<Curso> listarTodos() throws SQLException {
        PreparedStatement pstm;
        List<Curso> cursos = new ArrayList<>();
        ResultSet rs;
        String sqlListar = "SELECT * FROM Curso c ORDER BY c.nome;";
        pstm = DBConnection.getConnection().prepareStatement(sqlListar);
        rs = pstm.executeQuery();
        while (rs.next()) {
            Curso curso = transformarResultSet(rs);
            cursos.add(curso);
        }
        pstm.close();
        DBConnection.close();
        return cursos;
    }

    public Curso transformarResultSet(ResultSet rs) throws SQLException {
        Curso curso = new Curso(rs.getInt("c.idCurso"),
                rs.getString("c.nome"),
                rs.getString("c.descricao"),
                rs.getString("c.eixoTecnologico"),
                rs.getString("c.cargaHoraria"),
                rs.getBoolean("c.status"));
        return curso;
    }

    public List<Curso> consultarSQL(String sql) throws SQLException {
        List<Curso> cursos = new ArrayList<>();
        PreparedStatement pstm;
        pstm = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Curso curso = transformarResultSet(rs);
            cursos.add(curso);
        }
        pstm.close();
        DBConnection.close();
        return cursos;
    }
}
