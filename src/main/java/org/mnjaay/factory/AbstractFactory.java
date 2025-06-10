package org.mnjaay.factory;

import org.mnjaay.dao.IDao;
import org.mnjaay.dao.impl.*;
import org.mnjaay.entities.*;
import org.mnjaay.entities.Module;

public abstract class AbstractFactory {
    public <T> Bulletin getBulletin(Class<? extends Bulletin> typeBulletin) {
        return null;
    }

    public <T> Classe getClasse(Class<? extends Classe> typeClasse) {
        return null;
    }

    public <T> Utilisateur getUtilisateur(Class<? extends Utilisateur> typeUtilisateur) {
        return null;
    }

    public <T> Module getModule(Class<? extends Module> typeModule) {
        return null;
    }

    public <T> Note getNote(Class<? extends  Note> typeNote) {
        return null;
    }

    public <T> Releve getReleve(Class<? extends Releve> typeReleve) {
        return null;
    }

    public HibernateBulletinDaoImpl getBulletinDaoImpl(Class<? extends HibernateBulletinDaoImpl> typeBulletinDao) {
        return null;
    }

    public HibernateClasseDaoImpl getClasseDaoImpl(Class<? extends HibernateClasseDaoImpl> typeBulletinDao) {
        return null;
    }

    public HibernateEnseignantDaoImp getEnseignantDaoImpl(Class<? extends HibernateEnseignantDaoImp> typeBulletinDao) {
        return null;
    }

    public HibernateEtudiantDaoImpl getEtudiantDaoImpl(Class<? extends HibernateEtudiantDaoImpl> typeBulletinDao) {
        return null;
    }

    public HibernateModuleDaoImpl getModuleDaoImpl(Class<? extends HibernateModuleDaoImpl> typeBulletinDao) {
        return null;
    }

    public HibernateReleveDaoImpl getReleveDaoImpl(Class<? extends HibernateReleveDaoImpl> typeBulletinDao) {
        return null;
    }

    public HibernateNoteDaoImpl getNoteDaoImpl(Class<? extends HibernateNoteDaoImpl> typeBulletinDao) {
        return null;
    }
}
