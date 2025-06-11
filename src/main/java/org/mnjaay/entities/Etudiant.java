package org.mnjaay.entities;

import jakarta.persistence.*;

@Entity(name = "etudiant")
public class Etudiant extends Utilisateur{

    @OneToOne( cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "bulletin_id")
    private Bulletin bulletin;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "classe_id")
    private Classe classe = null;

    public Etudiant() {}

    public Etudiant(String nom, String prenom) {
        super(nom, prenom);
    }

    public Etudiant(String nom, String prenom, Classe classe) {
        super(nom, prenom);
        setClasse(classe);
    }

    public Etudiant(String nom, String prenom, Bulletin bulletin) {
        super(nom, prenom);
        setBulletin(bulletin);
    }

    public Etudiant(String nom, String prenom, Classe classe, Bulletin bulletin) {
        super(nom, prenom);
        setBulletin(bulletin);
        setClasse(classe);
    }

    public void setClasse(Classe classe) {
        try { // Dans le cas de la suppression d'une classe
            classe.addEtudiant(this);
        }catch (NullPointerException e) {}

        this.classe = classe;
    }

    public void setBulletin(Bulletin bulletin) {
        bulletin.setEtudiant(this);
        this.bulletin = bulletin;
    }
}
