import java.util.Date;

public class TravelInsurance extends Insurance{
    public TravelInsurance(String insuranceType) {
        super("Seyahat Sigortası",  new Date(), new Date());

    }

    @Override
    public void calculate(String insuranceType) {
        double price = 500;

        if(insuranceType.equals("Individual")){
            setInsurancePrice(price);
        }else if(insuranceType.equals("Enterprise")){
            double salePrice = (price * 0.10) - price;
            setInsurancePrice(salePrice);
        }
    }
}
