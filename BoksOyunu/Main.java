public class Main {

    public static void main(String[] args) {
        Fighter f1 = new Fighter("Ali",20,150,96,20);
        Fighter f2 = new Fighter("Muhammed", 25,123,90,36);

        Match match = new Match(f1,f2,80,100);
        match.run();
    }
}
