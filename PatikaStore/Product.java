public abstract class Product {

    private int id;
    private String name;
    private int price;
    private int stock;
    private int storage;
    private double displaySize;
    private int ram;

    private String brand;

    public Product(int id, String name, int price, int stock, int storage, double displaySize, int ram, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.storage = storage;
        this.displaySize = displaySize;
        this.ram = ram;
        this.brand = brand;
    }

    public Product() {

    }

    public abstract void menu();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(int displaySize) {
        this.displaySize = displaySize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setDisplaySize(double displaySize) {
        this.displaySize = displaySize;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
