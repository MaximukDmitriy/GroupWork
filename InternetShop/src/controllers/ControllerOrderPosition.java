package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * Created by Julia on 07.08.2017.
 */
public class ControllerOrderPosition {

    @FXML
    private TextArea txtAreaNumberOfPosition;

    @FXML
    private TextArea txtAreaNumberOfOrder;

    @FXML
    private TextArea txtAreaProduct;

    @FXML
    private TextArea txtAreaQuantity;

    @FXML
    private TextArea txtAreaPrice;

    @FXML
    private TextArea txtAreaSum;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    private void onActionOkClick() {
    }

    @FXML
    private void onActionCancelClick() {
        System.exit(0);
    }
}


