package org.mnjaay.testeur;

import org.mnjaay.dao.IDao;
import org.mnjaay.dao.ObjectFileUserDaoImpl;
import org.mnjaay.exceptions.DAOException;
import org.mnjaay.model.User;

import java.util.List;

public class ObjectFileTesteur {
    IDao<User> userDao;

    public ObjectFileTesteur() {
        userDao = new ObjectFileUserDaoImpl();
    }

    public void createUser(String login, String password) {
        User user = new User(login, password);
        try {
            userDao.create(user);
        } catch (DAOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }

    public User readUser(int id) {
        User user = null;

        try {
            user = userDao.read(id);
        } catch (DAOException e) {
            System.out.println("An error has occurred while reading the user: " + e.getMessage());
        }

        return user;
    }

    public List<User> listerUsers() {
        List<User> users = null;

        try {
            users = userDao.list();
        } catch (DAOException e) {
            System.out.println("An error has occurred while retrieving the users: " + e.getMessage());
        }

        return users;
    }

    public void deleteUser(int id) {
        try {
            userDao.delete(id);
        } catch (DAOException e) {
            System.out.println("An error has occurred while deleting the user: " + e.getMessage());
        }
    }
}
