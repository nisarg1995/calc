package in.hiddenbrains.calc.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.hiddenbrains.calc.Calculations.Keyboard;
import in.hiddenbrains.calc.R;

public class MortgageCalCOutputActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView principalandinterest , propertytax , homeownerinsurance , hoadues , totalmonthlypayment;
    private TextView principleamount, downpayment , interestrate , timeinmonths;
    private TextView annualpropertytax , homeownerinsuranceinput , HOAvalue;
    private Button ok,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_cal_coutput);
        Keyboard.setupUI(findViewById(R.id.parent), this);

        principalandinterest = (TextView)findViewById(R.id.principleandinterestvalue);
        propertytax = (TextView)findViewById(R.id.propertytaxvalue);
        homeownerinsurance = (TextView)findViewById(R.id.homeownerinsurancevalue);
        hoadues = (TextView)findViewById(R.id.hoaduesvalue);
        totalmonthlypayment = (TextView)findViewById(R.id.finalanswer);

        principleamount = (TextView)findViewById(R.id.principleamountvalue);
        downpayment = (TextView)findViewById(R.id.downpaymentvalue);
        interestrate = (TextView)findViewById(R.id.interestratevalue);
        timeinmonths = (TextView)findViewById(R.id.timevalue);

        annualpropertytax = (TextView)findViewById(R.id.annualpropertytax);
        homeownerinsuranceinput = (TextView)findViewById(R.id.homeownerinsurancevalueinput);
        HOAvalue = (TextView)findViewById(R.id.hoavalue);
        ok = (Button)findViewById(R.id.ok);
        home = (Button)findViewById(R.id.home);
        ok.setOnClickListener(this);
        home.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        principalandinterest.setText(bundle.getString("principalandinterest"));
        propertytax.setText(bundle.getString("propertytaxes"));
        homeownerinsurance.setText(bundle.getString("homeownerinsurance"));
        hoadues.setText(bundle.getString("hoadues"));
        totalmonthlypayment.setText(bundle.getString("totalpayment"));

        principleamount.setText(bundle.getString("homeamount"));
        downpayment.setText(bundle.getString("downpayment"));
        interestrate.setText(bundle.getString("interestrate"));
        timeinmonths.setText(bundle.getString("time"));

        annualpropertytax.setText(bundle.getString("propertytax"));
        homeownerinsuranceinput.setText(bundle.getString("homeownerinsurance"));
        HOAvalue.setText(bundle.getString("hoadues"));
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
        setTitle(R.string.title_activity_mortgage_cal_coutput);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }

}
