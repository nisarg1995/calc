package in.hiddenbrains.calc.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import in.hiddenbrains.calc.Calculations.Keyboard;
import in.hiddenbrains.calc.Calculations.TimeCalculation;
import in.hiddenbrains.calc.R;

public class TimeCalCActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText day1 , hour1 , minute1 , second1;
    private EditText day2 , hour2 , minute2 , second2;
    private EditText day3 , hour3 , minute3 , second3;
    private Spinner spinner;
    private Button submit;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;
    private int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_cal_c);
        Keyboard.setupUI(findViewById(R.id.parent), this);

        day1 = (EditText)findViewById(R.id.days1);
        hour1 = (EditText)findViewById(R.id.hours1);
        minute1 = (EditText)findViewById(R.id.minutes1);
        second1 = (EditText)findViewById(R.id.seconds1);

        day2 = (EditText)findViewById(R.id.days2);
        hour2 = (EditText)findViewById(R.id.hours2);
        minute2 = (EditText)findViewById(R.id.minutes2);
        second2 = (EditText)findViewById(R.id.seconds2);

        day3 = (EditText)findViewById(R.id.days3);
        hour3 = (EditText)findViewById(R.id.hours3);
        minute3 = (EditText)findViewById(R.id.minutes3);
        second3 = (EditText)findViewById(R.id.seconds3);

        spinner = (Spinner)findViewById(R.id.spinner);
        arrayList = new ArrayList<String>();
        arrayList.add("   + (addition) ");
        arrayList.add("   - (substraction) ");

        arrayAdapter = new ArrayAdapter<String>(this , R.layout.layout_of_spinner , arrayList);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
        flag = 1;

        submit = (Button)findViewById(R.id.calculate);
        submit.setOnClickListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0){
                flag = 1;
        }
        else if(position == 1){
                flag = 0;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        flag = 1;
    }

    @Override
    public void onClick(View v) {
        if(day1.getText().toString() .equals("") || hour1.getText().toString() .equals("") || minute1.getText().toString().equals("") || second1.getText().toString() .equals("") || day2.getText().toString() .equals("") || hour2.getText().toString() .equals("") || minute2.getText().toString().equals("") || second2.getText().toString() .equals("") ){
            Toast.makeText(this , "Please enter the values " , Toast.LENGTH_LONG).show();
        }

        else {
            Integer intday1 = Integer.valueOf(day1.getText().toString());
            Integer inthour1 = Integer.valueOf(hour1.getText().toString());
            Integer intminute1 = Integer.valueOf(minute1.getText().toString());
            Integer intsecond1 = Integer.valueOf(second1.getText().toString());

            Integer intday2 = Integer.valueOf(day2.getText().toString());
            Integer inthour2 = Integer.valueOf(hour2.getText().toString());
            Integer intminute2 = Integer.valueOf(minute2.getText().toString());
            Integer intsecond2 = Integer.valueOf(second2.getText().toString());

            TimeCalculation timeCalculation = new TimeCalculation(intday1, inthour1, intminute1, intsecond1, intday2, inthour2, intminute2, intsecond2,flag);
            Integer[] answer = timeCalculation.calculate();
            day3.setText(answer[0].toString());
            hour3.setText(answer[1].toString());
            minute3.setText(answer[2].toString());
            second3.setText(answer[3].toString());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.title_activity_time_cal_c);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }
}
