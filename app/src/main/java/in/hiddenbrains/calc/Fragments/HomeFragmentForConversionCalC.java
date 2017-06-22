package in.hiddenbrains.calc.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import in.hiddenbrains.calc.Calculations.Keyboard;
import in.hiddenbrains.calc.ConvertCalculationClasses.Angle;
import in.hiddenbrains.calc.ConvertCalculationClasses.Area;
import in.hiddenbrains.calc.ConvertCalculationClasses.BitsBytes;
import in.hiddenbrains.calc.ConvertCalculationClasses.Density;
import in.hiddenbrains.calc.ConvertCalculationClasses.Electric_current;
import in.hiddenbrains.calc.ConvertCalculationClasses.Energy;
import in.hiddenbrains.calc.ConvertCalculationClasses.Force;
import in.hiddenbrains.calc.ConvertCalculationClasses.Fuel_consumption;
import in.hiddenbrains.calc.ConvertCalculationClasses.Length;
import in.hiddenbrains.calc.ConvertCalculationClasses.Mass;
import in.hiddenbrains.calc.ConvertCalculationClasses.Power;
import in.hiddenbrains.calc.ConvertCalculationClasses.Pressure;
import in.hiddenbrains.calc.ConvertCalculationClasses.Speed;
import in.hiddenbrains.calc.ConvertCalculationClasses.Temperature;
import in.hiddenbrains.calc.ConvertCalculationClasses.Time;
import in.hiddenbrains.calc.ConvertCalculationClasses.Volume;
import in.hiddenbrains.calc.R;
public class HomeFragmentForConversionCalC extends Fragment implements View.OnClickListener{

    private TextView conversiontype  , finalanswer;
    private EditText valuetoconvert;
    private Spinner fromspinner , tospinner;
    private int id;
    private String[] temp;
    private ArrayAdapter<String> spinnerarray;
    private List<String> spinnerarraylist;
    private Button submit;
    private int from , to;

    public HomeFragmentForConversionCalC() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home_fragment_for_conversion_cal_c, container, false);
        Keyboard.setupUI(view.findViewById(R.id.parent), getActivity());
        conversiontype = (TextView)view.findViewById(R.id.convertortype);
        finalanswer = (TextView)view.findViewById(R.id.answer);

        valuetoconvert = (EditText)view.findViewById(R.id.valuetoconvert);
        fromspinner = (Spinner)view.findViewById(R.id.fromspinner);
        tospinner = (Spinner)view.findViewById(R.id.tospinner);
        submit = (Button)view.findViewById(R.id.submit);

        submit.setOnClickListener(this);
        Bundle bundle = getArguments();
        int id = bundle.getInt("id");


        switch(id){

            case 0:
                temp = getResources().getStringArray(R.array.angle);
                conversiontype.setText(getString(R.string.angle));
                break;

            case 1:
                temp = getResources().getStringArray(R.array.area);
                conversiontype.setText(getString(R.string.area));
                break;

            case 2:
                temp = getResources().getStringArray(R.array.bits_and_bytes);
                conversiontype.setText(getString(R.string.bitsandbytes));
                break;

            case 3:
                temp = getResources().getStringArray(R.array.density);
                conversiontype.setText(getString(R.string.density));
                break;

            case 4:
                temp = getResources().getStringArray(R.array.electrical_current);
                conversiontype.setText(getString(R.string.electricalcurrent));
                break;

            case 5:
                temp = getResources().getStringArray(R.array.energy);
                conversiontype.setText(getString(R.string.energy));
                break;

            case 6:
                temp = getResources().getStringArray(R.array.force);
                conversiontype.setText(getString(R.string.force));
                break;

            case 7:
                temp = getResources().getStringArray(R.array.fuel_consumption);
                conversiontype.setText(getString(R.string.fuelconsuption));
                break;

            case 8:
                temp = getResources().getStringArray(R.array.length);
                conversiontype.setText(getString(R.string.length));
                break;

            case 9:
                temp = getResources().getStringArray(R.array.mass);
                conversiontype.setText(getString(R.string.mass));
                break;

            case 10:
                temp = getResources().getStringArray(R.array.power);
                conversiontype.setText(getString(R.string.power));
                break;

            case 11:
                temp = getResources().getStringArray(R.array.pressure);
                conversiontype.setText(getString(R.string.pressure));
                break;

            case 12:
                temp = getResources().getStringArray(R.array.speed);
                conversiontype.setText(getString(R.string.spped));
                break;

            case 13:
                temp = getResources().getStringArray(R.array.temperature);
                conversiontype.setText(getString(R.string.temperature));
                break;

            case 14:
                temp = getResources().getStringArray(R.array.time);
                conversiontype.setText(getString(R.string.time123));
                break;

            case 15:
                temp = getResources().getStringArray(R.array.volume);
                conversiontype.setText(getString(R.string.volume));
                break;

        }

        spinnerarraylist =  Arrays.asList(temp);
        spinnerarray = new ArrayAdapter<String>(getActivity() , R.layout.layout_of_spinner , spinnerarraylist);
        fromspinner.setAdapter(spinnerarray);
        tospinner.setAdapter(spinnerarray);

        fromspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tospinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public void onClick(View v) {

        Double value = Double.valueOf(valuetoconvert.getText().toString());

        if( from == to){
            finalanswer.setText(value.toString());
        }
        else {
            Double temp , answer;
            Bundle bundle = getArguments();
            switch (bundle.getInt("id")) {

                case 0:
                    Angle obj = new Angle();
                    temp = obj.converttoindex(value, from);
                    answer = obj.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 1:
                    Area obj1 = new Area();
                    temp = obj1.converttoindex(value, from);
                    answer = obj1.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 2:
                    BitsBytes obj2 = new BitsBytes();
                    temp = obj2.converttoindex(value, from);
                    answer = obj2.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 3:
                    Density obj3  = new Density();
                    temp = obj3.converttoindex(value, from);
                    answer = obj3.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 4:
                    Electric_current obj4  = new Electric_current();
                    temp = obj4.converttoindex(value, from);
                    answer = obj4.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 5:
                    Energy obj5 = new Energy();
                    temp = obj5.converttoindex(value, from);
                    answer = obj5.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 6:
                    Force obj6 = new Force();
                    temp = obj6.converttoindex(value, from);
                    answer = obj6.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 7:
                    Fuel_consumption obj7 = new Fuel_consumption();
                    temp = obj7.converttoindex(value, from);
                    answer = obj7.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 8:
                    Length obj8 = new Length();
                    temp = obj8.converttoindex(value, from);
                    answer = obj8.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 9:
                    Mass obj9 = new Mass();
                    temp = obj9.converttoindex(value, from);
                    answer = obj9.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 10:
                    Power obj10 = new Power();
                    temp = obj10.converttoindex(value, from);
                    answer = obj10.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 11:
                    Pressure obj11 = new Pressure();
                    temp = obj11.converttoindex(value, from);
                    answer = obj11.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 12:
                    Speed obj12 = new Speed();
                    temp = obj12.converttoindex(value, from);
                    answer = obj12.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());

                    break;

                case 13:
                    Temperature obj13 = new Temperature();
                    temp = obj13.converttoindex(value, from);
                    answer = obj13.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 14:
                    Time obj14 = new Time();
                    temp = obj14.converttoindex(value, from);
                    answer = obj14.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());
                    break;

                case 15:
                    Volume obj15 = new Volume();
                    temp = obj15.converttoindex(value, from);
                    answer = obj15.converttoanswer(temp, to);
                    finalanswer.setText(answer.toString());

                    break;

            }
        }
    }

}
