package in.hiddenbrains.calc.ConvertCalculationClasses;

/**
 * Created by sunil on 14-03-2016.
 */
public class Area {
    private Double valuetoconvert;

    public Double converttoindex(Double valuetoconvert, int type){

        Double answer = 0.0;
        switch (type){

            case 0:
                answer =  valuetoconvert;
                break;

            case 1:
                answer =  valuetoconvert*2.471054;
                break;

            case 2:
                answer =  valuetoconvert*247.105381;
                break;

            case 3:
                answer =  valuetoconvert*0.000247;
                break;

            case 4:
                answer =  valuetoconvert*0.000023;
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
                answer =  valuetoconvert * 0.404686;
                break;

            case 2:
                answer =  valuetoconvert * 0.004047;
                break;

            case 3:
                answer = valuetoconvert * 4046.856422;
                break;

            case 4:
                answer = valuetoconvert * 43560;
                break;
        }
        return answer;
    }

}
