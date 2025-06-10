package org.mnjaay.dao.impl;
import org.mnjaay.entities.Bulletin;

public class HibernateBulletinDaoImpl extends HibernateObjectDaoImpl<Bulletin> {
    public HibernateBulletinDaoImpl() {
        super(Bulletin.class);
    }
}