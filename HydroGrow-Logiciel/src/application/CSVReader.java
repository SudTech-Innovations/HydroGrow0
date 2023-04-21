package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicolas_Vinckier
 *
 */
public class CSVReader {
    /**
     * @param csvFile
     * @param column
     * @return
     * @throws IOException
     */
    public static List<String> readColumn(String csvFile, int column) throws IOException {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<String> values = new ArrayList<String>();

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            String[] row = line.split(cvsSplitBy);
            if (row.length > column) {
                values.add(row[column]);
            }
        }
        if (br != null) {
            br.close();
        }

        return values;
    }

    /**
     * @param csvFile
     * @return
     * @throws IOException
     */
    public static List<String> read(String csvFile) throws IOException {
        BufferedReader br = null;
        String line = "";
        // String cvsSplitBy = ";";
        List<String> lines = new ArrayList<String>();

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        if (br != null) {
            br.close();
        }

        return lines;
    }
}
