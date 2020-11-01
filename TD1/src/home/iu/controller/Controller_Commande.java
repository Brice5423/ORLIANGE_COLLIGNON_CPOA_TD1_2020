package home.iu.controller;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoCategorie;
import dao.interfaces.IDaoCommande;
import home.metier.Categorie;
import home.metier.Commande;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller_Commande implements Initializable, ChangeListener<Commande> {

    DaoFactory DaoF;
    private IDaoCommande daoCommande;
    private Commande commandeTab;

    @FXML
    private VBox Vbox_Commande;

    @FXML
    private TextField imput_idCl;

    @FXML
    private Label lbl_ErreurID;

    @FXML
    private TextField imput_Date;

    @FXML
    private Label lbl_ErreurModifDate;

    @FXML
    private Label lbl_ErreurModifID;

    @FXML
    private ChoiceBox<?> Choice_ModifCl;

    @FXML
    private TextField imput_ModifDate;

    @FXML
    private Label lbl_MessageCommande;

    @FXML
    private Button btn_ModifAffichCommande;

    @FXML
    private Button btn_SuppCommande;

    @FXML
    private TextField imput_ModifID;

    @FXML
    private TableView<Commande> tbl_Commandes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DaoF = DaoFactory.getDAOFactory(Controller_Accueil.typeEPersistance);
        daoCommande = DaoF.getDaoCommande();

        TableColumn<Commande, Integer> colID = new TableColumn<>("ID");
        colID.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("id"));
        TableColumn<Commande, String> colDate = new TableColumn<>("Date");
        colDate.setCellValueFactory(new PropertyValueFactory<Commande, String>("date"));
        TableColumn<Commande, String> colIdClient = new TableColumn<>("Id Client");
        colIdClient.setCellValueFactory(new PropertyValueFactory<Commande, String>("id_cl"));
        this.tbl_Commandes.getColumns().setAll(colID, colDate, colIdClient);
        this.tbl_Commandes.getItems().addAll(DaoF.getDaoCommande().getAllCommande());

        this.tbl_Commandes.getSelectionModel().selectedItemProperty().addListener( this);
    }

    public void changed(ObservableValue<? extends Commande> observable, Commande oldValue, Commande newValue) {
        this.btn_SuppCommande.setDisable(newValue == null);
        this.btn_ModifAffichCommande.setDisable(newValue == null);

        commandeTab = observable.getValue();
    }


    @FXML
    void OnClick_CreerCommande(ActionEvent event) {
        boolean complet = true;

        lbl_ErreurID.setVisible(false);

        //Liste de verification des Erreurs
        if (imput_idCl.getText() == "") {
            lbl_ErreurID.setVisible(true);
            complet = false;
        }
        //Quand on appuie sur le boutton Créer
        if (complet) {
            DaoFactory DaoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
            IDaoCategorie DaoCategorie = DaoF.getDaoCategorie();

            Commande commande = new Commande();
            commande.setDate(new Date());
            commande.setId(Integer.valueOf(imput_idCl.getText()));

            lbl_MessageCommande.setText("La commande " + commande.toStringController() + " à bien été créée");

            daoCommande.create(commande);

            imput_Date.clear();
            imput_idCl.clear();

            this.tbl_Commandes.getItems().addAll(commande);
        }
    }

    @FXML
    void OnClick_ModifCommande(ActionEvent event) {
        boolean complet = true;

        lbl_ErreurModifDate.setVisible(false);
        lbl_ErreurModifID.setVisible(false);

        //Liste de verification des Erreurs
        if (imput_Date.getText() == "") {
            lbl_ErreurID.setVisible(true);
            complet = false;
        }
        if (imput_idCl.getText() == "") {
            lbl_ErreurID.setVisible(true);
            complet = false;
        }
        if (complet) {
            commandeTab.setDate(new Date());
            commandeTab.setId((int) Choice_ModifCl.getValue());

            lbl_MessageCommande.setText("La commande " + commandeTab.toStringController() + " à bien été modifiée");

            daoCommande.update(commandeTab);

            imput_ModifID.clear();
            imput_ModifDate.clear();
            Choice_ModifCl.setValue(null);

            this.tbl_Commandes.refresh();
        }

    }

    @FXML
    void OnClick_SuppCommande(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression de la commande");
        alert.setHeaderText("Êtes-vous sûr de vouloir supprimer cette commande ?");
        alert.setContentText("Le produit sera perdu définitivement");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            daoCommande.delete(commandeTab);
            tbl_Commandes.getItems().clear();
            this.tbl_Commandes.getItems().addAll(DaoF.getDaoCommande().getAllCommande());
        }
    }

    @FXML
    void OnClick_ModifAffichCommande(ActionEvent event) {

    }

}

