package Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Books {

    private SimpleBooleanProperty finished;
    private SimpleStringProperty name;
    private SimpleStringProperty author;
    private SimpleStringProperty publisher;
    private SimpleStringProperty Notes;
    private SimpleStringProperty category;
    private SimpleIntegerProperty grade;
    private SimpleIntegerProperty year;
    private String bookCover;

    public Books(Boolean finished, String name, String author, String publisher, String category, Integer grade,
            Integer year, String bookCover) {
        this.finished = new SimpleBooleanProperty(finished);
        this.name = new SimpleStringProperty(name);
        this.author = new SimpleStringProperty(author);
        this.publisher = new SimpleStringProperty(publisher);
        this.category = new SimpleStringProperty(category);
        this.grade = new SimpleIntegerProperty(grade);
        this.year = new SimpleIntegerProperty(year);
        this.Notes = new SimpleStringProperty("");
        this.bookCover = bookCover;
    }

    public Books(Boolean finished, String name, String author, String publisher, String category, Integer year,
    String bookCover) {
        this.finished = new SimpleBooleanProperty(finished);
        this.name = new SimpleStringProperty(name);
        this.author = new SimpleStringProperty(author);
        this.publisher = new SimpleStringProperty(publisher);
        this.category = new SimpleStringProperty(category);
        this.grade = new SimpleIntegerProperty(-1);
        this.year = new SimpleIntegerProperty(year);
        this.Notes = new SimpleStringProperty("");
        this.bookCover = bookCover;
    }

    public Books() {
        this.Notes = new SimpleStringProperty("");
    }

    // Finished------------------------------------------------------------------------------
    public boolean isFinished() {
        return finished.get();
    }

    public SimpleBooleanProperty finishedProperty() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished.set(finished);
    }

    // Name------------------------------------------------------------------------------

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    // Author------------------------------------------------------------------------------

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty AuthorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    // Publisher------------------------------------------------------------------------------

    public String getPublisher() {
        return publisher.get();
    }

    public SimpleStringProperty publisherProperty() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher.set(publisher);
    }

    // Category
    // ------------------------------------------------------------------------------

    public String getCategory() {
        return this.category.get();
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    // Grade
    // ------------------------------------------------------------------------------

    public Integer getGrade() {
        return grade.get();
    }

    public void setGrade(Integer grade) {
        this.grade.set(grade);
    }

    // Year------------------------------------------------------------------------------
    public Integer getYear() {
        return year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    // Notes------------------------------------------------------------------------------
    public String getNotes() {
        return this.Notes.get();
    }

    public void setNotes(String Notes) {
        this.Notes.set(Notes);
    }

    // Image-----------------------------------------------------------------------------
    public void setBookCover(String image) {
        bookCover = image;
    }

    public String getBookCover() {
        return bookCover;
    }
}