package executable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterfaceJFrame extends JFrame {
	JTextField tempField = new JTextField();
	JTextField humField = new JTextField();

	/**
	 * 
	 */
	public InterfaceJFrame() throws IOException {
		// Titre de la fenêtre
		super("HydroGrow Interface");

		// Taille de la fenêtre
		setSize(400, 400);

		// Action lors de la fermeture de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initialisation des composants
		init();

		// Affichage de la fenêtre
		setVisible(true);

	}

	public void init() throws IOException {

		// JLabel pour la sélection de plante
		JLabel labelPlante = new JLabel("Plante : ");
		// Définissez les coordonnées et la taille du label
		labelPlante.setBounds(20, 10, 70, 50);

		// Création d'une combobox pour la sélection de plante
		// JComboBox<String> comboBox = new JComboBox<>(plantes.toArray(new
		// String[plantes.size()]));
		// comboBox.setBounds(120, 20, 150, 30);

		// JLabel pour la température
		JLabel labelTemp = new JLabel("Température : ");
		labelTemp.setBounds(20, 70, 100, 30);

		// JTextField pour la température
		tempField.setBounds(120, 70, 150, 30);

		// JLabel pour l'humidité
		JLabel labelHum = new JLabel("Humidité : ");
		labelHum.setBounds(20, 120, 100, 30);

		// JTextField pour l'humidité
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

		// Ajout des éléments dans le JFrame
		add(labelPlante);
		// add(comboBox);
		add(labelTemp);
		add(tempField);
		add(labelHum);
		add(humField);
		add(resetButton);
		add(validButton);
		add(labelOutput);

		setVisible(true);
	}
}
