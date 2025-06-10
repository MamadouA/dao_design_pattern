package org.mnjaay.factory;

import org.mnjaay.dao.impl.HibernateModuleDaoImpl;

public class ModuleFactory extends AbstractFactory {

    @Override
    public HibernateModuleDaoImpl getModuleDaoImpl(Class<? extends HibernateModuleDaoImpl> typeBulletinDao) {
        return new HibernateModuleDaoImpl();
    }
}
