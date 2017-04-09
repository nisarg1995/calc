package in.hiddenbrains.calc.ConvertCalculationClasses;

/**
 * Created by sunil on 14-03-2016.
 */
public class Time{
private Double valuetoconvert;

        public Double converttoindex(Double valuetoconvert, int type){

            Double answer = 0.0;
            switch (type){

                case 0:
                    answer =  valuetoconvert;
                    break;

                case 1:
                    answer =  valuetoconvert*30.416667;
                    break;

                case 2:
                    answer =  valuetoconvert*365;
                    break;

                case 3:
                    answer =  valuetoconvert*0.041667;
                    break;

                case 4:
                    answer =  valuetoconvert*0.069444 / 100;
                    break;

                case 5:
                    answer = valuetoconvert*0.115741/10000;
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
                    answer =  valuetoconvert * 3.287671 / 100;
                    break;

                case 2:
                    answer =  valuetoconvert * 2.739726 / 1000;
                    break;

                case 3:
                    answer = valuetoconvert * 24;
                    break;

                case 4:
                    answer = valuetoconvert * 1440;
                    break;

                case 5:
                    answer = valuetoconvert * 86400;
                    break;
            }
            return answer;
        }

}
