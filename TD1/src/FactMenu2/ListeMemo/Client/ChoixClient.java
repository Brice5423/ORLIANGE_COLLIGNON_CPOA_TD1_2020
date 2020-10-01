package FactMenu2.ListeMemo.Client;

import FactMenu2.ListeMemo.Client.Affiche.AfficheClient;
import FactMenu2.ListeMemo.Client.Ajout.AjoutClient;
import FactMenu2.ListeMemo.Client.Modif.ModifClient;
import FactMenu2.ListeMemo.Client.Sup.SupClient;

import java.util.Scanner;

public class ChoixClient {
    public static void choixClient() {
        System.out.println("Faite un choix entre les actions possibles pour la client :");
        System.out.println("1: affiche toutes les client de la base.");
        System.out.println("2: ajouter une client.");
        System.out.println("3: modifier une client.");
        System.out.println("4: supprimer une client.");

        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            choix = sc.nextInt();
        } while((choix < 1) || (choix > 4));

        System.out.println();

        switch(choix) {
            case 1:
                System.out.println("Choix 1 : affiche toutes les client de la base.");
                AfficheClient.afficheClient();
                break;
            case 2:
                System.out.println("Choix 2 : ajouter un client.");
                AjoutClient.ajoutClient();
                break;
            case 3:
                System.out.println("Choix 3 : modifier un client.");
                ModifClient.modifClient();
                break;
            case 4:
                System.out.println("Choix 4 : supprime un client");
                SupClient.supClient();
                break;
        }
    }
}