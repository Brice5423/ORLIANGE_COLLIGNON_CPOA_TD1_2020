package home.iu.controller;


import dao.enumeration.EPersistance;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class Controller_Accueil implements Initializable {
    public static EPersistance typeEPersistance;
    private ToggleGroup Button;


    @FXML
    private RadioButton radio_MYSQL;

    @FXML
    private RadioButton radio_LM;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button = new ToggleGroup();
        this.radio_MYSQL.setToggleGroup(Button);
        this.radio_LM.setToggleGroup(Button);

        this.radio_MYSQL.setSelected(false);
        this.radio_LM.setSelected(true);
        typeEPersistance = EPersistance.LISTE_MEMOIRE;
    }


    @FXML
    void OnClick_ConfirmationRD(ActionEvent event) {
        if (Button.getSelectedToggle().equals(radio_MYSQL)) {
            typeEPersistance = EPersistance.MYSQL;
        }
        else {
            typeEPersistance = EPersistance.LISTE_MEMOIRE;
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


    @FXML
    void OnCick_Quitter(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quitter la fenêtre");
        alert.setHeaderText("Êtes-vous sûr de vouloir quitter l'application ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Platform.exit();
        }
    }
}


