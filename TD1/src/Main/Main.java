/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |                  */
/* Langage : Java JDK15 & MySQL   |                  */
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
        // launch application project //
        Application.launch(args);
    }
}
