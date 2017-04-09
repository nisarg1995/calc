package in.hiddenbrains.calc.ConvertCalculationClasses;

public class Angle {

    private Double valuetoconvert;

    public Double converttoindex(Double valuetoconvert, int type){

        Double answer = 0.0;
        switch (type){

            case 0:
                answer =  valuetoconvert;
                break;

            case 1:
                answer =  valuetoconvert*57.29578;
                break;

            case 2:
                answer =  valuetoconvert*360;
                break;

            case 3:
                answer =  valuetoconvert*45;
                break;

            case 4:
                answer =  valuetoconvert*90;
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
                answer =  valuetoconvert * 0.017453;
                break;

            case 2:
                answer =  valuetoconvert * 0.002778;
                break;

            case 3:
                answer = valuetoconvert * 0.022222;
                break;

            case 4:
                answer = valuetoconvert * 0.011111;
                break;
        }
        return answer;
    }
}
