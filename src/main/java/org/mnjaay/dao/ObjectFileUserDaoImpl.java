package org.mnjaay.dao;

import org.mnjaay.exceptions.DAOException;
import org.mnjaay.model.User;
import org.mnjaay.model.Users;
import org.mnjaay.utils.SerializableManager;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ObjectFileUserDaoImpl implements  IDao<Users> {
    private final SerializableManager serializableManager;

    public ObjectFileUserDaoImpl() {
        serializableManager = new SerializableManager();
    }

    @Override
    public void create(Users entities) throws DAOException {
        try {
            serializableManager.serializeUsersList("users.ser", entities);
        } catch (IOException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Users read(int id) throws DAOException {
        return null;
    }

    @Override
    public List<Users> list() throws DAOException {
        Users users = null;

        try {
            users = serializableManager.deserializeUsersList("users.ser");
        } catch (IOException e) {
            System.out.println("An error has occurred while reading the users: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class users note found: " + e.getMessage());
        }
        return Collections.singletonList(users);
    }

    @Override
    public void update(Users entities) throws DAOException {

    }

    @Override
    public void delete(int id) throws DAOException {

    }
}
