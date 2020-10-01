/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Client.Modif;

import java.util.Scanner;

public class ModifClient {
    public static void modifClient() {
        String id_client = null, nom_client = null, prenom_client = null, identifiant_client = null, mdp_client = null;
        String adr_num_client = null, adr_voie_client = null, adr_code_client = null, adr_ville_client = null, adr_pays_client = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("Donner l'id du client à modif :");
        id_client = sc.next();
        System.out.println("Donner le nom du client à modif :");
        nom_client = sc.next();
        System.out.println("Donner le prenom du client à modif :");
        prenom_client = sc.next();
        System.out.println("Donner l'identifant du client à modif :");
        identifiant_client = sc.next();
        System.out.println("Donner le mdp du client à modif svp :");
        mdp_client = sc.next();
        System.out.println("Donner le numero de l'adresse du client à modif :");
        adr_num_client = sc.next();
        System.out.println("Donner ld rue de l'adresse du client à modif :");
        adr_voie_client = sc.next();
        System.out.println("Donner le code porstal du client à modif :");
        adr_code_client = sc.next();
        System.out.println("Donner le ville du client à modif :");
        adr_ville_client = sc.next();
        System.out.println("Donner le pays du client à modif :");
        adr_pays_client = sc.next();

        ModifClientSQL.modifClientSQL(id_client, nom_client, prenom_client, identifiant_client, mdp_client,
                                    adr_num_client, adr_voie_client, adr_code_client, adr_ville_client, adr_pays_client);
    }
}
