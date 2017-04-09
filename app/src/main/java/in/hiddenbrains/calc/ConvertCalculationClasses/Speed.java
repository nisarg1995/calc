package in.hiddenbrains.calc.ConvertCalculationClasses;

/**
 * Created by sunil on 14-03-2016.
 */
public class Speed {
    private Double valuetoconvert;

    public Double converttoindex(Double valuetoconvert, int type){

        Double answer = 0.0;
        switch (type){

            case 0:
                answer =  valuetoconvert;
                break;

            case 1:
                answer =  valuetoconvert*0.03048 / 100;
                break;

            case 2:
                answer =  valuetoconvert*0.018288;
                break;

            case 3:
                answer =  valuetoconvert*3.6;
                break;

            case 4:
                answer =  valuetoconvert*1.609344;
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
                answer =  valuetoconvert * 3280.833333;
                break;

            case 2:
                answer =  valuetoconvert * 54.680665;
                break;

            case 3:
                answer = valuetoconvert * 0.277778;
                break;

            case 4:
                answer = valuetoconvert * 62.137119 / 100;
                break;
        }
        return answer;
    }

}
