/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2;

import java.util.Scanner;

import FactMenu2.Choix.*;
import DAO.Enum.EPersistance;

// Pour savoir si il y a une classe dans à DAO à implementé. Pour l'opti //
import DAO.*;

public class Menu2 {
    public static void menu2() {
        // Text explicative des choix possibles //
        System.out.println("Faite un choix entre les 2 types de traitement :");
        System.out.println("1: Menu MySQL.");
        System.out.println("2: Menu Liste Memoire.");

        Scanner sc = new Scanner(System.in);
        int choix = 1;
        do {
            choix = sc.nextInt();
        } while ((choix < 1) || (choix > 3));

        System.out.println();

        EPersistance Type;
        switch (choix) {
            case 1:
                System.out.println("Choix 1 : Menu MySQL.");
                Type = EPersistance.MYSQL;
                MenuSQL.menuSQL();
                break;
            case 2:
                System.out.println("Choix 2 : Menu Liste Memoire.");
                Type = EPersistance.LISTE_MEMOIRE;
                MenuLM.menuLM();
                break;
        }
    }
}
