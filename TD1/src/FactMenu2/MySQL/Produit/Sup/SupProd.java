/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Produit.Sup;

import java.util.Scanner;

public class SupProd {
    public static void supProd() {
        String id_prod = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("Donner l'id du produit a sup : ");
        id_prod = sc.next();

        SupProdSQL.supProdSQL(id_prod);
    }
}
