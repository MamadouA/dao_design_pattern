package org.mnjaay.dao;

import org.mnjaay.exceptions.DAOException;
import org.mnjaay.model.User;
import org.mnjaay.model.Users;
import org.mnjaay.utils.Serializer;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class ObjectFileUserDaoImpl implements  IDao<User> {
    private final String usersFile = "users.ser";
    private final Serializer serializer;

    public ObjectFileUserDaoImpl() {
        serializer = new Serializer();
    }

    @Override
    public void create(User entity) throws DAOException {
        try {
            Users users = serializer.deserializeUsers();
            users.add(entity);
            serializer.serializeUsers(users);

        } catch (IOException e) {
            System.out.println("An error has occurred while reading the users: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Users class not found");
        }
    }

    @Override
    public User read(int id) throws DAOException {
        User user = null;
        try {
            Users users = serializer.deserializeUsers();

            user = users.getUsers().stream().filter(u -> u.getId() == id).toList().getFirst();

        } catch (IOException e) {
            System.out.println("An error has occurred while reading the users: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Users class not found");
        }
        catch (NoSuchElementException e) {
            System.out.println("User not found!");
        }

        return user;
    }

    @Override
    public List<User> list() throws DAOException {
        try {
            Users users = serializer.deserializeUsers();

            return users.getUsers();
        } catch (IOException e) {
            System.out.println("An error has occurred while reading the users: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Users class not found");
        }

        return null;
    }

    @Override
    public void update(User entity) throws DAOException {
//        try {
//            Users users = serializableManager.deserializeUsersList(usersFile);
//
//            // TODO
//
//            serializableManager.serializeUsersList(usersFile, users);
//        } catch (IOException e) {
//            System.out.println("An error has occurred while reading the users: " + e.getMessage());
//        } catch (ClassNotFoundException e) {
//            System.out.println("Users class not found");
//        }
    }

    @Override
    public void delete(int id) throws DAOException {
        try {
            Users users = serializer.deserializeUsers();

            users.remove(id);

            serializer.serializeUsers(users);
        } catch (IOException e) {
            System.out.println("An error has occurred while reading the users: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Users class not found");
        }
    }
}
