package in.hiddenbrains.calc.ConvertCalculationClasses;

/**
 * Created by sunil on 14-03-2016.
 */
public class Force {
    private Double valuetoconvert;

    public Double converttoindex(Double valuetoconvert, int type){

        Double answer = 0.0;
        switch (type){

            case 0:
                answer =  valuetoconvert;
                break;

            case 1:
                answer =  valuetoconvert*1000;
                break;

            case 2:
                answer =  valuetoconvert*1000000;
                break;

            case 3:
                answer =  valuetoconvert*9806.65;
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
                answer =  valuetoconvert * 0.001;
                break;

            case 2:
                answer =  valuetoconvert * 0.000001;
                break;

            case 3:
                answer = valuetoconvert * 0.000102;
                break;

        }
        return answer;
    }

}
