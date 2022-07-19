import java.util.Scanner;

public class Game {
    private Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.print("L�tfen Oyuncu Ad� Giriniz: ");
        String playerName = scan.next();
        System.out.println("Oyuna Ho�geldiniz " + playerName);

        Player player = new Player(playerName);
        player.selectChar();

        Zone zone = null;
        while (true) {
            player.printInfo();
            System.out.println(" ");
            System.out.println("=======B�lgeler======= ");
            System.out.println("1. G�venli Ev");
            System.out.println("2. T�kkan");
            System.out.println("3. Ma�ara");
            System.out.println("4. Orman");
            System.out.println("5. Nehir");
            System.out.println("6. Maden");
            System.out.println("0 - ��k�� yap");
            System.out.print("L�tfen gitmek istedi�iniz b�lgeyi se�iniz: ");
            int selZone = scan.nextInt();
            while (selZone < 0 || selZone > 6) {
                System.out.println("Yanl�� se�im yapt�n�z");
                System.out.println("Otomatikman G�venli Ev'e g�t�r�ld�n�z.");
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
                System.out.println("Oyundan ��k�� yapt�n�z.");
                break;
            }


            if (!zone.onZone()) {
                System.out.println("Game over");
                break;
            }
        }
    }
}
