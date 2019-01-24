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
import pl.pwn.piotr.bazafx.model.Squad;
import pl.pwn.piotr.bazafx.service.NeckService;
import pl.pwn.piotr.bazafx.service.SquadService;

import java.io.IOException;
import java.util.List;

public class SquadTableController {

    @FXML
    private TableView<Squad> squadTable;

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<Squad, Long> colId;

    @FXML
    private TableColumn<Squad, String> colSquadNumber;

    @FXML
    private TableColumn<Squad, String> colSquadLider;

    private SquadService squadService;

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
        fillNeckData();
        setCallValue();

    }

    private void setCallValue() {
        colId.setCellValueFactory(new PropertyValueFactory<Squad, Long>("id"));
        colSquadNumber.setCellValueFactory(new PropertyValueFactory<Squad, String>("squadNumber"));
        colSquadLider.setCellValueFactory(new PropertyValueFactory<Squad, String>("squadLider"));

    }

    private void fillNeckData() {
        squadService = new SquadService();
        List<Squad> squads = squadService.getAllSquads();

        ObservableList<Squad> allSquad = FXCollections.observableArrayList(squads);
        squadTable.setItems(null);
        squadTable.setItems(allSquad);
    }
}
