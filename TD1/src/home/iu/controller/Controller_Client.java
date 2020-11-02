package home.iu.controller;


import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoClient;

import home.metier.Client;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class Controller_Client implements Initializable, ChangeListener<Client> {
    DaoFactory daoF;
    private IDaoClient daoClient;
    private Client clientTab;


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
    private Pane pane_Modif;
    @FXML
    private Button btn_ModifClient;

    @FXML
    private TextField input_ModifId;

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
    private Label lbl_MessageClient;


    @FXML
    private TextField input_FiltreNom;
    @FXML
    private TextField input_FiltrePrenom;

    @FXML
    private Button btn_AffichModifClient;
    @FXML
    private Button btn_SuppClient;

    @FXML
    private TableView<Client> tbl_Clients;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        daoF = DaoFactory.getDAOFactory(Controller_Accueil.typeEPersistance);
        daoClient = daoF.getDaoClient();

        TableColumn<Client, Integer> colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
        TableColumn<Client, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
        TableColumn<Client, String> colPrenom = new TableColumn<>("Prénom");
        colPrenom.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
        TableColumn<Client, String> colMail = new TableColumn<>("Mail");
        colMail.setCellValueFactory(new PropertyValueFactory<Client, String>("mail"));
        TableColumn<Client, String> colMdp = new TableColumn<>("Mot de passe");
        colMdp.setCellValueFactory(new PropertyValueFactory<Client, String>("mdp"));
        TableColumn<Client, String> colNumero = new TableColumn<>("Numéro");
        colNumero.setCellValueFactory(new PropertyValueFactory<Client, String>("adrNum"));
        TableColumn<Client, String> colVoie = new TableColumn<>("Voie");
        colVoie.setCellValueFactory(new PropertyValueFactory<Client, String>("adrVoie"));
        TableColumn<Client, Integer> colCP = new TableColumn<>("Code postal");
        colCP.setCellValueFactory(new PropertyValueFactory<Client, Integer>("adrCodePostal"));
        TableColumn<Client, String> colVille = new TableColumn<>("Ville");
        colVille.setCellValueFactory(new PropertyValueFactory<Client, String>("adrVille"));
        TableColumn<Client, String> colPays = new TableColumn<>("Pays");
        colPays.setCellValueFactory(new PropertyValueFactory<Client, String>("adrPays"));
        this.tbl_Clients.getColumns().setAll(colId, colNom, colPrenom, colMail, colMdp, colNumero, colVoie, colCP, colVille, colPays);
        this.tbl_Clients.getItems().addAll(daoF.getDaoClient().getAllClients());

        this.tbl_Clients.getSelectionModel().selectedItemProperty().addListener( this);
    }


    public void changed(ObservableValue<? extends Client> observable, Client oldValue, Client newValue) {
        this.btn_SuppClient.setDisable(newValue == null);
        this.btn_AffichModifClient.setDisable(newValue == null);

        clientTab = observable.getValue();
    }

    public void cacheCreeClient() {
        boolean remplie1 = (input_Nom.getText() != "") || (input_Prenom.getText() != "") || (input_Mail.getText() != "") || (input_Mdp.getText() != "");
        boolean remplie2 = (input_No.getText() != "") || (input_Rue.getText() != "") || (input_Cp.getText() != "") || (input_Ville.getText() != "") || (input_Pays.getText() != "");

        if (remplie1 || remplie2) {
            input_Nom.clear();
            input_Prenom.clear();
            input_Mail.clear();
            input_Mdp.clear();

            input_No.clear();
            input_Rue.clear();
            input_Cp.clear();
            input_Ville.clear();
            input_Pays.clear();
        }
    }

    public void cacheModifClient() {
        if (pane_Modif.isVisible()) {
            pane_Modif.setVisible(false);
            btn_ModifClient.setVisible(false);

            input_ModifId.clear();
            input_ModifNom.clear();
            input_ModifPrenom.clear();
            input_ModifMail.clear();
            input_ModifMdp.clear();

            input_ModifNo.clear();
            input_ModifRue.clear();
            input_ModifCp.clear();
            input_ModifVille.clear();
            input_ModifPays.clear();
        }
    }


    @FXML
    void OnClick_CreerClient(ActionEvent event) {
        boolean complet = true;

        cacheModifClient();

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

        //Quand on appuie sur le boutton Créer
        if (complet) {
            DaoFactory DaoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
            IDaoClient DaoClient = DaoF.getDaoClient();

            Client client = new Client();
            client.setNom(input_Nom.getText());
            client.setPrenom(input_Prenom.getText());
            client.setMail(input_Mail.getText());
            client.setMdp(input_Mdp.getText());
            client.setAdrNum(input_No.getText());
            client.setAdrVoie(input_Rue.getText());
            client.setAdrCodePostal(input_Cp.getText());
            client.setAdrVille(input_Ville.getText());
            client.setAdrPays(input_Pays.getText());

            lbl_MessageClient.setText("Le client " + client.toStringController() + " à bien été crée");

            DaoClient.create(client);

            cacheCreeClient();

            //this.tbl_Clients.getItems().addAll(client);
            tbl_Clients.getItems().clear();
            this.tbl_Clients.getItems().addAll(DaoF.getDaoClient().getAllClients());
        }
    }


    @FXML
    void OnClick_AffichModifClient(ActionEvent event) {
        pane_Modif.setVisible(true);
        btn_ModifClient.setVisible(true);

        input_ModifId.setText(String.valueOf(clientTab.getId()));
        input_ModifNom.setText(clientTab.getNom());
        input_ModifPrenom.setText(clientTab.getPrenom());
        input_ModifMail.setText(String.valueOf(clientTab.getMail()));
        input_ModifMdp.setText(clientTab.getMdp());
        input_ModifNo.setText(clientTab.getAdrNum());
        input_ModifRue.setText(String.valueOf(clientTab.getAdrVoie()));
        input_ModifCp.setText(clientTab.getAdrCodePostal());
        input_ModifVille.setText(clientTab.getAdrVille());
        input_ModifPays.setText(clientTab.getAdrPays());

        cacheCreeClient();
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

        if (complet) {
            clientTab.setNom(input_ModifNom.getText());
            clientTab.setPrenom(input_ModifPrenom.getText());
            clientTab.setMail(input_ModifMail.getText());
            clientTab.setMdp(input_ModifMdp.getText());
            clientTab.setAdrNum(input_ModifNo.getText());
            clientTab.setAdrVoie(input_ModifRue.getText());
            clientTab.setAdrCodePostal(input_ModifCp.getText());
            clientTab.setAdrVille(input_ModifVille.getText());
            clientTab.setAdrPays(input_ModifPays.getText());

            lbl_MessageClient.setText("Le client " + clientTab.toStringController() + " à bien été modifié");

            daoClient.update(clientTab);

            //this.tbl_Clients.refresh();
            tbl_Clients.getItems().clear();
            this.tbl_Clients.getItems().addAll(daoF.getDaoClient().getAllClients());

            cacheModifClient();
        }
    }


    @FXML
    void OnClick_SuppClient(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression du Produit");
        alert.setHeaderText("Êtes-vous sûr de vouloir supprimer ce client ?");
        alert.setContentText("Le client sera perdu définitivement");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            daoClient.delete(clientTab);
            tbl_Clients.getItems().clear();
            this.tbl_Clients.getItems().addAll(daoF.getDaoClient().getAllClients());

            lbl_MessageClient.setText("");
            cacheCreeClient();
            cacheModifClient();
        }
    }


    @FXML
    void OnClick_Refresh(ActionEvent event) {
        tbl_Clients.getItems().clear();
        this.tbl_Clients.getItems().addAll(daoF.getDaoClient().getAllClients());

        input_FiltreNom.clear();
        input_FiltrePrenom.clear();

        lbl_MessageClient.setText("");
        cacheCreeClient();
        cacheModifClient();
    }


    @FXML
    void OnClick_ValiderFiltre(ActionEvent event) {
        tbl_Clients.getItems().clear();
        this.tbl_Clients.getItems().addAll(daoF.getDaoClient().getByNomPrenom(input_FiltreNom.getText(), input_FiltrePrenom.getText()));
    }

    @FXML
    void OnClick_FiltreNomPrenom(ActionEvent event) {
        tbl_Clients.getItems().clear();
        this.tbl_Clients.getItems().addAll(daoF.getDaoClient().getByNomPrenom(input_FiltreNom.getText(), input_FiltrePrenom.getText()));
    }
}
