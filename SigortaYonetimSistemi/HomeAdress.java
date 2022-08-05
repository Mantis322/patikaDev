public class HomeAdress implements IAdress{
    private final String adressName = "Ev Adresi  ";
    private String adress;
    private String city;
    private String province;
    private int adressID  = 1;

    public HomeAdress(String adress, String city, String province) {
        this.adress = adress;
        this.city = city;
        this.province = province;
        adressID++;
    }


    @Override
    public void showAdress() {
        System.out.println(adressName);
        System.out.println("---------------");
        System.out.println("ID: "  + getAdressID() +
                "Adresiniz: " + getAdress() + "Şehir: " + getCity() + "İl: " + getProvince());
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getAdressID() {
        return adressID;
    }

    public void setAdressID(int adressID) {
        this.adressID = adressID;
    }
}
