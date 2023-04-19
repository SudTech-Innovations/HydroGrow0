package application;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        // Création d'un objet Scanner pour lire l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur de saisir les valeurs d'environnement
        System.out.println("Entrez la température (en degrés Celsius):");
        double temperature = scanner.nextDouble();

        System.out.println("Entrez l'humidité (en pourcentage):");
        double humidite = scanner.nextDouble();

        // Création d'un objet Environnement à partir des valeurs d'environnement saisies
        Environnement environnement = new Environnement(temperature, humidite);

        // Affichage des valeurs d'environnement
        System.out.println("Les valeurs d'environnement sont:");
        System.out.println("Température: " + environnement.getTemperature() + "°C");
        System.out.println("Humidité: " + environnement.getHumidite() + "%");

        // Demander à l'utilisateur de saisir le nom de la plante
        System.out.println("Entrez le nom de la plante:");
        String nomPlante = scanner.next();

        // Création d'un objet Plante à partir du nom de la plante saisie
        Plante plante = new Plante(nomPlante);

        // Affichage des informations sur la plante
        System.out.println("Informations sur la plante:");
        System.out.println("Nom: " + plante.getNom());
        System.out.println("Humidité recommandée: " + plante.getHumiditeRecommandee() + "%");
        System.out.println("Température recommandée: " + plante.getTemperatureRecommandee() + "°C");

    }
}
