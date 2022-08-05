import java.util.Date;

public abstract class Insurance {
    private String insuranceName;
    private double insurancePrice;
    private Date insuranceStartingDate;
    private Date insuraceExpDate;

    public Insurance(String insuranceName,  Date insuranceStartingDate, Date insuraceExpDate) {
        this.insuranceName = insuranceName;
        this.insuranceStartingDate = insuranceStartingDate;
        this.insuraceExpDate = insuraceExpDate;

    }

    public abstract void calculate(String insuranceType);

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public Date getInsuranceStartingDate() {
        return insuranceStartingDate;
    }

    public void setInsuranceStartingDate(Date insuranceStartingDate) {
        this.insuranceStartingDate = insuranceStartingDate;
    }

    public Date getInsuraceExpDate() {
        return insuraceExpDate;
    }

    public void setInsuraceExpDate(Date insuraceExpDate) {
        this.insuraceExpDate = insuraceExpDate;
    }
}
