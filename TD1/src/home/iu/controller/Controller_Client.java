package home.iu.controller;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import home.metier.Client;
import home.metier.Produit;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_Client implements Initializable {

    DaoFactory DaoF;

    @FXML
    private Button btn_AffichModifClient;

    @FXML
    private Button btn_SuppClient;

    @FXML
    private TableView<Client> tbl_Clients;

    @FXML
    private Button btn_ModifClient;

    @FXML
    private Pane pane_Modif;

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
    private TextField input_Mail;

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
    private TextField input_ModifMail;

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
    private ChoiceBox<?> choice_ModifID;

    @FXML
    private Label lbl_ErreurModifID;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DaoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);

        TableColumn<Produit, Integer> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("nom"));
        TableColumn<Produit, String> colPrenom = new TableColumn<>("Prénom");
        colPrenom.setCellValueFactory(new PropertyValueFactory<Produit, String>("prenom"));
        TableColumn<Produit, String> colMail = new TableColumn<>("Mail");
        colMail.setCellValueFactory(new PropertyValueFactory<Produit, String>("mail"));
        TableColumn<Produit, Double> colMdp = new TableColumn<>("Mot de passe");
        colMdp.setCellValueFactory(new PropertyValueFactory<Produit, Double>("mdp"));
        TableColumn<Produit, String> colNumero = new TableColumn<>("Numéro");
        colNumero.setCellValueFactory(new PropertyValueFactory<Produit, String>("numero"));
        TableColumn<Produit, Integer> colVoie = new TableColumn<>("Voie");
        colVoie.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("voie"));
        TableColumn<Produit, Integer> colCP = new TableColumn<>("Code postal");
        colCP.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("cp"));
        TableColumn<Produit, Integer> colVille = new TableColumn<>("Ville");
        colVille.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("ville"));
        TableColumn<Produit, Integer> colPays = new TableColumn<>("Pays");
        colPays.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("pays"));

        this.tbl_Clients.getColumns().setAll(colNom, colPrenom, colMail, colMdp, colNumero, colVoie, colCP, colVille, colPays);
        this.tbl_Clients.getItems().addAll(DaoF.getDaoClient().getAllClients());

        this.tbl_Clients.getSelectionModel().selectedItemProperty().addListener(this);
    }

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
        if (input_Mail.getText() == "") {
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
        boolean complet = true;

        lbl_ErreurModifNom.setVisible(false);
        lbl_ErreurModifPrenom.setVisible(false);
        lbl_ErreurModifMail.setVisible(false);
        lbl_ErreurModifMdp.setVisible(false);
        lbl_ErreurModifNo.setVisible(false);
        lbl_ErreurModifRue.setVisible(false);
        lbl_ErreurModifCP.setVisible(false);
        lbl_ErreurModifVille.setVisible(false);
        lbl_ErreurModifPays.setVisible(false);
        lbl_ErreurModifID.setVisible(false);

        //Liste de verification des Erreurs
        if (input_ModifNom.getText() == "") {
            lbl_ErreurModifNom.setVisible(true);
            complet = false;
        }
        if (input_ModifPrenom.getText() == "") {
            lbl_ErreurModifPrenom.setVisible(true);
            complet = false;
        }
        if (input_ModifMail.getText() == "") {
            lbl_ErreurModifMail.setVisible(true);
            complet = false;
        }
        if (input_ModifMdp.getText() == "") {
            lbl_ErreurModifMdp.setVisible(true);
            complet = false;
        }
        if (input_ModifNo.getText() == "") {
            lbl_ErreurModifNo.setVisible(true);
            complet = false;
        }
        if (input_ModifRue.getText() == "") {
            lbl_ErreurModifRue.setVisible(true);
            complet = false;
        }
        if (input_ModifCp.getText() == "") {
            lbl_ErreurModifCP.setVisible(true);
            complet = false;
        }
        if (input_ModifVille.getText() == "") {
            lbl_ErreurModifVille.setVisible(true);
            complet = false;
        }
        if (input_ModifPays.getText() == "") {
            lbl_ErreurModifPays.setVisible(true);
            complet = false;
        }
        if (choice_ModifID.getValue() == null) {
            lbl_ErreurModifID.setVisible(true);
            complet = false;
        }

    }

    @FXML
    void OnClick_SuppClient(ActionEvent event) {

    }

    @FXML
    void OnClick_VisuClient(ActionEvent event) {

    }
}
