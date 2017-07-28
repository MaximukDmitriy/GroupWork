package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerLogin {

    @FXML
    private Button btnLogIn;
    @FXML
    private Button btnCancel;


    @FXML private void onActionLogInClick() {

    }

    @FXML private void onActionCancelClick() {
        System.exit(0);
    }
}
