package in.hiddenbrains.calc.Calculations;

/**
 * Created by sunil on 28-03-2016.
 */
public class TimeCalculation {
    
    private int day1 ,hour1 , minute1 , second1;
    private int day2 ,hour2 , minute2 , second2;
    private int day3 ,hour3 , minute3 , second3;
    private int flag;
    private long totalseconds1 , totalseconds2 , totalseconds3;
    public TimeCalculation(int day1 , int hour1 , int minute1 , int second1 , int day2 , int hour2 , int minute2 , int second2, int flag){
        this.day1 = day1;
        this.hour1 = hour1;
        this.minute1 = minute1;
        this.second1 = second1;

        this.day2 = day2;
        this.hour2 = hour2;
        this.minute2 = minute2;
        this.second2 = second2;

        this.flag = flag;
    }

    public Integer[] calculate(){
        Integer[] answer = new Integer[5];

        second3 = 0;
        minute3 = 0;
        hour3 = 0;
        day3 = 0;


        if(flag == 1) {
            second3 = second1 + second2;

            if (second3 > 60) {
                minute3 = minute3 + (second3 / 60);
                second3 = second3 % 60;
            }

            minute3 = minute3 + minute1 + minute2;

            if (minute3 > 60) {
                hour3 = hour3 + (minute3 / 60);
                minute3 = minute3 % 60;

            }

            hour3 = hour3 + hour1 + hour2;

            if (hour3 > 24) {
                day3 = day3 + (hour3 / 24);
                hour3 = hour3 % 24;
            }

            day3 = day3 + day1 + day2;

            answer[0] = day3;
            answer[1] = hour3;
            answer[2] = minute3;
            answer[3] = second3;

            return answer;
        }
        else{

            totalseconds1 = second1 + ( minute1 * 60 ) + (hour1 * 3600) + (day1 * 86400);
            totalseconds2 = second2 + ( minute2 * 60 ) + (hour2 * 3600) + (day2 * 86400);

            totalseconds3 = totalseconds1 - totalseconds2 ;

                day3 = (int) (totalseconds3 / 86400);
                totalseconds3 = totalseconds3 % 86400;
                hour3 = (int) (totalseconds3 / 3600);
                totalseconds3 = totalseconds3 % 3600;
                minute3 = (int) (totalseconds3 / 60);
                totalseconds3 = totalseconds3 % 60;
                second3 = (int) totalseconds3;

                answer[0] = day3;
                answer[1] = hour3;
                answer[2] = minute3;
                answer[3] = second3;
            return answer;
        }
    }
}
