package home.iu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.net.URL;

public class Controller_Accueil {

    @FXML
    private RadioButton radio_MYSQL;

    @FXML
    private RadioButton radio_LM;

    @FXML
    void OnCick_Quitter(ActionEvent event) {

    }

    @FXML
    void OnClick_Aide(ActionEvent event) {

    }

    @FXML
    void OnClick_Categorie(ActionEvent event) {
        Scene scene = null;
        Stage stage = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            scene = new Scene(FXMLLoader.load(getClass().getResource("../sample/Categorie.fxml")));
            stage = new Stage();
            stage.setTitle("Pages des Catégories");
            assert stage != null;
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnClick_Client(ActionEvent event) {
        Scene scene = null;
        Stage stage = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            scene = new Scene(FXMLLoader.load(getClass().getResource("../sample/Client.fxml")));
            stage = new Stage();
            stage.setTitle("Page des Clients");
            assert stage != null;
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnClick_Commande(ActionEvent event) {
        Scene scene = null;
        Stage stage = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            scene = new Scene(FXMLLoader.load(getClass().getResource("../sample/Commande.fxml")));
            stage = new Stage();
            stage.setTitle("Page des Commandes");
            assert stage != null;
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnClick_Produit(ActionEvent event) {
        Scene scene = null;
        Stage stage = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            scene = new Scene(FXMLLoader.load(getClass().getResource("../sample/Produit.fxml")));
            stage = new Stage();
            stage.setTitle("Page des Produits");
            assert stage != null;
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


