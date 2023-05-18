package vinckier.hydrogrow_back.models;

import javax.persistence.*;

@Entity
@Table(name = "environnement")
public class Environnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_environnement")
    private Long idEnvironnement;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "humidite")
    private Double humidite;

    @Column(name = "luminosite")
    private Integer luminosite;

    @Column(name = "ph")
    private Double ph;

    @Column(name = "nutriments")
    private String nutriments;

    public Environnement() {
    }

    // getters and setters
    public Long getIdEnvironnement() {
        return idEnvironnement;
    }

    public void setIdEnvironnement(Long idEnvironnement) {
        this.idEnvironnement = idEnvironnement;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidite() {
        return humidite;
    }

    public void setHumidite(Double humidite) {
        this.humidite = humidite;
    }

    public Integer getLuminosite() {
        return luminosite;
    }

    public void setLuminosite(Integer luminosite) {
        this.luminosite = luminosite;
    }

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    public String getNutriments() {
        return nutriments;
    }

    public void setNutriments(String nutriments) {
        this.nutriments = nutriments;
    }
}