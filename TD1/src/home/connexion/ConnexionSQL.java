package home.connexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnexionSQL { // Etape 1: connexion //
    public static Connection creeConnexion() {
        String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/collign97u_CPOA";
        url += "?serverTimezone=Europe/Paris";
        String login = "collign97u_appli";
        String pwd = "Jfido47992";

        Connection maConnexion = null;

        try {
            maConnexion = DriverManager.getConnection(url, login, pwd);
        } catch (SQLException sqle) {
            System.out.println("Erreur connexion" + sqle.getMessage());
        }

        return maConnexion;
    }
}
