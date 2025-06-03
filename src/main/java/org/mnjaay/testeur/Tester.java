package org.mnjaay.testeur;

import org.mnjaay.dao.IDao;
import org.mnjaay.dao.impl.HibernateBulletinDaoImpl;
import org.mnjaay.dao.impl.HibernateClasseDaoImpl;
import org.mnjaay.dao.impl.HibernateEtudiantDaoImpl;
import org.mnjaay.dao.impl.HibernateUserDaoImpl;
import org.mnjaay.entities.Bulletin;
import org.mnjaay.entities.Classe;
import org.mnjaay.entities.Etudiant;
import org.mnjaay.exceptions.DAOException;
import org.mnjaay.entities.User;

import java.util.List;

public class Tester {
    IDao<User> userDao;
    IDao<Classe> classeDao;
    IDao<Etudiant> etudiantDao;
    IDao<Bulletin> bulletinDao;

    public Tester() {
        userDao = new HibernateUserDaoImpl();
        classeDao = new HibernateClasseDaoImpl();
        etudiantDao = new HibernateEtudiantDaoImpl();
        bulletinDao = new HibernateBulletinDaoImpl();
    }

    // - Users
    public void createUser(String login, String password) {
        User user = new User(login, password);

        try {
            userDao.create(user);
            System.out.println("User created successfully !");
        }
        catch (DAOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }

    public User read(int id) {
        try {
            User user = userDao.read(id);
            System.out.println("User retrieved successfully !");
            return user;
        }
        catch (DAOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }

        return null;
    }

    public void deleteUser(int id) {
        try {
            userDao.delete(id);
            System.out.println("User deleted successfully !");
        }
        catch (DAOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }

    public void updateUser(User user) {
        try {
            userDao.update(user);
            System.out.println("User updated successfully !");
        }
        catch (DAOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }

    public List<User> listUsers() {
        try {
            List<User> users = userDao.list();
            System.out.println("Users retrieved successfully !");
            return users;
        }
        catch (DAOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }

        return null;
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
