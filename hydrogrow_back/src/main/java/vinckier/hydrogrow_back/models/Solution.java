package vinckier.hydrogrow_back.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolution;
    private String description;
    private Double quantite;
    private Long idEnvironnement;
    private Date datePreparation;

    // Constructeurs
    public Solution() {
    }

    public Solution(Long idSolution, String description, Double quantite,
            Long idEnvironnement, Date datePreparation) {
        this.idSolution = idSolution;
        this.description = description;
        this.quantite = quantite;
        this.idEnvironnement = idEnvironnement;
        this.datePreparation = datePreparation;
    }

    // Getters et Setters
    public Long getIdSolution() {
        return idSolution;
    }

    public void setIdSolution(Long idSolution) {
        this.idSolution = idSolution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Long getIdEnvironnement() {
        return idEnvironnement;
    }

    public void setIdEnvironnement(Long idEnvironnement) {
        this.idEnvironnement = idEnvironnement;
    }

    public Date getDatePreparation() {
        return datePreparation;
    }

    public void setDatePreparation(Date datePreparation) {
        this.datePreparation = datePreparation;
    }
}