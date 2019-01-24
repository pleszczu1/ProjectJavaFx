package pl.pwn.piotr.bazafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.pwn.piotr.bazafx.model.RoleEnum;
import pl.pwn.piotr.bazafx.model.User;
import pl.pwn.piotr.bazafx.service.AddUserService;

import java.io.IOException;

public class AdminAddUserController {

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfPassword;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnSave;

    @FXML
    private ToggleGroup g1;

    @FXML
    private RadioButton rbAdmin;

    @FXML
    private RadioButton rbUser;


    @FXML
    private RadioButton rbActive;

    @FXML
    private ToggleGroup g2;

    @FXML
    private RadioButton rbNonActive;

    @FXML
    void save(MouseEvent event) {

        AddUserService addUserService = new AddUserService();
        String login = tfLogin.getText();
        String password = tfPassword.getText();
        RoleEnum role = rbAdmin.isSelected() ? RoleEnum.ROLE_ADMIN : RoleEnum.ROLE_USER;
        Boolean active = rbActive.isSelected() ? true : false;

        User user = new User(login, password, role, active);
        addUserService.save(user);

    }

    @FXML
    void back(MouseEvent event) throws IOException {

        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
        adminStage.setTitle("Panel administratora");
        adminStage.setScene(new Scene(root));
        adminStage.show();

        ((Node) event.getSource()).getScene().getWindow().hide();
    }

}
