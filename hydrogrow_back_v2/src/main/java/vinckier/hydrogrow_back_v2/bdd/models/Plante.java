package vinckier.hydrogrow_back_v2.bdd.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlante;
    private String nomPlante;
    private String typePlante;
    private String description;
    private int boutureMin;
    private int boutureMax;
    private int pousseMin;
    private int pousseMax;
    private int humiditeMin;
    private int humiditeMax;
    private int temperatureMin;
    private int temperatureMax;
    private String lumiere;
    private int expositionMin;
    private int expositionMax;

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

    public int getBoutureMin() {
        return boutureMin;
    }

    public void setBoutureMin(int boutureMin) {
        this.boutureMin = boutureMin;
    }

    public int getBoutureMax() {
        return boutureMax;
    }

    public void setBoutureMax(int boutureMax) {
        this.boutureMax = boutureMax;
    }

    public int getPousseMin() {
        return pousseMin;
    }

    public void setPousseMin(int pousseMin) {
        this.pousseMin = pousseMin;
    }

    public int getPousseMax() {
        return pousseMax;
    }

    public void setPousseMax(int pousseMax) {
        this.pousseMax = pousseMax;
    }

    public int getHumiditeMin() {
        return humiditeMin;
    }

    public void setHumiditeMin(int humiditeMin) {
        this.humiditeMin = humiditeMin;
    }

    public int getHumiditeMax() {
        return humiditeMax;
    }

    public void setHumiditeMax(int humiditeMax) {
        this.humiditeMax = humiditeMax;
    }

    public int getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(int temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public int getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(int temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public String getLumiere() {
        return lumiere;
    }

    public void setLumiere(String lumiere) {
        this.lumiere = lumiere;
    }

    public int getExpositionMin() {
        return expositionMin;
    }

    public void setExpositionMin(int expositionMin) {
        this.expositionMin = expositionMin;
    }

    public int getExpositionMax() {
        return expositionMax;
    }

    public void setExpositionMax(int expositionMax) {
        this.expositionMax = expositionMax;
    }

    public void setNom(String nom) {
        this.nomPlante = nom;
    }
}
