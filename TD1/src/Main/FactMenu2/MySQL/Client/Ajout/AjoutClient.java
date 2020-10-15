/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package Main.FactMenu2.MySQL.Client.Ajout;

import java.util.Scanner;

public class AjoutClient {
    public static void ajoutClient() {
        String nom_client = null, prenom_client = null, identifiant_client = null, mdp_client = null;
        String adr_num_client = null, adr_voie_client = null, adr_code_client = null, adr_ville_client = null, adr_pays_client = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("Donner le nom du client :");
        nom_client = sc.next();
        System.out.println("Donner le prenom du client :");
        prenom_client = sc.next();
        System.out.println("Donner l'identifant du client :");
        identifiant_client = sc.next();
        System.out.println("Donner le mdp du client svp :");
        mdp_client = sc.next();
        System.out.println("Donner le numero de l'adresse du client :");
        adr_num_client = sc.next();
        System.out.println("Donner la voie de l'adresse du client :");
        adr_voie_client = sc.next();
        System.out.println("Donner le code porstal du client :");
        adr_code_client = sc.next();
        System.out.println("Donner le ville du client :");
        adr_ville_client = sc.next();
        System.out.println("Donner le pays du client :");
        adr_pays_client = sc.next();

        AjoutClientSQL.ajoutClientSQL(nom_client, prenom_client, identifiant_client, mdp_client,
                                    adr_num_client, adr_voie_client, adr_code_client, adr_ville_client, adr_pays_client);
    }
}
