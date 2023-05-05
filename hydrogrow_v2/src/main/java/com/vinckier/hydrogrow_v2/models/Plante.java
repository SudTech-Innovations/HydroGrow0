package com.vinckier.hydrogrow_v2.models;

import javax.persistence.*;

@Entity
@Table(name = "plante")
public class Plante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plante")
    private int idPlante;
    @Column(name = "nom")
    private String nom;
    @ManyToOne
    @JoinColumn(name = "id_environnement")
    private Environnement environnement;

    public int getIdPlante() {
        return idPlante;
    }

    public void setIdPlante(int idPlante) {
        this.idPlante = idPlante;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(Environnement environnement) {
        this.environnement = environnement;
    }
}
