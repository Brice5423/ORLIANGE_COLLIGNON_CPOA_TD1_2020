package home.iu.controller;


import dao.factory.DaoFactory;
import dao.interfaces.IDaoCategorie;

import home.metier.Categorie;

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


public class Controller_Categorie implements Initializable, ChangeListener<Categorie> {
    DaoFactory daoF;
    private IDaoCategorie daoCateg;
    private Categorie categorieTabSelect;


    @FXML
    private TextField input_titre;
    @FXML
    private Label lbl_ErreurTitre;

    @FXML
    private TextField input_visuel;
    @FXML
    private Label lbl_ErreurVisuel;


    @FXML
    private Pane pane_ModifCategorie;
    @FXML
    private Button btn_ModifCategorie;

    @FXML
    private TextField input_ModifId;

    @FXML
    private TextField input_ModifTitre;
    @FXML
    private Label lbl_ErreurModifTitre;

    @FXML
    private TextField input_ModifVisuel;
    @FXML
    private Label lbl_ErreurModifVisuel;


    @FXML
    private Label lbl_MessageCategorie;


    @FXML
    private Button btn_AffichModifCategorie;
    @FXML
    private Button btn_SuppCategorie;

    @FXML
    private TableView<Categorie> tbl_Categories;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        daoF = DaoFactory.getDAOFactory(Controller_Accueil.typeEPersistance);
        daoCateg = daoF.getDaoCategorie();

        TableColumn<Categorie, Integer> colID = new TableColumn<>("ID");
        colID.setCellValueFactory(new PropertyValueFactory<Categorie, Integer>("id"));
        TableColumn<Categorie, String> colTitre = new TableColumn<>("Titre");
        colTitre.setCellValueFactory(new PropertyValueFactory<Categorie, String>("titre"));
        TableColumn<Categorie, String> colVisuel = new TableColumn<>("Visuel");
        colVisuel.setCellValueFactory(new PropertyValueFactory<Categorie, String>("visuel"));
        this.tbl_Categories.getColumns().setAll(colID, colTitre, colVisuel);
        refreshCateg();

        this.tbl_Categories.getSelectionModel().selectedItemProperty().addListener( this);
    }


    public void refreshCateg() {
        this.tbl_Categories.getItems().clear();
        this.tbl_Categories.getItems().addAll(daoF.getDaoCategorie().getAllCategories());
        this.tbl_Categories.getSelectionModel().clearSelection();
    }

    public void changed(ObservableValue<? extends Categorie> observable, Categorie oldValue, Categorie newValue) {
        this.btn_SuppCategorie.setDisable(newValue == null);
        this.btn_AffichModifCategorie.setDisable(newValue == null);

        categorieTabSelect = observable.getValue();
    }

    public void cacheCreeCategorie() {
        if ((input_titre.getText() != "") || (input_visuel.getText() != "")) {
            input_titre.clear();
            input_visuel.clear();
        }
    }

    public void cacheErreurCreeCategorie() {
        if ((lbl_ErreurTitre.isVisible()) || (lbl_ErreurVisuel.isVisible())) {
            lbl_ErreurTitre.setVisible(false);
            lbl_ErreurVisuel.setVisible(false);
        }
    }

    public void cacheModifCategorie() {
        if (pane_ModifCategorie.isVisible()) {
            pane_ModifCategorie.setVisible(false);
            btn_ModifCategorie.setVisible(false);

            input_ModifId.clear();
            input_ModifTitre.clear();
            input_ModifVisuel.clear();
        }
    }

    public void cacheErreurModifCategorie() {
        lbl_ErreurModifTitre.setVisible(false);
        lbl_ErreurModifVisuel.setVisible(false);
    }


    @FXML
    void OnClick_CreerCategorie(ActionEvent event) {
        boolean complet = true;

        cacheErreurCreeCategorie();
        cacheModifCategorie();

        //Liste de verification des Erreurs
        if (input_titre.getText() == "") {
            lbl_ErreurTitre.setVisible(true);
            complet = false;
        }
        if (input_visuel.getText() == "") {
            lbl_ErreurVisuel.setVisible(true);
            complet = false;
        }

        //Quand on appuie sur le boutton Créer
        if (complet) {
            Categorie categorie = new Categorie();
            categorie.setTitre(input_titre.getText());
            categorie.setVisuel(input_visuel.getText());

            lbl_MessageCategorie.setText("La catégorie " + categorie.toStringController() + " à bien été créée");

            daoCateg.create(categorie);

            refreshCateg();
            cacheCreeCategorie();
        }
    }


    @FXML
    void OnClick_AffichModifCategorie(ActionEvent event) {
        pane_ModifCategorie.setVisible(true);
        btn_ModifCategorie.setVisible(true);

        cacheCreeCategorie();
        cacheErreurCreeCategorie();
        cacheErreurModifCategorie();

        input_ModifId.setText(String.valueOf(categorieTabSelect.getId()));
        input_ModifTitre.setText(categorieTabSelect.getTitre());
        input_ModifVisuel.setText(categorieTabSelect.getVisuel());
    }

    @FXML
    void OnClick_ModifCategorie (ActionEvent event){
        boolean complet = true;

        cacheErreurModifCategorie();

        //Liste de verification des Erreurs
        if (input_ModifTitre.getText() == "") {
            lbl_ErreurModifTitre.setVisible(true);
            complet = false;
        }
        if (input_ModifVisuel.getText() == "") {
            lbl_ErreurModifVisuel.setVisible(true);
            complet = false;
        }

        if (complet) {
            categorieTabSelect.setTitre(input_ModifTitre.getText());
            categorieTabSelect.setVisuel(input_ModifVisuel.getText());

            lbl_MessageCategorie.setText("La catégorie " + categorieTabSelect.toStringController() + " à bien été modifiée");

            daoCateg.update(categorieTabSelect);

            refreshCateg();
            cacheModifCategorie();
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
            daoCateg.delete(categorieTabSelect);
            refreshCateg();

            lbl_MessageCategorie.setText("");
            cacheCreeCategorie();
            cacheErreurCreeCategorie();
            cacheModifCategorie();
        }
    }
}
