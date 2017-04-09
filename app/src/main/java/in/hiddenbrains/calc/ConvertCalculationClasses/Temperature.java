package in.hiddenbrains.calc.ConvertCalculationClasses;

/**
 * Created by sunil on 14-03-2016.
 */
public class Temperature {
    private Double valuetoconvert;

    public Double converttoindex(Double valuetoconvert, int type){

        Double answer = 0.0;
        switch (type){

            case 0:
                answer =  valuetoconvert;
                break;

            case 1:
                answer =  (valuetoconvert-32) * 0.55555555555;
                break;

            case 2:
                answer =  valuetoconvert - 273.15;
                break;

            case 3:
                answer =  (valuetoconvert - 491.67) * 0.55555555555;
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
                answer =  (valuetoconvert*1.8) + 32;
                break;

            case 2:
                answer =  valuetoconvert +  273.15;
                break;

            case 3:
                answer = (valuetoconvert + 273.15 ) * 1.8;
                break;


        }
        return answer;
    }

}
