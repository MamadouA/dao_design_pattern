package org.mnjaay.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "enseignant")
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

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Enseignant enseignant = (Enseignant) obj;

        return Objects.equals(id, enseignant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
