package application;

public class Environnement {
    private double temperature;
    private double humidite;

    public Environnement(double temperature, double humidite) {
        this.temperature = temperature;
        this.humidite = humidite;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidite() {
        return humidite;
    }

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
