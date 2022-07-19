public class Weapon {
    private String weaponName;
    private int weaponID;
    private int weaponDamage;
    private int weaponCost;


    public Weapon(String weaponName, int weaponID, int weaponDamage, int weaponCost) {
        this.weaponName = weaponName;
        this.weaponID = weaponID;
        this.weaponDamage = weaponDamage;
        this.weaponCost = weaponCost;
    }

    public static Weapon[] weapons(){
        Weapon[] weaponlist = new Weapon[3];
        weaponlist[0] = new Weapon("Tabanca",1,2,25);
        weaponlist[1]= new Weapon("Kýlýç",2,3,35);
        weaponlist[2] = new Weapon("Tüfek",3,7,45);
        return weaponlist;
    }

    public static Weapon getWeaponObjectByID(int id){
        for (Weapon w : Weapon.weapons()){
            if(w.getWeaponID() == id){
                return w;
            }
        }
        return null;
    }

    public String getWeaponName(){
        return weaponName;
    }
    public void setWeaponName(String name){
        this.weaponName = name;
    }

    public int getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponCost() {
        return weaponCost;
    }

    public void setWeaponCost(int weaponCost) {
        this.weaponCost = weaponCost;
    }
}
