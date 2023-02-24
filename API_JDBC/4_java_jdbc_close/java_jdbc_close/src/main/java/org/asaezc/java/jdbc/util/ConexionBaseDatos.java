package org.asaezc.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:****/name_bd?serverTimezone=Europe/Madrid";
    private static String username = "****";
    private static String password = "****";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
