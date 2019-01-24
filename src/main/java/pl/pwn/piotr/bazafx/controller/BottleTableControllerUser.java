package pl.pwn.piotr.bazafx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.pwn.piotr.bazafx.model.Bottle;
import pl.pwn.piotr.bazafx.service.BottleService;

import java.io.IOException;
import java.util.List;

public class BottleTableControllerUser {

    @FXML
    private TableView<Bottle> bottleTable;

    @FXML
    private TableColumn<Bottle, Long> colId;

    @FXML
    private TableColumn<Bottle, String> colRawMaterial;

    @FXML
    private TableColumn<Bottle, String> colNeck;

    @FXML
    private TableColumn<Bottle, Integer> colWeight;

    @FXML
    private TableColumn<Bottle, Integer> colCtalogueNumber;

    @FXML
    private TableColumn<Bottle, Integer> colCapacity;

    @FXML
    private TableColumn<Bottle, Integer> colNumberInPacking;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private ComboBox<String> cmbFilterNeck;

    @FXML
    private ComboBox<Integer> cmbFilterCapacity;

    private BottleService bottleService;

   /* NeckService neckService;
    List<String> gwinty = neckService.getNeckForSelect();
    ObservableList<String> data = FXCollections.observableArrayList(gwinty);*/

    public void initialize(){
     //   cmbFilterNeck.setItems(data);
        fillBottleData();
        bottleTable.setEditable(true);
        colId.setCellValueFactory(new PropertyValueFactory<Bottle, Long>("id"));
        colRawMaterial.setCellValueFactory(new PropertyValueFactory<Bottle, String>("nameMaterial"));
        colNeck.setCellValueFactory(new PropertyValueFactory<Bottle, String>("neckName"));
        colWeight.setCellValueFactory(new PropertyValueFactory<Bottle, Integer>("weight"));
        colCtalogueNumber.setCellValueFactory(new PropertyValueFactory<Bottle, Integer>("catalogueNumber"));
        colCapacity.setCellValueFactory(new PropertyValueFactory<Bottle, Integer>("capacity"));
        colNumberInPacking.setCellValueFactory(new PropertyValueFactory<Bottle, Integer>("numberInBox"));

    }

    private void fillBottleData() {
        BottleService bottleService = new BottleService();
        List<Bottle> bottles = bottleService.getAllBottles();

        ObservableList<Bottle> allBottles= FXCollections.observableArrayList(bottles);
        bottleTable.setItems(null);
        bottleTable.setItems(allBottles);
    }

    @FXML
    void backAction(MouseEvent event) throws IOException {

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/userView.fxml"));
        adminStage.setTitle("Panel administratora");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}