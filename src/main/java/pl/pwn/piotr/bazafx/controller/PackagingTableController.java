package pl.pwn.piotr.bazafx.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.pwn.piotr.bazafx.model.Neck;
import pl.pwn.piotr.bazafx.model.Packaging;
import pl.pwn.piotr.bazafx.service.NeckService;
import pl.pwn.piotr.bazafx.service.PackagingService;

import java.io.IOException;
import java.util.List;

public class PackagingTableController {

    @FXML
    private TableView<Packaging> packagingTable;

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<Packaging, Long> colId;

    @FXML
    private TableColumn<Packaging, String> colPackaging;

    private PackagingService packagingService;

    @FXML
    void backAction(MouseEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
        adminStage.setTitle("Panel administratora");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    public void initialize(){
        fillPackagingData();
        setCallValue();

    }

    private void setCallValue() {
        colId.setCellValueFactory(new PropertyValueFactory<Packaging, Long>("id"));
        colPackaging.setCellValueFactory(new PropertyValueFactory<Packaging, String>("packaging"));
    }

    private void fillPackagingData() {
        packagingService = new PackagingService();
        List<Packaging> packagings = packagingService.getAllPAckaging();

        ObservableList<Packaging> allNeck= FXCollections.observableArrayList(packagings);
        packagingTable.setItems(null);
        packagingTable.setItems(allNeck);
    }
}
