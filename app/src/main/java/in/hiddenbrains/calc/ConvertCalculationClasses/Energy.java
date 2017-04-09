package in.hiddenbrains.calc.ConvertCalculationClasses;

/**
 * Created by sunil on 14-03-2016.
 */
public class Energy {
    private Double valuetoconvert;

    public Double converttoindex(Double valuetoconvert, int type){

        Double answer = 0.0;
        switch (type){

            case 0:
                answer =  valuetoconvert;
                break;

            case 1:
                answer =  valuetoconvert*0.238846;
                break;

            case 2:
                answer =  valuetoconvert*25199576.11;
                break;

            case 3:
                answer =  valuetoconvert*0.238846;
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
                answer =  valuetoconvert * 4.1868;
                break;

            case 2:
                answer =  valuetoconvert * 39.683207 /1000000000;
                break;

            case 3:
                answer = valuetoconvert * 4.1868;
                break;
        }
        return answer;
    }

}
