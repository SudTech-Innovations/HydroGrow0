package vinckier.hydrogrow_back_v2.dao.boucle;

import java.util.List;

import vinckier.hydrogrow_back_v2.application.LecteurCSV;
import jakarta.persistence.EntityManager;
import vinckier.hydrogrow_back_v2.bdd.models.Plante;
import vinckier.hydrogrow_back_v2.dao.service.PlanteDAO;

/**
 * Cette classe implémente une méthode pour boucler sur les lignes d'un fichier
 * CSV d'informations sur les plantes. Chaque ligne est traitée pour créer une
 * nouvelle instance 'Plante' et la stocker en base de données.
 */
public class BouclePlante {

    /**
     * Méthode pour boucler sur les lignes d'un fichier CSV d'informations sur les
     * plantes, pour créer une instance Plante et la sauvegarder en base de données
     * à l'aide de PlanteDAO.
     * 
     * @param lines      La liste de lignes du fichier CSV contenant les
     *                   informations sur les plantes.
     * @param lecteurCSV Le lecteur CSV utilisé pour lire les lignes du fichier CSV.
     * @param planteDAO  Le DAO utilisé pour stocker les instances 'Plante' en base
     *                   de données.
     * @param em         L'EntityManager permettant l'accès à la base de données via
     *                   l'implémentation JPA.
     */
    public static void bouclePlante(List<List<String>> lines, LecteurCSV lecteurCSV, PlanteDAO planteDAO) {

        for (int i = 1; i < lines.size(); i++) {

            Plante plante = new Plante();

            plante.setIdPlante((long) i);
            plante.setNom(lines.get(i).get(0));

            String boutureString = lines.get(i).get(1);
            String[] boutureParts = boutureString.split("-");
            int boutureMin = 0;
            int boutureMax = 0;
            if (boutureParts.length == 2) {
                boutureMin = Integer.parseInt(boutureParts[0]);
                boutureMax = Integer.parseInt(boutureParts[1]);
            }
            plante.setBoutureMin(boutureMin);
            plante.setBoutureMax(boutureMax);

            String pousseString = lines.get(i).get(2);
            String[] pousseParts = pousseString.split("-");
            int pousseMin = 0;
            int pousseMax = 0;
            if (pousseParts.length == 2) {
                pousseMin = Integer.parseInt(pousseParts[0]);
                pousseMax = Integer.parseInt(pousseParts[1]);
            }
            plante.setPousseMin(pousseMin);
            plante.setPousseMax(pousseMax);

            String humiditeString = lines.get(i).get(3);
            String[] humiditeParts = humiditeString.split("-");
            int humiditeMin = 0;
            int humiditeMax = 0;
            if (humiditeParts.length == 2) {
                humiditeMin = Integer.parseInt(humiditeParts[0]);
                humiditeMax = Integer.parseInt(humiditeParts[1]);
            }
            plante.setHumiditeMin(humiditeMin);
            plante.setHumiditeMax(humiditeMax);

            String temperatureString = lines.get(i).get(4);
            String[] temperatureParts = temperatureString.split("-");
            int temperatureMin = 0;
            int temperatureMax = 0;
            if (temperatureParts.length == 2) {
                temperatureMin = Integer.parseInt(temperatureParts[0]);
                temperatureMax = Integer.parseInt(temperatureParts[1]);
            }
            plante.setTemperatureMin(temperatureMin);
            plante.setTemperatureMax(temperatureMax);

            String lumiere = lines.get(i).get(5);
            plante.setLumiere(lumiere);

            String expositionString = lines.get(i).get(6);
            String[] expositionParts = expositionString.split("-");
            int expositionMin = 0;
            int expositionMax = 0;
            if (expositionParts.length == 2) {
                expositionMin = Integer.parseInt(expositionParts[0]);
                expositionMax = Integer.parseInt(expositionParts[1]);
            }
            plante.setExpositionMin(expositionMin);
            plante.setExpositionMax(expositionMax);

            planteDAO.save(plante);
        }
    }
}
