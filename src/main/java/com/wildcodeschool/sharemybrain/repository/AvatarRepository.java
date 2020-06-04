package com.wildcodeschool.sharemybrain.repository;

import com.wildcodeschool.sharemybrain.entity.Avatar;
import com.wildcodeschool.sharemybrain.util.JdbcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AvatarRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Avatar> findAllAvatars() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM avatar;"
            );

            resultSet = statement.executeQuery();

            List<Avatar> avatars = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_avatar");
                String url = resultSet.getString("url");
                avatars.add(new Avatar(id, url));
            }
            return avatars;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    public Avatar findAvatar(int idAvatar) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM avatar WHERE id_avatar = ?;"
            );
            statement.setInt(1, idAvatar);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String url = resultSet.getString("url");
                return new Avatar(idAvatar, url);
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

