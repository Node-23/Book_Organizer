package View.MainView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.BookManager;
import Model.Books;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
    private MenuItem search;
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

    @FXML
    public void onMenuAction(){
        if(BookManager.getBookList().isEmpty()){
            search.setDisable(true);
        }else{
            search.setDisable(false);
        }
    }

    @FXML
    public void onAddAction() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/View/AddView/AddView.fxml"));
        Scene scene = new Scene(parent);
        Stage popupwindow = new Stage();
        popupwindow.setResizable(false);
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("New");
        popupwindow.getIcons().add(new Image(getClass().getResourceAsStream(iconPath)));
        popupwindow.setScene(scene);
        popupwindow.showAndWait();
        table.setItems(FXCollections.observableArrayList(BookManager.getBookList()));
    }

    @FXML
    public void openBook(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2 && table.getSelectionModel().getSelectedItem() != null) 
        {   
            BookManager.setBookSelected(table.getSelectionModel().getSelectedItem().getName());
            Parent parent = FXMLLoader.load(getClass().getResource("/View/BookView/BookView.fxml"));
            Scene scene = new Scene(parent);
            Stage popupwindow = new Stage();
            popupwindow.setResizable(false);
            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle(BookManager.getBookSelected());
            popupwindow.getIcons().add(new Image(getClass().getResourceAsStream(iconPath)));
            popupwindow.setScene(scene);
            popupwindow.showAndWait();
            table.setItems(FXCollections.observableArrayList(BookManager.getBookList()));
        }
    }

    @FXML
    public void onMenuSearchAction() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/View/SearchView/SearchView.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/View/SearchView/TableView.css").toExternalForm());
        Stage popupwindow = new Stage();
        popupwindow.setResizable(false);
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Search");
        popupwindow.getIcons().add(new Image(getClass().getResourceAsStream(iconPath)));
        popupwindow.setScene(scene);
        popupwindow.showAndWait();
    }

}
