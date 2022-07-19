public class SafeHouse extends SafeZone{

    public SafeHouse(Player player){
        super("G�venli Ev",player);
    }

    @Override
    boolean onZone(){
        System.out.println("G�venli Ev'e ho�geldiniz.");
        System.out.println("Can�n�z yenileniyor.");
        this.getPlayer().setHealth(this.getPlayer().getOrjHealth());
        System.out.println("Can�n�z: " + this.getPlayer().getHealth());
        return true;
    }
}
