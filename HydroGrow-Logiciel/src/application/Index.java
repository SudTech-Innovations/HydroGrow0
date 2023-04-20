package application;

import java.util.Scanner;

public class Index {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomPlante;
        boolean planteTrouvee = false;

        // Boucle tant que la plante n'est pas trouvée dans le fichier CSV
        while (!planteTrouvee) {
            System.out.println("Entrez le nom de la plante :");
            nomPlante = scanner.nextLine();

            // Vérifier si la plante est dans le fichier CSV
            Plante plante = Plante.getPlanteFromCSV(nomPlante);
            if (plante != null) {
                planteTrouvee = true;

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
                            "L'humidité est trop élevée de " + differenceHumidite
                                    + "% par rapport à la recommandation.");
                } else if (humidite < humiditeRecommandee) {
                    double differenceHumidite = humiditeRecommandee - humidite;
                    System.out.println(
                            "L'humidité est trop faible de " + differenceHumidite
                                    + "% par rapport à la recommandation.");
                } else {
                    System.out.println("L'humidité est dans la plage recommandée.");
                }
            } else {
                System.out.println("La plante n'est pas dans le fichier CSV. Veuillez saisir à nouveau.");
            }
        }

        scanner.close();
    }
}
