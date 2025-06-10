package org.mnjaay.dao.impl;

import org.mnjaay.entities.Enseignant;

public class HibernateEnseignantDaoImp extends HibernateObjectDaoImpl<Enseignant> {

    public HibernateEnseignantDaoImp() {
        super(Enseignant.class);
    }
}
