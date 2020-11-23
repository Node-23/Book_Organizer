package View.AddView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class AddViewController implements Initializable {

    @FXML
    private Button imageBt;
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
    @FXML
    private CheckBox imageCB;

    private String bookCoverActualPath;
    private String bookCoverNewPath;
    private String type;

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

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    @FXML
    public void onImageBtAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select the book cover image");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        try {
            File file = fileChooser.showOpenDialog(null);
            bookCoverActualPath = file.getAbsolutePath();
            type = getFileExtension(file);
            imageCB.setSelected(true);
            imageCB.setDisable(false);
        } catch (NullPointerException e) {
        }
    }

    @FXML
    public void unselectImage() {
        bookCoverActualPath = null;
        imageCB.setDisable(true);
    }

    @FXML
    public void unfinishedBookGrade() {
        if (finished.isSelected() == false) {
            gradeTxt.setDisable(true);
        } else {
            gradeTxt.setDisable(false);
        }
    }

    private void copyFile() {
        var source = new File(bookCoverActualPath);
        var dest = new File(bookCoverNewPath);

        try {
            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onAddBtAction() {

        if (Errors.verifyIsBlanck(nameTxt.getText(), authorTxt.getText(), publisherTxt.getText(), categoryTxt.getText(),
                yearTxt.getText())) {
            return;
        }

        if (finished.isSelected() && Errors.verifyIsBlanck(gradeTxt.getText())) {
            return;
        }

        if (finished.isSelected() && Errors.gradeLimiter(Integer.parseInt(gradeTxt.getText()))) {
            return;
        }

        if(bookCoverActualPath != null){
            bookCoverNewPath= System.getProperty("user.dir") +"\\src\\BookCovers\\"+nameTxt.getText()+"."+type;
            copyFile();
        }
        
        Books newBook = new Books();
        if (finished.isSelected()) {
            newBook = new Books(finished.isSelected(), nameTxt.getText(), authorTxt.getText(), publisherTxt.getText(),
                    categoryTxt.getText(), Integer.parseInt(gradeTxt.getText()), Integer.parseInt(yearTxt.getText()),
                    bookCoverNewPath);
        } else {
            newBook = new Books(finished.isSelected(), nameTxt.getText(), authorTxt.getText(), publisherTxt.getText(),
                    categoryTxt.getText(), Integer.parseInt(yearTxt.getText()), bookCoverNewPath);
        }
        if (Errors.verifyIsRepeted(newBook.getName())) {
            return;
        }
        
        BookManager.addBooks(newBook);
        Stage stage = (Stage) cancelBt.getScene().getWindow();
        stage.close();
        
    }
}
