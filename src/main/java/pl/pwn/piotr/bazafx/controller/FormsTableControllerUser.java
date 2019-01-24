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
import pl.pwn.piotr.bazafx.model.Forms;
import pl.pwn.piotr.bazafx.service.FormsService;

import java.io.IOException;
import java.util.List;

public class FormsTableControllerUser {

    @FXML
    private TableView<Forms> formsTable;

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<Forms, Long> colId;

    @FXML
    private TableColumn<Forms, Integer> colCatalogueNumber;

    @FXML
    private TableColumn<Forms, Integer> colNumberOfMolds;

    @FXML
    private TableColumn<Forms, Integer> colCapacity;

    @FXML
    private TableColumn<Forms, String> colRawMaterial;

    @FXML
    private TableColumn<Forms, String> colNeck;

    @FXML
    private TableColumn<Forms, Integer> colIdBottle;

    FormsService formsService;

    public void initialize(){
        //   cmbFilterNeck.setItems(data);
        fillFormData();
        formsTable.setEditable(true);
        colId.setCellValueFactory(new PropertyValueFactory<Forms, Long>("id"));
        colRawMaterial.setCellValueFactory(new PropertyValueFactory<Forms, String>("nameMaterial"));
        colNeck.setCellValueFactory(new PropertyValueFactory<Forms, String>("neckName"));
        colCapacity.setCellValueFactory(new PropertyValueFactory<Forms, Integer>("capacity"));
        colCatalogueNumber.setCellValueFactory(new PropertyValueFactory<Forms, Integer>("numberOfTheBottles"));
        colIdBottle.setCellValueFactory(new PropertyValueFactory<Forms, Integer>("bottleId"));
        colNumberOfMolds.setCellValueFactory(new PropertyValueFactory<Forms, Integer>("quantityOfTheForms"));

    }

    private void fillFormData() {
        formsService = new FormsService();
        List<Forms> forms = formsService.getAllForms();

        ObservableList<Forms> allForms= FXCollections.observableArrayList(forms);
        formsTable.setItems(null);
        formsTable.setItems(allForms);
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
