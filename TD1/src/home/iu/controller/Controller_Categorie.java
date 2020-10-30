package home.iu.controller;

import home.metier.Produit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class Controller_Categorie {

    @FXML
    private VBox Vbox_Categ;

    @FXML
    private TextField imput_titre;

    @FXML
    private Label lbl_ErreurTitre;

    @FXML
    private TextField imput_visuel;

    @FXML
    private Label lbl_ErreurVisuel;

    @FXML
    private TextField imput_ModifTitre;

    @FXML
    private Label lbl_ErreurModifTitre;

    @FXML
    private TextField imput_ModifVisuel;

    @FXML
    private Label lbl_ErreurModifVisuel;

    @FXML
    private ChoiceBox<?> choice_ModifID;

    @FXML
    private Label lbl_ErreurModifID;

    @FXML
    private Label lbl_Creercateg;

    @FXML
    private Label lbl_ModifCateg;

    @FXML
    private TableView<Produit> tblProduits;

    public void Table() {
        TableColumn<Produit, Double> colID = new TableColumn<>("ID");
        TableColumn<Produit, Double> colNom = new TableColumn<>("ID");
        TableColumn<Produit, Double> colDescription = new TableColumn<>("ID");
        TableColumn<Produit, Double> colTarif = new TableColumn<>("ID");
        TableColumn<Produit, Double> colID_Categ = new TableColumn<>("ID");
        colID.setCellValueFactory(
                new PropertyValueFactory<Produit, Double>("ID"));
        this.tblProduits.getColumns().setAll(colID, colNom, colDescription, colTarif, colID_Categ);
        //this.tblProduits.getItems().addAll(DAOFactory.getDAOFactory().getProduitDAO().findAll());
    }


    @FXML
    void OnClick_CreerCategorie(ActionEvent event) {
        boolean complet = true;

        lbl_ErreurTitre.setVisible(false);
        lbl_ErreurVisuel.setVisible(false);

        //Liste de verification des Erreurs
        if (imput_titre.getText() == "") {
            lbl_ErreurTitre.setVisible(true);
            complet = false;
        }
        if (imput_visuel.getText() == "") {
            lbl_ErreurVisuel.setVisible(true);
            complet = false;
        }
    }

    @FXML
    void OnClick_ModifCategorie (ActionEvent event){
        boolean complet = true;

        lbl_ErreurModifID.setVisible(false);
        lbl_ErreurModifTitre.setVisible(false);
        lbl_ErreurModifVisuel.setVisible(false);

        //Liste de verification des Erreurs
        if (choice_ModifID.getValue() == null) {
            lbl_ErreurModifID.setVisible(true);
            complet = false;
        }
        if (imput_ModifTitre.getText() == "") {
            lbl_ErreurModifTitre.setVisible(true);
            complet = false;
        }
        if (imput_ModifVisuel.getText() == "") {
            lbl_ErreurModifVisuel.setVisible(true);
            complet = false;
        }

    }


    @FXML
    void OnClick_SuppCategorie(ActionEvent event) {

    }

    @FXML
    void OnClick_VisuCategorie(ActionEvent event) {

    }
}
