package home.iu.controller;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoCategorie;
import dao.interfaces.IDaoClient;
import home.metier.Categorie;
import home.metier.Client;
import home.metier.Produit;
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
import javafx.scene.layout.VBox;
import org.junit.experimental.categories.Categories;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_Categorie implements Initializable, ChangeListener<Categorie> {

    DaoFactory DaoF;

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
    private Pane pane_ModifCategorie;

    @FXML
    private TextField imput_ModifTitre;

    @FXML
    private Label lbl_ErreurModifTitre;

    @FXML
    private TextField imput_ModifVisuel;

    @FXML
    private Label lbl_ErreurModifVisuel;

    @FXML
    private Button btn_ModifCategorie;

    @FXML
    private Label lbl_Creercateg;

    @FXML
    private Label lbl_ModifCateg;

    @FXML
    private Button btn_AffichModifCategorie;

    @FXML
    private Button btn_SuppCategorie;

    @FXML
    private TableView<Categorie> tbl_Categories;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DaoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);

        TableColumn<Categorie, Integer> colID = new TableColumn<>("ID");
        colID.setCellValueFactory(new PropertyValueFactory<Categorie, Integer>("id"));
        TableColumn<Categorie, String> colTitre = new TableColumn<>("Titre");
        colTitre.setCellValueFactory(new PropertyValueFactory<Categorie, String>("titre"));
        TableColumn<Categorie, String> colVisuel = new TableColumn<>("Visuel");
        colVisuel.setCellValueFactory(new PropertyValueFactory<Categorie, String>("visuel"));
        this.tbl_Categories.getColumns().setAll(colID, colTitre, colVisuel);
        this.tbl_Categories.getItems().addAll(DaoF.getDaoCategorie().getAllCategories());

        this.tbl_Categories.getSelectionModel().selectedItemProperty().addListener( this);
    }
    public void changed(ObservableValue<? extends Categorie> observable, Categorie oldValue, Categorie newValue) {
        this.btn_SuppCategorie.setDisable(newValue == null);
        this.btn_AffichModifCategorie.setDisable(newValue == null);
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

        //Quand on appuie sur le boutton Créer
        if (complet) {
            DaoFactory DaoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
            IDaoCategorie DaoCategorie = DaoF.getDaoCategorie();

            Categorie categorie = new Categorie();
            categorie.setTitre(imput_titre.getText());
            categorie.setVisuel(imput_visuel.getText());

            lbl_Creercateg.setText(categorie.toStringController());

            DaoCategorie.create(categorie);

            imput_titre.clear();
            imput_visuel.clear();

            this.tbl_Categories.getItems().addAll(DaoF.getDaoCategorie().getAllCategories());
        }
    }

    @FXML
    void OnClick_ModifCategorie (ActionEvent event){
        boolean complet = true;

        lbl_ErreurModifTitre.setVisible(false);
        lbl_ErreurModifVisuel.setVisible(false);

        //Liste de verification des Erreurs
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
    void OnClick_AffichModifCategorie(ActionEvent event) {
        pane_ModifCategorie.setVisible(true);
        btn_ModifCategorie.setVisible(true);
    }
}
