package asaezc.apiservlet.webapp.jdbc.bootstrap.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static String url = "jdbc:mysql://localhost:???/nombreBd?serverTimezone=Europe/Madrid";
    private static String username = "user";
    private static String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
