/* ********************************|**************** */
/* Auteur : Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : VSC & Eclipse       |   ...            */
/* Langage : Java                 |                  */
/* Date : 15/09/2020              |                  */
/* ********************************|**************** */

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;*/

import java.util.Scanner;

public class Connexion {
	public static void main(final String[] args) {
		// Text explicative des choix //
		System.out.println("Faite un choix :");
		System.out.println("1: ajouter une catégorie.");
		System.out.println("2: modifier une catégorie.");
		System.out.println("3: supprimer une catégorie.");
		System.out.println("4: renvoier toutes les catégories de la base.");

		// Pour donner les choix voulu //
		final Scanner sc = new Scanner(System.in);
		int choix;
		do {
			choix = sc.nextInt();
		} while((choix < 1) || (choix > 4));
		sc.close();

		System.out.println("");

		switch(choix) {
			case 1:
				System.out.println("Choix 1 : ajouter une catégorie.");
				break;
			case 2:
				System.out.println("Choix 2 : modifier une catégorie.");
				break;
			case 3:
				System.out.println("Choix 3 : supprimer une catégorie.");
				break;
			case 4:
				System.out.println("Choix 4 : renvoier toutes les catégories de la base.");
				break;
		}
	}


	//----- ----- Fonction pour la connextion ----- -----//

	// Etape 1: connexion //
	/*public Connection creeConnexion() {
		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/collign97u_CPPOA";
		url += "?serverTimezone=Europe/Paris";
		String login = "collign97u_appli";
		String pwd = "Nico2410";

		Connection maConnexion = null;

		try {
			maConnexion = DriverManager.getConnection(url, login, pwd);
		} catch (SQLException sqle) {
			System.out.println("Erreur connexion" + sqle.getMessage());
		}

		return maConnexion;
	}

	// Etape 2 : exécution d'une requête //
	public void uneRequete() {
		try {
			Connection laConnexion = creeConnexion();
			Statement requete = laConnexion.createStatement();
			ResultSet res = requete.executeQuery("select no_etudiant, nom_etudiant from etudiant");
			
			// Etape 3 : les résultats //
			while (res.next()) {
				int no = res.getInt(1);
				String nom = res.getString("nom_etudiant");
			}
			
			// Etape 4 : fermetures //
			if (res != null)
				res.close();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}*/
}
