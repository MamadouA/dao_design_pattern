package org.mnjaay.factory;

import org.mnjaay.dao.impl.HibernateClasseDaoImpl;

public class ClasseFactory extends AbstractFactory {

    @Override
    public HibernateClasseDaoImpl getClasseDaoImpl(Class<? extends HibernateClasseDaoImpl> typeBulletinDao) {
        return new HibernateClasseDaoImpl();
    }
}
