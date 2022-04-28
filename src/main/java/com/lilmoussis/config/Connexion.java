package com.lilmoussis.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String username = "root";
    private static final String password = "";
    private static final String url = "jdbc:mariadb://localhost:3306/magasin";
    private static Connection connection  =null;

    public static Connection getConnection(){
        if (connection == null){
            try {
                connection = DriverManager.getConnection(url,username,password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
