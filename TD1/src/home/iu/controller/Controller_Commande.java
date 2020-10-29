package home.iu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controller_Commande {

    @FXML
    private VBox Vbox_Commande;

    @FXML
    private DatePicker date_com;

    @FXML
    private Label lbl_ErreurDate;

    @FXML
    private TextField imput_idCl;

    @FXML
    private Label lbl_ErreurID;

    @FXML
    private DatePicker date_ModifCom;

    @FXML
    private Label lbl_ErreurModifDate;

    @FXML
    private Label lbl_ErreurModifID;

    @FXML
    private ChoiceBox<?> Choice_ModifCom;

    @FXML
    private Label lbl_Creercommande;

    @FXML
    private Label lbl_ModifCommande;

    @FXML
    private Label lbl_VisuCommande;

    @FXML
    private ChoiceBox<?> Choice_VisuCom;

    @FXML
    private ChoiceBox<?> Choice_SuppCom;

    @FXML
    void OnClick_CreerCommande(ActionEvent event) {

    }

    @FXML
    void OnClick_ModifCommande(ActionEvent event) {

    }

    @FXML
    void OnClick_SuppCommande(ActionEvent event) {

    }

    @FXML
    void OnClick_VisuCommande(ActionEvent event) {

    }

}

