import java.util.Random;

public class Mines extends BattleZone {


    public Mines(Player player) {
        super("Maden", player, new Snake(), "Para, Silah ya da Ganimet", 5);
    }

    @Override
    public boolean combat(int monsterNumber) {
        double randomStrike = Math.random() * 100;
        for (int i = 1; i <= monsterNumber; i++) {
            int snakeMonsterDamage = snakeDamege();
            this.getMonster().setMonsterDamage(snakeMonsterDamage);
            this.getMonster().setMonsterHealth(this.getMonster().getMonsterOrjHealth());
            System.out.println();
            this.getPlayer().printInfo();
            System.out.println();
            monsterInfo(i);

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getMonsterHealth() > 0) {
                System.out.println();
                System.out.print("Vur ya da Ka� (Vurmak i�in 'V', Ka�mak i�in 'K'): ");
                String selectAction = scan.nextLine();
                selectAction = selectAction.toUpperCase();

                randomStrike = Math.random() * 100;

                if (selectAction.equals("V")) {

                    if (randomStrike <= 50) {
                        System.out.println();
                        System.out.println(this.getMonster().getName() + " canvar�na vurdunuz.");
                        this.getMonster().setMonsterHealth(this.getMonster().getMonsterHealth() - this.getPlayer().getTotalDamage());
                        afterHits();
                        if (this.getMonster().getMonsterHealth() > 0) {
                            System.out.println();
                            System.out.println(this.getMonster().getName() + " size vurdu.");
                            int monsterGivenDamage = this.getMonster().getMonsterDamage() - this.getPlayer().getInventory().getArmor().getArmorDodge();
                            if (monsterGivenDamage < 0) {
                                monsterGivenDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterGivenDamage);
                            afterHits();
                        }
                    } else {
                        System.out.println();
                        System.out.println(this.getMonster().getName() + " size vurdu.");
                        int monsterGivenDamage = this.getMonster().getMonsterDamage() - this.getPlayer().getInventory().getArmor().getArmorDodge();
                        if (monsterGivenDamage < 0) {
                            monsterGivenDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterGivenDamage);
                        afterHits();
                        if (this.getPlayer().getHealth() > 0) {
                            System.out.println();
                            System.out.println(this.getMonster().getName() + " canvar�na vurdunuz.");
                            this.getMonster().setMonsterHealth(this.getMonster().getMonsterHealth() - this.getPlayer().getTotalDamage());
                            afterHits();
                        }
                    }


                } else {
                    return false;
                }

            }
            double lucyNumber = Math.random() * 100;
            if (lucyNumber <= 15) {
                lucyNumber = Math.random() * 100;
                if (lucyNumber <20){
                    int selectedID= 3;
                    if (this.getPlayer().getInventory().getWeapon().getWeaponID() != selectedID){
                        System.out.println("T�fek z�rh kazand�n�z.");
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjectByID(selectedID));
                    }else {
                        System.out.println("Bu Silah zaten �zerinizde mevcut");
                    }

                } else if (lucyNumber>20 && lucyNumber<=50) {
                    int selectedID= 2;
                    if (this.getPlayer().getInventory().getWeapon().getWeaponID() != selectedID){
                        System.out.println("K�l�� z�rh kazand�n�z.");
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjectByID(selectedID));
                    }else {
                        System.out.println("Bu Silah zaten �zerinizde mevcut");
                    }
                } else if (lucyNumber>50 && lucyNumber<=100) {
                    int selectedID= 1;
                    if (this.getPlayer().getInventory().getWeapon().getWeaponID() != selectedID){
                        System.out.println("Tabanca z�rh kazand�n�z.");
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjectByID(selectedID));
                    }else {
                        System.out.println("Bu Silah zaten �zerinizde mevcut");
                    }
                }
            } else if (lucyNumber > 15 && lucyNumber <= 30) {
                lucyNumber = Math.random() * 100;
                if (lucyNumber <20){
                    int selectedID= 3;
                    if (this.getPlayer().getInventory().getArmor().getArmorID() != selectedID){
                        System.out.println("A��r z�rh kazand�n�z.");
                        this.getPlayer().getInventory().setArmor(Armor.getArmorObjectByID(selectedID));
                    }else {
                        System.out.println("Bu z�rh Zaten �zerinizde mevcut");
                    }
                } else if (lucyNumber>20 && lucyNumber<=50) {
                    int selectedID= 2;
                    if (this.getPlayer().getInventory().getArmor().getArmorID() != selectedID){
                        System.out.println("Orta z�rh kazand�n�z.");
                        this.getPlayer().getInventory().setArmor(Armor.getArmorObjectByID(selectedID));
                    }else {
                        System.out.println("Bu z�rh Zaten �zerinizde mevcut");
                    }

                } else if (lucyNumber>50 && lucyNumber<=100) {
                    int selectedID= 1;
                    if (this.getPlayer().getInventory().getArmor().getArmorID() != selectedID){
                        System.out.println("Hafif z�rh kazand�n�z.");
                        this.getPlayer().getInventory().setArmor(Armor.getArmorObjectByID(selectedID));
                    }else {
                        System.out.println("Bu z�rh Zaten �zerinizde mevcut");
                    }
                }
            } else if (lucyNumber > 30 && lucyNumber <=55) {
                lucyNumber = Math.random() * 100;
                if (lucyNumber <20){
                    System.out.println("10 Para kazand�n�z.");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                } else if (lucyNumber>20 && lucyNumber<=50) {
                    System.out.println("5 Para kazand�n�z.");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                } else if (lucyNumber>50 && lucyNumber<=100) {
                    System.out.println("1 Para Kazand�n�z");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                }
            } else if (lucyNumber>55 && lucyNumber<=100) {
                System.out.println("Bir �ey kazanamad�n�z. ");
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            return false;
        }

        System.out.println();


        return true;
    }

    public int snakeDamege() {
        Random r = new Random();
        return r.nextInt(4) + 3;
    }
}
