package org.mnjaay.testeur;

import org.mnjaay.dao.IDao;
import org.mnjaay.dao.ObjectFileUserDaoImpl;
import org.mnjaay.exceptions.DAOException;
import org.mnjaay.model.User;
import org.mnjaay.model.Users;

import java.util.List;

public class ObjectFileTesteur {
    IDao<Users> userDao;

    public ObjectFileTesteur() {
        userDao = new ObjectFileUserDaoImpl();
    }

    public void createUsers(Users users) {
        try {
            userDao.create(users);
        } catch (DAOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }

    public List<Users> listUsers() {
        List<Users> users = null;

        try {
             users = userDao.list();

        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
