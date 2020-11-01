package home.iu.controller;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoProduit;

import home.metier.Categorie;
import home.metier.Produit;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class Controller_Produit implements Initializable, ChangeListener<Produit> {
    private DaoFactory DaoF;
    private IDaoProduit daoProd;
    private Produit produitTab;

    @FXML
    private Pane pane_Modif;

    @FXML
    private Button btn_ModifProduit;

    @FXML
    private Button btn_SuppProduit;

    @FXML
    private Button btn_AffichModif;

    @FXML
    private ChoiceBox<Categorie> Choice_Categ;

    @FXML
    private TextField input_nom;

    @FXML
    private TextArea input_Description;

    @FXML
    private TextField input_Tarif;

    @FXML
    private TextField input_Visuel;

    @FXML
    private Label lbl_ErreurVisuel;

    @FXML
    private Label lbl_ErreurNom;

    @FXML
    private Label lbl_ErreurDescription;

    @FXML
    private Label lbl_ErreurTarif;

    @FXML
    private Label lbl_ErreurCateg;

    @FXML
    private TextField input_ModifId;

    @FXML
    private TextField input_ModifNom;

    @FXML
    private TextArea input_ModifDescription;

    @FXML
    private TextField input_ModifTarif;

    @FXML
    private TextField input_ModifVisuel;

    @FXML
    private Label lbl_ErreurModifVisuel;

    @FXML
    private Label lbl_ErreurModifNom;

    @FXML
    private Label lbl_ErreurModifDescription;

    @FXML
    private Label lbl_ErreurModifTarif;

    @FXML
    private Label lbl_ErreurModifCateg;

    @FXML
    private Label lbl_MessageProduit;

    @FXML
    private ChoiceBox<Categorie> Choice_ModifCateg;

    @FXML
    private TableView<Produit> tbl_Produits;

    @FXML
    private TextField imput_FiltreNom;

    @FXML
    private ChoiceBox<?> Choice_FiltreCateg;

    @FXML
    private Button btn_ValiderFiltre;

    @FXML
    private TextField imput_FiltreTarif;

    @FXML
    void OnClick_ValiderFiltre(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DaoF = DaoFactory.getDAOFactory(Controller_Accueil.typeEPersistance);
        daoProd = DaoF.getDaoProduit();

        this.Choice_Categ.setItems(FXCollections.observableArrayList(DaoF.getDaoCategorie().getAllCategories()));
        this.Choice_ModifCateg.setItems(FXCollections.observableArrayList(DaoF.getDaoCategorie().getAllCategories()));

        TableColumn<Produit, Integer> colIdentifiant = new TableColumn<>("ID");
        colIdentifiant.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("id"));
        TableColumn<Produit, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));
        TableColumn<Produit, String> colDescription = new TableColumn<>("Description");
        colDescription.setCellValueFactory(new PropertyValueFactory<Produit, String>("description"));
        TableColumn<Produit, Double> colTarif = new TableColumn<>("Tarif");
        colTarif.setCellValueFactory(new PropertyValueFactory<Produit, Double>("tarif"));
        TableColumn<Produit, String> colVisuel = new TableColumn<>("Visuel");
        colVisuel.setCellValueFactory(new PropertyValueFactory<Produit, String>("visuel"));
        TableColumn<Produit, Integer> colIdCategorie = new TableColumn<>("Id_Catégorie");
        colIdCategorie.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("categorie"));
        this.tbl_Produits.getColumns().setAll(colIdentifiant, colNom, colDescription, colTarif, colVisuel, colIdCategorie);
        tbl_Produits.getItems().clear();
        this.tbl_Produits.getItems().addAll(DaoF.getDaoProduit().getAllProduits());

        this.tbl_Produits.getSelectionModel().selectedItemProperty().addListener(this);
    }

    public void changed(ObservableValue<? extends Produit> observable, Produit oldValue, Produit newValue) {
        this.btn_SuppProduit.setDisable(newValue == null);
        this.btn_AffichModif.setDisable(newValue == null);

        produitTab = observable.getValue();
    }

    @FXML
    void OnClick_CreerProduit(ActionEvent event) {
        boolean complet = true;

        lbl_ErreurNom.setVisible(false);
        lbl_ErreurDescription.setVisible(false);
        lbl_ErreurVisuel.setVisible(false);
        lbl_ErreurTarif.setVisible(false);
        lbl_ErreurCateg.setVisible(false);

        //Liste de verification des Erreurs
        if (input_nom.getText() == "") {
            lbl_ErreurNom.setVisible(true);
            complet = false;
        }
        if (input_Description.getText() == "") {
            lbl_ErreurDescription.setVisible(true);
            complet = false;
        }
        if (input_Visuel.getText() == "") {
            lbl_ErreurVisuel.setVisible(true);
            complet = false;
        }
        if ((input_Tarif.getText() == "") || (!isDouble(input_Tarif.getText()))) {
            lbl_ErreurTarif.setVisible(true);
            complet = false;
        }
        if (Choice_Categ.getValue() == null) {
            lbl_ErreurCateg.setVisible(true);
            complet = false;
        }

        //Quand on appuie sur le boutton Créer
        if (complet) {
            Produit produit = new Produit();
            produit.setNom(input_nom.getText());
            produit.setDescription(input_Description.getText());
            produit.setTarif(Double.valueOf(input_Tarif.getText()));
            produit.setVisuel(input_Visuel.getText());
            produit.setCategorie(Choice_Categ.getValue());

            lbl_MessageProduit.setText("Le produit " + produit.toStringController() + " à bien été crée");

            daoProd.create(produit);

            input_nom.clear();
            input_Description.clear();
            input_Tarif.clear();
            input_Visuel.clear();
            Choice_Categ.setValue(null);

            this.tbl_Produits.getItems().addAll(produit);
        }
    }

    @FXML
    void OnClick_AffichModifProduit(ActionEvent event) {
        pane_Modif.setVisible(true);
        btn_ModifProduit.setVisible(true);

        input_ModifId.setText(String.valueOf(produitTab.getId()));
        input_ModifNom.setText(produitTab.getNom());
        input_ModifDescription.setText(produitTab.getDescription());
        input_ModifTarif.setText(String.valueOf(produitTab.getTarif()));
        input_ModifVisuel.setText(produitTab.getVisuel());
        Choice_ModifCateg.setValue(produitTab.getCategorie());
    }

    @FXML
    void OnClick_ModifProduit(ActionEvent event) {
        boolean complet = true;

        lbl_ErreurModifNom.setVisible(false);
        lbl_ErreurModifDescription.setVisible(false);
        lbl_ErreurModifVisuel.setVisible(false);
        lbl_ErreurModifTarif.setVisible(false);
        lbl_ErreurModifCateg.setVisible(false);

        //Liste de verification des Erreurs
        if (input_ModifNom.getText() == "") {
            lbl_ErreurModifNom.setVisible(true);
            complet = false;
        }
        if (input_ModifDescription.getText() == "") {
            lbl_ErreurModifDescription.setVisible(true);
            complet = false;
        }
        if (input_ModifVisuel.getText() == "") {
            lbl_ErreurModifVisuel.setVisible(true);
            complet = false;
        }
        if ((input_ModifTarif.getText() == "") || (!isDouble(input_Tarif.getText()))) {
            lbl_ErreurModifTarif.setVisible(true);
            complet = false;
        }
        if (Choice_ModifCateg.getValue() == null) {
            lbl_ErreurModifCateg.setVisible(true);
            complet = false;
        }

        if (complet) {
            Produit produit = new Produit();
            produit.setId(Integer.valueOf(input_ModifId.getText()));
            produit.setNom(input_nom.getText());
            produit.setDescription(input_Description.getText());
            produit.setTarif(Double.valueOf(input_Tarif.getText()));
            produit.setVisuel(input_Visuel.getText());
            produit.setCategorie(Choice_Categ.getValue());

            lbl_MessageProduit.setText("Le produit " + produit.toStringController() + " à bien été modifié");

            daoProd.update(produit);

            input_ModifNom.clear();
            input_ModifDescription.clear();
            input_ModifVisuel.clear();
            input_ModifTarif.clear();
            Choice_ModifCateg.setValue(null);

            this.tbl_Produits.refresh();
        }
    }

    @FXML
    void OnClick_SuppProduit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression du Produit");
        alert.setHeaderText("Êtes-vous sûr de vouloir supprimer ce produit ?");
        alert.setContentText("Le produit sera perdu définitivement");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            daoProd.delete(produitTab);
            tbl_Produits.getItems().clear();
            this.tbl_Produits.getItems().addAll(DaoF.getDaoProduit().getAllProduits());
        }
    }

    public boolean isDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
