package org.mnjaay.factory;

import org.mnjaay.dao.impl.HibernateBulletinDaoImpl;

public class BulletinFactory extends AbstractFactory {
    @Override
    public HibernateBulletinDaoImpl getBulletinDaoImpl(Class<? extends HibernateBulletinDaoImpl> typeBulletinDao) {
        return new HibernateBulletinDaoImpl();
    }
}
