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
    private ChoiceBox<?> choice_ModifCateg;

    @FXML
    private Label lbl_Creercateg;

    @FXML
    private Label lbl_ModifCateg;

    @FXML
    private TableView<Produit> tblProduits;

    public void Table() {
        TableColumn<Produit, Double> colID =
                new TableColumn<>("ID");
        TableColumn<Produit, Double> colNom =
                new TableColumn<>("ID");
        TableColumn<Produit, Double> colDescription =
                new TableColumn<>("ID");
        TableColumn<Produit, Double> colTarif =
                new TableColumn<>("ID");
        TableColumn<Produit, Double> colID_Categ =
                new TableColumn<>("ID");
        colID.setCellValueFactory(
                new PropertyValueFactory<Produit, Double>("ID"));
        this.tblProduits.getColumns().setAll(colID, colNom, colDescription, colTarif, colID_Categ);
        //this.tblProduits.getItems().addAll(
               // DAOFactory.getDAOFactory().getProduitDAO().findAll());
    }


    @FXML
    void OnClick_CreerCategorie(ActionEvent event) {

    }

    @FXML
    void OnClick_ModifCategorie(ActionEvent event) {

    }

    @FXML
    void OnClick_SuppCategorie(ActionEvent event) {

    }

    @FXML
    void OnClick_VisuCategorie(ActionEvent event) {

    }
}
