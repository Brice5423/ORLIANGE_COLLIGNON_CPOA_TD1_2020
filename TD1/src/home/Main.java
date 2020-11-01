/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   SURVIVRE       */
/* Langage : Java JDK 15 & MySQL  |                  */
/* Date : 17/09/2020              |                  */
/*****************************************************/

package home;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;


public class Main extends Application {
    public static void main(String[] args) {
        // launch application project //
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            URL fxmlURL = getClass().getResource("iu/sample/Accueil.fxml");
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(fxmlURL);
            Node root = fxmlLoader.load();
            Scene scene = new Scene((VBox) root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Boutique de vêtements moches");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
