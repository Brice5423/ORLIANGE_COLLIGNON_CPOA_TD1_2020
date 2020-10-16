/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   main           */
/* Langage : Java & SQL           |                  */
/* Date : 17/09/2020              |                  */
/*****************************************************/

package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            URL fxmlURL = getClass().getResource("IU/Sample/CreerProduit.fxml");
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(fxmlURL);
            Node root = fxmlLoader.load();
            Scene scene = new Scene((VBox) root, 600, 500);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Ajouter un Produit");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /*// Text de choix entre les 2 types de menus //
        System.out.println("Faite un choix entre les 2 menus :");
        System.out.println("1: Menu1 (TD1)");
        System.out.println("2: Menu2 (TD2)");

        // Oblige de donner un des 2 choix (1 ou 2) //
        Scanner sc = new Scanner(System.in);
        int choix = 1;
        do {
            choix = sc.nextInt();
        } while ((choix < 1) || (choix > 2));

        System.out.println();

        switch (choix) {
            case 1:
                System.out.println("Choix 1 : TD1.");
                Menu1.menu1();
                break;
            case 2:
                System.out.println("Choix 2 : TD2.");
                Menu2.menu2();
                break;
        }*/

        // launch application project
        Application.launch(args);
    }
}
