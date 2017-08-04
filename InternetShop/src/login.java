import controllers.ControllerLogin;
import controllers.ControllerMain;
import entities.Employee;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Authentication;

import java.io.IOException;

public class login extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private Authentication authentication;
    private ControllerMain mainController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initRootLayout();
        showLoginLayout();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Инициализирует корневой макет.
     */
    public void initRootLayout() {
        try {

            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/javafx/main.fxml"));
            rootLayout = loader.load();
            mainController = loader.getController();
            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLoginLayout() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/javafx/adminka/login.fxml"));
            AnchorPane personOverview = loader.load();
            ControllerLogin login = loader.getController();
            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(personOverview);
            mainController.setAuthentification(login.getAuthentication());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
