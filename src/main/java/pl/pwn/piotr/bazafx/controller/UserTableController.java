package pl.pwn.piotr.bazafx.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import pl.pwn.piotr.bazafx.model.RoleEnum;
import pl.pwn.piotr.bazafx.model.User;
import pl.pwn.piotr.bazafx.service.UserService;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.List;



public class UserTableController {


    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, Long> colId;

    @FXML
    private TableColumn<User, String> colLogin;

    @FXML
    private TableColumn<User, String> colRole;

    @FXML
    private TableColumn<User, Boolean>  colActive;

    @FXML
    private Button btnDeleteUser;

    @FXML
    private Button btnChangeRole;

    @FXML
    private Button btnChangeActive;

    @FXML
    private Button btnBack;

    private UserService userService;

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

        //-- Pobranie danych z bazy danych z tabeli user i dodanie do TableView na widoku
        fillUserData();

        // wskazanie kolumn do wyświetlenia z naszego modelu
        setCallValue();
        // -------

       // włączenie edytowania w tabeli
        userTable.setEditable(true);

        // metoda odpowiedzialne za obsługę edycji naposzczególnych polach
        editCalls();
    }

     private void editCalls() {

        // edycja kolumny role
       editRoleCell();

        // edycja kolumny active
        editActiveCell();
    }

   private void setCallValue() {
        colId.setCellValueFactory(new PropertyValueFactory<User, Long>("id"));
        colLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        colRole.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
        colActive.setCellValueFactory(new PropertyValueFactory<User, Boolean>("active"));
    }

    private void fillUserData() {
        userService = new UserService();
        List<User> users = userService.getAllUser();

        ObservableList<User> allUser= FXCollections.observableArrayList(users);
        userTable.setItems(null);
        userTable.setItems(allUser);
    }

    private void editActiveCell() {
        colActive.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<User, Boolean>, ObservableValue<Boolean>>() {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<User, Boolean> param) {
                final User user = param.getValue();

                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(user.getActive());
                booleanProp.addListener(new ChangeListener<Boolean>() {
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        user.setActive(newValue);
                        updateCell(user);

                    }
                });
                return booleanProp;
            }
        });

       colActive.setCellFactory(new Callback<TableColumn<User, Boolean>, TableCell<User, Boolean>>() {

           public TableCell<User, Boolean> call(TableColumn<User, Boolean> p) {
               CheckBoxTableCell<User, Boolean> cell = new CheckBoxTableCell<User, Boolean>();
               cell.setAlignment(Pos.CENTER);
               return cell;
           }
       });
    }
    private void editRoleCell() {
        ObservableList<String> roles = FXCollections.observableArrayList("ROLE_ADMIN", "ROLE_USER");

        colRole.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {

            public ObservableValue<String> call(TableColumn.CellDataFeatures<User, String> param) {
                User user = param.getValue();

                RoleEnum rola = user.getRole();
                return new SimpleObjectProperty<String>(rola.name());
            }
        });
        colRole.setCellFactory(ComboBoxTableCell.<User, String>forTableColumn(roles));
        colRole.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<User, String>>() {
            public void handle(TableColumn.CellEditEvent<User, String> event) {
                TablePosition<User, String> pos = event.getTablePosition();

                String newRole = event.getNewValue();
                int row = pos.getRow();
                User user = event.getTableView()
                        .getItems()
                        .get(row);
                user.setRole(RoleEnum.valueOf(newRole));

                // update wiersza po edycji pola
                updateCell(user);
            }
        });
    }

    @FXML
    void deleteUser(MouseEvent event) {
        if (userTable.getSelectionModel() == null || userTable.getSelectionModel()
                .getSelectedItem() == null) {

            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText("Please select Item before clicked Delete");
            error.setTitle("No selected item!");
            error.show();
            return;
        }

        // pobranie zaznaczonego wiersza
        long id = userTable.getSelectionModel().getSelectedItem().getId();
        userService.delete(id);

        fillUserData();
    }

    private void updateCell(User selectedItem) {
        userService.update(selectedItem);
    }
}
