package home.iu.controller;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoCategorie;
import dao.interfaces.IDaoClient;
import dao.interfaces.IDaoProduit;
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
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller_Categorie implements Initializable, ChangeListener<Categorie> {

    DaoFactory DaoF;
    private IDaoCategorie daoCateg;
    private Categorie categorieTab;

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
    private Label lbl_MessageCategorie;

    @FXML
    private Button btn_AffichModifCategorie;

    @FXML
    private Button btn_SuppCategorie;

    @FXML
    private TextField imput_ModifId;

    @FXML
    private TableView<Categorie> tbl_Categories;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DaoF = DaoFactory.getDAOFactory(Controller_Accueil.typeEPersistance);
        daoCateg = DaoF.getDaoCategorie();

        TableColumn<Categorie, Integer> colID = new TableColumn<>("ID");
        colID.setCellValueFactory(new PropertyValueFactory<Categorie, Integer>("id"));
        TableColumn<Categorie, String> colTitre = new TableColumn<>("Titre");
        colTitre.setCellValueFactory(new PropertyValueFactory<Categorie, String>("titre"));
        TableColumn<Categorie, String> colVisuel = new TableColumn<>("Visuel");
        colVisuel.setCellValueFactory(new PropertyValueFactory<Categorie, String>("visuel"));
        this.tbl_Categories.getColumns().setAll(colID, colTitre, colVisuel);
        tbl_Categories.getItems().clear();
        this.tbl_Categories.getItems().addAll(DaoF.getDaoCategorie().getAllCategories());

        this.tbl_Categories.getSelectionModel().selectedItemProperty().addListener( this);
    }
    public void changed(ObservableValue<? extends Categorie> observable, Categorie oldValue, Categorie newValue) {
        this.btn_SuppCategorie.setDisable(newValue == null);
        this.btn_AffichModifCategorie.setDisable(newValue == null);

        categorieTab = observable.getValue();
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

            lbl_MessageCategorie.setText("La catégorie " + categorie.toStringController() + " à bien été créée");

            DaoCategorie.create(categorie);

            imput_titre.clear();
            imput_visuel.clear();

            this.tbl_Categories.getItems().addAll(categorie);
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
        if (complet) {

            categorieTab.setTitre(imput_ModifTitre.getText());
            categorieTab.setVisuel(imput_ModifVisuel.getText());

            lbl_MessageCategorie.setText("La catégorie " + categorieTab.toStringController() + " à bien été modifiée");

            daoCateg.update(categorieTab);

            imput_ModifTitre.clear();
            imput_ModifVisuel.clear();

            this.tbl_Categories.refresh();
        }

    }


    @FXML
    void OnClick_SuppCategorie(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression du Produit");
        alert.setHeaderText("Êtes-vous sûr de vouloir supprimer cette catégorie ?");
        alert.setContentText("La catégorie sera perdue définitivement");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            daoCateg.delete(categorieTab);
            tbl_Categories.getItems().clear();
            this.tbl_Categories.getItems().addAll(DaoF.getDaoCategorie().getAllCategories());
        }

    }

    @FXML
    void OnClick_AffichModifCategorie(ActionEvent event) {
        pane_ModifCategorie.setVisible(true);
        btn_ModifCategorie.setVisible(true);

        imput_ModifId.setText(String.valueOf(categorieTab.getId()));
        imput_ModifTitre.setText(categorieTab.getTitre());
        imput_ModifVisuel.setText(categorieTab.getVisuel());
    }
}
