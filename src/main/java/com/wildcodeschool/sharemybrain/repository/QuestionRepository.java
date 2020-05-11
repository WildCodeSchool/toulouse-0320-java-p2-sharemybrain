package com.wildcodeschool.sharemybrain.repository;

import com.wildcodeschool.sharemybrain.entity.Question;
import com.wildcodeschool.sharemybrain.entity.User;
import com.wildcodeschool.sharemybrain.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionRepository {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/share_my_brain?serverTimezone=GMT";
    private final static String DB_USER = "poule";
    private final static String DB_PASSWORD = "p0uleR3qu3st?";


    public List<Question> findWithLimit(int limit, int offset) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM question LIMIT ?,?;"
            );
            statement.setInt(2, limit);
            statement.setInt(1, offset);
            resultSet = statement.executeQuery();

            List<Question> questions = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_question");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Date date = resultSet.getDate("date");
                int idUser = resultSet.getInt("id_user");
                int idSkill = resultSet.getInt("id_skill");

                questions.add(new Question(id, title, description, idUser, idSkill, date));
            }
            return questions;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    public int totalLines(int idSkill) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            if (idSkill == -1) {
                statement = connection.prepareStatement(
                        "SELECT COUNT(*) as count FROM question;"
                );
            } else {
                statement = connection.prepareStatement(
                        "SELECT COUNT(*) as count FROM question where id_skill = ?;"
                );
                statement.setInt(1, idSkill);
            }
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return 0;
    }

    public List<Question> findWithSkill(int limit, int offset, int idSkill) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM question  WHERE id_skill = ? LIMIT ?,?;"
            );
            statement.setInt(3, limit);
            statement.setInt(2, offset);
            statement.setInt(1, idSkill);
            resultSet = statement.executeQuery();

            List<Question> questions = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_question");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Date date = resultSet.getDate("date");
                int idUser = resultSet.getInt("id_user");
                questions.add(new Question(id, title, description, idUser, idSkill, date));
            }
            return questions;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    public Question findQuestion(int idQuestion) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM question  WHERE id_question = ?;"
            );
            statement.setInt(1, idQuestion);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Date date = resultSet.getDate("date");
                int idUser = resultSet.getInt("id_user");
                int idSkill = resultSet.getInt("id_skill");

                Question question = new Question(idQuestion, title, description, idUser, idSkill, date);

                return question;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }
    public void askQuestion(String question_title, String question, String date, int idUser, int idSkill) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "INSERT INTO question (title, description, `date`, id_user, id_skill) VALUES (?, ?, ?, ?, ?);"
            );
            statement.setString(1,question_title);
            statement.setString(2, question);
            statement.setString(3, date);
            statement.setInt(4, idUser);
            statement.setInt(5, idSkill);

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