import java.util.Scanner;

public class Player {
    private Scanner scan = new Scanner(System.in);

    private Inventory inventory;
    private int damage;
    private int health;

    private int orjHealth;
    private int money;
    private String name;
    private String charName;


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();

    }


    public void selectChar() {
        System.out.println("KARAKTERLER");
        System.out.println("=================================");
        System.out.println("Samuray \t ID:1 \t Hasar: 5 \t Sa�l�k: 21 \t Para: 15");
        System.out.println("Ok�u \t\t ID:2 \t Hasar: 7 \t Sa�l�k: 18 \t Para: 20");
        System.out.println("�ovalye \t ID:3 \t Hasar: 8 \t Sa�l�k: 24 \t Para: 5");
        System.out.println("=================================");
        System.out.print("L�tfen oynamak istedi�iniz karaterin ID numaras�n� yaz�n�z : ");
        int charChoose = scan.nextInt();
        while (charChoose < 1 || charChoose > 3) {
            System.out.println("Yanl�� se�im yapt�n�z l�tfen tekrar se�iniz.");
            charChoose = scan.nextInt();
        }

        switch (charChoose) {

            case 1:
                initPlayer(new Samurai());
                System.out.println("Se�ti�iniz karakter: " + this.getCharName());
                break;
            case 2:
                initPlayer(new Archer());
                System.out.println("Se�ti�iniz karakter: " + this.getCharName());
                break;
            case 3:
                initPlayer(new Knight());
                System.out.println("Se�ti�iniz karakter: " + this.getCharName());
                break;
            default:
                System.out.println("L�tfen belirtilen ID numaralar�na g�re se�im yap�n�z.");
                break;
        }

    }


    public void initPlayer(Character character) {
        this.setCharName(character.getCharName());
        this.setMoney(character.getMoney());
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setOrjHealth(character.getHealth());
    }

    public void printInfo() {
        System.out.println("Silah�n�z: " + this.getInventory().getWeapon().getWeaponName() +
                ", Hasar: " + this.getTotalDamage() +
                ", Z�rh�n�z: " + this.getInventory().getArmor().getArmorName() +
                ", Bloklama: " + this.getInventory().getArmor().getArmorDodge() +
                ", Sa�l�k: " + this.getHealth() +
                ", Para: " + this.getMoney()

        );
    }

    public int getTotalDamage() {
        return this.damage + this.getInventory().getWeapon().getWeaponDamage();
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return this.charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }


}
