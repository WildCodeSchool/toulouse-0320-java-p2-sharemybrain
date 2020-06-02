package com.wildcodeschool.sharemybrain.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSingleton {

    private final static String DB_URL = "jdbc:mysql://51.68.18.102:3306/nantes_java_0320_pjt2_sharemybrain?serverTimezone=GMT";
    private final static String DB_USER = "poule";
    private final static String DB_PASSWORD = "p0uleR3qu3st?";

    private static JdbcSingleton instance = null;
    private Connection connection = null;

    private JdbcSingleton() {

    }

    public static JdbcSingleton getInstance() {

        if (instance == null) {
            instance = new JdbcSingleton();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
        }
        return connection;
    }
}
