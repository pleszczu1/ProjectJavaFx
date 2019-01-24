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
import pl.pwn.piotr.bazafx.model.Machine;
import pl.pwn.piotr.bazafx.service.MachineService;

import java.io.IOException;
import java.util.List;

public class MachineTableControllerAdmin {

    @FXML
    private TableView<Machine> machineTable;

    @FXML
    private TableColumn<Machine, Long> colId;

    @FXML
    private TableColumn<Machine, String> colMachine;

    @FXML
    private TableColumn<Machine, Integer> colNumberOfHeads;

    @FXML
    private TableColumn<Machine, Integer> colNumberOfPrams;

    @FXML
    private Button btnBack;

    private MachineService machineServices;

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
        fillMachineData();

        // wskazanie kolumn do wyświetlenia z naszego modelu
        setCallValue();
    }

    private void setCallValue() {
        colId.setCellValueFactory(new PropertyValueFactory<Machine, Long>("id"));
        colMachine.setCellValueFactory(new PropertyValueFactory<Machine, String>("numberOfTheMachine"));
        colNumberOfHeads.setCellValueFactory(new PropertyValueFactory<Machine, Integer>("numberOfHeads"));
        colNumberOfPrams.setCellValueFactory(new PropertyValueFactory<Machine, Integer>("numberOfPrams"));
    }

    private void fillMachineData() {
        machineServices = new MachineService();
        List<Machine> machines = machineServices.getAllMachines();

        ObservableList<Machine> allmachines = FXCollections.observableArrayList(machines);
        machineTable.setItems(null);
        machineTable.setItems(allmachines);
    }
}
