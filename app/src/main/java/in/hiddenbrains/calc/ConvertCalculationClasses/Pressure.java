package in.hiddenbrains.calc.ConvertCalculationClasses;

/**
 * Created by sunil on 14-03-2016.
 */
public class Pressure {
    private Double valuetoconvert;

    public Double converttoindex(Double valuetoconvert, int type){

        Double answer = 0.0;
        switch (type){

            case 0:
                answer =  valuetoconvert;
                break;

            case 1:
                answer =  valuetoconvert*0.986923 / 100000;
                break;

            case 2:
                answer =  valuetoconvert*0.986923 / 100000;
                break;

            case 3:
                answer =  valuetoconvert*105.848507 / 100;
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
                answer =  valuetoconvert * 101325;
                break;

            case 2:
                answer =  valuetoconvert * 101325;
                break;

            case 3:
                answer = valuetoconvert * 9.447464 / 10;
                break;

        }
        return answer;
    }

}
