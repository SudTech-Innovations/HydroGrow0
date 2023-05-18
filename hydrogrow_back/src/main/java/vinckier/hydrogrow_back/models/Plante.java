package vinckier.hydrogrow_back.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlante;
    private String nomPlante;
    private String typePlante;
    private String description;

    // Constructeurs
    public Plante() {
    }

    public Plante(Long idPlante, String nomPlante, String typePlante, String description) {
        this.idPlante = idPlante;
        this.nomPlante = nomPlante;
        this.typePlante = typePlante;
        this.description = description;
    }

    // Getters et Setters
    public Long getIdPlante() {
        return idPlante;
    }

    public void setIdPlante(Long idPlante) {
        this.idPlante = idPlante;
    }

    public String getNomPlante() {
        return nomPlante;
    }

    public void setNomPlante(String nomPlante) {
        this.nomPlante = nomPlante;
    }

    public String getTypePlante() {
        return typePlante;
    }

    public void setTypePlante(String typePlante) {
        this.typePlante = typePlante;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}