package application;

/**
 * @author Nicolas_Vinckier
 *
 */
public class Environnement {
    private double temperature;
    private double humidite;

    /**
     * @param temperature
     * @param humidite
     */
    public Environnement(double temperature, double humidite) {
        this.temperature = temperature;
        this.humidite = humidite;
    }

    /** Getter 
     * @return double
     */
    public double getTemperature() {
        return temperature;
    }

    /** Getter
     * @return double
     */
    public double getHumidite() {
        return humidite;
    }

    /**
     * @param plante
     * @return
     */
    public boolean isOptimal(Plante plante) {
        // Comparaison des valeurs d'humidité et de température avec celles recommandées
        // pour la plante
        if (this.humidite >= plante.getHumiditeRecommandee()
                && this.temperature >= plante.getTemperatureRecommandee()) {
            return true;
        } else {
            return false;
        }
    }
}
