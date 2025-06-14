package org.mnjaay.testeur;

import org.mnjaay.dao.IDao;
import org.mnjaay.dao.impl.*;
import org.mnjaay.entities.*;
import org.mnjaay.exceptions.DAOException;
import org.mnjaay.factory.*;

import java.util.List;

public class Testeur {
    IDao<Classe> classeDao;
    IDao<Etudiant> etudiantDao;
    IDao<Bulletin> bulletinDao;
    IDao<Enseignant> enseignantDao;
    IDao<Releve> releveDao;
    IDao<Note> noteDao;

    public Testeur() {
        classeDao = ConcreteFactory
                        .getFactory(ClasseFactory.class)
                        .getClasseDaoImpl(HibernateClasseDaoImpl.class);

        etudiantDao = ConcreteFactory
                        .getFactory(EtudiantFactory.class)
                        .getEtudiantDaoImpl(HibernateEtudiantDaoImpl.class);

        bulletinDao = ConcreteFactory
                        .getFactory(BulletinFactory.class)
                        .getBulletinDaoImpl(HibernateBulletinDaoImpl.class);

        releveDao = ConcreteFactory
                    .getFactory(ReleveFactory.class)
                    .getReleveDaoImpl(HibernateReleveDaoImpl.class);

        noteDao = ConcreteFactory
                .getFactory(NoteFactory.class)
                .getNoteDaoImpl(HibernateNoteDaoImpl.class);
    }

        // Teste création et suppresion en cascade
    // ----------------------------------------------------------------
    public void creerEtudiant() {
        try {
            // - Classe
            Classe classe = new Classe("LPTI3 ASR");

            // - Bulletin
            Bulletin bulletin = new Bulletin(15, 16.0);

            // - Releve
            Releve releveSemestre1 = new Releve(bulletin, 12);

            // - Notes du Semestre 1
            releveSemestre1.addNote(new Note(10.0, "Passable", releveSemestre1));
            releveSemestre1.addNote(new Note(5.0, "Médiocre", releveSemestre1));
            releveSemestre1.addNote(new Note(14.0, "Bien", releveSemestre1));

            // - Notes du Semestre 2
            Releve releveSemestre2 = new Releve(bulletin, 13);
            releveSemestre2.addNote(new Note(18, "Trés bien", releveSemestre2));
            releveSemestre2.addNote(new Note(11, "Bien", releveSemestre2));

            bulletin.addReleve(releveSemestre1);
            bulletin.addReleve(releveSemestre2);

            Etudiant etudiant = new Etudiant("Doe", "Toto", classe, bulletin);
            etudiantDao.create(etudiant);
            System.out.println("New student created successfully!");
        } catch (DAOException e) {
            System.err.println("Error while creating a new student: " + e.getMessage());
        }
    }

    public void supprimerEtudiant(int id) {
        try {
            etudiantDao.delete(id);
        } catch (DAOException e) {
            System.err.println("Error while deleting a student: " + e.getMessage());
        }
    }

    public void supprimerClasse(int id) {
        try {
            Classe classe = classeDao.read(id);
            classe.removeEtudiants();
            classeDao.delete(id);
        } catch (DAOException e) {
            System.err.println("Error while deleting a classe: " + e.getMessage());
        }
    }

    public List<Etudiant> listerEtudiant() {
        try {
            return etudiantDao.list();
        } catch (DAOException e) {
            System.err.println("Error while retrieving the student: " + e.getMessage());
        }
        return null;
    }
    // ----------------------------------------------------------------

    public void createStudentWithBulletin() {
        Etudiant etudiant = new Etudiant("Doe", "John");

        Bulletin bulletin = new Bulletin(5, 15, etudiant);

        Releve releve = new Releve(bulletin, 10);

    }

    public void createTeacher(String nom, String prenom) {
        try {
            Enseignant enseignant = new Enseignant(nom, prenom);
            enseignantDao.create(enseignant);
            System.out.println("New teacher create successfully!");
        } catch (DAOException e) {
            System.err.println("Error while creating a new teacher: " + e.getMessage());
        }
    }


    public void createStudentWithClasse (String nom, String prenom, String libelleClasse) {
        Classe classe = createClasse(libelleClasse);
        Etudiant etudiant = createStudent(nom, prenom, classe);
    }

    public void createStudentWithClasseWithBulletin (String nom, String prenom, String libelleClasse, int rang, double moyenne) {
        Classe classe = createClasse(libelleClasse);
        Etudiant etudiant = createStudent(nom, prenom, classe, new Bulletin(rang, moyenne));
    }

    public Etudiant createStudent (String nom, String prenom, Classe classe) {
        Etudiant etudiant = new Etudiant (nom, prenom);
        etudiant.setClasse (classe);

        try {
            etudiantDao.create(etudiant);
            System.out.println("Un nouvel étudiant ajouté dans une classe!");
        } catch (DAOException e) {
            System.err.println(e.getMessage());
        }

        return etudiant;
    }

    public Etudiant createStudent (String nom, String prenom, Classe classe, Bulletin bulletin) {
        Etudiant etudiant = new Etudiant (nom, prenom);
        etudiant.setClasse (classe);
        etudiant.setBulletin(bulletin);

        try {
            etudiantDao.create(etudiant);
            System.out.println("Un nouvel étudiant ajouté dans une classe!");
        } catch (DAOException e) {
            System.err.println(e.getMessage());
        }

        return etudiant;
    }

    // - Classes
    public Classe createClasse (String libelle) {
        Classe classe = new Classe(libelle);

        try {
            classeDao.create(classe);
            System.out.println("Une nouvelle classe est ajoutée!");
        } catch (DAOException e) {
            System.err.println(e.getMessage());
        }

        return classe;
    }

    // - Bulletins
    public Bulletin createBulletin (int rang, double moyenne, Etudiant etudiant) {
        Bulletin bulletin = new Bulletin(rang, moyenne, etudiant);

        try {
            bulletinDao.create(bulletin);
            System.out.println("Une nouvelle bulletin est ajoutée!");
        } catch (DAOException e) {
            System.err.println(e.getMessage());
        }

        return bulletin;
    }
}
