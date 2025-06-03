package org.mnjaay.entities;

import jakarta.persistence.*;

@Entity(name = "t_notes")
public class Note {
    @Id
    @Column(name = "id_note")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double value;
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "releve_id")
    private Releve releve;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Releve getReleve() {
        return releve;
    }

    public void setReleve(Releve releve) {
        this.releve = releve;
    }
}
