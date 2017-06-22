package in.hiddenbrains.calc.Activities;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import in.hiddenbrains.calc.R;

public class HealthActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener{

    TextView a1,a2,a3,a4,a5;
    EditText age,feet,inch,weight;
    Spinner spinner;
    ArrayAdapter<String> simpleadapter;
    RadioGroup radiogroup;
    RadioButton genderbutton;
    Button submit;
    List<String> list;
    Integer spinnerpostion=0;
    Integer temp,tempa1,tempa2,tempa4,tempa5;
    Double bmr=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        a1=(TextView)findViewById(R.id.twolblose);
        a2=(TextView)findViewById(R.id.onelblose);
        a3=(TextView)findViewById(R.id.maintain);
        a4=(TextView)findViewById(R.id.onelbgain);
        a5=(TextView)findViewById(R.id.twolbgain);
        submit = (Button)findViewById(R.id.calculate);
        submit.setOnClickListener(this);

        radiogroup=(RadioGroup)findViewById(R.id.radiogroup1);
        age=(EditText)findViewById(R.id.age);
        feet=(EditText)findViewById(R.id.feet);
        inch=(EditText)findViewById(R.id.inch);
        weight=(EditText)findViewById(R.id.weight);
        String[] simplearray=getResources().getStringArray(R.array.activitylevels);

        list= Arrays.asList(simplearray);
        spinner=(Spinner)findViewById(R.id.activityselector);
        simpleadapter=new ArrayAdapter<String>(this,R.layout.layout_of_spinner_health,list);
        spinner.setAdapter(simpleadapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position == 0){
            spinnerpostion=0;
        }

        else if(position ==1){
            spinnerpostion=1;
        }
        else if(position ==2){
            spinnerpostion=2;
        }
        else if(position ==3){
            spinnerpostion=3;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

        int eqaution=0;
        int selectedId=radiogroup.getCheckedRadioButtonId();
        genderbutton=(RadioButton)findViewById(selectedId);

        if(v.getId()==R.id.calculate){

            if(genderbutton.getText().toString().equals("Male")){
                eqaution=1;
            }

            if(age.getText().toString().equals("")) {
                Toast.makeText(this, "Please specify your age", Toast.LENGTH_LONG).show();
            }
            else if (feet.getText().toString().equals("")){
                Toast.makeText(this,"Please Enter Height",Toast.LENGTH_LONG).show();
            }
            else if(inch.getText().toString().equals("")){
                Toast.makeText(this,"Please Enter Height accurately",Toast.LENGTH_LONG).show();
            }
            else if(weight.getText().toString().equals("")){
                Toast.makeText(this,"Please Enter Weight",Toast.LENGTH_LONG).show();
            }

            else{

                Integer in,ft,ag;
                Double wght,hight;
                wght=Double.valueOf(weight.getText().toString());
                in=Integer.valueOf(inch.getText().toString());
                ft=Integer.valueOf(feet.getText().toString());
                ag= Integer.valueOf(age.getText().toString());

                Double f1=ft*30.48;
                Double f2=in*2.54;
                hight=f1+f2;

                if(eqaution==1){

                    bmr=(10*wght)+(6.25*hight)-(5*ag)+5;
                }
                else{
                    bmr=(10*wght)+(6.25*hight)-(5*ag)-161;


                }

                switch (spinnerpostion){

                    case 0:
                        bmr=bmr*1.2;
                        temp = bmr.intValue();
                        tempa1=temp-1000;
                        tempa2=temp-500;
                        tempa4=temp+500;
                        tempa5=temp+1000;
                        a1.setText((tempa1.toString()));
                        a2.setText((tempa2.toString()));
                        a3.setText((temp.toString()));
                        a4.setText(tempa4.toString());
                        a5.setText(tempa5.toString());
                        a1.setWidth(tempa1 / 12);
                        a2.setWidth(tempa2 / 12);
                        a3.setWidth(temp / 12);
                        a4.setWidth(tempa4 / 12);
                        a5.setWidth(tempa5 / 12);
                        break;

                    case 1:

                        bmr=bmr*1.4;
                        temp =bmr.intValue();
                        tempa1=temp-1000;
                        tempa2=temp-500;
                        tempa4=temp+500;
                        tempa5=temp+1000;
                        a1.setText((tempa1.toString()));
                        a2.setText((tempa2.toString()));
                        a3.setText((temp.toString()));
                        a4.setText(tempa4.toString());
                        a5.setText(tempa5.toString());
                        a1.setWidth(tempa1 / 12);
                        a2.setWidth(tempa2 / 12);
                        a3.setWidth(temp / 12);
                        a4.setWidth(tempa4/12);
                        a5.setWidth(tempa5 / 12);
                        break;

                    case 2:

                        bmr=bmr*1.6;
                        temp =bmr.intValue();
                        tempa1=temp-1000;
                        tempa2=temp-500;
                        tempa4=temp+500;
                        tempa5=temp+1000;
                        a1.setText((tempa1.toString()));
                        a2.setText((tempa2.toString()));
                        a3.setText((temp.toString()));
                        a4.setText(tempa4.toString());
                        a5.setText(tempa5.toString());
                        a1.setWidth(tempa1/12);
                        a2.setWidth(tempa2/12);
                        a3.setWidth(temp / 12);
                        a4.setWidth(tempa4/12);
                        a5.setWidth(tempa5/12);
                        break;

                    case 3:
                        bmr=bmr*1.9;
                        temp =bmr.intValue();
                        tempa1=temp-1000;
                        tempa2=temp-500;
                        tempa4=temp+500;
                        tempa5=temp+1000;
                        a1.setText((tempa1.toString()));
                        a2.setText((tempa2.toString()));
                        a3.setText((temp.toString()));
                        a4.setText(tempa4.toString());
                        a5.setText(tempa5.toString());
                            a1.setWidth(tempa1/12);
                            a2.setWidth(tempa2/12);
                            a3.setWidth(temp / 12);
                            a4.setWidth(tempa4/12);
                            a5.setWidth(tempa5/12);
                        break;
                }
            }
        }
    }
}