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

public class UserController {

    @FXML
    private Button btnMachineList;

    @FXML
    private Button btnMoldList;

    @FXML
    private Button btnBottleList;

    @FXML
    private Button btnNeckList;

    @FXML
    private Button btnRawMaterialList;

    @FXML
    private Button btnPackagingList;

    @FXML
    private Button btnProductionList;

    @FXML
    private Button btnOutputList;

    @FXML
    private MenuItem mClose;

    @FXML
    void bottleList(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/bottleTableViewUser.fxml"));
        adminStage.setTitle("Panel butelek");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    void machineList(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/machineTableViewUser.fxml"));
        adminStage.setTitle("Panel maszyn");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }

    @FXML
    void moldList(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/formsTableViewUser.fxml"));
        adminStage.setTitle("Panel form");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene()
                .getWindow()
                .hide();
    }


    @FXML
    void outputList(MouseEvent event) {

    }

    @FXML
    void productionList(MouseEvent event) {

    }

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }


}
