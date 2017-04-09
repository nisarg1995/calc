package in.hiddenbrains.calc.Model;

import android.content.Intent;

/**
 * Created by sunil on 09-03-2016.
 */
public class CalculatorType {

    private  Integer id;
    private String CalculatorName;
    private Integer imgid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CalculatorType(Integer id , String CalculatorName , Integer imgid){
        this.id = id;
        this.CalculatorName = CalculatorName;
        this.imgid = imgid;

    }

    public String getCalculatorName() {

        return CalculatorName;
    }

    public void setCalculatorName(String calculatorName) {

        this.CalculatorName = calculatorName;
    }

    public Integer getImgid() {

        return imgid;
    }

    public void setImgid(Integer imgid) {
        
        this.imgid = imgid;
    }
}
