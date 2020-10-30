package home.iu.controller;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoProduit;

import home.metier.Categorie;
import home.metier.Produit;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller_Produit implements Initializable {

    @FXML
    private ChoiceBox<Categorie> Choice_Categ;

    @FXML
    private TextField input_nom;

    @FXML
    private TextArea input_Description;

    @FXML
    private TextField input_Tarif;

    @FXML
    private Label lbl_ErreurNom;

    @FXML
    private Label lbl_ErreurDescription;

    @FXML
    private Label lbl_ErreurTarif;

    @FXML
    private Label lbl_ErreurCateg;

    @FXML
    private TextField input_ModifNom;

    @FXML
    private TextArea input_ModifDescription;

    @FXML
    private TextField input_ModifTarif;

    @FXML
    private Label lbl_ErreurModifNom;

    @FXML
    private Label lbl_ErreurModifDescription;

    @FXML
    private Label lbl_ErreurModifTarif;

    @FXML
    private Label lbl_ErreurModifCateg;

    @FXML
    private Label lbl_ErreurModifId;

    @FXML
    private Label lbl_CreerProduit;

    @FXML
    private Label lbl_ModifProduit;

    @FXML
    private ChoiceBox<?> Choice_ModifId;

    @FXML
    private ChoiceBox<?> Choice_ModifCateg;

    @FXML
    private ChoiceBox<?> Choice_VisuCateg;

    @FXML
    private ChoiceBox<?> Choice_SuppCateg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DaoFactory DaoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
        this.Choice_Categ.setItems(FXCollections.observableArrayList(DaoF.getDaoCategorie().getAllCategories()));
    }

    @FXML
    void OnClick_CreerProduit(ActionEvent event) {
        boolean complet = true;

        lbl_ErreurNom.setVisible(false);
        lbl_ErreurDescription.setVisible(false);
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
            DaoFactory DaoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
            IDaoProduit DaoProd = DaoF.getDaoProduit();

            Produit produit = new Produit();
            produit.setId(25);
            produit.setNom(input_nom.getText());
            produit.setDescription(input_Description.getText());
            produit.setTarif(Double.valueOf(input_Tarif.getText()));
            produit.setVisuel("visuel.png");
            produit.setCategorie(Choice_Categ.getValue());

            lbl_CreerProduit.setText(produit.toStringController());

            DaoProd.create(produit);
        }
    }


    @FXML
    void OnClick_ModifProduit(ActionEvent event) {
        boolean complet = true;

        lbl_ErreurModifId.setVisible(false);
        lbl_ErreurModifNom.setVisible(false);
        lbl_ErreurModifDescription.setVisible(false);
        lbl_ErreurModifTarif.setVisible(false);
        lbl_ErreurModifCateg.setVisible(false);

        //Liste de verification des Erreurs
        if (Choice_ModifId.getValue() == null) {
            lbl_ErreurModifId.setVisible(true);
            complet = false;
        }
        if (input_ModifNom.getText() == "") {
            lbl_ErreurModifNom.setVisible(true);
            complet = false;
        }
        if (input_ModifDescription.getText() == "") {
            lbl_ErreurModifDescription.setVisible(true);
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

    }

    @FXML
    void OnClick_SuppProduit(ActionEvent event) {

    }


    @FXML
    void OnClick_VisuProduit(ActionEvent event) {

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