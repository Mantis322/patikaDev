import java.util.Date;

public class ResidenceInsurance extends Insurance{
    public ResidenceInsurance(String insuranceType) {
        super("Konut Sigortası",  new Date(), new Date());
        calculate(insuranceType);
    }

    @Override
    public void calculate(String insuranceType) {
        double price = 1500;

        if(insuranceType.equals("Individual")){
            setInsurancePrice(price);
        }else if(insuranceType.equals("Enterprise")){
            double salePrice = (price * 0.10) - price;
            setInsurancePrice(salePrice);
        }
    }

}
