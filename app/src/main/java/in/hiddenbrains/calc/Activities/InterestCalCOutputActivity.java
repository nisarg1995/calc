package in.hiddenbrains.calc.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.hiddenbrains.calc.Calculations.Keyboard;
import in.hiddenbrains.calc.R;

public class InterestCalCOutputActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView amountview , interestview , finalamountview ,amount2 ,interestrate2 , interesttime , tax , taxrate2;
    private Button ok , home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_cal_coutput);
        Keyboard.setupUI(findViewById(R.id.parent), this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Double amount = bundle.getDouble("amount");
        double interestrate = bundle.getDouble("interestrate");
        double taxamount = bundle.getDouble("taxamount");
        double time = bundle.getDouble("time");
        double finalamount = bundle.getDouble("finalresult");
        double interest = bundle.getDouble("interestamount");
        double taxra = bundle.getDouble("taxra");

        amountview = (TextView)findViewById(R.id.amount);
        interestview = (TextView)findViewById(R.id.interest);
        finalamountview = (TextView)findViewById(R.id.finalanswer);
        tax = (TextView)findViewById(R.id.tax);
        amount2 = (TextView)findViewById(R.id.amount2);
        interestrate2 = (TextView)findViewById(R.id.interestrate);
        taxrate2 = (TextView)findViewById(R.id.taxrate);
        interesttime = (TextView)findViewById(R.id.interesttime);

        ok= (Button)findViewById(R.id.ok);
        home = (Button)findViewById(R.id.home);

        amountview.setText(String.valueOf(amount));
        interestview.setText(String.valueOf(interest));
        tax.setText(String.valueOf(taxamount));
        finalamountview.setText(String.valueOf(finalamount));
        amount2.setText(String.valueOf(amount));
        interestrate2.setText(String.valueOf(interestrate));
        taxrate2.setText(String.valueOf(taxra));
        interesttime.setText(String.valueOf(time));


        ok.setOnClickListener(this);
        home.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.ok:
                setResult(0,null);
                finish();
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;

            case R.id.home:
                Intent intent = new Intent(this , MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.title_activity_interest_cal_coutput);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }


}
