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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private Label lbl_CreerProduit;

    @FXML
    private Label lbl_ModifProduit;

    @FXML
    private TextField imput_VisuNom;

    @FXML
    private Label lbl_VisuProduit;

    @FXML
    private TextField imput_SuppNom;

    @FXML
    void OnClick_ModifProduit(ActionEvent event) {

    }

    @FXML
    void OnClick_SuppProduit(ActionEvent event) {

    }

    @FXML
    void OnClick_VisuProduit(ActionEvent event) {

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
        if ((input_Tarif.getText() == "")||(!isDouble(input_Tarif.getText()))) {
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

    public boolean isDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DaoFactory DaoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
        this.Choice_Categ.setItems(FXCollections.observableArrayList(DaoF.getDaoCategorie().getAllCategories()));
    }
}
