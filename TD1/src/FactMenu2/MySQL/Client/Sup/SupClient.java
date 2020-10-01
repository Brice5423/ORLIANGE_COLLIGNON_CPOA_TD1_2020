/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Client.Sup;

import java.util.Scanner;

public class SupClient {
    public static void supClient() {
        String id_client = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("Donner l'id du client a sup : ");
        id_client = sc.next();

        SupClientSQL.supClientSQL(id_client);
    }
}
