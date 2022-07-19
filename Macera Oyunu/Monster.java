import java.util.Random;

public abstract class Monster {
    private String name;
    private int id;
    private int monsterDamage;
    private int monsterHealth;

    private int monsterOrjHealth;

    private int award;



    public Monster(String name, int id, int monsterDamage, int monsterHealth, int award) {
        this.name = name;
        this.id = id;
        this.monsterDamage = monsterDamage;
        this.monsterHealth = monsterHealth;
        this.monsterOrjHealth = monsterHealth;
        this.award = award;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonsterDamage() {
        return monsterDamage;
    }

    public void setMonsterDamage(int monsterDamage) {
        this.monsterDamage = monsterDamage;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        if (monsterHealth < 0) {
            monsterHealth = 0;
        }
        this.monsterHealth = monsterHealth;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }





    public int getMonsterOrjHealth() {
        return monsterOrjHealth;
    }

    public void setMonsterOrjHealth(int monsterOrjHealth) {
        this.monsterOrjHealth = monsterOrjHealth;
    }
}
