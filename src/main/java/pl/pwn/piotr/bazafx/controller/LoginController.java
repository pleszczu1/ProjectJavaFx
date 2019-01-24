package pl.pwn.piotr.bazafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.pwn.piotr.bazafx.model.User;
import pl.pwn.piotr.bazafx.model.RoleEnum;
import pl.pwn.piotr.bazafx.service.UserService;


import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfPassword;

    @FXML
    private PasswordField psPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnShow;

    public void initialize(){

    }

    @FXML
    void login(InputEvent event) throws SQLException, IOException{

        String login = tfLogin.getText();
        String pass = psPassword.isVisible() ? psPassword.getText() : tfPassword.getText();

        UserService userService = new UserService();
        User user = userService.login(login, pass);

        if(user != null){
            RoleEnum role = user.getRole();
            System.out.println("Zalogowano użytkownika: " + login + " o roli: " + role);

            if(RoleEnum.ROLE_ADMIN.equals(role)){
                Stage adminStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
                adminStage.setTitle("Panel administratora");
                adminStage.setScene(new Scene(root));
                adminStage.show();

                ((Node) event.getSource()).getScene().getWindow().hide();
            }
            else if (RoleEnum.ROLE_USER.equals(role)){
                Stage userStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/view/userView.fxml"));
                userStage.setTitle("Panel użytkownika");
                userStage.setScene(new Scene(root));
                userStage.show();

                ((Node) event.getSource()).getScene().getWindow().hide();
            }
        }
        else{
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Error");
            error.setContentText("Błędny login lub hasło lub konto jest nieaktywne!!!");
            error.setTitle("Podaj poprawne dane logowania");
            error.showAndWait();
        }
    }

    @FXML
    void showPass(MouseEvent event) {

        if ("Show".equals(btnShow.getText())) {
            tfPassword.setText(psPassword.getText());
            btnShow.setText("hide");
            tfPassword.setVisible(true);
            psPassword.setVisible(false);
        } else if ("hide".equals(btnShow.getText())) {
            psPassword.setText(tfPassword.getText());
            btnShow.setText("Show");
            tfPassword.setVisible(false);
            psPassword.setVisible(true);
        }
    }

    @FXML
    void loginKeyAction(KeyEvent event) throws IOException, SQLException {
        if (event.getCode() == KeyCode.ENTER) {
            login(event);
        }
    }
}
