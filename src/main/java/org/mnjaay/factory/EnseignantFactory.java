package org.mnjaay.factory;

import org.mnjaay.dao.impl.HibernateEnseignantDaoImp;

public class EnseignantFactory extends AbstractFactory {

    @Override
    public HibernateEnseignantDaoImp getEnseignantDaoImpl(Class<? extends HibernateEnseignantDaoImp> typeBulletinDao) {
        return new HibernateEnseignantDaoImp();
    }
}
