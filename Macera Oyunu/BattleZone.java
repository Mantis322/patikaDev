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

        System.out.println("�uan Buradas�n�z: " + this.getName());
        System.out.println("Burada " + randomMonster + " tane " + this.monster.getName() + " ya��yor ");
        System.out.print("Sava� ya da Ka�  (Sava�mak i�i ' S ' , Ka�mak i�in 'K'): ");

        String selectCase = scan.nextLine();
        selectCase = selectCase.toUpperCase();

        if (selectCase.equals("S") && combat(randomMonster)) {
            System.out.println("Bu sava�� kazand�n...");
            System.out.println(this.getAward() + " �d�l�n� kazand�n�z. ");
            return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("�ld�n�z");
            return false;
        }
        if (this.getPlayer().getInventory().isWater() && this.getPlayer().getInventory().isFirewood() && this.getPlayer().getInventory().isFood()) {
            System.out.println("Tebrikler oyunu kazand�n�z.");
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
                System.out.print("Vur ya da Ka� (Vurmak i�in 'V', Ka�mak i�in 'K'): ");
                String selectAction = scan.nextLine();
                selectAction = selectAction.toUpperCase();

                double randomStrike = Math.random() * 100;

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
            System.out.println();
            System.out.println("�d�l: " + this.getMonster().getAward());
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
            if (this.getPlayer().getHealth() <= 0) {
                return false;
            }
        }

        isWin();
        return true;
    }


    public void afterHits() {
        System.out.println("Can�n�z: " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + "Can�: " + this.getMonster().getMonsterHealth());
    }

    public void isWin() {
    }

    public void monsterInfo(int i) {
        System.out.println("------------------------------------");
        System.out.println(i + ". " + this.getMonster().getName() + "De�erleri");
        System.out.println(this.getMonster().getName() + "Sa�l���: " + this.getMonster().getMonsterHealth());
        System.out.println(this.getMonster().getName() + " Hasar�: " + this.getMonster().getMonsterDamage());

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
