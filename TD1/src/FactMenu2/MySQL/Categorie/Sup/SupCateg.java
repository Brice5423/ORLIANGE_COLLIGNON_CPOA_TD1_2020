/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Categorie.Sup;

import java.util.Scanner;

public class SupCateg {
    public static void supCateg() {
        String id_categ = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("Donner l'id de la categorie a sup : ");
        id_categ = sc.next();

        SupCategSQL.supCategSQL(id_categ);
    }
}
