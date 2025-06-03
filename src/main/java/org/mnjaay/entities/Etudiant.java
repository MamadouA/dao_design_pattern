package org.mnjaay.entities;

import jakarta.persistence.*;

@Entity(name = "t_etudiants")
public class Etudiant extends Utilisateur{

    @OneToOne(cascade = {CascadeType.PERSIST})
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
        this.classe = classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }
}
