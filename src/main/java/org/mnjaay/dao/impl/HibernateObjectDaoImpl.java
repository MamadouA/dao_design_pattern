package org.mnjaay.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mnjaay.dao.IDao;
import org.mnjaay.db.HibernateConnection;
import org.mnjaay.exceptions.DAOException;

import java.util.List;

public abstract class HibernateObjectDaoImpl <T> implements IDao<T> {
    private Class<T> typeObject;

    public HibernateObjectDaoImpl(Class<T> typeObject) {
        this.typeObject = typeObject;
    }

    @Override
    public void create(T entity) throws DAOException {
        try {
            Session session = HibernateConnection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            throw new DAOException("ERROR : " + e.getClass() + " : " + e.getMessage());
        }
    }

    @Override
    public T read(int id) throws DAOException {
        try {
            Session session = HibernateConnection.getInstance().getSession();
            return session.find(typeObject, id);
        } catch (Exception e) {
            throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
        }
    }

    @Override
    public List<T> list() throws DAOException {
        try {
            Session session = HibernateConnection.getInstance().getSession();
            return session.createQuery("select u " + " from t_entitys u", typeObject).getResultList();
        } catch (Exception e) {
            throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
        }
    }

    @Override
    public void update(T entity) throws DAOException {
        try {
            Session session = HibernateConnection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();

        } catch (Exception e) {
            throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        try {
            Session session = HibernateConnection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            T entity = read(id);
            if (entity != null) {
                session.remove(entity);
            }

            transaction.commit();
        } catch (Exception e) {
            throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
        }
    }
}
