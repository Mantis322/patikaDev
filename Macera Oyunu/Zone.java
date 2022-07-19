import java.util.Scanner;

public abstract class Zone {
    private String name;
    private Player player;
    protected Scanner scan = new Scanner(System.in);

    public Zone(String name, Player player){
        this.name = name;
        this.player = player;
    }

    abstract boolean onZone();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
