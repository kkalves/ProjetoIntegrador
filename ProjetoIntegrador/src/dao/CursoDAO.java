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
        String sqlInserir = "INSERT INT curso (nome, descricao, eixoTecnologico, cargaHoraria, status)"
                + " VALUES (?, ?, ?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlInserir);
        pstm.setString(1, curso.getNome());
        pstm.setString(2, curso.getDescricao());
        pstm.setString(3, curso.getEixoTecnologico());
        pstm.setString(4, curso.getCargaHoraria());
        pstm.setBoolean(5, curso.isStatus());
        pstm.executeUpdate();
        pstm.close();
        DBConnection.fechar();
        System.out.println("Cadastrado com sucesso!");
        return true;
    }
    
    public void atualizar(Curso curso) throws SQLException {
        PreparedStatement pstm;
        String sqlAtualizar = "UPDATE orientador SET nome = ?, descricao = ?, eixoTecnologico = ?, cargaHoraria = ?, status = ?"
                + " WHERE idCurso = ?;";
        pstm = DBConnection.getConnection().prepareStatement(sqlAtualizar);
        pstm.setInt(1, curso.getId());
        pstm.setString(2, curso.getNome());
        pstm.setString(3, curso.getDescricao());
        pstm.setString(4, curso.getEixoTecnologico());
        pstm.setString(5, curso.getCargaHoraria());
        pstm.setBoolean(6, curso.isStatus());
        pstm.executeUpdate();
        pstm.close();
        DBConnection.fechar();
        System.out.println("Atualizado com sucesso!");
    }
    
    public int remover(int id) throws SQLException {
        PreparedStatement pstm;
        int result = 0;
        String sqlRemover = "DELETE FROM curso WHERE id = ?;";
        pstm = DBConnection.getConnection().prepareStatement(sqlRemover);
        pstm.setLong(1, id);
        result = pstm.executeUpdate();
        pstm.close();
        DBConnection.fechar();
        System.out.println("Removido com sucesso!");
        return result;
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
        DBConnection.fechar();
        return cursos;
    }
}
