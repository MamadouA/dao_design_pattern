package org.mnjaay.factory;

import org.mnjaay.dao.impl.HibernateEtudiantDaoImpl;

public class EtudiantFactory extends AbstractFactory{

    @Override
    public HibernateEtudiantDaoImpl getEtudiantDaoImpl(Class<? extends HibernateEtudiantDaoImpl> typeBulletinDao) {
        return new HibernateEtudiantDaoImpl();
    }
}
