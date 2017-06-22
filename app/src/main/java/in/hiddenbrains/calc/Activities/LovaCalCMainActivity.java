package in.hiddenbrains.calc.Activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import in.hiddenbrains.calc.Calculations.Keyboard;
import in.hiddenbrains.calc.Calculations.LoveCalculation;
import in.hiddenbrains.calc.R;

public class LovaCalCMainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText himname , hername;
    private Button himbirthday , herbirthday , calculate;
    private Spinner himspinner , herspinner;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;
    private int himyear = 0, heryear = 0;

    public int getHimyear() {
        return himyear;
    }

    public void setHimyear(int himyear) {
        this.himyear = himyear;
    }

    public int getHeryear() {
        return heryear;
    }

    public void setHeryear(int heryear) {
        this.heryear = heryear;
    }

    public int getHimdate() {
        return himdate;
    }

    public void setHimdate(int himdate) {
        this.himdate = himdate;
    }

    public int getHerdate() {
        return herdate;
    }

    public void setHerdate(int herdate) {
        this.herdate = herdate;
    }

    public int getHimmonth() {
        return himmonth;
    }

    public void setHimmonth(int himmonth) {
        this.himmonth = himmonth;
    }

    public int getHermonth() {
        return hermonth;
    }

    public void setHermonth(int hermonth) {
        this.hermonth = hermonth;
    }

    private int himdate = 0, herdate = 0;
    private int himmonth = 0, hermonth = 0;
    private int himflag = 0, herflag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lova_cal_cmain);
        Keyboard.setupUI(findViewById(R.id.parent), this);
        himname = (EditText) findViewById(R.id.himname);
        himspinner = (Spinner)findViewById(R.id.himspinner);
        himbirthday = (Button)findViewById(R.id.himbirthday);

        hername = (EditText) findViewById(R.id.hername);
        herspinner = (Spinner)findViewById(R.id.herspinner);
        herbirthday = (Button)findViewById(R.id.herbirthday);

        calculate = (Button)findViewById(R.id.calculate);

        String[] array = getResources().getStringArray(R.array.zodiac);
        arrayList = new ArrayList<String>(Arrays.asList(array));
        arrayAdapter = new ArrayAdapter<String>(this , R.layout.layout_of_spinner , arrayList);
        himspinner.setAdapter(arrayAdapter);
        herspinner.setAdapter(arrayAdapter);

        himspinner.setOnItemSelectedListener(this);
        herspinner.setOnItemSelectedListener(this);
        himflag = 0;
        herflag = 0;
        himbirthday.setOnClickListener(this);
        herbirthday.setOnClickListener(this);
        calculate.setOnClickListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(view.getId() == R.id.himspinner){
            himflag = position;
        }
        else if(view.getId() == R.id.herspinner){
            herflag = position;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showDatePickerDialog1(View v) {
        DialogFragment newFragment = new DatePickerFragment1();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }



    @SuppressLint("ValidFragment")
    class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            himbirthday.setTextSize(20);
            setHimyear(year);
            setHimmonth(month);
            setHimdate(day);
            himbirthday.setText((day + "/" + (month+1) + "/" + year).toString());
        }
    }


    @SuppressLint("ValidFragment")
    class DatePickerFragment1 extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            herbirthday.setTextSize(20);
            setHeryear(year);
            setHermonth(month);
            setHerdate(day);
            herbirthday.setText((day+ "/" + (month +1) + "/" + year).toString());
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.himbirthday:
                showDatePickerDialog(v);
                break;

            case R.id.herbirthday:
                showDatePickerDialog1(v);
                break;

            case R.id.calculate:

                String himname1 = himname.getText().toString();
                String hername1 = hername.getText().toString();
                LoveCalculation loveCalculation = new LoveCalculation(himname1 , hername1 , getHimyear() , getHimmonth() , getHimdate() , getHeryear() , getHermonth() , getHerdate() , himflag ,herflag);
                int answer = loveCalculation.calculate();

                Intent intent = new Intent(this , LovaCalCOutputActivity.class);
                intent.putExtra("answer",answer);
                startActivityForResult(intent, 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        himname.setText("");
        hername.setText("");
    }


    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.title_activity_lova_cal_cmain);
    }


}