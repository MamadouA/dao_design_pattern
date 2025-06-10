package org.mnjaay.factory;

import org.mnjaay.dao.impl.HibernateReleveDaoImpl;

public class ReleveFactory extends AbstractFactory {

    @Override
    public HibernateReleveDaoImpl getReleveDaoImpl(Class<? extends HibernateReleveDaoImpl> typeBulletinDao) {
        return new HibernateReleveDaoImpl();
    }
}
