package in.hiddenbrains.calc.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.hiddenbrains.calc.R;
import in.hiddenbrains.calc.Calculations.SimpleCalcCalculation;


public class SimpleCalCActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private Button one ,two, three, four, five, six, seven, eight, nine, zero;
    private Button addition , substraction , multiplication , division;
    private Button dot , clearall , clearoneplace , equal;
    private TextView CalculatoString , upresult;
    private String buffer;
    private String result;
    private SimpleCalcCalculation simpleCalcCalculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_calc);

        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);

        addition = (Button)findViewById(R.id.addition);
        substraction = (Button)findViewById(R.id.substraction);
        multiplication = (Button)findViewById(R.id.multiplication);
        division = (Button)findViewById(R.id.division);

        dot = (Button)findViewById(R.id.dot);
        clearall = (Button)findViewById(R.id.Clear);
        clearoneplace = (Button)findViewById(R.id.ClearOnePlace);
        equal = (Button)findViewById(R.id.equal);

        CalculatoString = (TextView)findViewById(R.id.CalculatorString);
        upresult = (TextView)findViewById(R.id.upresult);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);

        addition.setOnClickListener(this);
        substraction.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        division.setOnClickListener(this);

        dot.setOnClickListener(this);
        clearall.setOnClickListener(this);
        clearoneplace.setOnClickListener(this);
        equal.setOnClickListener(this);

        one.setOnTouchListener(this);
        two.setOnTouchListener(this);
        three.setOnTouchListener(this);
        four.setOnTouchListener(this);
        five.setOnTouchListener(this);
        six.setOnTouchListener(this);
        seven.setOnTouchListener(this);
        eight.setOnTouchListener(this);
        nine.setOnTouchListener(this);
        zero.setOnTouchListener(this);

        addition.setOnTouchListener(this);
        substraction.setOnTouchListener(this);
        multiplication.setOnTouchListener(this);
        division.setOnTouchListener(this);

        dot.setOnTouchListener(this);
        clearall.setOnTouchListener(this);
        clearoneplace.setOnTouchListener(this);

        CalculatoString.setText("0");
    }


    @Override
    public void onClick(View v) {

        if(CalculatoString.getText().toString().equals("0"))
            buffer = "";
        else
            buffer = CalculatoString.getText().toString();
        switch (v.getId()){

            case R.id.one:
                buffer = buffer+"1";
                CalculatoString.setText(buffer);
                break;

            case R.id.two:
                buffer = buffer+"2";
                CalculatoString.setText(buffer);
                break;

            case R.id.three:
                buffer = buffer+"3";
                CalculatoString.setText(buffer);
                break;

            case R.id.four:
                buffer = buffer+"4";
                CalculatoString.setText(buffer);
                break;

            case R.id.five:
                buffer = buffer+"5";
                CalculatoString.setText(buffer);
                break;

            case R.id.six:
                buffer = buffer+"6";
                CalculatoString.setText(buffer);
                break;

            case R.id.seven:
                buffer = buffer+"7";
                CalculatoString.setText(buffer);
                break;

            case R.id.eight:
                buffer = buffer+"8";
                CalculatoString.setText(buffer);
                break;

            case R.id.nine:
                buffer = buffer+"9";
                CalculatoString.setText(buffer);
                break;

            case R.id.zero:
                buffer = buffer+"0";
                CalculatoString.setText(buffer);
                break;

            case R.id.dot:
                buffer = buffer+".";
                CalculatoString.setText(buffer);
                break;

            case R.id.ClearOnePlace:
                if(buffer.equals("0") || buffer.equals("")){

                }
                else {
                    buffer = buffer.substring(0, buffer.length() - 1);
                    if(buffer.equals("")){
                        CalculatoString.setText("0");
                    }
                    else{
                        if(buffer.charAt(buffer.length()-1) == '.'){
                            buffer = buffer.substring(0, buffer.length() - 1);
                        }
                        else{}
                        CalculatoString.setText(buffer);
                    }

                }
                break;

            case R.id.Clear:
                buffer = "0";
                upresult.setText("");
                CalculatoString.setText(buffer);
                break;

            case R.id.addition:
                buffer = buffer+"+";
                CalculatoString.setText(buffer);
                break;

            case R.id.substraction:
                buffer = buffer +"-";
                CalculatoString.setText(buffer);
                break;

            case R.id.multiplication:
                buffer = buffer +"*";
                CalculatoString.setText(buffer);
                break;

            case R.id.division:
                buffer = buffer +"/";
                CalculatoString.setText(buffer);
                break;

            case R.id.equal:
                simpleCalcCalculation = new SimpleCalcCalculation();
                result = simpleCalcCalculation.Solution(CalculatoString.getText().toString());
                upresult.setText(CalculatoString.getText().toString() + "=");
                CalculatoString.setText(result);
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Button button = (Button)findViewById(v.getId());
            button.setBackgroundResource(R.color.verylightgrey);
        }
        else if(event.getAction() == MotionEvent.ACTION_UP){
            Button button = (Button)findViewById(v.getId());
            button.setBackgroundResource(R.drawable.simple_calc_rectangle_button);
        }
        return false;
    }
}
