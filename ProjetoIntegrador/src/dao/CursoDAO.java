package dao;

import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Curso;

/**
 *
 * @author Giseli e Keyve
 */
public class CursoDAO {

    private static final String update = "update curso set nome = ?, descricao = ?, eixoTecnologico = ?, cargaHoraria = ? where id = ?;";
    private static final String remove = "delete from curso where id = ?;";
    private static final String listarTodos = "select * from curso;";
    private static final String ordenarTabela = "select * from curso order by nome;";

    public static boolean cadastrar(Curso curso) throws SQLException{
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

    public int atualizar(Curso curso) throws SQLException, ClassNotFoundException {
       PreparedStatement pstm;
        String sqlAtualizar = "UPDATE orientador SET nome = ?, descricao = ?, eixoTecnologico = ?, cargaHoraria = ?, status = ?"
                + " WHERE idCurso = ?;";
        pstm = DBConnection.getConnection().prepareStatement(sqlAtualizar);
        pstm.setString(1, curso.getNome());
        pstm.setString(2, curso.getDescricao());
        pstm.setString(3, curso.getEixoTecnologico());
        pstm.setString(4, curso.getCargaHoraria());
        pstm.setLong(5, curso.getId());
        result = pstm.executeUpdate();
        pstm.close();
        return result;
    }
    public static void atualizar(Orientador orientador) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = null;
        String sql = null;
        
        pstm = DBconecction.getConnection().prepareStatement(sql);
        pstm.setInt(1, orientador.getId());
        pstm.setBoolean(2, orientador.isStatus());
        pstm.setString(3, orientador.getNome());
        pstm.setString(4, orientador.getCpf());
        pstm.setString(5, orientador.getRg());
        pstm.setString(6, orientador.getTitulacao());
        pstm.setString(7, orientador.getTelefone());
        pstm.setString(8, orientador.getEmail());
        pstm.setString(9, orientador.getDataEntrada());
        pstm.setString(10, orientador.getEndereco().getEstado());
        pstm.setString(11, orientador.getEndereco().getCidade());
        pstm.setString(12, orientador.getEndereco().getBairro());
        pstm.setString(13, orientador.getEndereco().getRua());
        pstm.setInt(14, orientador.getEndereco().getNumero());
        pstm.setString(15, orientador.getContaBancaria().getBanco());
        pstm.setInt(16, orientador.getContaBancaria().getAgencia());
        pstm.setLong(17, orientador.getContaBancaria().getConta());
        pstm.executeUpdate();
        System.out.println("Atualização realizada com sucesso!");
    }

    public int remover(long id) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        pstm = conn.prepareStatement(remove);
        pstm.setLong(1, id);
        result = pstm.executeUpdate();
        pstm.close();
        return result;
    }

    public Curso buscarPorNome(String nome) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement pstm = conn.prepareStatement("select * from curso where nome like '%" + nome + "%';");
        rs = pstm.executeQuery();
        while (rs.next()) {
            Curso curso;
            curso = new Curso(rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getString("eixoTecnologico"),
                    rs.getString("cargaHoraria"));
            return curso;
        }
        return null;
    }

    public List<Curso> listarTodos() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Curso> cursos = new ArrayList<>();
        ResultSet rs = null;
        pstm = conn.prepareStatement(ordenarTabela);
        rs = pstm.executeQuery();
        while (rs.next()) {
            Curso curso;
            curso = new Curso(rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getString("eixoTecnologico"),
                    rs.getString("cargaHoraria"));
            cursos.add(curso);
        }
        pstm.close();
        return cursos;
    }
}
