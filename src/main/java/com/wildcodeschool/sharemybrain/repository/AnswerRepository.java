package com.wildcodeschool.sharemybrain.repository;

import com.wildcodeschool.sharemybrain.entity.User;
import com.wildcodeschool.sharemybrain.util.JdbcUtils;

import java.sql.*;
import java.util.Date;


public class AnswerRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/share_my_brain?serverTimezone=GMT";
    private final static String DB_USER = "poule";
    private final static String DB_PASSWORD = "p0uleR3qu3st?";

    public void answerQuestion(int idQuestion, int idUser, String description, String date) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "INSERT INTO answer (id_question, id_user, description,`date`) VALUES (?, ?, ?, ?);"
            );
            statement.setInt(1, idQuestion);
            statement.setInt(2, idUser);
            statement.setString(3, description);
            statement.setString(4, date);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
    }
}
