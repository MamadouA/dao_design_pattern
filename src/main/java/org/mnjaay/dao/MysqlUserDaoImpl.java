package org.mnjaay.dao;

import org.mnjaay.database.DBManger;
import org.mnjaay.exceptions.DAOException;
import org.mnjaay.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class JdbcUserDaoImpl implements IDao<User>{

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
        return null;
    }

    @Override
    public List<User> list() throws DAOException {
        return List.of();
    }

    @Override
    public void update(User entity) throws DAOException {

    }

    @Override
    public void delete(int id) throws DAOException {

    }
}
