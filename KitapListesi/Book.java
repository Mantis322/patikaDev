import java.util.ArrayList;
import java.util.Date;

public class Book {
    private String bookName;
    private int page;
    private String author;
    private int realeseDate;

    private ArrayList<Book> bookList = new ArrayList<>();

    public Book(String bookName, int page, String author, int realeseDate) {
        this.bookName = bookName;
        this.page = page;
        this.author = author;
        this.realeseDate = realeseDate;


    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRealeseDate() {
        return realeseDate;
    }

    public void setRealeseDate(int realeseDate) {
        this.realeseDate = realeseDate;
    }
}
