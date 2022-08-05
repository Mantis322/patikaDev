import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public abstract class Account  {
    Scanner scn = new Scanner(System.in);

    private User user;
    private List<Insurance> insuranceList = new ArrayList<>();

    private AuthenticationStatus loginStatus=AuthenticationStatus.FAIL;

    public Account(User user) {
        this.user = user;

    }

    public final void showUserInfo(){
        System.out.println("| Ad    | Soyad    | E-mail          | Meslek     | Yaş | Adres                | ");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-8s | %15-s | %10-s | %3-s | \n",
                user.getName(), user.getSurname(), user.getEmail(), user.getJob(),user.getAge(),
                user.getAdressList());

    }

    private enum AuthenticationStatus{
        SUCCESS,
        FAIL;
    }

    private boolean isLogin(){
        if (loginStatus == AuthenticationStatus.SUCCESS){
            return true;
        }
        return false;
    }

    public String userName(){
        return  user.getName();
    }

    public List<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(Insurance insurancelist) {
        this.insuranceList.add(insurancelist);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addAddress(){
        AdressManager.addAdress(this.user);
    }

    public void deleteAdress(){
        AdressManager.deleteAdress(this.user);
    }

    public abstract void addInsurance();

    public void login(String email,String password,Account account) throws InvalidAuthenticationException{


        if (user.getEmail().equals(email) && user.getPassword().equals(password)){
            loginStatus = AuthenticationStatus.SUCCESS;
        }else {
            throw new InvalidAuthenticationException("E-mail ya da şifre birbiriyle uyuşmuyor");
        }

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
