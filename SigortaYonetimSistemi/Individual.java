import java.util.List;
import java.util.Scanner;

public class Individual extends Account{
    Account account;
    Scanner scn = new Scanner(System.in);
    public Individual(User user) {
        super(user);
    }

    @Override
    public void addInsurance() {
        System.out.println("Poliçe ekleme bölümüne hoşgeldiniz");
        System.out.println("Sigorta Türlerimiz");
        System.out.println("1- Sağlık Sigortası\n" +
                "2- Konut Sigortası\n" +
                "3- Seyahat Sigortası\n" +
                "4- Araba Sigortası");
        System.out.print("Yapmak istediğiniz sigorta çeşidinin numarasını giriniz : ");
        int choose = scn.nextInt();

        switch (choose){
            case 1:
                account.setInsuranceList(new HealthInsurance(this.getClass().getName()));
                System.out.println("Sigortanız yapılmıştır. Aktif sigortalarınız: ");
                account.getInsuranceList();
                break;
            case 2:
                account.setInsuranceList(new ResidenceInsurance(this.getClass().getName()));
                System.out.println("Sigortanız yapılmıştır. Aktif sigortalarınız: ");
                account.getInsuranceList();
                break;
            case 3:
                account.setInsuranceList(new TravelInsurance(this.getClass().getName()));
                System.out.println("Sigortanız yapılmıştır. Aktif sigortalarınız: ");
                account.getInsuranceList();
                break;
            case 4 :
                account.setInsuranceList(new CarInsurance(this.getClass().getName()));
                System.out.println("Sigortanız yapılmıştır. Aktif sigortalarınız: ");
                account.getInsuranceList();
                break;
            default:
                System.out.println("Yanlış Seçim yaptınız.");
                break;
        }
    }


}
