package org.asaezc.apiservlet.webapp.cdi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static String url = "jdbc:mysql://server/name_bd?serverTimezone=Europe/Madrid";
    private static String username = "name_user";
    private static String password = "****";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
