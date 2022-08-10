import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book("Kitap 1", 101, "Deneme Yazar", 2002);
        Book book2 = new Book("Kitap 2", 50, "Test", 2010);
        Book book3 = new Book("Kitap 3", 60, "Test 2", 2010);
        Book book4 = new Book("Livepath", 284, "Culver", 2005);
        Book book5 = new Book("Riffwire	", 80, "Halie", 2000);
        Book book6 = new Book("Jabberstorm", 164, "Valene", 2022);


        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);


        Map<String, String> mapBookList = new HashMap<>() {
        };

        Map<String, String> newList = new HashMap<>();

        bookList.stream().forEach(i -> mapBookList.put(i.getBookName(),i.getAuthor()));

        bookList.stream().filter(i -> i.getPage()>100).forEach(i->newList.put(i.getBookName(),i.getAuthor()));

        for (String i: mapBookList.keySet()){
            System.out.println("Kitap adı : " + i+ " " +" Yazar: " + mapBookList.get(i));

        }

        System.out.println("=========================================");
        System.out.println("Sayfa sayısı 100'den büyük olanlar ");

        for (String i: newList.keySet()){
            System.out.println("Kitap adı : " + i+ " " +" Yazar: " + newList.get(i));

        }

    }
}
