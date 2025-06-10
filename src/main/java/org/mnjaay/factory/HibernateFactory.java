package org.mnjaay.factory;

import org.mnjaay.dao.impl.*;

public class HibernateFactory {
    public static Object getObjectHibernateImp(Object typeHibernateDao) {
       if(typeHibernateDao == HibernateEtudiantDaoImpl.class)
           return new HibernateEtudiantDaoImpl();

       else if(typeHibernateDao == HibernateEnseignantDaoImp.class)
           return new HibernateEnseignantDaoImp();

       else if(typeHibernateDao == HibernateBulletinDaoImpl.class)
           return new HibernateBulletinDaoImpl();

       else if(typeHibernateDao == HibernateClasseDaoImpl.class)
           return new HibernateClasseDaoImpl();

       else if(typeHibernateDao == HibernateUserDaoImpl.class)
           return new HibernateUserDaoImpl();

        return null;
    }
}
