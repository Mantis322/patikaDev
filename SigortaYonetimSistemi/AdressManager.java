import java.util.Scanner;

public class AdressManager {

    public static void addAdress(User user) {
        Scanner scn = new Scanner(System.in);
        IAdress iAdress;
        System.out.println("Eklemek istediğiniz Adres Türü Seçiniz:  ");
        System.out.println(" 1- EV ADRESİ \n" + "2- İŞ ADRESİ");
        int chooseAdressType = scn.nextInt();
        while (chooseAdressType < 1 || chooseAdressType > 2) {
            System.out.println("Yanlış seçim yaptınız");
            chooseAdressType = scn.nextInt();
        }
        System.out.println("Lütfen Adresinizi Giriniz: ");
        String adress = scn.nextLine();

        System.out.println("Lütfen Şehrinizi Giriniz: ");
        String city = scn.nextLine();

        System.out.println("Lütfen İl Giriniz: ");
        String province = scn.nextLine();

        if (chooseAdressType == 1 ){
            iAdress = new HomeAdress(adress,city,province);
        }else {
            iAdress = new BusinessAdress(adress,city,province);
        }
        user.setAdressList(iAdress);
    }

    public static void deleteAdress(User user){
        user.getAdressList();
        Scanner scn = new Scanner(System.in);
        System.out.println("Lütfen silmek istediğiniz adresin ID numarasını giriniz.");
        int id = scn.nextInt();
        user.getAdressList().remove(id-1);
        System.out.println("Silme işlemi tamamlandı");


    }
}
