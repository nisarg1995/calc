package in.hiddenbrains.calc.ConvertCalculationClasses;

/**
 * Created by sunil on 14-03-2016.
 */
public class Length {
    private Double valuetoconvert;

    public Double converttoindex(Double valuetoconvert, int type){

        Double answer = 0.0;
        switch (type){

            case 0:
                answer =  valuetoconvert;
                break;

            case 1:
                answer =  valuetoconvert*0.3048;
                break;

            case 2:
                answer =  valuetoconvert*1000;
                break;

            case 3:
                answer =  valuetoconvert*0.0254;
                break;

            case 4:
                answer =  valuetoconvert*1609.344;
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
                answer =  valuetoconvert * 3.28084;
                break;

            case 2:
                answer =  valuetoconvert * 0.001;
                break;

            case 3:
                answer = valuetoconvert * 39.370079;
                break;

            case 4:
                answer = valuetoconvert * 0.621371 / 1000;
                break;
        }
        return answer;
    }

}
