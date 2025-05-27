package org.mnjaay;

import org.mnjaay.dao.IDao;
import org.mnjaay.dao.MysqlUserDaoImpl;
import org.mnjaay.exceptions.DAOException;
import org.mnjaay.model.User;

public class JDBCTesteur {
    IDao<User> userDao;

    public JDBCTesteur() {
        userDao = new MysqlUserDaoImpl();
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
}
