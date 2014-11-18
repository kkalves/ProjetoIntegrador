package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giseli e Keyve
 */
public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        return connection = connect();
    }

    private static Connection connect() throws SQLException {
        /*String url = "jdbc:mysql://acad03.lages.ifsc.edu.br:3306/ProjetoIntegradorCompleto";//aluno:@acad03.lages.ifsc.edu.br:3306:
        String driverMySQL = "com.mysql.jdbc.Driver";
        String user = "aluno";
        String pass = "lages";*/
        String url = "jdbc:mysql://localhost/projetointegrador";
        String driverMySQL = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "12345";
        try {
            Class.forName(driverMySQL);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro DBConnection" + ex.getMessage());
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }

    public static void close() throws SQLException {
        connection.close();
    }
}
