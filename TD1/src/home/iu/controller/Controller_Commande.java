package home.iu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private Label lbl_Creercommande;

    @FXML
    void OnClick_CreerCommande(ActionEvent event) {

    }
}
