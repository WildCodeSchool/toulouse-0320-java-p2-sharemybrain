package com.wildcodeschool.sharemybrain.repository;

import com.wildcodeschool.sharemybrain.entity.Avatar;
import com.wildcodeschool.sharemybrain.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvatarRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/share_my_brain?serverTimezone=GMT";
    private final static String DB_USER = "poule";
    private final static String DB_PASSWORD = "p0uleR3qu3st?";

    public List<Avatar> findAllAvatars() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
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
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
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

