package org.mnjaay.dao.impl;

import org.mnjaay.entities.User;

public class HibernateUserDaoImpl extends HibernateObjectDaoImpl<User> {

    public HibernateUserDaoImpl() {
        super(User.class);
    }
}