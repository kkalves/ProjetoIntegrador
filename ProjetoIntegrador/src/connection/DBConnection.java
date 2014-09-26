package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Giseli e Keyve
 */
public class DBConnection {

    private static final String urlMySql = "jdbc:mysql://localhost/projetointegrador";
    private static final String user = "root";
    private static final String pass = "12345";

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public static void abrir() throws SQLException {
        connection = DriverManager.getConnection(urlMySql, user, pass);
        System.out.println("Abrindo conexão!");
    }

    public static void fechar() throws SQLException {
        connection.close();
        System.out.println("Fechando conexão!");
    }
}
