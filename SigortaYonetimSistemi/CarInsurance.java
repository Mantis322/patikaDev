import java.util.Date;

public class CarInsurance extends Insurance{
    public CarInsurance(String insuranceType) {
        super("Araba Sigortası",  new Date(),new Date());
    }

    @Override
    public void calculate(String insuranceType) {
        double price = 750;

        if(insuranceType.equals("Individual")){
            setInsurancePrice(price);
        }else if(insuranceType.equals("Enterprise")){
            double salePrice = (price * 0.10) - price;
            setInsurancePrice(salePrice);
        }
    }
}
