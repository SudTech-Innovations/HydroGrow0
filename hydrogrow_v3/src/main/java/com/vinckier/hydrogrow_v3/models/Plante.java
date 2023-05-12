package com.vinckier.hydrogrow_v3.models;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(mappedBy = "plantes")
    private List<Environnement> environnementsPartages;

    @OneToMany(mappedBy = "plante")
    private List<Planification> planifications;

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

    public List<Planification> getPlanifications() {
        return planifications;
    }

    public void setPlanifications(List<Planification> planifications) {
        this.planifications = planifications;
    }

    public List<Environnement> getEnvironnementsPartages() {
        return environnementsPartages;
    }

    public void setEnvironnementsPartages(List<Environnement> environnementsPartages) {
        this.environnementsPartages = environnementsPartages;
    }

    public void addEnvironnementPartage(Environnement environnement) {
        this.environnementsPartages.add(environnement);
        environnement.getPlantes().add(this);
    }

    public void removeEnvironnementPartage(Environnement environnement) {
        this.environnementsPartages.remove(environnement);
        environnement.getPlantes().remove(this);
    }

    @Override
    public String toString() {
        return nom;
    }
}