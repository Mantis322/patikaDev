public abstract class SafeZone extends Zone {
   public SafeZone(String name, Player player){
        super(name,player);
    }

    @Override
    boolean onZone(){
        return false;
    }
}
