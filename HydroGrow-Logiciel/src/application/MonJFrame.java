package application;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.stream.Stream;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MonJFrame extends JFrame {

	public MonJFrame() throws IOException {
		// Titre de la fenêtre
		super("HydroGrow Interface");

		// Taille de la fenêtre
		setSize(500, 500);

		// Action lors de la fermeture de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initialisation des composants
		init();

		// Affichage de la fenêtre
		setVisible(true);

	}

	public void init() throws IOException {
		// Fichier csv
		String csvFile = ClassLoader.getSystemClassLoader().getResource("data/plantes.csv").getFile();
		// List<String> lines = CSVReader.read("data/plantes.csv");

		// Création d'une JTable pour afficher les données du CSV
		JTable table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 270, 450, 150);

		// JLabel pour la sélection de plante
		JLabel labelPlante = new JLabel("Plante : ");
		labelPlante.setBounds(20, 10, 70, 50); // Définissez les coordonnées et la taille du label

		// Création d'une combobox pour la sélection de plante
		// List<String> plantes = CSVReader.read(csvFile);

		// Lire le fichier CSV et stocker les valeurs de la première colonne dans une
		// liste
		List<String> plantes = CSVReader.readColumn(csvFile, 0);
		plantes.remove(0); // Supprimer la première ligne de la liste
		// Ajouter "Sélectionner une plante" à la première position de la liste
		plantes.add(0, "Sélectionner une plante");

		// Création d'une JTable pour afficher les données du CSV (seulement la première
		// colonne)
		List<String> nomsPlantes = CSVReader.readColumn(csvFile, 0);
		nomsPlantes.remove(0); // Supprimer la première ligne de la liste
		Object[][] data = new Object[nomsPlantes.size()][1];
		for (int i = 0; i < nomsPlantes.size(); i++) {
			String[] data2 = nomsPlantes.get(i).split(";");
			String nom = data2[0];
			double h = Double.parseDouble(data2[1]);
			double t = Double.parseDouble(data2[2]);

			Plante plante2 = new Plante(nom, h, t);
			Index.plantes.add(plante2);
		}

		// Création d'une combobox pour la sélection de plante
		JComboBox<String> comboBox = new JComboBox<>(plantes.toArray(new String[plantes.size()]));
		comboBox.setBounds(120, 20, 150, 30);

		// JLabel pour la température
		JLabel labelTemp = new JLabel("Température : ");
		labelTemp.setBounds(20, 70, 100, 30);

		// JTextField pour la température
		JTextField tempField = new JTextField();
		tempField.setBounds(120, 70, 150, 30);

		// JLabel pour l'humidité
		JLabel labelHum = new JLabel("Humidité : ");
		labelHum.setBounds(20, 120, 100, 30);

		// JTextField pour l'humidité
		JTextField humField = new JTextField();
		humField.setBounds(120, 120, 150, 30);

		// JButton pour reset
		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(20, 170, 100, 30);

		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempField.setText(""); // Réinitialisation du champ de texte pour la température
				humField.setText(""); // Réinitialisation du champ de texte pour l'humidité
				// labelOutput.setText(""); // Réinitialisation du champ de texte pour
				// l'affichage de sortie
			}
		});

		// JButton pour valider
		JButton validButton = new JButton("Valider");
		validButton.setBounds(170, 170, 100, 30);

		// JLabel pour l'affichage de sortie
		JLabel labelOutput = new JLabel(" ");
		labelOutput.setBounds(20, 220, 250, 30);

		// Action pour le bouton Valider
		validButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Récupération des valeurs saisies
				String planteSelectionnee = comboBox.setSelectedIndex(0);
				double temperature = Double.parseDouble(tempField.getText());
				double humidite = Double.parseDouble(humField.getText());

				// Vérification des conditions optimales
				Plante plante = Index.getPlante(planteSelectionnee);
				Environnement env = new Environnement(temperature, humidite);
				boolean isOptimal = env.isOptimal(plante);

				// Affichage du résultat
				if (isOptimal) {
					labelOutput.setText("Les conditions sont optimales pour la plante sélectionnée !");
				} else {
					labelOutput.setText("Les conditions ne sont pas optimales pour la plante sélectionnée !");
				}
			}
		});

		// Ajout des éléments dans le JFrame
		add(labelPlante);
		add(comboBox);
		add(labelTemp);
		add(tempField);
		add(labelHum);
		add(humField);
		add(resetButton);
		add(validButton);
		add(labelOutput);
		add(scrollPane);

		// Affichage de la fenêtre
		setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		new MonJFrame();
	}
}
