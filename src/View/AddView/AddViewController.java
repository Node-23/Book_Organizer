package View.AddView;

import java.net.URL;
import java.util.ResourceBundle;

import Model.BookManager;
import Model.Books;
import Model.Errors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddViewController implements Initializable {

    @FXML
    private Button addBt;
    @FXML
    private Button cancelBt;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField authorTxt;
    @FXML
    private TextField publisherTxt;
    @FXML
    private TextField categoryTxt;
    @FXML
    private TextField gradeTxt;
    @FXML
    private TextField yearTxt;
    @FXML
    private CheckBox finished;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        yearTxt.textProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    yearTxt.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        gradeTxt.textProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    gradeTxt.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @FXML
    public void onCancelBtAction() {
        Stage stage = (Stage) cancelBt.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onAddBtAction() {

        if (Errors.verifyIsBlanck(nameTxt.getText(), authorTxt.getText(), publisherTxt.getText(), categoryTxt.getText(),
                gradeTxt.getText(), yearTxt.getText())) {
            return;
        }

        if(Errors.gradeLimiter(Integer.parseInt(gradeTxt.getText()))){
            return;
        }

        Books newBook = new Books();
        newBook = new Books(finished.isSelected(), nameTxt.getText(), authorTxt.getText(), publisherTxt.getText(),
                categoryTxt.getText(), Integer.parseInt(gradeTxt.getText()), Integer.parseInt(yearTxt.getText()));

        if (Errors.verifyIsRepeted(newBook.getName())) {
            return;
        }

        BookManager.addBooks(newBook);
        Stage stage = (Stage) cancelBt.getScene().getWindow();
        stage.close();

    }
}
