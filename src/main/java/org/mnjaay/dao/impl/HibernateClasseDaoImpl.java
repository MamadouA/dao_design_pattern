package org.mnjaay.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mnjaay.dao.IDao;
import org.mnjaay.db.HibernateConnection;
import org.mnjaay.entities.Classe;
import org.mnjaay.exceptions.DAOException;

import java.util.List;

public class HibernateClasseDaoImpl implements IDao<Classe> {

    @Override
    public void create(Classe classe) throws DAOException {
        try {
            Session session = HibernateConnection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(classe);
            transaction.commit();
        } catch (Exception e) {
            throw new DAOException("ERROR : " + e.getClass() + " : " + e.getMessage());
        }
    }

    @Override
    public Classe read(int id) throws DAOException {
        try {
            Session session = HibernateConnection.getInstance().getSession();
            return session.find(Classe.class, id);
        } catch (Exception e) {
            throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
        }
    }

    @Override
    public List<Classe> list() throws DAOException {
        try {
            Session session = HibernateConnection.getInstance().getSession();
            return session.createQuery("select u " + " from t_classes u", Classe.class).getResultList();
        } catch (Exception e) {
            throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
        }
    }

    @Override
    public void update(Classe entity) throws DAOException {
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
            Classe classe = read(id);
            if (classe != null) {
                session.remove(classe);
            }

            transaction.commit();
        } catch (Exception e) {
            throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
        }
    }
}