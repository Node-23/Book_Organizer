package Model;

import java.util.ArrayList;

public class BookManager {

    private static ArrayList<Books> bookList = new ArrayList<>();
    private static String bookNameToNote;

    public static void setBookOfTheNotes(String bookName){
        bookNameToNote = bookName;
    }

    public static String getBookOfTheNotes(){
        return bookNameToNote;
    }    

    public static void addBooks(Books book) {
        bookList.add(
                new Books(book.isFinished(), book.getName(), book.getAuthor(), book.getPublisher(),book.getCategory(),book.getGrade() ,book.getYear()));
    }

    public static void editBook(String bookName, Books book) {
        for (Books b : bookList) {
            if (b.getName().equals(bookName)) {
                bookList.remove(b);
                bookList.add(book);
                break;
            }
        }
    }

    public static void deleteBook(Books book) {
        for (Books b : bookList) {
            if (b.equals(book)) {
                bookList.remove(b);
                break;
            }
        }
    }

    public static Boolean repetedBookName(String bookName) {
        for (Books b : bookList) {
            if (b.getName().equals(bookName)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> bookNameList() {
        ArrayList<String> books = new ArrayList<>();
        for (Books b : bookList) {
            books.add(b.getName());
        }
        return books;
    }

    public static ArrayList<Books> getBookList() { 
        ArrayList<Books> books = new ArrayList<>();
        for (Books b : bookList) {
            books.add(b);
        }
        return books;
    }

    public static Books searchBook(String bookName) {
        for (Books b : bookList) {
            if (b.getName().equals(bookName)) {
                return b;
            }
        }
        return null;
    }

    public static ArrayList<Books> typeSearcher(String word, String type) {
        if (type == "Name") {
            return bookNameSearch(word);
        }
        if (type == "Author") {
            return bookAuthorSearch(word);
        }
        if (type == "Publisher") {
            return bookPublisherSearch(word);
        }
        if (type == "Category") {
            return bookCategorySearch(word);
        }
        if (type == "Grade") {
            return bookGradeSearch(word);
        }
        if (type == "Year") {
            return bookYearSearch(word);
        }
        return null;
    }

//--------------------------------------------------------------------------------
    private static ArrayList<Books> bookNameSearch(String word) {
        ArrayList<Books> books = new ArrayList<>();
        for (Books b : bookList) {
            if (b.getName().toLowerCase().contains(word.toLowerCase())) {
                books.add(b);
            }
        }
        return books;
    }

    private static ArrayList<Books> bookAuthorSearch(String word) {
        ArrayList<Books> books = new ArrayList<>();
        for (Books b : bookList) {
            if (b.getAuthor().toLowerCase().contains(word.toLowerCase())) {
                books.add(b);
            }
        }
        return books;
    }

    private static ArrayList<Books> bookPublisherSearch(String word) {
        ArrayList<Books> books = new ArrayList<>();
        for (Books b : bookList) {
            if (b.getPublisher().toLowerCase().contains(word.toLowerCase())) {
                books.add(b);
            }
        }
        return books;
    }

    private static ArrayList<Books> bookCategorySearch(String word) {
        ArrayList<Books> books = new ArrayList<>();
        for (Books b : bookList) {
            if (b.getCategory().toLowerCase().contains(word.toLowerCase())) {
                books.add(b);
            }
        }
        return books;
    }

    private static ArrayList<Books> bookYearSearch(String word) {
        ArrayList<Books> books = new ArrayList<>();
        for (Books b : bookList) {
            if (b.getYear() == Integer.parseInt(word)) {
                books.add(b);
            }
        }
        return books;
    }

    private static ArrayList<Books> bookGradeSearch(String word) {
        ArrayList<Books> books = new ArrayList<>();
        for (Books b : bookList) {
            if (b.getGrade() == Integer.parseInt(word)) {
                books.add(b);
            }
        }
        return books;
    }
//-----------------------------------------------------------------------

}

