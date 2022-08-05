import java.util.Scanner;

public class Login {
    Scanner scanner=new Scanner(System.in);
    AccountManager accountManager=new AccountManager();
    public void login(){
        System.out.println("Sisteme hoşgeldiniz.");
        System.out.print("Email giriniz : ");
        String email=scanner.nextLine();
        System.out.print("Şifre giriniz : ");
        String password=scanner.nextLine();
        Account loginAccount = accountManager.login(email,password);

        run(loginAccount);

    }
    private void run(Account account){
        boolean run = true;
        while (run){
            System.out.println("İşlem listesi");
            System.out.println("1- Kullanıcı bilgilerini göster\n" +
                    "2- Kullanıcıya yeni poliçe yap\n" +
                    "3- Kullanıcıya yeni adres ekle\n" +
                    "4- Kullanıcı adresi sil\n" +
                    "9- Programdan çıkış yap.");
            System.out.print("Yapmak istediğiniz işlem numarasını yazın : ");
            int value=scanner.nextInt();
            switch (value) {
                case 1:
                    account.showUserInfo();
                    break;
                case 2:
                    account.addInsurance();
                    break;
                case 3:
                    account.addAddress();
                    break;
                case 4:
                    account.deleteAdress();
                    break;
                case 9:
                    System.out.println("Tekrar görüşmek üzere");
                    run = false;
                default:
                    System.out.println("Geçersiz değer");
            }
        }
    }
}
