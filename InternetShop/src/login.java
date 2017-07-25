import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chat");
        Parent root = FXMLLoader.load(getClass().getResource("/javafx/adminka/registration.fxml"));
        Scene main = new Scene(root);
        primaryStage.setScene(main);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
