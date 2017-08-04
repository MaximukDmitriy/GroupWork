package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import models.Authentication;

public class ControllerMain {

    @FXML
    private Menu mnuManagement;

    @FXML
    private BorderPane content;

    Authentication authentification;

    @FXML
    private void onActionManagementClick() {
    }

    public void setAuthentification(Authentication authentification) {
        this.authentification = authentification;
    }

    public void setMenuActivated(){
        mnuManagement.setDisable(authentification == null || this.authentification.IsAdmin());
    }
}
