import java.util.*;

public class Notebook extends Product {
    Brand brand = new Brand();
    private List<Notebook> notebookList = new ArrayList<>();
    Scanner scn = new Scanner(System.in);

    private int productID = 1;

    public Notebook(int id, String name, int price, int stock, int storage, double displaySize, int ram, String brand) {
        super(id, name, price, stock, storage, displaySize, ram, brand);

    }

    public Notebook() {
        menu();

    }

    @Override
    public void menu() {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("1- Yeni Notebook ekle\n" +
                    "2- Notebook listesini görüntüle\n" +
                    "3- Notebook sil\n" +
                    "4- Notebookları markaya göre filtrele\n" +
                    "0- Çıkış yap ");

            System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
            int menuChoose = scn.nextInt();
            while (menuChoose < 0 || menuChoose > 4) {
                System.out.println("Yanlış seçim yaptınız: ");
                menuChoose = scn.nextInt();
            }

            switch (menuChoose) {
                case 0:
                    isTrue = false;
                    break;
                case 1:
                    addNotebook();
                    break;
                case 2:
                    getNotebookList();
                    break;
                case 3:
                    deleteItem();
                    break;
                case 4:
                    brandFilter();
                    break;


            }
        }

    }

    public void addNotebook() {

        try {
            System.out.println("Ürün Fiyatı");
            int price = scn.nextInt();

            System.out.println("Stok Miktarı: ");
            int stock = scn.nextInt();

            System.out.println("Ürün Adı: ");
            scn.nextLine();
            String productName = scn.nextLine();

            System.out.println("Marka Listesi");
            System.out.println("========");

            brand.list();

            System.out.println("Marka Seçiniz: ");
            int chooseBrand = scn.nextInt();
            String productBrand =  brand.getBrand(chooseBrand);


            System.out.println("Ram : ");
            int ram = scn.nextInt();

            System.out.println("Depolama: ");
            int storage = scn.nextInt();

            System.out.println("Ekran Boyutu: ");
            double screen = scn.nextDouble();

            this.notebookList.add(new Notebook(productID, productName, price, stock, storage, screen, ram, productBrand));

            System.out.println("Eklenen ürünün ID'si" + " " + productID);

            productID++;
        } catch (InputMismatchException e) {
            System.out.println("Hatalı giriş yaptınız.");
            e.getMessage();
            scn.nextLine();

        }


    }

    public void getNotebookList() {
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | RAM    | Ekran Boyutu      | Hafızası   |");

        for (Notebook n : this.notebookList) {

            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-6s | %-17s | %-10s | \n",
                    n.getId(), n.getName(), n.getPrice(), n.getBrand(), n.getStock(), n.getRam(), n.getDisplaySize(), n.getStorage());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
    }



    public void deleteItem() {
        getNotebookList();
        System.out.print("Silinmesini istediğiniz notebook ID numarasını giriniz: ");
        int id = scn.nextInt();
        this.notebookList.remove(id - 1);
        System.out.println("Güncel notebook listesi");
        System.out.println("========================");
        getNotebookList();

    }

    public void brandFilter() {
        scn.nextLine();
        System.out.println("Filtrelemek istediğiniz ürün markasını giriniz: ");
        String choose = scn.nextLine();
        String filter = choose.substring(0,1) + choose.substring(1);
        List<Notebook> filterNotebookList = new ArrayList<>();

        for (Notebook a : this.notebookList) {
            if (filter.equals(a.getBrand())) {
                filterNotebookList.add(a);
            }
        }
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | RAM    | Ekran Boyutu      | Hafızası   |");

        for (Notebook n : filterNotebookList) {

            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-6s | %-17s | %-10s | \n",
                    n.getId(), n.getName(), n.getPrice(), n.getBrand(), n.getStock(), n.getRam(), n.getDisplaySize(), n.getStorage());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
    }

}

