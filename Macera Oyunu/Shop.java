import java.util.Scanner;

public class Shop extends SafeZone {
    Scanner scn = new Scanner(System.in);

    public Shop(Player player) {
        super("Ma�aza", player);
    }

    @Override
    boolean onZone() {
        System.out.println("Ma�azaya Ho�geldiniz");

        boolean showMenu = true;

        while (showMenu){
            System.out.println("1 - Silah");
            System.out.println("2 - Z�rh");
            System.out.println("3 - ��k��");

            System.out.print("Ne Almak �stersiniz ? : ");
            int selectShop = scan.nextInt();
            while (selectShop < 1 || selectShop > 3) {
                System.out.println("Ge�ersiz se�im l�tfen tekrar se�iniz.");
                selectShop = scan.nextInt();
            }
            switch (selectShop) {
                case 1:
                    showWeapons();
                    buyWeapon();
                    break;
                case 2:
                    showArmors();
                    buyArmors();
                    break;
                case 3:
                    System.out.println("G�r���r�z");
                    showMenu = false;
                    return true;
                default:
                    System.out.println("Yanl�� se�im");
                    break;

            }
        }

        return true;
    }

    public void showWeapons() {
        System.out.println("===Silahlar===");
        for (Weapon w : Weapon.weapons()) {
            System.out.println("ID: " + w.getWeaponID() + " " + w.getWeaponName() +
                    " " + " Damage: "
                    + w.getWeaponDamage() + " " +
                    " Para: " + " "
                    + w.getWeaponCost());
        }
        System.out.println("0 - ��k��");
    }

    public void buyWeapon() {
        System.out.print("Bir silah se�iniz: ");
        int selectedWeaponID = scn.nextInt();

        while (selectedWeaponID < 0 || selectedWeaponID > Weapon.weapons().length) {
            System.out.println("Yanl�� de�er girdiniz l�tfen tekrar giriniz.");
            selectedWeaponID = scn.nextInt();
        }
        if (this.getPlayer().getInventory().getWeapon().getWeaponID() != selectedWeaponID){
            if(selectedWeaponID != 0 ){
                Weapon selectWeapon = Weapon.getWeaponObjectByID(selectedWeaponID);

                if (selectWeapon != null){
                    if (selectWeapon.getWeaponCost() > this.getPlayer().getMoney()){
                        System.out.println("Yeterli paran�z bulunmamaktad�r.");

                    }else {
                        System.out.println(selectWeapon.getWeaponName() + "Silah�n� ald�n�z.");
                        int balance = this.getPlayer().getMoney() - selectWeapon.getWeaponCost();
                        this.getPlayer().setMoney(balance);
                        System.out.println("KALAN BAK�YEN�Z : " + this.getPlayer().getMoney());
                        this.getPlayer().getInventory().setWeapon(selectWeapon);
                    }
                }
            }
        }else {
            System.out.println("Bu e�yaya zaten sahipsiniz tekrar alamazs�n�z.");
        }


    }

    public void showArmors() {
        System.out.println("Z�rhlar");
        for (Armor a : Armor.armors()) {
            System.out.println("ID: " + a.getArmorID() + " " + a.getArmorName() +
                    " " + " Bloklama: "
                    + a.getArmorDodge() + " " +
                    " Para: " + " "
                    + a.getArmorCost());
        }
        System.out.println("0- ��k��        ");
    }

    public void buyArmors(){
        System.out.print("Bir z�rh se�iniz: ");
        int selectedArmorID = scn.nextInt();

        while (selectedArmorID < 0 || selectedArmorID > Armor.armors().length) {
            System.out.println("Yanl�� de�er girdiniz l�tfen tekrar giriniz.");
            selectedArmorID = scn.nextInt();
        }
        if (this.getPlayer().getInventory().getArmor().getArmorID() != selectedArmorID){
            if (selectedArmorID != 0 ){
                Armor selectedArmor = Armor.getArmorObjectByID(selectedArmorID);

                if (selectedArmor != null){
                    if (selectedArmor.getArmorCost() > this.getPlayer().getMoney()){
                        System.out.println("Yeterli paran�z bulunmamaktad�r.");

                    }else {
                        System.out.println(selectedArmor.getArmorName() + "Silah�n� ald�n�z.");
                        int balance = this.getPlayer().getMoney() - selectedArmor.getArmorCost();
                        this.getPlayer().setMoney(balance);
                        System.out.println("KALAN BAK�YEN�Z : " + this.getPlayer().getMoney());
                        this.getPlayer().getInventory().setArmor(selectedArmor);
                    }
                }
            }
        }else {
            System.out.println("Bu e�yaya zaten sahipsiniz tekrar alamazs�n�z.");
        }


    }

}
