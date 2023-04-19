package application;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Créer une instance de la classe Plante avec le nom de la plante saisi par
        // l'utilisateur
        System.out.println("Entrez le nom de la plante :");
        String nomPlante = scanner.next();
        Plante plante = new Plante(nomPlante);

        // Demander à l'utilisateur d'entrer les valeurs d'environnement
        System.out.println("Entrez la température de l'environnement :");
        double temperature = scanner.nextDouble();

        System.out.println("Entrez l'humidité de l'environnement :");
        double humidite = scanner.nextDouble();

        // Vérifier si les valeurs saisies sont supérieures ou inférieures aux valeurs
        // recommandées
        double humiditeRecommandee = plante.getHumiditeRecommandee();
        double temperatureRecommandee = plante.getTemperatureRecommandee();

        if (temperature > temperatureRecommandee) {
            double differenceTemperature = temperature - temperatureRecommandee;
            System.out.println("La température est trop élevée de " + differenceTemperature
                    + "°C par rapport à la recommandation.");
        } else if (temperature < temperatureRecommandee) {
            double differenceTemperature = temperatureRecommandee - temperature;
            System.out.println("La température est trop faible de " + differenceTemperature
                    + "°C par rapport à la recommandation.");
        } else {
            System.out.println("La température est dans la plage recommandée.");
        }

        if (humidite > humiditeRecommandee) {
            double differenceHumidite = humidite - humiditeRecommandee;
            System.out.println(
                    "L'humidité est trop élevée de " + differenceHumidite + "% par rapport à la recommandation.");
        } else if (humidite < humiditeRecommandee) {
            double differenceHumidite = humiditeRecommandee - humidite;
            System.out.println(
                    "L'humidité est trop faible de " + differenceHumidite + "% par rapport à la recommandation.");
        } else {
            System.out.println("L'humidité est dans la plage recommandée.");
        }

        scanner.close();
    }
}
