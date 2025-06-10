package org.mnjaay.dao.impl;

import org.mnjaay.entities.Etudiant;

public class HibernateEtudiantDaoImpl extends HibernateObjectDaoImpl<Etudiant> {

    public HibernateEtudiantDaoImpl() {
        super(Etudiant.class);
    }
}