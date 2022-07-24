import java.util.Comparator;

public class Book {
   private String bookName;
   private int page;
   private String author;
   private int releaseDate;

    public Book(String bookName, int page, String author, int releaseDate) {
        this.bookName = bookName;
        this.page = page;
        this.author = author;
        this.releaseDate = releaseDate;
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

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }
}
