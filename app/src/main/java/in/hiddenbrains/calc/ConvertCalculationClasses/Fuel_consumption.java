package in.hiddenbrains.calc.ConvertCalculationClasses;

/**
 * Created by sunil on 14-03-2016.
 */
public class Fuel_consumption {
    private Double valuetoconvert;

    public Double converttoindex(Double valuetoconvert, int type){

        Double answer = 0.0;
        switch (type){

            case 0:
                answer =  valuetoconvert;
                break;

            case 1:
                answer =  valuetoconvert*42.514371;
                break;

            case 2:
                answer =  valuetoconvert*0.425144;
                break;

            case 3:
                answer =  valuetoconvert*100;
                break;

        }
        return answer;
    }

    public Double converttoanswer(Double valuetoconvert , int type){
        Double answer = 0.0;

        switch (type){
            case 0:
                answer =  valuetoconvert;
                break;

            case 1:
                answer =  valuetoconvert * 42.514371;
                break;

            case 2:
                answer =  valuetoconvert * 2.352146;
                break;

            case 3:
                answer = valuetoconvert * 100;
                break;

        }
        return answer;
    }

}
