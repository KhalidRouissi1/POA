package com.example.tp3fx;

import com.example.tp3fx.Persone;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddBookController implements Initializable {

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfEmail;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button importBtn;

    @FXML
    private Button exportBtn;
    @FXML
    private Button exitBtn;

    @FXML
    private TableView<Persone> Table;

    @FXML
    private TableColumn<Persone, String> emailCol;

    @FXML
    private TableColumn<Persone, String> firstNameCol;

    @FXML
    private TableColumn<Persone, String> lastNameCol;

    private ObservableList<Persone> personeList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personeList = FXCollections.observableArrayList(
                new Persone("Samira", "Ben Hmed", "samia@example.com")
        );

        // Set value factories for each column
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Persone, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Persone, String>("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Persone, String>("email"));

        Table.setItems(personeList);
    }



    public void handleAddButtonClick(javafx.event.ActionEvent actionEvent) {
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String email = tfEmail.getText();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Missing Information");
            alert.setContentText("Please fill all fields before adding.");
            alert.showAndWait();
            return;
        }
        if(!isEmailAdress(email)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Wrong Email Address");
            alert.setContentText("Please put valid email address.");
            alert.showAndWait();
            return;
        }

        Persone newPerson = new Persone(firstName, lastName, email);
        personeList.add(newPerson);

        tfFirstName.clear();
        tfLastName.clear();
        tfEmail.clear();
    }

    public void handleDeleteButtonClick(javafx.event.ActionEvent actionEvent) {
        Persone selectedPerson = Table.getSelectionModel().getSelectedItem();

        if (selectedPerson != null) {
            personeList.remove(selectedPerson);
            Table.getSelectionModel().clearSelection();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("No person selected");
            alert.setContentText("Please select a person to delete.");
            alert.showAndWait();
        }
    }
    public static boolean isEmailAdress(String email){
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$" );
        Matcher m = p.matcher(email.toUpperCase());
        return m.matches();
    }

    public void handleImportButtonClick(javafx.event.ActionEvent actionEvent) {
        DataClass dataClass = new DataClass();
        List<Persone> importList = dataClass.getImportList();
        personeList.addAll(importList);
    }

    public void handleExportButtonClick(javafx.event.ActionEvent actionEvent) {
        List<Persone> exportData = new ArrayList<>();

        for (Persone person : personeList) {
            exportData.add(person);
        }

        DataClass dataClass = new DataClass();

        dataClass.setExportList(exportData);


    }

    public void handleExitAction(javafx.event.ActionEvent actionEvent) {
        Platform.exit();
    }
}
