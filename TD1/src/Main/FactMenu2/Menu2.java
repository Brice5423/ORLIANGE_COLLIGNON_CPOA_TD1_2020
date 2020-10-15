/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2            */
/* Langage : Java & SQL           |                  */
/* Date : 07/10/2020              |                  */
/*****************************************************/

package Main.FactMenu2;

import java.util.Scanner;

import DAO.Enum.EPersistance;

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
        } while ((choix < 1) || (choix > 2));

        System.out.println();

        EPersistance type;

        switch (choix) {
            case 1:
                System.out.println("Choix 1 : Menu MySQL.");
                type = EPersistance.MYSQL;
                break;
            case 2:
                System.out.println("Choix 2 : Menu Liste Memoire.");
                type = EPersistance.LISTE_MEMOIRE;
                break;
            default:
                throw new IllegalStateException("Valeur inadaptée : " + choix);
        }

        /*DaoFactory DaoF = DaoFactory.getDAOFactory(type);
        IDaoCategorie DaoCat = DaoF.getDaoCategorie();
        IDaoClient DaoCli = DaoF.getDaoClient();
        IDaoProduit DaoProd = DaoF.getDaoProduit();

        List<Categorie> categories = DaoCat.getAllCategories();
        List<Client> clients = DaoCli.getAllClients();
        List<Produit> produits = DaoProd.getAllProduits();*/


        System.out.println("Le programe ne va pas plus loin. On as eu des problèmes et on sait consentrer sur les tests.");
    }
}
