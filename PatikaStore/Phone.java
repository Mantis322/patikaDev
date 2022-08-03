import java.util.*;

public class Phone extends Product{
    Brand brand = new Brand();

    Scanner scn = new Scanner(System.in);

    private int battery;
    private String colour;
    private int productID =1;

    private List<Phone> phoneList = new ArrayList<>();


    public Phone(int id, String name, int price, int stock, int storage, double displaySize, int ram, String brand, int battery, String colour) {
        super(id, name, price, stock, storage, displaySize, ram, brand);

        this.battery = battery;
        this.colour = colour;

    }

    public Phone(){
        menu();
    }

    @Override
    public void menu() {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("1- Yeni Telefon ekle\n" +
                    "2- Telefon listesini görüntüle\n" +
                    "3- Telefon sil\n" +
                    "4- Telefonları markaya göre filtrele\n" +
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
                    addPhone();
                    break;
                case 2:
                    getPhoneList();
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

    public void addPhone() {

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

            System.out.println("Batarya: ");
            int battery = scn.nextInt();

            System.out.println("Renk: ");
            scn.nextLine();
            String colour = scn.nextLine();

            this.phoneList.add(new Phone(productID, productName, price, stock, storage, screen, ram, productBrand,battery,colour));

            System.out.println("Eklenen ürünün ID'si" + " " + productID);

            productID++;
        } catch (InputMismatchException e) {
            System.out.println("Hatalı giriş yaptınız.");
            e.getMessage();
            scn.nextLine();

        }


    }

    public void getPhoneList(){
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Batarya     | Stoğu        | RAM    | Ekran Boyutu      | Hafızası   | Renk     |");

        for (Phone n : this.phoneList) {

            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-11s | %-12s | %-6s | %-17s | %-10s | %-8s |\n",
                    n.getId(), n.getName(), n.getPrice(), n.getBrand(),n.getBattery(),n.getStock(), n.getRam(), n.getDisplaySize(),
                    n.getStorage(),n.getColour());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
    }


    public void deleteItem() {
        getPhoneList();
        System.out.print("Silinmesini istediğiniz notebook ID numarasını giriniz: ");
        int id = scn.nextInt();
        this.phoneList.remove(id - 1);
        System.out.println("Güncel notebook listesi");
        System.out.println("========================");
        getPhoneList();

    }

    public void brandFilter(){
        scn.nextLine();
        System.out.println("Filtrelemek istediğiniz markayı giriniz: ");
        String choose = scn.nextLine();
        String filter = choose.substring(0,1) + choose.substring(1);
        List<Phone> filteredList = new ArrayList<>();

        for (Phone n : this.phoneList){
            if (filter.equals(n.getBrand())){
                filteredList.add(n);
            }
        }

        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Batarya     | Stoğu        | RAM    | Ekran Boyutu      | Hafızası   | Renk     |");

        for (Phone n : filteredList) {

            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-11s | %-12s | %-6s | %-17s | %-10s | %-8s |\n",
                    n.getId(), n.getName(), n.getPrice(), n.getBrand(),n.getBattery(),n.getStock(), n.getRam(), n.getDisplaySize(),
                    n.getStorage(),n.getColour());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");


    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }




}
