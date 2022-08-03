import java.util.Scanner;

public class PatikaStore {
    public void run() {
        Scanner scn = new Scanner(System.in);
        Brand brand = new Brand();
        while (true) {
            boolean isExit = false;
            System.out.println("Patika Store Ürün yönetim Paneli ! ");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz: ");
            int menuChoose = scn.nextInt();

            switch (menuChoose) {
                case 1:
                    Notebook notebook = new Notebook();
                    break;
                case 2:
                    Phone phone = new Phone();
                    break;
                case 3:
                    brand.list();
                    break;
                case 0:
                    isExit = true;
                    break;
                default:
                    break;
            }
            if (isExit) {
                System.out.println("Tekrar görüşmek üzere");
                break;
            }
        }

    }
}
