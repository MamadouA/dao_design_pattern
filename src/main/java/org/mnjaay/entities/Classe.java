package org.mnjaay.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    public Classe(String libelle) {
        this.libelle = libelle;
    }

    public List<Enseignant> getEnseignats() {
        return enseignants;
    }
}
