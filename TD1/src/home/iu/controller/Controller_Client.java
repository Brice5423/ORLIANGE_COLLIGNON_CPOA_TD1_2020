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
    private TextField input_Nom;

    @FXML
    private Label lbl_ErreurNom;

    @FXML
    private TextField input_Prenom;

    @FXML
    private Label lbl_ErreurPrenom;

    @FXML
    private TextField input_Id;

    @FXML
    private Label lbl_ErreurMail;

    @FXML
    private TextField input_Mdp;

    @FXML
    private Label lbl_ErreurMdp;

    @FXML
    private TextField input_No;

    @FXML
    private Label lbl_ErreurNo;

    @FXML
    private TextField input_Rue;

    @FXML
    private Label lbl_ErreurRue;

    @FXML
    private TextField input_Cp;

    @FXML
    private Label lbl_ErreurCP;

    @FXML
    private TextField input_Ville;

    @FXML
    private Label lbl_ErreurVille;

    @FXML
    private TextField input_Pays;

    @FXML
    private Label lbl_ErreurPays;

    @FXML
    private TextField input_ModifNom;

    @FXML
    private Label lbl_ErreurModifNom;

    @FXML
    private TextField input_ModifPrenom;

    @FXML
    private Label lbl_ErreurModifPrenom;

    @FXML
    private TextField input_ModifId;

    @FXML
    private Label lbl_ErreurModifMail;

    @FXML
    private TextField input_ModifMdp;

    @FXML
    private Label lbl_ErreurModifMdp;

    @FXML
    private TextField input_ModifNo;

    @FXML
    private Label lbl_ErreurModifNo;

    @FXML
    private TextField input_ModifRue;

    @FXML
    private Label lbl_ErreurModifRue;

    @FXML
    private TextField input_ModifCp;

    @FXML
    private Label lbl_ErreurModifCP;

    @FXML
    private TextField input_ModifVille;

    @FXML
    private Label lbl_ErreurModifVille;

    @FXML
    private TextField input_ModifPays;

    @FXML
    private Label lbl_ErreurModifPays;

    @FXML
    private Label lbl_Creerclient;

    @FXML
    private Label lbl_ModifClient;

    @FXML
    void OnClick_CreerClient(ActionEvent event) {
        boolean complet = true;

        lbl_ErreurNom.setVisible(false);
        lbl_ErreurPrenom.setVisible(false);
        lbl_ErreurMail.setVisible(false);
        lbl_ErreurMdp.setVisible(false);
        lbl_ErreurNo.setVisible(false);
        lbl_ErreurRue.setVisible(false);
        lbl_ErreurCP.setVisible(false);
        lbl_ErreurVille.setVisible(false);
        lbl_ErreurPays.setVisible(false);

        //Liste de verification des Erreurs
        if (input_Nom.getText() == "") {
            lbl_ErreurNom.setVisible(true);
            complet = false;
        }
        if (input_Prenom.getText() == "") {
            lbl_ErreurPrenom.setVisible(true);
            complet = false;
        }
        if (input_Id.getText() == "") {
            lbl_ErreurMail.setVisible(true);
            complet = false;
        }
        if (input_Mdp.getText() == "") {
            lbl_ErreurMdp.setVisible(true);
            complet = false;
        }
        if (input_No.getText() == "") {
            lbl_ErreurNo.setVisible(true);
            complet = false;
        }
        if (input_Rue.getText() == "") {
            lbl_ErreurRue.setVisible(true);
            complet = false;
        }
        if (input_Cp.getText() == "") {
            lbl_ErreurCP.setVisible(true);
            complet = false;
        }
        if (input_Ville.getText() == "") {
            lbl_ErreurVille.setVisible(true);
            complet = false;
        }
        if (input_Pays.getText() == "") {
            lbl_ErreurPays.setVisible(true);
            complet = false;
        }
    }

    @FXML
    void OnClick_ModifClient(ActionEvent event) {

    }

    @FXML
    void OnClick_SuppClient(ActionEvent event) {

    }

    @FXML
    void OnClick_VisuClient(ActionEvent event) {

    }
}
