import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	// Etape 1: connexion //
	public Connection creeConnexion() {
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
	}
}
