package org.mnjaay.dao;

import org.mnjaay.exceptions.DAOException;
import org.mnjaay.model.User;

import java.util.List;

public interface IDao <T> {
    public void create(T entity) throws DAOException;
    public User read(int id) throws DAOException;
    public List<T> list() throws DAOException;
    public void update(T entity) throws DAOException;
    public void delete(int id) throws DAOException;
}
