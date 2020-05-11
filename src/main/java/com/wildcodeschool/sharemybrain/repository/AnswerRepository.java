package com.wildcodeschool.sharemybrain.repository;

import com.wildcodeschool.sharemybrain.entity.Answer;
import com.wildcodeschool.sharemybrain.entity.User;
import com.wildcodeschool.sharemybrain.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    public int countAnswersByQuestion(int idQuestion) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT COUNT(id_answer) as total FROM answer WHERE id_question = ?;"
            );
            statement.setInt(1, idQuestion);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int total = resultSet.getInt("total");
                return total;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return -1;
    }

    public List<Answer> answersByIdQuestion(int idQuestion) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM answer WHERE id_question = ?;"
            );
            statement.setInt(1, idQuestion);
            resultSet = statement.executeQuery();
            List<Answer> answers = new ArrayList<>();
            while (resultSet.next()) {
                int idAnswer = resultSet.getInt("id_answer");
                int idUser = resultSet.getInt("id_user");
                String answerText = resultSet.getString("description");
                Date date = resultSet.getDate("date");
                answers.add(new Answer(idAnswer, idQuestion, idUser, answerText, date));
            }
            return answers;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }
}
