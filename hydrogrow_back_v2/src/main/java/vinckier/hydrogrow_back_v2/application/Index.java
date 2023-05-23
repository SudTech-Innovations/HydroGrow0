// package vinckier.hydrogrow_back_v2.application;

// import java.io.IOException;
// import java.util.List;

// import jakarta.persistence.EntityManager;
// import vinckier.hydrogrow_back_v2.bdd.JPAUtils;
// import vinckier.hydrogrow_back_v2.dao.boucle.*;
// import vinckier.hydrogrow_back_v2.dao.service.*;

// /**
//  * Classe principale de l'application.
//  */
// public class Index {

// 	/**
// 	 * Méthode principale de l'application.
// 	 * Elle lit un fichier CSV contenant des informations sur les produits
// 	 * alimentaires, instancie les DAO nécessaires pour stocker ces informations
// 	 * dans une base de données, puis exécute plusieurs boucles qui effectuent des
// 	 * opérations de base de données pour stocker les informations.
// 	 * Enfin, elle ferme l'EntityManager et affiche "OK".
// 	 * 
// 	 * @param args Les arguments de la ligne de commande.
// 	 * @throws IOException Si une erreur d'entrée / sortie se produit lors de la
// 	 *                     lecture du fichier CSV.
// 	 */
// 	public static void main(String[] args) throws IOException {
// 		String csvFile = "hydrogrow_back_v2/src/main/java/vinckier/hydrogrow_back_v2/application/plantes.csv";
// 		String delimiter = ",";
// 		LecteurCSV lecteurCSV = new LecteurCSV(csvFile, delimiter);

// 		List<List<String>> lines = lecteurCSV.lignes();

// 		// System.out.println("Contenu du fichier CSV :");
// 		// for (List<String> row : lines) {
// 		// for (String value : row) {
// 		// System.out.print(value + " ");
// 		// }
// 		// System.out.println();
// 		// }

// 		EntityManager em = JPAUtils.getInstance().getEntityManager();

// 		PlanteDAO planteDAO = new PlanteDAO(em);

// 		BouclePlante bouclePlante = new BouclePlante();
// 		BouclePlante.bouclePlante(lines, lecteurCSV, planteDAO);

// 		em.close();

// 		System.out.println("OK");
// 	}
// }
