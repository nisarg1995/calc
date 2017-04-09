package in.hiddenbrains.calc.Calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathsOperations {

    public static Double addition(Double number1 , Double number2){

        return round( number1 + number2 , 6);
    }
    public static Double substraction(Double number1 , Double number2){

        return round( number1 - number2 , 6);
    }
    public static Double multiplication(Double number1 , Double number2){

        return round( number1 * number2 , 6);
    }
    public static String division(Double number1 , Double number2){

        if(number2!=0) {
            return String.valueOf(round( number1 / number2 , 6));
        }
        else
            return "error";
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
