package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Plante {
    private String nom;
    private double humiditeRecommandee;
    private double temperatureRecommandee;

    public Plante(String nomPlante) {
        this.nom = nomPlante;
        // Récupération des valeurs d'humidité et de température recommandées à partir
        // du fichier CSV
        String csvFile = "HydroGrow/data/plantes.csv";
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] plante = line.split(cvsSplitBy);
                if (plante[0].equals(nomPlante)) {
                    humiditeRecommandee = Double.parseDouble(plante[1]);
                    temperatureRecommandee = Double.parseDouble(plante[2]);
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNom() {
        return nom;
    }

    public double getHumiditeRecommandee() {
        return humiditeRecommandee;
    }

    public double getTemperatureRecommandee() {
        return temperatureRecommandee;
    }
}
