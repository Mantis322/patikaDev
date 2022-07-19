public class Armor {
    private String armorName;
    private int armorID;
    private int armorDodge;
    private int armorCost;

    Armor(String armorName,int armorID,int armorDodge,int armorCost){
        this.armorName = armorName;
        this.armorID = armorID;
        this.armorDodge = armorDodge;
        this.armorCost = armorCost;
    }

    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Hafif Zýrh",1,1,15);
        armorList[1]= new Armor("Orta Zýrh",2,3,25);
        armorList[2] = new Armor("Aðýr Zýrh",3,5,40);
        return armorList;
    }

    public static Armor getArmorObjectByID(int id){
        for (Armor a : Armor.armors()){
            if(a.getArmorID() == id){
                return a;
            }
        }
        return null;
    }
    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorID() {
        return armorID;
    }

    public void setArmorID(int armorID) {
        this.armorID = armorID;
    }

    public int getArmorDodge() {
        return armorDodge;
    }

    public void setArmorDodge(int armorDodge) {
        this.armorDodge = armorDodge;
    }

    public int getArmorCost() {
        return armorCost;
    }

    public void setArmorCost(int armorCost) {
        this.armorCost = armorCost;
    }
}
