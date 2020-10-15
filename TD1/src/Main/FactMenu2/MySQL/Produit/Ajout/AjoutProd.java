/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package Main.FactMenu2.MySQL.Produit.Ajout;

import java.util.Scanner;

public class AjoutProd {
    public static void ajoutProd() {
        String nom_prod = null, description_prod = null, tarif_prod = null, visuel_prod = null, id_categorie = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("Donner un nom au produit : ");
        nom_prod = sc.next();
        System.out.println("Donner une description du produit : ");
        description_prod = sc.next();
        System.out.println("Donner un tarif du produit : ");
        tarif_prod = sc.next();
        System.out.println("Donner le visuel du produit : ");
        visuel_prod = sc.next();
        System.out.println("Donner l'id du type de categorie du produit : ");
        id_categorie = sc.next();

        AjoutProdSQL.ajoutProdSQL(nom_prod, description_prod, tarif_prod, visuel_prod, id_categorie);
    }
}
