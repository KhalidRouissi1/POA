package com.example;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerEtudiant {

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private ToggleGroup sexe;

    @FXML
    private ChoiceBox<String> filiere;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private TableView<Etudiant> studentstable;
    @FXML
    private TableColumn<Etudiant, Integer> idColumn;
    @FXML
    private TableColumn<Etudiant, String> nomColumn;
    @FXML
    private TableColumn<Etudiant, String> prenomColumn;
    @FXML
    private TableColumn<Etudiant, String> sexeColumn;
    @FXML
    private TableColumn<Etudiant, String> filiereColumn;

    private EtudiantM etudiantM; 

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("prenom"));
        sexeColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("sexe"));
        filiereColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("filiere"));

        etudiantM = new EtudiantM();
        FetchStudents();
    }

    private void FetchStudents() {
        List<Etudiant> etudiants = etudiantM.findAll();

        studentstable.getItems().setAll(etudiants);

    }

    @FXML
    void addStudent(ActionEvent event) {
        String nom = this.nom.getText();
        String prenom = this.prenom.getText();
        String sexe = ((RadioButton) this.sexe.getSelectedToggle()).getText();
        String filiere = this.filiere.getValue();

        if (nom == "" || prenom == "" || filiere == null) {
            System.err.println("data invalid");
            return;
        }

        Etudiant etudiant = new Etudiant(nom, prenom, sexe, filiere);
        etudiantM.create(etudiant);
        studentstable.getItems().add(etudiant);
        clearInput();
    }

    private void clearInput() {
        nom.setText("");
        prenom.setText("");
        filiere.setValue(null);
    }



}
