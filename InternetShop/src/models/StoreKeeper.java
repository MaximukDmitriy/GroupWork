package models;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Julia on 08.08.2017.
 */
public class StoreKeeper extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("StoreKeeper");
        Parent root = FXMLLoader.load(getClass().getResource("/javafx/orders/storekeeper.fxml"));

        Scene main = new Scene(root);
        primaryStage.setScene(main);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
