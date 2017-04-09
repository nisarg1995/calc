package in.hiddenbrains.calc.Calculations;

import java.text.DecimalFormat;

/**
 * Created by sunil on 25-03-2016.
 */
public class MortgageCalculation {
    private Double homeamount , downpayment , interestrate , timeinyears;
    private Double propertytax , homeownerinsurence , hoadues;

    public MortgageCalculation(Double homeamount , Double downpayment , Double interestrate , Double timeinyears , Double propertytax,  Double homeownerinsurence , Double hoadues){

        this.homeamount = homeamount;
        this.downpayment = downpayment;
        this.interestrate = interestrate;
        this.timeinyears = timeinyears;
        this.propertytax = propertytax;
        this.homeownerinsurence = homeownerinsurence;
        this.hoadues = hoadues;
    }

    public Double  calcuate(){
        Double answer=0.0;
        Double amounttomortgage = homeamount - downpayment;
        Double interestratepermonth = (interestrate / 100) / 12;
        Double totalnumberofmonth = timeinyears * 12;

        Double temp = interestratepermonth +1;

        Double temp2 = Math.pow(temp , totalnumberofmonth);

        Double temp3 =  interestratepermonth * temp2;

        Double temp4 = temp2 - 1;

        answer = amounttomortgage * temp3 / temp4;

        return round(answer);
    }

    public Double getPropertytax() {
        return round(propertytax / 12) ;
    }

    public Double getInsurancetax() {
        return round(homeownerinsurence / 12) ;
    }


    public static Double round(Double answer){
        double answer1;
        DecimalFormat decim = new DecimalFormat("0.00");
        answer1 = Double.parseDouble(decim.format(answer));
        return answer1;
    }
}
