package View.SearchView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Alerts;
import Model.BookManager;
import Model.Books;
import Model.Errors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchViewController implements Initializable {

    ArrayList<Books> books = new ArrayList<>();

    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();
    @FXML
    private TableView<Books> table;
    @FXML
    private TextField keyWord;
    @FXML
    private Button searchBt;
    @FXML
    private TableColumn<Books, Boolean> finished;
    @FXML
    private TableColumn<Books, String> name;
    @FXML
    private TableColumn<Books, String> author;
    @FXML
    private TableColumn<Books, String> publisher;
    @FXML
    private TableColumn<Books, String> category;
    @FXML
    private TableColumn<Books, Integer> grade;
    @FXML
    private TableColumn<Books, Integer> year;

    ChangeListener<String> listener = new ChangeListener<>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (!newValue.matches("\\d*")) {
                keyWord.setText(newValue.replaceAll("[^\\d]", ""));
            }
        }
    };

    @FXML
    public void textFieldLettersPermission() {
        if (choiceBox.getValue() == "Year"||choiceBox.getValue() == "Grade") {
            keyWord.textProperty().addListener(listener);
        } else {
            keyWord.textProperty().removeListener(listener);
        }
    }

    @FXML
    public void keyWordClearOnTypeChange(){
        keyWord.setText("");
    }

    @FXML
    public void onSearchBtAction() {
    
        if (Errors.verifySelectionIsNull(choiceBox.getValue(),"search")) {
            return;
        }
        if (Errors.verifyIsBlanck(keyWord.getText())) {
            return;
        }

        if(choiceBox.getValue() == "Grade"){
            if(Errors.gradeLimiter(Integer.parseInt(keyWord.getText()))){
                return;
            }
        }

        books = BookManager.typeSearcher(keyWord.getText(), choiceBox.getValue());

        if (books.isEmpty()) {
            Alerts.EmptyArray();
            return;
        }
        table.setItems(FXCollections.observableArrayList(books));
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        choiceBox.getItems().addAll("Name", "Author", "Publisher","Category","Grade","Year");

        finished.setCellValueFactory(new PropertyValueFactory<>("finished"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        grade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));

        finished.setCellFactory(CheckBoxTableCell.forTableColumn(finished));

        table.setItems(FXCollections.observableArrayList(books));
        
    }
}

