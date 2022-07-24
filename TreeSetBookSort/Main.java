import java.util.ArrayList;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        TreeSet<Book> bookList = new TreeSet<>(Comparator.comparing(Book::getBookName));

        bookList.add(new Book("Ben bir kitabım",300,"Mahmut",2002));
        bookList.add(new Book("Ben bir kitabım 2 ",150,"Mahmut",2005));
        bookList.add(new Book("Dun Root", 390,"Lemmy",2010));
        bookList.add(new Book("Gölgelerin Efendisi 2", 200,"John",2004));

        for (Book b: bookList) {
            System.out.println("Kitap adı: " + b.getBookName()
            + ", Sayfa sayısı: " + b.getPage() + ", Yazar: " + b.getAuthor() + ", Yayımlanma tarihi : "
                    + b.getReleaseDate());
        }

        System.out.println("-----------------------------------------");
        System.out.println("SAYFA SAYISINA GÖRE SIRALAMA");

        TreeSet<Book> bookList2 = new TreeSet<>(Comparator.comparing(Book::getPage));

        bookList2.add(new Book("Ben bir kitabım",300,"Mahmut",2002));
        bookList2.add(new Book("Ben bir kitabım 2",150,"Mahmut",2005));
        bookList2.add(new Book("Dun Root", 390,"Lemmy",2010));
        bookList2.add(new Book("Gölgelerin Efendisi 2", 200,"John",2004));

        for (Book a: bookList2) {
            System.out.println("Kitap adı: " + a.getBookName()
                    + ", Sayfa sayısı: " + a.getPage() + ", Yazar: " + a.getAuthor() + ", Yayımlanma tarihi : "
                    + a.getReleaseDate());
        }

    }
}
