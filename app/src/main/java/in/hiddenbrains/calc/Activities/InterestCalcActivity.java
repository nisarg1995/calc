package in.hiddenbrains.calc.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import in.hiddenbrains.calc.Calculations.InterestCalculation;
import in.hiddenbrains.calc.Calculations.Keyboard;
import in.hiddenbrains.calc.R;

public class InterestCalcActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private EditText principleamount , interestpercentage , interesttime , taxpercent;
    private TextView  simple , compound;
    private Button calculate;
    private Spinner selector;
    private TextView textView;
    private int calctype;
    private List<String> simpleInterestList;
    private List<String> compoundInterestList;

    private ArrayAdapter<String> simpleAdapter , customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_calc);

        setTitle(R.string.title_activity_interest_calc);

        Keyboard.setupUI(findViewById(R.id.parent), this);
        principleamount = (EditText)findViewById(R.id.interestprincipleamount);
        interestpercentage = (EditText)findViewById(R.id.interesetpercentage);
        interesttime = (EditText)findViewById(R.id.interesttime);
        taxpercent = (EditText)findViewById(R.id.taxpercentage);
        textView = (TextView)findViewById(R.id.textview);
        simple = (TextView)findViewById(R.id.simpleInterest);
        simple.setTextColor(getResources().getColor(R.color.orange));
        simple.setBackgroundResource(R.drawable.temp);

        compound = (TextView)findViewById(R.id.compundInterest);

        selector = (Spinner)findViewById(R.id.interestPrecentageCalculation);
        selector.setOnItemSelectedListener(this);

        String[] simplearray = getResources().getStringArray(R.array.spinnervaluesforsimple);
        String[] compoundarray = getResources().getStringArray(R.array.spinnervaluesforcompound);

        simpleInterestList = Arrays.asList(simplearray);
        compoundInterestList = Arrays.asList(compoundarray);

        simpleAdapter = new ArrayAdapter<String>(this , R.layout.layout_of_spinner , simpleInterestList);
        customAdapter = new ArrayAdapter<String>(this , R.layout.layout_of_spinner , compoundInterestList);
        selector.setAdapter(simpleAdapter);
        calctype = 0;
        calculate = (Button)findViewById(R.id.submit);
        calculate.setOnClickListener(this);

        simple.setOnClickListener(this);
        compound.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position == 0){
            textView.setText(R.string.text);
            interestpercentage.setText("");
            interesttime.setText("");
            taxpercent.setText("");
        }

        else if(position ==1 || position ==2 || position == 3){
            textView.setText(R.string.text2);
            interestpercentage.setText("");
            interesttime.setText("");
            taxpercent.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.simpleInterest:
                simple.setTextColor(getResources().getColor(R.color.orange));
                simple.setBackgroundResource(R.drawable.temp);
                compound.setTextColor(getResources().getColor(R.color.black));
                compound.setBackgroundResource(R.drawable.interest_calc_textview_rectangle);
                selector.setAdapter(simpleAdapter);
                calctype = 0;
                break;

            case R.id.compundInterest:
                compound.setTextColor(getResources().getColor(R.color.orange));
                compound.setBackgroundResource(R.drawable.temp);
                simple.setTextColor(getResources().getColor(R.color.black));
                simple.setBackgroundResource(R.drawable.interest_calc_textview_rectangle);
                selector.setAdapter(customAdapter);
                calctype =1;
                break;

            case R.id.submit:
                Double amount = 0.0, interestrate = 0.0, time =0.0, taxrate =0.0;

                if(!principleamount.getText().toString().equals(""))
                    amount = Double.valueOf(principleamount.getText().toString());

                if(!interestpercentage.getText().toString().equals(""))
                    interestrate = Double.valueOf(interestpercentage.getText().toString());

                if(!interesttime.getText().toString().equals(""))
                    time = Double.valueOf(interesttime.getText().toString());

                if(!taxpercent.getText().toString().equals(""))
                    taxrate = Double.valueOf(taxpercent.getText().toString());

                amount = InterestCalculation.round(amount);
                Integer type = selector.getPositionForView(selector.getSelectedView());

                InterestCalculation interestCalculation = new InterestCalculation(amount , interestrate , taxrate , time , type , calctype);

                Double[] answer = interestCalculation.calculate();

                //Toast.makeText(this, String.valueOf(answer) , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this , InterestCalCOutputActivity.class);
                intent.putExtra("amount",amount);
                intent.putExtra("interestrate",interestrate);
                intent.putExtra("time",time);
                intent.putExtra("taxra",taxrate);
                intent.putExtra("finalresult" , answer[0]);
                intent.putExtra("interestamount",answer[1]);
                intent.putExtra("taxamount", answer[2]);
                startActivityForResult(intent, 0);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        principleamount.setText("");
        interestpercentage.setText("");
        interesttime.setText("");
        taxpercent.setText("");
    }


    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.title_activity_interest_calc);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }

}