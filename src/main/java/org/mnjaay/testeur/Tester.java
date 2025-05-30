package org.mnjaay.testeur;

import org.mnjaay.dao.IDao;
import org.mnjaay.dao.impl.HibernateUserDaoImpl;
import org.mnjaay.dao.impl.MysqlUserDaoImpl;
import org.mnjaay.exceptions.DAOException;
import org.mnjaay.model.User;

import java.util.List;

public class Tester {
    IDao<User> userDao;

    public Tester() {
        userDao = new HibernateUserDaoImpl();
    }

    public void createUser(String login, String password) {
        User user = new User(login, password);

        try {
            userDao.create(user);
            System.out.println("User created successfully !");
        }
        catch (DAOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }

    public User read(int id) {
        try {
            User user = userDao.read(id);
            System.out.println("User retrieved successfully !");
            return user;
        }
        catch (DAOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }

        return null;
    }

    public void deleteUser(int id) {
        try {
            userDao.delete(id);
            System.out.println("User deleted successfully !");
        }
        catch (DAOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }

    public void updateUser(User user) {
        try {
            userDao.update(user);
            System.out.println("User updated successfully !");
        }
        catch (DAOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }

    public List<User> listUsers() {
        try {
            List<User> users = userDao.list();
            System.out.println("Users retrieved successfully !");
            return users;
        }
        catch (DAOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }

        return null;
    }
}
