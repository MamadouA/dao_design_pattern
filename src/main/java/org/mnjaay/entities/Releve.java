package org.mnjaay.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "t_releves")
public class Releve {
    @Id
    @Column(name = "id_releve")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double moyenne;

    @ManyToOne
    private Bulletin bulletin;

    @OneToMany(mappedBy = "releve")
    List<Note> notes = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
}
