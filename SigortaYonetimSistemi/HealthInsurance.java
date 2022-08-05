import java.util.Date;

public class HealthInsurance extends Insurance{
    public HealthInsurance(String insuranceType) {
        super("Sağlık Sigortası",  new Date(), new Date());
        calculate(insuranceType);
    }

    @Override
    public void calculate(String insuranceType) {
        double price = 999.99;

        if(insuranceType.equals("Individual")){
            setInsurancePrice(price);
        }else if(insuranceType.equals("Enterprise")){
            double salePrice = (price * 0.10) - price;
            setInsurancePrice(salePrice);
        }
    }


}
