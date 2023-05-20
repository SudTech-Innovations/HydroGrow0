package vinckier.hydrogrow_back_v2.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe effectue la lecture d'un fichier CSV.
 */
public class LecteurCSV {

    /**
     * Chemin du fichier CSV
     */
    public String csvFile;

    /**
     * Délimiteur entre les valeurs CSV
     */
    public String delimiter;

    /**
     * Liste de toutes les lignes de CSV, chaque ligne étant une liste de chaînes de
     * caractères
     */
    public List<List<String>> lines = new ArrayList<List<String>>();

    /**
     * Constructeur pour initialiser les variables csvFile, delimiter et lines.
     * 
     * @param csvFile   Le chemin du fichier CSV à lire.
     * @param delimiter Le délimiteur utilisé pour séparer les valeurs CSV.
     * @throws IOException si une erreur d'entrée-sortie survient lors de la lecture
     *                     du fichier CSV.
     */
    public LecteurCSV(String csvFile, String delimiter) throws IOException {
        this.csvFile = csvFile;
        this.delimiter = delimiter;
        BufferedReader br = null;
        String line = "";

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            String[] row = line.split(delimiter);
            List<String> rowList = new ArrayList<String>();
            for (String value : row) {
                rowList.add(value);
            }
            lines.add(rowList);
        }
        if (br != null) {
            br.close();
        }
    }

    /**
     * Renvoie toutes les valeurs de la colonne spécifiée sous forme de liste de
     * chaînes de caractères
     * 
     * @param column L'indice de la colonne à récupérer
     * @return La liste des valeurs pour la colonne spécifiée.
     */
    public List<String> colonne(int column) {
        List<String> values = new ArrayList<String>();
        for (List<String> row : lines) {
            if (row.size() > column) {
                values.add(row.get(column));
            }
        }
        return values;
    }

    /**
     * Renvoie la ligne spécifiée sous forme de liste de chaînes de caractères.
     * 
     * @param row L'indice de la ligne à récupérer
     * @return La liste des valeurs pour la ligne spécifiée
     * @throws IndexOutOfBoundsException Si l'index de la ligne n'est pas valide.
     */
    public List<String> ligne(int row) {
        if (row < 0 || row >= lines.size()) {
            throw new IndexOutOfBoundsException("Indice de ligne invalide : " + row);
        }
        return lines.get(row);
    }

    /**
     * Renvoie toutes les lignes du fichier CSV sous forme d'une liste de listes de
     * chaînes de caractères
     * 
     * @return La liste des lignes CSV sous forme de liste de listes de chaînes de
     *         caractères.
     */
    public List<List<String>> lignes() {
        return lines;
    }
}