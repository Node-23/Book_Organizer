package View.BookView;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Alerts;
import Model.BookManager;
import Model.Books;
import View.MainView.MainViewController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BookViewController implements Initializable {

    @FXML
    private Menu delete;
    @FXML
    private Menu edit;
    @FXML
    private Label name;
    @FXML
    private Label author;
    @FXML
    private Label publisher;
    @FXML
    private Label category;
    @FXML
    private Label grade;
    @FXML
    private Label year;
    @FXML
    private ImageView bookCover;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Books book;
        book = BookManager.searchBook(BookManager.getBookSelected());
        name.setText(book.getName());
        author.setText(book.getAuthor());
        publisher.setText(book.getPublisher());
        category.setText(book.getCategory());
        year.setText(Integer.toString(book.getYear()));
        if(book.getGrade()== -1){
            grade.setText("Not finished yet");    
        }else{
        grade.setText(Integer.toString(book.getGrade()));
        }
        if(book.getBookCover()== null){
            //Create and set a default book cover image
        }else{  
        String path = "file:///"+book.getBookCover();
        bookCover.setImage(new Image(path));
        }
    }

    @FXML
    public void deleteMenu(){
        System.out.println("entrou");
        if(Alerts.confirmAlert()){
            BookManager.deleteBook(BookManager.getBookSelected());
            MainViewController.deleteWindowClose();
        }

    }



}
