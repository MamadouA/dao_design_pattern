package org.mnjaay.runtime;
import org.mnjaay.entities.*;
import org.mnjaay.testeur.Testeur;

public class Main {
    public static void main(String[] args) {
        Testeur testeur = new Testeur();

        // - Classe
        Classe classe = new Classe("LTI3 Jour");

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

        bulletin.addReleve(releveSemestre1);
        bulletin.addReleve(releveSemestre2);

        Etudiant etudiant = new Etudiant("Doe", "Toto", bulletin);

        testeur.creerEtudiant(etudiant);
    }
}
