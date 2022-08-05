import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String job;
    private int age;
    private ArrayList<IAdress> adressList = new ArrayList();
    private Date lastLogIn;

    private String insuranceType;

    private IAdress addresses;

    public User(String name, String surname, String email, String password,IAdress adress , String job, int age,
                String insuranceType) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.addresses = adress;
        this.lastLogIn = new Date(System.currentTimeMillis());
        this.insuranceType = insuranceType;
    }


    public ArrayList<IAdress> getAdressList() {
        return adressList;
    }

    public void setAdressList(IAdress adressList) {
        this.adressList.add(adressList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getLastLogIn() {
        return lastLogIn;
    }

    public void setLastLogIn(Date lastLogIn) {
        this.lastLogIn = lastLogIn;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public IAdress getAddresses() {
        return addresses;
    }

    public void setAddresses(IAdress addresses) {
        this.addresses = addresses;
    }
}
