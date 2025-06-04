package org.mnjaay.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mnjaay.db.HibernateConnection;
import org.mnjaay.entities.Etudiant;
import org.mnjaay.exceptions.DAOException;

import java.util.List;

public class HibernateEtudiantDaoImpl extends HibernateObjectDaoImpl<Etudiant> {

    @Override
    public void create(Etudiant etudiant) throws DAOException {
        try {
            Session session = HibernateConnection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(etudiant);
            transaction.commit();
        } catch (Exception e) {
            throw new DAOException("ERROR : " + e.getClass() + " : " + e.getMessage());
        }
    }

    @Override
    public Etudiant read(int id) throws DAOException {
        try {
            Session session = HibernateConnection.getInstance().getSession();
            return session.find(Etudiant.class, id);
        } catch (Exception e) {
            throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
        }
    }

    @Override
    public List<Etudiant> list() throws DAOException {
        try {
            Session session = HibernateConnection.getInstance().getSession();
            return session.createQuery("select u " + " from t_etudiants u", Etudiant.class).getResultList();
        } catch (Exception e) {
            throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
        }
    }

    @Override
    public void update(Etudiant entity) throws DAOException {
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
            Etudiant etudiant = read(id);
            if (etudiant != null) {
                session.remove(etudiant);
            }

            transaction.commit();
        } catch (Exception e) {
            throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
        }
    }
}