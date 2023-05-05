package com.vinckier.hydrogrow_v2.models;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "environnement")
public class Environnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_environnement")
    private int idEnvironnement;
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "environnement", cascade = CascadeType.ALL)
    private List<Plante> plantes;

    public int getIdEnvironnement() {

        return idEnvironnement;
    }

    public void setIdEnvironnement(int idEnvironnement) {
        this.idEnvironnement = idEnvironnement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Plante> getPlantes() {
        return plantes;
    }

    public void setPlantes(List<Plante> plantes) {
        this.plantes = plantes;
    }

    @Override
    public String toString() {
        return "Environnement [idEnvironnement=" + idEnvironnement + ", nom=" + nom + "]";
    }
}