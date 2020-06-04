package com.wildcodeschool.sharemybrain.repository;

import com.wildcodeschool.sharemybrain.entity.Skill;
import com.wildcodeschool.sharemybrain.util.JdbcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SkillRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Skill> findAllSkills() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM skill;"
            );
            resultSet = statement.executeQuery();

            List<Skill> skills = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_skill");
                String name = resultSet.getString("name");
                skills.add(new Skill(id, name));
            }
            return skills;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    public Skill findSkillById(int idSkill) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM skill WHERE id_skill = ?;"
            );
            statement.setInt(1, idSkill);
            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                String name = resultSet.getString("name");
                 return new Skill(idSkill, name);
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

    public String findSkillNameById(int idSkill) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM skill WHERE id_skill = ?;"
            );
            statement.setInt(1, idSkill);
            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                String skillName = resultSet.getString("name");
                return skillName;
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
}
