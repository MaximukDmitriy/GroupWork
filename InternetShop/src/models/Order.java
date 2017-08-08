package models;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * Created by Julia on 07.08.2017.
 */
public class Order extends Application {

    private final TableView table = new TableView();


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Order");
        Parent root = FXMLLoader.load(getClass().getResource("/javafx/orders/order.fxml"));

        Scene main = new Scene(root);
        primaryStage.setScene(main);
        primaryStage.show();

        table.setEditable(true);


        TableColumn nameOfManager = new TableColumn("П.І.П. менеджера");
        TableColumn contactOfManager = new TableColumn("e-mail/контакт. тел.");
        TableColumn date = new TableColumn("дата замовлення");
        TableColumn status = new TableColumn("статус");

      //  table.getColumns().addAll(nameOfManager, contactOfManager, date, status);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
