package controllers;

import entities.Employee;
import entities.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import services.UserFunctions;

import java.security.NoSuchAlgorithmException;

public class ControllerLogin {

    @FXML
    private Button fldLogin;
    @FXML
    private Button fldPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCancel;

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    @FXML
    private void onActionLoginClick() throws NoSuchAlgorithmException {
        employee = UserFunctions.getAuthentificatedUser(fldPassword.getText() ,fldLogin.getText());
    }

    @FXML private void onActionCancelClick() {
        System.exit(0);
    }

}
