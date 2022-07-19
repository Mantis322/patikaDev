public class SafeHouse extends SafeZone{

    public SafeHouse(Player player){
        super("Güvenli Ev",player);
    }

    @Override
    boolean onZone(){
        System.out.println("Güvenli Ev'e hoþgeldiniz.");
        System.out.println("Canýnýz yenileniyor.");
        this.getPlayer().setHealth(this.getPlayer().getOrjHealth());
        System.out.println("Canýnýz: " + this.getPlayer().getHealth());
        return true;
    }
}
