package org.mnjaay.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "t_enseignants")
public class Enseignant extends Utilisateur{

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    protected List<Classe> classes = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    protected List<Module> modules = new ArrayList<>();

    public Enseignant() {}

    public Enseignant(String nom, String prenom) {
        super(nom, prenom);
    }

    public void addClasse(Classe classe) {
        classes.add(classe);
        classe.getEnseignats().add(this);
    }
}
