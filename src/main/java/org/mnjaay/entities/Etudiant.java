package org.mnjaay.entities;

import jakarta.persistence.*;

@Entity(name = "t_etudiants")
public class Etudiant extends Utilisateur{

    @OneToOne( cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "bulletin_id")
    private Bulletin bulletin;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe = null;

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

    public void setClasse(Classe classe) {
        classe.addEtudiant(this);
        this.classe = classe;
    }

    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
        this.bulletin.setEtudiant(this);
    }
}
