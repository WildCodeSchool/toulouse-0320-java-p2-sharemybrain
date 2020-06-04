package com.wildcodeschool.sharemybrain.repository;
import com.wildcodeschool.sharemybrain.entity.Answer;
import com.wildcodeschool.sharemybrain.util.JdbcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class AnswerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void answerQuestion(int idQuestion, int idUser, String description, String date) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
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
            connection = jdbcTemplate.getDataSource().getConnection();
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


    public List<Answer> findAnswerWithId(int idQuest) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            statement = connection.prepareStatement(
                    "SELECT *  FROM answer WHERE id_question = ?;"
            );
            statement.setInt(1, idQuest);
            resultSet = statement.executeQuery();

            List<Answer> answers = new ArrayList<>();

            while (resultSet.next()) {
                int idAnswer = resultSet.getInt("id_answer");
                int idQuestion = resultSet.getInt("id_question");
                int idUser = resultSet.getInt("id_user");
                String description = resultSet.getString("description");
                Date date = resultSet.getDate("date");
                answers.add(new Answer(idAnswer, idQuestion, idUser, description, date));
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
