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
    private Label lbl_Messagecommande;


    @FXML
    void OnClick_CreerCommande(ActionEvent event) {
        boolean complet = true;

        lbl_ErreurDate.setVisible(false);
        lbl_ErreurID.setVisible(false);

        //Liste de verification des Erreurs
        if (imput_idCl.getText() == "") {
            lbl_ErreurID.setVisible(true);
            complet = false;
        }
        if (date_com.getValue() == null) {
            lbl_ErreurDate.setVisible(true);
            complet = false;
        }
    }

    @FXML
    void OnClick_ModifCommande(ActionEvent event) {
        boolean complet = true;

        lbl_ErreurDate.setVisible(false);
        lbl_ErreurID.setVisible(false);

        //Liste de verification des Erreurs


    }

    @FXML
    void OnClick_SuppCommande(ActionEvent event) {

    }

    @FXML
    void OnClick_VisuCommande(ActionEvent event) {

    }

}

