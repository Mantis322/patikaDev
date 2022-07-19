import java.util.Scanner;

public class Game {
    private Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.print("Lütfen Oyuncu Adý Giriniz: ");
        String playerName = scan.next();
        System.out.println("Oyuna Hoþgeldiniz " + playerName);

        Player player = new Player(playerName);
        player.selectChar();

        Zone zone = null;
        while (true) {
            player.printInfo();
            System.out.println(" ");
            System.out.println("=======Bölgeler======= ");
            System.out.println("1. Güvenli Ev");
            System.out.println("2. Tükkan");
            System.out.println("3. Maðara");
            System.out.println("4. Orman");
            System.out.println("5. Nehir");
            System.out.println("6. Maden");
            System.out.println("0 - Çýkýþ yap");
            System.out.print("Lütfen gitmek istediðiniz bölgeyi seçiniz: ");
            int selZone = scan.nextInt();
            while (selZone < 0 || selZone > 6) {
                System.out.println("Yanlýþ seçim yaptýnýz");
                System.out.println("Otomatikman Güvenli Ev'e götürüldünüz.");
                break;
            }

            switch (selZone) {
                case 0:
                    zone = null;
                    break;
                case 1:
                    zone = new SafeHouse(player);
                    break;
                case 2:
                    zone = new Shop(player);
                    break;
                case 3:
                    zone = new Cave(player);
                    break;
                case 4:
                    zone = new Forest(player);
                    break;
                case 5:
                    zone = new River(player);
                    break;
                case 6:
                    zone = new Mines(player);
                    break;
                default:
                    zone = new SafeHouse(player);
                    break;
            }
            if (zone == null) {
                System.out.println("Oyundan çýkýþ yaptýnýz.");
                break;
            }


            if (!zone.onZone()) {
                System.out.println("Game over");
                break;
            }
        }
    }
}
