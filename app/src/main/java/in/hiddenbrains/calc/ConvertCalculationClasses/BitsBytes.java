package in.hiddenbrains.calc.ConvertCalculationClasses;

/**
 * Created by sunil on 14-03-2016.
 */
public class BitsBytes {
    private Double valuetoconvert;

    public Double converttoindex(Double valuetoconvert, int type){

        Double answer = 0.0;
        switch (type){

            case 0:
                answer =  valuetoconvert;
                break;

            case 1:
                answer =  valuetoconvert*0.000122;
                break;

            case 2:
                answer =  valuetoconvert*0.000977;
                break;

            case 3:
                answer =  valuetoconvert*1024;
                break;

            case 4:
                answer =  valuetoconvert*1048576;
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
                answer =  valuetoconvert * 8192;
                break;

            case 2:
                answer =  valuetoconvert * 1024;
                break;

            case 3:
                answer = valuetoconvert * 0.000977;
                break;

            case 4:
                answer = valuetoconvert * 0.000001;
                break;
        }
        return answer;
    }

}
