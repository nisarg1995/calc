package in.hiddenbrains.calc.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import in.hiddenbrains.calc.Calculations.Keyboard;
import in.hiddenbrains.calc.Calculations.MortgageCalculation;
import in.hiddenbrains.calc.R;

public class MortgageCalcActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText homeamount , downpayment, interestrate , timeinyears;
    private EditText propertytax , homeownerinsurance , hoadues;
    private String home_amount , down_payment , interest_rate , time_inyears;
    private String property_tax , home_insurance , hoa_dues;
    private Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_calc);
        Keyboard.setupUI(findViewById(R.id.parent), this);

        homeamount = (EditText)findViewById(R.id.homeamount);
        downpayment = (EditText)findViewById(R.id.downpayment);
        interestrate = (EditText)findViewById(R.id.interestrate);
        timeinyears = (EditText)findViewById(R.id.timeinyears);
        propertytax = (EditText)findViewById(R.id.propertytax);

        homeownerinsurance = (EditText)findViewById(R.id.homwownerinsurence);
        hoadues = (EditText)findViewById(R.id.hoadues);

        calculate = (Button)findViewById(R.id.calculate);
        calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(!homeamount.getText().toString().equals("")){
            home_amount = homeamount.getText().toString();
        }
        else{
            home_amount="0.0";
        }

        if(!downpayment.getText().toString().equals("")){
                down_payment = downpayment.getText().toString();
        }
        else{
            down_payment="0.0";
        }

        if(!interestrate.getText().toString().equals("")) {
            interest_rate = interestrate.getText().toString();
        }
        else{
            interest_rate="0.0";
        }

        if(!timeinyears.getText().toString().equals("")) {
            time_inyears = timeinyears.getText().toString();
        }
        else
        {
            time_inyears ="0";
        }

        if(!propertytax.getText().toString().equals("") ){
            property_tax = propertytax.getText().toString();
        }
        else{
            property_tax = "0.0";
        }

        if(!homeownerinsurance.getText().toString().equals("") ){
            home_insurance = homeownerinsurance.getText().toString();
        }
        else{
            home_insurance = "0.0";
        }

        if(!hoadues.getText().toString().equals("") ){
            hoa_dues = hoadues.getText().toString();
        }
        else{
            hoa_dues = "0.0";
        }

        MortgageCalculation mortgageCalculation = new MortgageCalculation(Double.parseDouble(home_amount) , Double.parseDouble(down_payment),Double.parseDouble(interest_rate),Double.parseDouble(time_inyears),Double.parseDouble(property_tax),Double.parseDouble(home_insurance),Double.parseDouble(hoa_dues));

        Double answer = mortgageCalculation.calcuate();
        Double propertytax = mortgageCalculation.getPropertytax();
        Double insurancetax = mortgageCalculation.getInsurancetax();
        Double finalanswer =MortgageCalculation.round(answer + propertytax + insurancetax + Double.valueOf(hoa_dues)) ;

        Intent intent = new Intent(this , MortgageCalCOutputActivity.class);

        intent.putExtra("principalandinterest",answer.toString());
        intent.putExtra("propertytaxes",propertytax.toString());
        intent.putExtra("homeownerinsurance",insurancetax.toString());
        intent.putExtra("hoadues",hoa_dues.toString());
        intent.putExtra("totalpayment",finalanswer.toString());

        intent.putExtra("homeamount",home_amount.toString());
        intent.putExtra("downpayment",down_payment.toString());
        intent.putExtra("interestrate",interest_rate.toString());
        intent.putExtra("time",time_inyears.toString());

        intent.putExtra("propertytax",property_tax.toString());
        intent.putExtra("homeownerinsurance",home_insurance.toString());
        intent.putExtra("hoadues",hoa_dues.toString());

        startActivityForResult(intent, 0);
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        homeamount.setText("");
        downpayment.setText("");
        interestrate.setText("");
        timeinyears.setText("");
        hoadues.setText("");
        homeownerinsurance.setText("");
        propertytax.setText("");
    }


    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.title_activity_finalcial_calc);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }

}
