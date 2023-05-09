package com.vinckier.hydrogrow_v2.models;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "planification")
public class Planification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_planification")
    private int idPlanificationPlante;

    @Column(name = "date_debut")
    private Date dateDebut;

    @Column(name = "date_fin")
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "id_plante")
    private Plante plante;

    @ManyToOne
    @JoinColumn(name = "id_environnement")
    private Environnement environnement;

    public int getIdPlanificationPlante() {
        return idPlanificationPlante;
    }

    public void setIdPlanificationPlante(int idPlanificationPlante) {
        this.idPlanificationPlante = idPlanificationPlante;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Plante getPlante() {
        return plante;
    }

    public void setPlante(Plante plante) {
        this.plante = plante;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(Environnement environnement) {
        this.environnement = environnement;
    }
}
