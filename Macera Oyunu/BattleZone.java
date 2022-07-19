import java.util.Random;

public abstract class BattleZone extends Zone {
    private Monster monster;
    private String award;

    private int maxMonsterNumber;


    public BattleZone(String name, Player player, Monster monster, String award, int maxMonsterNumber) {
        super(name, player);
        this.monster = monster;
        this.award = award;
        this.maxMonsterNumber = maxMonsterNumber;
    }

    @Override
    public boolean onZone() {
        int randomMonster = randomMonsterNumber();

        System.out.println("Þuan Buradasýnýz: " + this.getName());
        System.out.println("Burada " + randomMonster + " tane " + this.monster.getName() + " yaþýyor ");
        System.out.print("Savaþ ya da Kaç  (Savaþmak içi ' S ' , Kaçmak için 'K'): ");

        String selectCase = scan.nextLine();
        selectCase = selectCase.toUpperCase();

        if (selectCase.equals("S") && combat(randomMonster)) {
            System.out.println("Bu savaþý kazandýn...");
            System.out.println(this.getAward() + " ödülünü kazandýnýz. ");
            return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz");
            return false;
        }
        if (this.getPlayer().getInventory().isWater() && this.getPlayer().getInventory().isFirewood() && this.getPlayer().getInventory().isFood()) {
            System.out.println("Tebrikler oyunu kazandýnýz.");
            return false;
        }
        return true;
    }


    public boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            this.getMonster().setMonsterHealth(this.getMonster().getMonsterOrjHealth());
            System.out.println();
            this.getPlayer().printInfo();
            System.out.println();
            monsterInfo(i);

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getMonsterHealth() > 0) {
                System.out.println();
                System.out.print("Vur ya da Kaç (Vurmak için 'V', Kaçmak için 'K'): ");
                String selectAction = scan.nextLine();
                selectAction = selectAction.toUpperCase();

                double randomStrike = Math.random() * 100;

                if (selectAction.equals("V")) {

                    if (randomStrike <= 50) {
                        System.out.println();
                        System.out.println(this.getMonster().getName() + " canvarýna vurdunuz.");
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
                            System.out.println(this.getMonster().getName() + " canvarýna vurdunuz.");
                            this.getMonster().setMonsterHealth(this.getMonster().getMonsterHealth() - this.getPlayer().getTotalDamage());
                            afterHits();
                        }
                    }


                } else {
                    return false;
                }

            }
            System.out.println();
            System.out.println("Ödül: " + this.getMonster().getAward());
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
            if (this.getPlayer().getHealth() <= 0) {
                return false;
            }
        }

        isWin();
        return true;
    }


    public void afterHits() {
        System.out.println("Canýnýz: " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + "Caný: " + this.getMonster().getMonsterHealth());
    }

    public void isWin() {
    }

    public void monsterInfo(int i) {
        System.out.println("------------------------------------");
        System.out.println(i + ". " + this.getMonster().getName() + "Deðerleri");
        System.out.println(this.getMonster().getName() + "Saðlýðý: " + this.getMonster().getMonsterHealth());
        System.out.println(this.getMonster().getName() + " Hasarý: " + this.getMonster().getMonsterDamage());

    }

    public int randomMonsterNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxMonsterNumber()) + 1;
    }


    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }


    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public int getMaxMonsterNumber() {
        return maxMonsterNumber;
    }

    public void setMaxMonsterNumber(int maxMonsterNumber) {
        this.maxMonsterNumber = maxMonsterNumber;
    }
}
