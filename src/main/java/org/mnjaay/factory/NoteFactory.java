package org.mnjaay.factory;

import org.mnjaay.dao.impl.HibernateNoteDaoImpl;

public class NoteFactory extends AbstractFactory {
    @Override
    public HibernateNoteDaoImpl getNoteDaoImpl(Class<? extends HibernateNoteDaoImpl> typeBulletinDao) {
        return new HibernateNoteDaoImpl();
    }
}
