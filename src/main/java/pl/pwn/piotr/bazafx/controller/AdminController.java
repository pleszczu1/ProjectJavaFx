package pl.pwn.piotr.bazafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML
    private Button btnAddUser;

    @FXML
    private Button btnDelUser;

    @FXML
    private Button btnChangeUser;

    @FXML
    private Button btnListOfUsers;

    @FXML
    private Button btnMachines;

    @FXML
    private Button btnMolds;

    @FXML
    private Button btnBottles;

    @FXML
    private Button btnNeck;

    @FXML
    private Button btnRawMaterial;

    @FXML
    private Button btnPackaging;

    @FXML
    private Button btnProduction;

    @FXML
    private Button btnOutput;

    @FXML
    private MenuItem mClose;

    @FXML
    private Button btnSquad;

    @FXML
    void addUser(MouseEvent event) throws IOException {

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminAddUserView.fxml"));
        adminStage.setTitle("Panel dodawania użytkownika");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();

    }

    @FXML
    void bottles(MouseEvent event) throws IOException {

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/bottleTableViewAdmin.fxml"));
        adminStage.setTitle("Panel butelek");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();

    }

    @FXML
    void changeUser(MouseEvent event) {

    }

    @FXML
    void delUser(MouseEvent event) {

    }

    @FXML
    void listOfUsers(MouseEvent event) throws IOException {

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/userTableView.fxml"));
        adminStage.setTitle("Panel użytkowników");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    void machines(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/machineTableViewAdmin.fxml"));
        adminStage.setTitle("Panel maszyn");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    void molds(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/formsTableViewAdmin.fxml"));
        adminStage.setTitle("Panel form");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    void neck(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/neckTableView.fxml"));
        adminStage.setTitle("Panel tworzyw");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    void output(MouseEvent event) {

    }

    @FXML
    void packaging(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/packagingTableView.fxml"));
        adminStage.setTitle("Panel opakowań");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    void production(MouseEvent event) {

    }

    @FXML
    void rawMaterial(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/rawMaterialTableView.fxml"));
        adminStage.setTitle("Panel tworzyw");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    void squad(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/squadTableView.fxml"));
        adminStage.setTitle("Panel tworzyw");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }


    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

}
