package Model;

public class Errors {

    public static boolean verifyIsBlanck(String name, String author, String publisher, String category, String year) {
        if (name.isBlank() == true || author.isBlank() == true || publisher.isBlank() == true
                || category.isBlank() == true || year.isBlank() == true) {
            Alerts.blanckAlert();
            return true;
        }
        return false;
    }

    public static boolean verifyIsBlanck(String word) {
        if (word.isBlank() == true) {
            Alerts.blanckAlert();
            return true;
        }
        return false;
    }

    public static boolean verifyIsRepeted(String bookName) {
        if (BookManager.repetedBookName(bookName) == true) {
            Alerts.repeatedBookAlert();
            return true;
        }
        return false;
    }

    public static boolean editVerifyIsRepeted(Books oldBook, Books newBook) {
        if (oldBook.getName().equals(newBook.getName())) {
            if (oldBook.getAuthor().equals(newBook.getAuthor()) && oldBook.getPublisher().equals(newBook.getPublisher())
                    && oldBook.getCategory().equals(newBook.getCategory())
                    && oldBook.getGrade().equals(newBook.getGrade()) && oldBook.getYear().equals(newBook.getYear())) {
                Alerts.repeatedBookAlert();
                return true;
            }
        } else if (BookManager.repetedBookName(newBook.getName()) == true) {

            Alerts.repeatedBookAlert();
            return true;
        }
        return false;
    }

    public static boolean verifySelectionIsNull(String selected, String Scene) {
        if (selected == null && Scene == "edit" || selected == null && Scene == "delete") {
            Alerts.nullBookAlert();
            return true;
        }
        if (selected == null && Scene == "search") {
            Alerts.nullCategoryAlert();
            return true;
        }

        return false;
    }

    public static boolean gradeLimiter(Integer grade) {
        if (grade > 10) {
            Alerts.gradeLimit();
            return true;
        }
        return false;
    }

}
