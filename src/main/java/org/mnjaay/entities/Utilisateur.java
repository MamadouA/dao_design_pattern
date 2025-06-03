package org.mnjaay.entities;

import jakarta.persistence.*;

@Entity(name = "t_utilisateurs")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "profile_utilisateur",
    discriminatorType = DiscriminatorType.STRING, length = 16)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    protected int id;
    protected String nom;
    protected String prenom;

    public Utilisateur() {}

    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
}
