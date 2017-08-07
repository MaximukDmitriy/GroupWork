package controllers;

import entities.Employee;
import entities.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Authentication;
import services.UserFunctions;

import java.security.NoSuchAlgorithmException;

public class ControllerLogin {

    @FXML
    private TextField fldLogin;
    @FXML
    private TextField fldPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCancel;

    private Authentication authentication;

    public Authentication getAuthentication() {
        return authentication;
    }

    @FXML
    private void onActionLoginClick() throws NoSuchAlgorithmException {
        authentication = new Authentication(fldLogin.getText(), fldPassword.getText());
    }

    @FXML private void onActionCancelClick() {
        System.exit(0);
    }

}
