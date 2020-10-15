package Main; /*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   main           */
/* Langage : Java & SQL           |                  */
/* Date : 17/09/2020              |                  */
/*****************************************************/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            URL fxmlURL=getClass().getResource("IU/Sample/CreerProduit.fxml");
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


        // launch application project
        Application.launch(args);
    }
}

//public class Main {
//    public static void main(String[] args) {
//        // Text de choix entre les 2 types de menus //
//        System.out.println("Faite un choix entre les 2 menus :");
//        System.out.println("1: Menu1 (TD1)");
//        System.out.println("2: Menu2 (TD2)");
//
//        // Oblige de donner un des 4 choix (1, 2, 3 ou 4) //
//        Scanner sc = new Scanner(System.in);
//        int choix = 1;
//        do {
//            choix = sc.nextInt();
//        } while ((choix < 1) || (choix > 2));
//
//        System.out.println();
//
//        switch (choix) {
//            case 1:
//                System.out.println("Choix 1 : Categorie.");
//                Menu1.menu1();
//                break;
//            case 2:
//                System.out.println("Choix 2 : Produit.");
//                Menu2.menu2();
//                break;
//        }
//    }
//}