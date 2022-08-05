import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager {
    private IAdress iAdress;
    private User user;
    private HomeAdress homeAdress;
    private Account account;
    Scanner scn = new Scanner(System.in);

    private TreeSet<Account> accountList = new TreeSet<Account>(Comparator.comparing(Account::userName));

    public void addUser() {


            System.out.println("Hesap ekleme paneli");
            System.out.println("Ev Adresi içi 1 \n"+
                    "İş adresi için 2");
            int adressChoose = scn.nextInt();
            System.out.println("Lütfen Adresinizi giriniz: ");
            scn.nextLine();
            String adress = scn.nextLine();

            System.out.println("Şehrinizi giriniz: ");
            String city = scn.nextLine();

            System.out.println("İlinizi giriniz: ");
            String province = scn.nextLine();

            if (adressChoose == 1 ) {
                iAdress = new HomeAdress(adress, city, province);
            }else {
                iAdress = new BusinessAdress(adress, city, province);
            }
            System.out.println("İsminiz : ");
            String name = scn.nextLine();

            System.out.println("Soyisminiz: ");
            String surname = scn.nextLine();

            System.out.println("E-mail adresiniz: ");
            String email = scn.nextLine();

            System.out.println("Şifreniz: ");
            String password = scn.nextLine();

            System.out.println("Mesleğiniz: ");
            String job = scn.nextLine();

            System.out.println("Yaşınız: ");
            int age = scn.nextInt();

        User user = new User(name,surname,email,password,iAdress,job,age,"Enterprise");
        account = new Enterprise(user);
        accountList.add(account);



    }

    public Account login(String email, String password){
        addUser();

        try {
            for (Account acc : accountList) {

                if (acc.getUser().getEmail().equals(email) && acc.getUser().getPassword().equals(password)) {
                    acc.login(email,password,acc);
                    return acc;
                }
            }
            throw new InvalidAuthenticationException("Şifre veya email yanlış girildi!");

        } catch (InvalidAuthenticationException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
