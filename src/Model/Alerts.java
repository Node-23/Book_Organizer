package Model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Alerts {

    private static String errorIconPath = "/Images/ErrorIcon.png";
    private static String warningIconPath = "/Images/WarningIcon.png";

    public static void blanckAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR!");
        alert.setHeaderText("FIELD EMPTY!");
        alert.setContentText("All fields must be filled.");
        ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(errorIconPath));
        alert.show();
    }

    public static void numberExceptionAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR!");
        alert.setHeaderText("FORMAT ERROR!");
        alert.setContentText("The year field must be filled with a number.");
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(errorIconPath));
        alert.show();
    }

    public static void repeatedBookAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR!");
        alert.setHeaderText("BOOK ALREADY INSERTED!");
        alert.setContentText("Please insert a new book.");
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(errorIconPath));
        alert.show();
    }

    public static void nullBookAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR!");
        alert.setHeaderText("NO BOOK SELECTED!");
        alert.setContentText("Please select a book.");
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(errorIconPath));
        alert.show();
    }

    public static void nullCategoryAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR!");
        alert.setHeaderText("NO CATEGORY SELECTED!");
        alert.setContentText("Please select a category.");
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(errorIconPath));
        alert.show();
    }

    public static void gradeLimit() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR!");
        alert.setHeaderText("GRADE VALUE IS GREATER THAN 10!");
        alert.setContentText("Please insert a grade value lesser than 10.");
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(errorIconPath));
        alert.show();
    }

    public static boolean confirmAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT!");
        alert.setHeaderText("ARE YOU SURE?");
        alert.setContentText(null);
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(warningIconPath));
        alert.showAndWait();
        if(alert.getResult() == ButtonType.OK){
            return true;
        }
        return false;
    }

    public static void EmptyArray() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING!");
        alert.setHeaderText("NO BOOK FOUND!");
        alert.setContentText(null);
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(warningIconPath));
        alert.show();
    }

}
