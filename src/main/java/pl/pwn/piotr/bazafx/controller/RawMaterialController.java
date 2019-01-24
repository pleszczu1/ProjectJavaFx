package pl.pwn.piotr.bazafx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.pwn.piotr.bazafx.model.RawMaterial;
import pl.pwn.piotr.bazafx.service.RawMaterialService;

import java.io.IOException;
import java.util.List;

public class RawMaterialController {

    @FXML
    private TableView<RawMaterial> rawMaterialTable;

    @FXML
    private TableColumn<RawMaterial, Long> colId;

    @FXML
    private TableColumn<RawMaterial, String> colRawMaterial;

    @FXML
    private TableColumn<RawMaterial, String> colNameOfTheMaterial;

    private RawMaterialService rawMaterialService;

    @FXML
    void backAction(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
        adminStage.setTitle("Panel administratora");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    public void initialize() {

        //-- Pobranie danych z bazy danych z tabeli machine i dodanie do TableView na widoku
        fillRawMaterialData();

        // wskazanie kolumn do wyświetlenia z naszego modelu
        setCallValue();
    }

    private void setCallValue() {
        colId.setCellValueFactory(new PropertyValueFactory<RawMaterial, Long>("id"));
        colRawMaterial.setCellValueFactory(new PropertyValueFactory<RawMaterial, String>("rawMaterial"));
        colNameOfTheMaterial.setCellValueFactory(new PropertyValueFactory<RawMaterial, String>("nameOfTheRawMaterial"));

    }

    private void fillRawMaterialData() {
        rawMaterialService = new RawMaterialService();
        List<RawMaterial> rawMaterials = rawMaterialService.getAllRawMaterials();

        ObservableList<RawMaterial> allRawMaterials = FXCollections.observableArrayList(rawMaterials);
        rawMaterialTable.setItems(null);
        rawMaterialTable.setItems(allRawMaterials);
    }

}
