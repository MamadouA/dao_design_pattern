package org.mnjaay.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "t_classes")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe")
    private int id;
    private String libelle;

    @OneToMany(mappedBy = "classe")
    private List<Etudiant> etudiants = new ArrayList<>();

    @ManyToMany(mappedBy = "classes")
    private List<Enseignant> enseignants = new ArrayList<>();

    public Classe() {}

    public Classe(String libelle) {
        this.libelle = libelle;
    }

    public void addEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
    }

    public void removeEtudiants() {
        for(Etudiant etudiant : etudiants) {
            etudiant.setClasse(null);
        }
    }

    public List<Enseignant> getEnseignats() {
        return enseignants;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Classe classe = (Classe) obj;
        return Objects.equals(id, classe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
