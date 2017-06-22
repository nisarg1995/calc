package in.hiddenbrains.calc.Calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by sunil on 10-03-2016.
 */
public class InterestCalculation {
    private Double amount;
    private Double interestrate;
    private Double time;
    private Double taxrate;
    private Integer id;
    private Integer type;

    public InterestCalculation(Double amount , Double interestrate,Double taxrate , Double time , Integer id , Integer type){
        this.amount = amount;
        this.interestrate = interestrate;
        this.time = time;
        this.taxrate = taxrate;
        this.id = id;
        this.type = type;
    }

    public Double[] calculate(){
        Double[] answer = new Double[3];

        if(type == 0) {

            if (id == 0) {
                answer[0] = amount;
                Double temp = amount * ((interestrate / 100) * time);
                Double temp2 = temp * (taxrate / 100);
                answer[0] = answer[0] + temp;
                answer[0] = answer[0] - temp2;
                answer[1] = temp;
                answer[2] = temp2;
            } else if (id == 1) {
                answer[0] = amount;
                Double temp = amount * ((interestrate / 100) * time);
                Double temp2 = temp * (taxrate / 100);
                answer[0] = answer[0] + temp;
                answer[0] = answer[0] - temp2;
                answer[1] = temp;
                answer[2] = temp2;
            }
        }

        else if(type == 1){
            if(id == 0){
                answer[0] = 0.0;
                Double temp = amount * Math.pow((1 + (((interestrate/100)*12 ) / 12 )), 12 * (time / 12));
                answer[0] = temp;
                answer[1] = answer[0] - amount;
                answer[2] = answer[1] * (taxrate / 100);
                answer[0] = answer[0] - answer[2];
            }
            else if(id==1){
                answer[0] = 0.0;
                Double temp = amount * Math.pow((1 + ((interestrate/100)*12 / 4 )) , 4 * (time));
                answer[0] = temp;
                answer[1] = answer[0] - amount;
                answer[2] = answer[1] * (taxrate / 100);
                answer[0] = answer[0] - answer[2];
            }
            else if(id==2){
                answer[0] = 0.0;
                Double temp = amount * Math.pow((1 + ((interestrate/100)*12 / 2 )) , 2 * (time));
                answer[0] = temp;
                answer[1] = answer[0] - amount;
                answer[2] = answer[1] * (taxrate / 100);
                answer[0] = answer[0] - answer[2];
            }
            else if(id==3){
                answer[0] = 0.0;
                Double temp = amount * Math.pow((1 + ((interestrate/100)*12 / 1)) , 1 * (time));
                answer[0] = temp;
                answer[1] = answer[0] - amount;
                answer[2] = answer[1] * (taxrate / 100);
                answer[0] = answer[0] - answer[2];
            }

        }
        return round(answer);
    }
    public static Double[] round(Double[] answer){

        Double[] answer1 = new Double[3];

        for(int i=0;i<3;i++){
            long factor = (long) Math.pow(10, 2);
            answer[i] = answer[i]* factor;
            long tmp = Math.round(answer[i]);
            answer1[i]= (double) tmp / factor;
        }
        return answer1;
    }

    public static Double round(Double answer){
        double answer1;
        DecimalFormat decim = new DecimalFormat("0.00");
        answer1 = Double.parseDouble(decim.format(answer));
        return answer1;
    }
}
