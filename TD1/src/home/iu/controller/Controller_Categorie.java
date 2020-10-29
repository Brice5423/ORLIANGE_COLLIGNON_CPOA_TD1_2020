package home.iu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private ChoiceBox<?> choice_VisuCateg;

    @FXML
    private Label lbl_VisuCateg;

    @FXML
    private ChoiceBox<?> choice_SuppCateg;

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
