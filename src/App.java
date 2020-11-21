import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/MainView/MainView.fxml"));
            Scene scene = new Scene(parent);
            // scene.getStylesheets().add(getClass().getResource('application.css').toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Book Organizer");
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Images/BookIcon.png")));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}