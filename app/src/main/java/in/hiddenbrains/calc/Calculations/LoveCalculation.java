package in.hiddenbrains.calc.Calculations;

import android.support.annotation.VisibleForTesting;

/**
 * Created by sunil on 30-03-2016.
 */
public class LoveCalculation {
    private String himname , hername;
    private int himyear , heryear;
    private int himmonth , hermonth;
    private int himday , herday;
    private int himflag , herflag;

    public LoveCalculation(String himname , String hername , int himyear , int himmonth , int himday , int heryear , int hermonth , int herday , int himflag , int herflag){
        this.himname = himname;
        this.hername = hername;
        this.himyear = himyear;
        this.himmonth = himmonth;
        this.himday = himday;
        this.heryear = heryear;
        this.hermonth = hermonth;
        this.herday  = herday;
        this.himflag = himflag;
        this.herflag = herflag;
    }

    public int calculate(){
        int answer = 0;
        Double himlength = Double.valueOf(himname.length());
        Double herlength = Double.valueOf(hername.length());
        Double himbirthdaycount = Double.valueOf(himyear + himmonth + himday);
        Double herbirthdaycount = Double.valueOf(heryear + hermonth + herday);
        Double himtemp1 = himlength + himbirthdaycount + (himflag * 10);
        Double hertemp1 = herlength + herbirthdaycount + (herflag * 10);
        Double himtemp2 = (himtemp1 * 100 / 90) + himbirthdaycount;
        Double hertemp2 = (hertemp1 * 100 / 90) + herbirthdaycount;
        Double himtemp3 = (himtemp2 * 100 / 90) + himflag ;
        Double hertemp3 = (hertemp2 * 100 / 90) + herflag ;
        Double himtemp4 = (himtemp3 * 100 / 90) + himlength;
        Double hertemp4 = (hertemp3 * 100 / 90) + herlength;
        answer = (int) ((((himtemp4 * 100 / 90) + (hertemp4 * 100 / 90) + 90) % 100) + 90 ) % 100;

        if(answer < 20){
            answer = answer + 20;
        }
        return answer;
    }

}
