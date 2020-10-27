package home.iu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controller_Client {

    @FXML
    private VBox Vbox_Client;

    @FXML
    private TextField input_nom;

    @FXML
    private Label lbl_ErreurNom;

    @FXML
    private TextField input_prenom;

    @FXML
    private TextField input_id;

    @FXML
    private Label lbl_ErreurPrenom;

    @FXML
    private TextField input_mdp;

    @FXML
    private Label lbl_ErreurMdp;

    @FXML
    private TextField input_no;

    @FXML
    private Label lbl_ErreurNo;

    @FXML
    private TextField input_rue;

    @FXML
    private Label lbl_ErreurRue;

    @FXML
    private TextField input_cp;

    @FXML
    private Label lbl_ErreurCP;

    @FXML
    private TextField input_ville;

    @FXML
    private Label lbl_ErreurVille;

    @FXML
    private TextField input_pays;

    @FXML
    private Label lbl_ErreurPays;

    @FXML
    private Label lbl_Creerclient;

    @FXML
    void OnClick_CreerClient(ActionEvent event) {

    }
}
