package org.mnjaay.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "t_bulletins")
public class Bulletin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bulletin")
    private int id;
    private int rang;
    private double moyenne;

    @OneToOne(mappedBy = "bulletin")
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @OneToMany(mappedBy = "bulletin", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    List<Releve> releves = new ArrayList<>();

    public void addReleve(Releve releve) {
        this.releves.add(releve);
    }

    public Bulletin(int rang, double moyenne) {
        this.rang = rang;
        this.moyenne = moyenne;
    }

    public Bulletin(int rang, double moyenne, Etudiant etudiant) {
        this.rang = rang;
        this.moyenne = moyenne;
        this.etudiant = etudiant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
