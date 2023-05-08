package com.vinckier.hydrogrow_v2;

/**
 * Classe principale du programme HydroGrow_v2 qui lance l'interface
 * utilisateur.
 * Si c'est la première fois que le logiciel est installé, il est nécessaire de
 * créer la base de données "hydrobase"
 * dans le gestionnaire de base de données (type phpmyadmin).
 */
public class Index {
	/**
	 * Execution du programme
	 */
	public static void main(String[] args) {
		// DatabaseInitializer.init();

		// Interface start = new Interface();
		// System.out.println(start);

		Interface_v2 start = new Interface_v2();
		System.out.println(start);
	}

}
