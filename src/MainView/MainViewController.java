package MainView;

import java.net.URL;
import java.util.ResourceBundle;

import Model.BookManager;
import Model.Books;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class MainViewController implements Initializable {
    private String iconPath = "/Images/BookIcon.png";

    @FXML
    private TableView<Books> table;
    @FXML
    private TableColumn<Books, Boolean> finished;
    @FXML
    private TableColumn<Books, String> name;
    @FXML
    private Tooltip tooltip;
    @FXML
    private MenuItem add;
    @FXML
    private MenuItem about;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        finished.setCellValueFactory(new PropertyValueFactory<>("finished"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        finished.setCellFactory(CheckBoxTableCell.forTableColumn(finished));

        table.setItems(FXCollections.observableArrayList(BookManager.getBookList()));
        tooltip.setFont(new Font("Arial", 10));
        tooltip.setShowDelay(Duration.seconds(0.1));

    }

    @FXML
    public void toolTipEnable(MouseEvent event){
        if(BookManager.getBookList().isEmpty() || table.getSelectionModel().getSelectedItem() == null){
            Tooltip.uninstall(table, tooltip);
        }
        else{
            Tooltip.install(table,tooltip);
        }
    }

}
