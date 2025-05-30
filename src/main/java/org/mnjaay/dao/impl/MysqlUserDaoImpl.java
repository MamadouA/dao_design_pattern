package org.mnjaay.dao.impl;

import org.mnjaay.dao.IDao;
import org.mnjaay.database.DBManger;
import org.mnjaay.exceptions.DAOException;
import org.mnjaay.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MysqlUserDaoImpl implements IDao<User> {

    @Override
    public void create(User entity) throws DAOException {
        try(Connection connection = DBManger.getConnection()) {
            String query = "INSERT INTO t_users(login, password) values(?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());

            ps.executeUpdate();
        }
        catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public User read(int id) throws DAOException {
        try(Connection connection = DBManger.getConnection()) {
            String query = "SELECT * FROM t_users WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                String login = rs.getString("login");
                String password = rs.getString("password");

                return new User(id, login, password);
            }
        }
        catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> list() throws DAOException {
        List<User> users = new ArrayList<>();

        try(Connection connection = DBManger.getConnection()) {
            String query = "SELECT * FROM t_users";
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String login = rs.getString("login");
                String password = rs.getString("password");

                User user = new User(id, login, password);
                users.add(user);
            }
        }
        catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return users;
    }

    @Override
    public void update(User entity) throws DAOException {
        try(Connection connection = DBManger.getConnection()) {
            String query = "UPDATE t_users SET login=?, password=? WHERE id=?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setInt(3, entity.getId());

            ps.executeUpdate();
        }
        catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        try(Connection connection = DBManger.getConnection()) {
            String query = "DELETE FROM t_users WHERE id=?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();
        }
        catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
    }
}
