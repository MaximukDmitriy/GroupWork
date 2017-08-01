package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerLogin {

    @FXML
    private Button btnLogIn;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField fldLogin;
    @FXML
    private TextField fldPassword;



    @FXML private void onActionLogInClick() {

    }

    @FXML private void onActionCancelClick() {
        System.exit(0);
    }
}
