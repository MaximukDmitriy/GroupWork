package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

/**
 * Created by Julia on 07.08.2017.
 */
public class ControllerOrder {

    @FXML
    private TextArea txtAreaNumberOfOrder;

    @FXML
    private TextArea txtAreaNameOfManager;

    @FXML
    private Button btnAddOrder;

    @FXML
    private Button btnDeleteOrder;

    @FXML
    private Button btnUpdateOrder;

    @FXML
    private TableView tblViewOrders;

    @FXML
    private void onActionAddOrderClick() {
    }

    @FXML
    private void onActionDelOrderClick() {
    }

    @FXML
    private void onActionUpOrderClick() {
    }

    @FXML
    private void onActionOkClick() {
    }

    @FXML
    private void onActionCancelClick() {

        System.exit(0);
    }

}
