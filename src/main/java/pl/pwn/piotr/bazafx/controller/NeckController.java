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
import pl.pwn.piotr.bazafx.model.Neck;
import pl.pwn.piotr.bazafx.model.RoleEnum;
import pl.pwn.piotr.bazafx.model.User;
import pl.pwn.piotr.bazafx.service.NeckService;
import pl.pwn.piotr.bazafx.service.UserService;

import java.io.IOException;
import java.util.List;

public class NeckController {

    @FXML
    private TableView<Neck> neckTable;

    @FXML
    private TableColumn<Neck, Long> colId;

    @FXML
    private TableColumn<Neck, String> colNeck;

    @FXML
    private TableColumn<Neck, String> colNeckDimension;

    private NeckService neckService;

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
        colId.setCellValueFactory(new PropertyValueFactory<Neck, Long>("id"));
        colNeck.setCellValueFactory(new PropertyValueFactory<Neck, String>("neck"));
        colNeckDimension.setCellValueFactory(new PropertyValueFactory<Neck, String>("neckDimension"));

    }

    private void fillNeckData() {
        neckService = new NeckService();
        List<Neck> necks = neckService.getAllNecks();

        ObservableList<Neck> allNeck= FXCollections.observableArrayList(necks);
        neckTable.setItems(null);
        neckTable.setItems(allNeck);
    }
}
