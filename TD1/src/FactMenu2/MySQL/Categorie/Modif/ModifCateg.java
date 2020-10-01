/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Categorie.Modif;

import java.util.Scanner;

public class ModifCateg {
    public static void modifCateg() {
        String id_cat = null, titre_cat = null, visuel_cat = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("Donner l'id pour le changement de la Categorie : ");
        id_cat = sc.next();
        System.out.println("Donner un nouveau titre de la Categorie : ");
        titre_cat = sc.next();
        System.out.println("Donner un nouveau visuel de la Categorie : ");
        visuel_cat = sc.next();

        ModifCategSQL.modifCategSQL(id_cat, titre_cat, visuel_cat);
    }
}
