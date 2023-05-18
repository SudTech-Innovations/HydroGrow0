package vinckier.hydrogrow_back.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanif;
    private Long idPlante;
    private Date dateDebut;
    private Date dateFin;
    private Long idEnvironnement;
    private Long idSolution;

    // Constructeurs
    public Planification() {
    }

    public Planification(Long idPlanif, Long idPlante, Date dateDebut,
            Date dateFin, Long idEnvironnement, Long idSolution) {
        this.idPlanif = idPlanif;
        this.idPlante = idPlante;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idEnvironnement = idEnvironnement;
        this.idSolution = idSolution;
    }

    // Getters et Setters
    public Long getIdPlanif() {
        return idPlanif;
    }

    public void setIdPlanif(Long idPlanif) {
        this.idPlanif = idPlanif;
    }

    public Long getIdPlante() {
        return idPlante;
    }

    public void setIdPlante(Long idPlante) {
        this.idPlante = idPlante;
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

    public Long getIdEnvironnement() {
        return idEnvironnement;
    }

    public void setIdEnvironnement(Long idEnvironnement) {
        this.idEnvironnement = idEnvironnement;
    }

    public Long getIdSolution() {
        return idSolution;
    }

    public void setIdSolution(Long idSolution) {
        this.idSolution = idSolution;
    }
}