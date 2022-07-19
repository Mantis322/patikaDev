import java.util.Scanner;

public class Shop extends SafeZone {
    Scanner scn = new Scanner(System.in);

    public Shop(Player player) {
        super("Maðaza", player);
    }

    @Override
    boolean onZone() {
        System.out.println("Maðazaya Hoþgeldiniz");

        boolean showMenu = true;

        while (showMenu){
            System.out.println("1 - Silah");
            System.out.println("2 - Zýrh");
            System.out.println("3 - Çýkýþ");

            System.out.print("Ne Almak Ýstersiniz ? : ");
            int selectShop = scan.nextInt();
            while (selectShop < 1 || selectShop > 3) {
                System.out.println("Geçersiz seçim lütfen tekrar seçiniz.");
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
                    System.out.println("Görüþürüz");
                    showMenu = false;
                    return true;
                default:
                    System.out.println("Yanlýþ seçim");
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
        System.out.println("0 - Çýkýþ");
    }

    public void buyWeapon() {
        System.out.print("Bir silah seçiniz: ");
        int selectedWeaponID = scn.nextInt();

        while (selectedWeaponID < 0 || selectedWeaponID > Weapon.weapons().length) {
            System.out.println("Yanlýþ deðer girdiniz lütfen tekrar giriniz.");
            selectedWeaponID = scn.nextInt();
        }
        if (this.getPlayer().getInventory().getWeapon().getWeaponID() != selectedWeaponID){
            if(selectedWeaponID != 0 ){
                Weapon selectWeapon = Weapon.getWeaponObjectByID(selectedWeaponID);

                if (selectWeapon != null){
                    if (selectWeapon.getWeaponCost() > this.getPlayer().getMoney()){
                        System.out.println("Yeterli paranýz bulunmamaktadýr.");

                    }else {
                        System.out.println(selectWeapon.getWeaponName() + "Silahýný aldýnýz.");
                        int balance = this.getPlayer().getMoney() - selectWeapon.getWeaponCost();
                        this.getPlayer().setMoney(balance);
                        System.out.println("KALAN BAKÝYENÝZ : " + this.getPlayer().getMoney());
                        this.getPlayer().getInventory().setWeapon(selectWeapon);
                    }
                }
            }
        }else {
            System.out.println("Bu eþyaya zaten sahipsiniz tekrar alamazsýnýz.");
        }


    }

    public void showArmors() {
        System.out.println("Zýrhlar");
        for (Armor a : Armor.armors()) {
            System.out.println("ID: " + a.getArmorID() + " " + a.getArmorName() +
                    " " + " Bloklama: "
                    + a.getArmorDodge() + " " +
                    " Para: " + " "
                    + a.getArmorCost());
        }
        System.out.println("0- Çýkýþ        ");
    }

    public void buyArmors(){
        System.out.print("Bir zýrh seçiniz: ");
        int selectedArmorID = scn.nextInt();

        while (selectedArmorID < 0 || selectedArmorID > Armor.armors().length) {
            System.out.println("Yanlýþ deðer girdiniz lütfen tekrar giriniz.");
            selectedArmorID = scn.nextInt();
        }
        if (this.getPlayer().getInventory().getArmor().getArmorID() != selectedArmorID){
            if (selectedArmorID != 0 ){
                Armor selectedArmor = Armor.getArmorObjectByID(selectedArmorID);

                if (selectedArmor != null){
                    if (selectedArmor.getArmorCost() > this.getPlayer().getMoney()){
                        System.out.println("Yeterli paranýz bulunmamaktadýr.");

                    }else {
                        System.out.println(selectedArmor.getArmorName() + "Silahýný aldýnýz.");
                        int balance = this.getPlayer().getMoney() - selectedArmor.getArmorCost();
                        this.getPlayer().setMoney(balance);
                        System.out.println("KALAN BAKÝYENÝZ : " + this.getPlayer().getMoney());
                        this.getPlayer().getInventory().setArmor(selectedArmor);
                    }
                }
            }
        }else {
            System.out.println("Bu eþyaya zaten sahipsiniz tekrar alamazsýnýz.");
        }


    }

}
