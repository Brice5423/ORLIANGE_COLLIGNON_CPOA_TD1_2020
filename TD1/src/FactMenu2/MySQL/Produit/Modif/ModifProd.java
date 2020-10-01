/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Produit.Modif;

import java.util.Scanner;

public class ModifProd {
    public static void modifProd() {
        String id_prod = null, nom_prod = null, description_prod = null, tarif_prod = null, visuel_prod = null, id_categorie = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("Donner l'id du produit a modif : ");
        id_prod = sc.next();
        System.out.println("Donner un nom au produit modif : ");
        nom_prod = sc.next();
        System.out.println("Donner une description du produit modif : ");
        description_prod = sc.next();
        System.out.println("Donner un tarif du produit modif : ");
        tarif_prod = sc.next();
        System.out.println("Donner le visuel du produit modif : ");
        visuel_prod = sc.next();
        System.out.println("Donner l'id du type de categorie du produit modif : ");
        id_categorie = sc.next();

        ModifProdSQL.modifProdSQL(id_prod, nom_prod, description_prod, tarif_prod, visuel_prod, id_categorie);
    }
}
