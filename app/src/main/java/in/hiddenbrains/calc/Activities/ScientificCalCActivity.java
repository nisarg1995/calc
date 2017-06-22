package in.hiddenbrains.calc.Activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.DuplicateFormatFlagsException;

import in.hiddenbrains.calc.Calculations.AdvanceOperations;
import in.hiddenbrains.calc.Calculations.Keyboard;
import in.hiddenbrains.calc.R;

public class ScientificCalCActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private Button sinin,cosin,tanin,sin,cos,tan,sinh,cosh,tanh,sinhin,coshin,tanhin,one1,two,three,four,five,six,seven,eight,nine,zero;
    public Button plus,multi,divi ,plusminus, minus,dot,equal,percent,allclear,random,radtodeg,clearone;
    private Button square,cube,xypower,sqrt,cuberoot,xyroot,ln,log,logy,log2,inverse,power2,e,pi,factorial;
    private TextView reddeg,result;
    public AdvanceOperations function;
    private String calculation="null",buffer="",operation="null";
    Double temp[]=new Double[1];
    int status=0;
    int mode=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitity_scientific_cal_c);
        Keyboard.setupUI(findViewById(R.id.parent), this);

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){

            mode=0;
            result = (TextView) findViewById(R.id.result);
            sin = (Button) findViewById(R.id.sin);
            cos = (Button) findViewById(R.id.cos);
            tan = (Button) findViewById(R.id.tan);
            ln = (Button) findViewById(R.id.ln);
            log = (Button) findViewById(R.id.log);
            factorial=(Button)findViewById(R.id.factorial);
            one1 = (Button) findViewById(R.id.one1);
            two = (Button) findViewById(R.id.two);
            three = (Button) findViewById(R.id.three);
            four = (Button) findViewById(R.id.four);
            five = (Button) findViewById(R.id.five);
            six = (Button) findViewById(R.id.six);
            seven = (Button) findViewById(R.id.seven);
            eight = (Button) findViewById(R.id.eight);
            nine = (Button) findViewById(R.id.nine);
            zero = (Button) findViewById(R.id.zero);
            e = (Button) findViewById(R.id.e);
            pi = (Button) findViewById(R.id.pi);
            square = (Button) findViewById(R.id.square);
            cube = (Button) findViewById(R.id.cube);
            sqrt = (Button) findViewById(R.id.root);
            cuberoot = (Button) findViewById(R.id.cuberoot);
            allclear=(Button)findViewById(R.id.clearall);
            clearone=(Button)findViewById(R.id.ClearOnePlace);
            divi = (Button) findViewById(R.id.division);
            multi = (Button) findViewById(R.id.multiplication);
            plus = (Button) findViewById(R.id.addition);
            minus = (Button) findViewById(R.id.substraction);
            dot = (Button) findViewById(R.id.dot);
            equal = (Button) findViewById(R.id.equal);
            one1.setOnClickListener(this);
            two.setOnClickListener(this);
            three.setOnClickListener(this);
            four.setOnClickListener(this);
            five.setOnClickListener(this);
            six.setOnClickListener(this);
            seven.setOnClickListener(this);
            eight.setOnClickListener(this);
            nine.setOnClickListener(this);
            zero.setOnClickListener(this);
            allclear.setOnClickListener(this);
            sqrt.setOnClickListener(this);
            cuberoot.setOnClickListener(this);
            ln.setOnClickListener(this);
            log.setOnClickListener(this);
            divi.setOnClickListener(this);
            multi.setOnClickListener(this);
            plus.setOnClickListener(this);
            minus.setOnClickListener(this);
            equal.setOnClickListener(this);
            dot.setOnClickListener(this);
            sin.setOnClickListener(this);
            cos.setOnClickListener(this);
            tan.setOnClickListener(this);
            e.setOnClickListener(this);
            pi.setOnClickListener(this);
            factorial.setOnClickListener(this);
            square.setOnClickListener(this);
            cube.setOnClickListener(this);
            clearone.setOnClickListener(this);

            one1.setOnTouchListener(this);
            two.setOnTouchListener(this);
            three.setOnTouchListener(this);
            four.setOnTouchListener(this);
            five.setOnTouchListener(this);
            six.setOnTouchListener(this);
            seven.setOnTouchListener(this);
            eight.setOnTouchListener(this);
            nine.setOnTouchListener(this);
            zero.setOnTouchListener(this);
            allclear.setOnTouchListener(this);
            sqrt.setOnTouchListener(this);
            cuberoot.setOnTouchListener(this);
            ln.setOnTouchListener(this);
            log.setOnTouchListener(this);
            divi.setOnTouchListener(this);
            multi.setOnTouchListener(this);
            plus.setOnTouchListener(this);
            minus.setOnTouchListener(this);
            equal.setOnTouchListener(this);
            dot.setOnTouchListener(this);
            sin.setOnTouchListener(this);
            cos.setOnTouchListener(this);
            tan.setOnTouchListener(this);
            e.setOnTouchListener(this);
            pi.setOnTouchListener(this);
            factorial.setOnTouchListener(this);
            square.setOnTouchListener(this);
            cube.setOnTouchListener(this);
            clearone.setOnTouchListener(this);
        }

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {

            mode=1;
            reddeg = (TextView) findViewById(R.id.radiandegree);
            result = (TextView) findViewById(R.id.result);
            sin = (Button) findViewById(R.id.sin);
            cos = (Button) findViewById(R.id.cos);
            tan = (Button) findViewById(R.id.tan);
            sinh = (Button) findViewById(R.id.sinh);
            cosh = (Button) findViewById(R.id.cosh);
            tanh = (Button) findViewById(R.id.tanh);
            sinin = (Button) findViewById(R.id.sininverse);
            cosin = (Button) findViewById(R.id.cosinverse);
            tanin = (Button) findViewById(R.id.taninverse);
            sinhin = (Button) findViewById(R.id.sinhinverse);
            coshin = (Button) findViewById(R.id.coshinverse);
            tanhin = (Button) findViewById(R.id.tanhinverse);
            one1 = (Button) findViewById(R.id.one1);
            two = (Button) findViewById(R.id.two);
            three = (Button) findViewById(R.id.three);
            four = (Button) findViewById(R.id.four);
            five = (Button) findViewById(R.id.five);
            six = (Button) findViewById(R.id.six);
            seven = (Button) findViewById(R.id.seven);
            eight = (Button) findViewById(R.id.eight);
            nine = (Button) findViewById(R.id.nine);
            zero = (Button) findViewById(R.id.zero);
            plus = (Button) findViewById(R.id.addition);
            plusminus = (Button) findViewById(R.id.sign);
            minus = (Button) findViewById(R.id.substraction);
            dot = (Button) findViewById(R.id.dot);
            divi = (Button) findViewById(R.id.division);
            multi = (Button) findViewById(R.id.multiplication);
            percent = (Button) findViewById(R.id.percentage);
            allclear = (Button) findViewById(R.id.clearall);
            radtodeg = (Button) findViewById(R.id.radian);
            e = (Button) findViewById(R.id.e);
            pi = (Button) findViewById(R.id.pi);
            factorial = (Button) findViewById(R.id.factorial);
            random = (Button) findViewById(R.id.random);
            square = (Button) findViewById(R.id.square);
            cube = (Button) findViewById(R.id.cube);
            xypower = (Button) findViewById(R.id.xpowy);
            xyroot = (Button) findViewById(R.id.xyroot);
            sqrt = (Button) findViewById(R.id.root);
            cuberoot = (Button) findViewById(R.id.cuberoot);
            xyroot = (Button) findViewById(R.id.xyroot);
            ln = (Button) findViewById(R.id.ln);
            log = (Button) findViewById(R.id.log10);
            log2 = (Button) findViewById(R.id.log2);
            logy = (Button) findViewById(R.id.logy);
            inverse = (Button) findViewById(R.id.inverse);
            power2 = (Button) findViewById(R.id.pow2);
            equal = (Button) findViewById(R.id.equal);

            one1.setOnClickListener(this);
            two.setOnClickListener(this);
            three.setOnClickListener(this);
            four.setOnClickListener(this);
            five.setOnClickListener(this);
            six.setOnClickListener(this);
            seven.setOnClickListener(this);
            eight.setOnClickListener(this);
            nine.setOnClickListener(this);
            zero.setOnClickListener(this);
            allclear.setOnClickListener(this);
            plusminus.setOnClickListener(this);
            percent.setOnClickListener(this);
            divi.setOnClickListener(this);
            multi.setOnClickListener(this);
            plus.setOnClickListener(this);
            minus.setOnClickListener(this);
            equal.setOnClickListener(this);
            dot.setOnClickListener(this);
            sin.setOnClickListener(this);
            cos.setOnClickListener(this);
            tan.setOnClickListener(this);
            sinin.setOnClickListener(this);
            cosin.setOnClickListener(this);
            tanin.setOnClickListener(this);
            sinh.setOnClickListener(this);
            cosh.setOnClickListener(this);
            tanh.setOnClickListener(this);
            sinhin.setOnClickListener(this);
            coshin.setOnClickListener(this);
            tanhin.setOnClickListener(this);
            radtodeg.setOnClickListener(this);
            e.setOnClickListener(this);
            pi.setOnClickListener(this);
            factorial.setOnClickListener(this);
            random.setOnClickListener(this);
            square.setOnClickListener(this);
            cube.setOnClickListener(this);
            xypower.setOnClickListener(this);
            xyroot.setOnClickListener(this);
            sqrt.setOnClickListener(this);
            cuberoot.setOnClickListener(this);
            ln.setOnClickListener(this);
            log.setOnClickListener(this);
            logy.setOnClickListener(this);
            log2.setOnClickListener(this);
            inverse.setOnClickListener(this);
            power2.setOnClickListener(this);

            one1.setOnTouchListener(this);
            two.setOnTouchListener(this);
            three.setOnTouchListener(this);
            four.setOnTouchListener(this);
            five.setOnTouchListener(this);
            six.setOnTouchListener(this);
            seven.setOnTouchListener(this);
            eight.setOnTouchListener(this);
            nine.setOnTouchListener(this);
            zero.setOnTouchListener(this);
            allclear.setOnTouchListener(this);
            sqrt.setOnTouchListener(this);
            cuberoot.setOnTouchListener(this);
            ln.setOnTouchListener(this);
            log.setOnTouchListener(this);
            divi.setOnTouchListener(this);
            multi.setOnTouchListener(this);
            plus.setOnTouchListener(this);
            minus.setOnTouchListener(this);
            equal.setOnTouchListener(this);
            dot.setOnTouchListener(this);
            sin.setOnTouchListener(this);
            cos.setOnTouchListener(this);
            tan.setOnTouchListener(this);
            e.setOnTouchListener(this);
            pi.setOnTouchListener(this);
            factorial.setOnTouchListener(this);
            square.setOnTouchListener(this);
            cube.setOnTouchListener(this);

            sinin.setOnTouchListener(this);
            cosin.setOnTouchListener(this);
            tanin.setOnTouchListener(this);
            sinh.setOnTouchListener(this);
            cosh.setOnTouchListener(this);
            tanh.setOnTouchListener(this);
            sinhin.setOnTouchListener(this);
            coshin.setOnTouchListener(this);
            tanhin.setOnTouchListener(this);
            radtodeg.setOnTouchListener(this);
            e.setOnTouchListener(this);
            pi.setOnTouchListener(this);
            factorial.setOnTouchListener(this);
            random.setOnTouchListener(this);
            square.setOnTouchListener(this);
            cube.setOnTouchListener(this);
            xypower.setOnTouchListener(this);
            xyroot.setOnTouchListener(this);
            sqrt.setOnTouchListener(this);
            cuberoot.setOnTouchListener(this);
            ln.setOnTouchListener(this);
            log.setOnTouchListener(this);
            logy.setOnTouchListener(this);
            log2.setOnTouchListener(this);
            inverse.setOnTouchListener(this);
            power2.setOnTouchListener(this);
        }
    }

    @Override
    public void onClick(View v) {

        status=0;
        if(result.getText().toString().equals("0"))
            buffer = "";
        else if(buffer.equals("abc")){
            buffer="";
        }
        else
            buffer = result.getText().toString();

        switch (v.getId())
        {
            case R.id.one1:
                buffer = buffer+"1";
                result.setText(buffer);
                break;

            case R.id.zero:
                buffer = buffer+"0";
                result.setText(buffer);
                break;

            case R.id.two:
                buffer = buffer+"2";
                result.setText(buffer);
                break;

            case R.id.three:
                buffer = buffer+"3";
                result.setText(buffer);
                break;

            case R.id.four:
                buffer = buffer+"4";
                result.setText(buffer);
                break;

            case R.id.five:
                buffer = buffer+"5";
                result.setText(buffer);
                break;

            case R.id.six:
                buffer = buffer+"6";
                result.setText(buffer);
                break;
            case R.id.seven:
                buffer = buffer+"7";
                result.setText(buffer);
                break;
            case R.id.eight:
                buffer = buffer+"8";
                result.setText(buffer);
                break;
            case R.id.nine:
                buffer = buffer+"9";
                result.setText(buffer);
                break;

            case R.id.dot:
                buffer = buffer+".";
                result.setText(buffer);
                break;

            case R.id.clearall:
                result.setText("0");
                temp[0]=null;
                calculation="";
                operation="";
                break;

            case R.id.ClearOnePlace:
                String result1=result.getText().toString();
                if(result1.length()==1)
                {
                    result.setText("0");
                }
                else {
                    String abc = result1.substring(0, result1.length() - 1);
                    String abc2=abc.substring(abc.length() - 1, abc.length());

                    if(abc2.equals(".")){
                        String abc3=abc.substring(0,result1.length()-2);
                        result.setText(abc3);
                    }
                    else {
                        result.setText(abc);
                    }
                }
                break;

            case R.id.cosinverse:

                if (result.getText().toString().equals("")){
                    break;
                }
                else {

                    Double d1 = Double.valueOf(result.getText().toString());
                    if(reddeg.getText().toString().equals("Degree")){
                        status=1;
                    }
                    Double d2 = function.cosinverse(d1, status);
                    String s1 = d2.toString();
                    result.setText(s1);
                    break;
                }
            case R.id.sininverse:

                if (result.getText().toString().equals("")){
                    break;
                }
                else {

                    Double d1 = Double.valueOf(result.getText().toString());
                    if(reddeg.getText().toString().equals("Degree")){
                        status=1;
                    }
                    Double d2 = function.sininverse(d1, status);
                    String s1 = d2.toString();
                    result.setText(s1);
                    break;
                }

            case R.id.taninverse:

                if (result.getText().toString().equals("")){
                    break;
                }
                else {

                    Double d1 = Double.valueOf(result.getText().toString());
                    if(reddeg.getText().toString().equals("Degree")){
                        status=1;
                    }
                    Double d2 = function.taninverse(d1, status);
                    String s1 = d2.toString();
                    result.setText(s1);
                    break;
                }

            case R.id.sinhinverse:

                if (result.getText().toString().equals("")){
                    break;
                }
                else {

                    Double d1 = Double.valueOf(result.getText().toString());
                    if(reddeg.getText().toString().equals("Degree")){
                        status=1;
                    }
                    Double d2 = function.sinhinverse(d1, status);
                    String s1 = d2.toString();
                    result.setText(s1);
                    break;
                }
            case R.id.coshinverse:

                if (result.getText().toString().equals("")){
                    break;
                }
                else {

                    Double d1 = Double.valueOf(result.getText().toString());
                    if(reddeg.getText().toString().equals("Degree")){
                        status=1;
                    }
                    Double d2 = function.coshinverse(d1, status);
                    String s1 = d2.toString();
                    result.setText(s1);
                    break;
                }
            case R.id.tanhinverse:

                if (result.getText().toString().equals("")){
                    break;
                }
                else {

                    Double d1 = Double.valueOf(result.getText().toString());
                    if(reddeg.getText().toString().equals("Degree")){
                        status=1;
                    }
                    Double d2 = function.tanhinverse(d1, status);
                    String s1 = d2.toString();
                    result.setText(s1);
                    break;
                }

            case R.id.tan:

                if (result.getText().toString().equals("")){
                    break;
                }
                else {

                    Double d1 = Double.valueOf(result.getText().toString());
                    if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {

                        if (reddeg.getText().toString().equals("Degree")) {
                            status = 1;
                        }
                    }
                    Double d2 = function.tane(d1, status,mode);
                    String s1 = d2.toString();
                    result.setText(s1);
                    break;
                }
            case R.id.sin:

                if (result.getText().toString().equals("")){
                    break;
                }
                else {

                    Double d1 = Double.valueOf(result.getText().toString());
                    if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {
                        if (reddeg.getText().toString().equals("Degree")) {
                            status = 1;
                        }
                    }
                    Double d2 = function.sine(d1, status,mode);
                    String s1 = d2.toString();
                    result.setText(s1);
                    break;
                }
            case R.id.cos:

                if (result.getText().toString().equals("")){
                    break;
                }
                else {

                    Double d1 = Double.valueOf(result.getText().toString());
                    if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {

                        if (reddeg.getText().toString().equals("Degree")) {
                            status = 1;
                        }
                    }
                    Double d2 = function.cose(d1, status,mode);
                    String s1 = d2.toString();
                    result.setText(s1);
                    break;
                }
            case R.id.tanh:

                if (result.getText().toString().equals("")){
                    break;
                }
                else {

                    Double d1 = Double.valueOf(result.getText().toString());
                    if(reddeg.getText().toString().equals("Degree")){
                        status=1;
                    }
                    Double d2 = function.tanhe(d1, status);
                    String s1 = d2.toString();
                    result.setText(s1);
                    break;
                }
            case R.id.sinh:

                if (result.getText().toString().equals("")){
                    break;
                }
                else {

                    Double d1 = Double.valueOf(result.getText().toString());
                    if(reddeg.getText().toString().equals("Degree")){
                        status=1;
                    }
                    Double d2 = function.sinhe(d1, status);
                    String s1 = d2.toString();
                    result.setText(s1);
                    break;
                }

            case R.id.cosh:

                if (result.getText().toString().equals("")){
                    break;
                }
                else {
                    Double d1 = Double.valueOf(result.getText().toString());
                    if(reddeg.getText().toString().equals("Degree")){
                        status=1;
                    }
                    Double d2 = function.coshe(d1, status);
                    String s1 = d2.toString();
                    result.setText(s1);
                    break;
                }

            case R.id.pi:
                Double d1=function.pi();
                result.setText(d1.toString());
                break;

            case R.id.e:
                Double d2=function.e();
                result.setText(d2.toString());
                break;

            case R.id.square:
                Double d3 =function.square(Double.valueOf(result.getText().toString()));
                result.setText(d3.toString());
                break;

            case R.id.root:
                Double d4=function.root(Double.valueOf(result.getText().toString()),mode);
                result.setText(d4.toString());
                break;

            case R.id.cube:
                Double d5=function.cube(Double.valueOf(result.getText().toString()));
                result.setText(d5.toString());
                break;

            case R.id.cuberoot:
                Double d6=function.cuberoot(Double.valueOf(result.getText().toString()),mode);
                result.setText(d6.toString());
                break;

            case R.id.xpowy:
                calculation="xpowy";
                if (temp[0] == null) {
                    temp[0] = Double.valueOf(result.getText().toString());
                    result.setText("0");
                }
                else if (temp[0] != Double.valueOf(result.getText().toString())) {
                    operation="xpowy";
                    Double temp2 = temp[0];
                    Double value = Double.valueOf(result.getText().toString());
                    Double total = function.powerxy(temp2, value);
                    temp[0] = total;
                    result.setText(temp[0].toString());
                }
                break;

            case R.id.xyroot:
                calculation="xyroot";

                if (temp[0] == null) {
                    temp[0] = Double.valueOf(result.getText().toString());
                    result.setText("0");
                }
                else if (temp[0] != Double.valueOf(result.getText().toString())) {
                    operation="xyroot";
                    Double temp2 = temp[0];
                    Double value = Double.valueOf(result.getText().toString());
                    Double total = function.masterroot(temp2, value);
                    temp[0] = total;
                    result.setText(temp[0].toString());
                }

                break;

            case R.id.logy:
                calculation="logy";

                if (temp[0] == null) {
                    temp[0] = Double.valueOf(result.getText().toString());
                    result.setText("0");
                }
                else if (temp[0] != Double.valueOf(result.getText().toString())) {
                    operation="logy";
                    Double temp2 = temp[0];
                    Double value = Double.valueOf(result.getText().toString());
                    Double total = function.logy(temp2, value);
                    temp[0] = total;
                    result.setText(temp[0].toString());
                }
                break;

            case R.id.log10:
                Double d7=function.logee(Double.valueOf(result.getText().toString()), mode);
                result.setText(d7.toString());
                break;

            case R.id.ln:
                Double d8=function.ln(Double.valueOf(result.getText().toString()),mode);
                result.setText(d8.toString());
                break;

            case R.id.log2:
                Double d9=function.log2(Double.valueOf(result.getText().toString()));
                result.setText(d9.toString());
                break;

            case R.id.pow2:
                Double d10=function.powerof2(Double.valueOf(result.getText().toString()));
                result.setText(d10.toString());
                break;

            case R.id.random:

                calculation="random";
                if (temp[0] == null) {
                    temp[0] = Double.valueOf(result.getText().toString());
                    result.setText("0");
                }
                else if (temp[0] != Double.valueOf(result.getText().toString())) {
                    Double temp2 = temp[0];
                    Double value = Double.valueOf(result.getText().toString());
                    Integer total = function.randome(temp2, value);
                    temp[0] = Double.valueOf(total);
                    result.setText(temp[0].toString());
                }
                break;

            case R.id.percentage:
                Double d11=function.percentage(Double.valueOf(result.getText().toString()));
                result.setText(d11.toString());
                break;

            case R.id.sign:
                Double d12=function.sign(Double.valueOf(result.getText().toString()));
                result.setText(d12.toString());
                break;

            case R.id.inverse:
                Double d13=function.inverse(Double.valueOf(result.getText().toString()));
                result.setText(d13.toString());
                break;

            case R.id.addition:
                calculation ="+";

                if(operation.equals("-")){
                    Double d=function.substraction(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0]=d;
                    result.setText(temp[0].toString());
                    buffer="abc";
                    operation="+";
                }
                else if (operation.equals("logy")){
                    Double d=function.logy(temp[0],Double.valueOf(result.getText().toString()));
                    temp[0]=d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="+";
                }
                else if (operation.equals("xpowy")){
                    Double d=function.powerxy(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0]=d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="+";
                }
                else if (operation.equals("xyroot")){
                    Double d=function.masterroot(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0]=d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="+";
                }
                else if(operation.equals("*")){
                    Double d = function.multiplication(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0] = d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="+";
                }
                else if(operation.equals("/")){
                    Double d = function.division(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0] = d;
                    buffer="abc";
                    if(temp[0]==1.0){
                        result.setText("Divide by zero error");
                    }
                    else {
                        result.setText(temp[0].toString());
                    }
                    operation="+";
                }
                else if(operation.equals("+") || operation.equals("null") || operation.equals(""))
                {
                    operation="+";
                    if (temp[0] == null) {
                        temp[0] = Double.valueOf(result.getText().toString());
                        result.setText("0");
                    } else if (temp[0] != Double.valueOf(result.getText().toString())) {
                        Double temp2 = temp[0];
                        Double value = Double.valueOf(result.getText().toString());
                        Double total = function.addition(temp2, value);
                        temp[0] = total;
                        result.setText(temp[0].toString());
                        buffer="abc";
                    }
                }
                break;

            case R.id.substraction:

                calculation="-";
                if(operation.equals("+")) {
                    Double d = function.addition(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0] = d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="-";
                }
                else if (operation.equals("logy")){
                    Double d=function.logy(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0]=d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="-";
                }
                else if (operation.equals("xpowy")){
                    Double d=function.powerxy(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0]=d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="-";
                }
                else if (operation.equals("xyroot")){
                    Double d=function.masterroot(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0]=d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="-";
                }
                else if(operation.equals("*")){
                    Double d = function.multiplication(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0] = d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="-";
                }
                else if(operation.equals("/")){
                    Double d = function.division(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0] = d;
                    buffer="abc";
                    if(temp[0]==1.0){
                        result.setText("Divide by zero error");
                    }
                    else {
                        result.setText(temp[0].toString());
                    }
                    operation="-";
                }
                else if(operation.equals("-") || operation.equals("null") || operation.equals(""))
                {
                    operation = "-";
                    if (temp[0] == null) {
                        temp[0] = Double.valueOf(result.getText().toString());
                        result.setText("0");
                    }
                    else if (temp[0] != Double.valueOf(result.getText().toString()))
                    {
                        Double temp2 = temp[0];
                        Double value = Double.valueOf(result.getText().toString());
                        Double total = function.substraction(temp2, value);
                        temp[0] = total;
                        result.setText(temp[0].toString());
                        buffer = "abc";
                    }
                }
                break;

            case R.id.multiplication:

                calculation="*";
                if(operation.equals("+")) {
                    Double d = function.addition(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0] = d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="*";
                }
                else if (operation.equals("logy")){
                    Double d=function.logy(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0]=d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="*";
                }
                else if (operation.equals("xpowy")){
                    Double d=function.powerxy(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0]=d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="*";
                }
                else if (operation.equals("xyroot")){
                    Double d=function.masterroot(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0]=d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="*";
                }
                else if(operation.equals("-")){
                    Double d = function.substraction(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0] = d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="*";
                }
                else if(operation.equals("/")){
                    Double d = function.division(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0] = d;
                    buffer="abc";
                    if(temp[0]==1.0){
                        result.setText("Divide by zero error");
                    }
                    else {
                        result.setText(temp[0].toString());
                    }
                    operation="*";
                }
                else if(operation.equals("*") || operation.equals("null") || operation.equals(""))
                {
                    operation = "*";
                    if (temp[0] == null) {
                        temp[0] = Double.valueOf(result.getText().toString());
                        result.setText("0");
                    } else if (temp[0] != Double.valueOf(result.getText().toString())) {
                        Double temp2 = temp[0];
                        Double value = Double.valueOf(result.getText().toString());
                        Double total = function.multiplication(temp2, value);
                        temp[0] = total;
                        result.setText(temp[0].toString());
                        buffer = "abc";
                    }
                }
                break;

            case R.id.division:

                calculation="/";
                if(operation.equals("+")) {
                    Double d = function.addition(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0] = d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="/";
                }
                else if (operation.equals("logy")){
                    Double d=function.logy(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0]=d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="/";
                }
                else if (operation.equals("xpowy")){
                    Double d=function.powerxy(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0]=d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="/";
                }
                else if (operation.equals("xyroot")){
                    Double d=function.masterroot(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0]=d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="/";
                }
                else if(operation.equals("*")){
                    Double d = function.multiplication(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0] = d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="/";
                }
                else if(operation.equals("-")){
                    Double d = function.substraction(temp[0], Double.valueOf(result.getText().toString()));
                    temp[0] = d;
                    buffer="abc";
                    result.setText(temp[0].toString());
                    operation="/";
                }

                else if(operation.equals("/") || operation.equals("null") || operation.equals(""))
                {
                    operation = "/";
                    if (temp[0] == null) {
                        temp[0] = Double.valueOf(result.getText().toString());
                        result.setText("0");
                    } else if (temp[0] != Double.valueOf(result.getText().toString())) {
                        Double temp2 = temp[0];
                        Double value = Double.valueOf(result.getText().toString());
                        Double total = function.division(temp2, value);
                        temp[0] = total;
                        result.setText(temp[0].toString());
                        buffer = "abc";
                    }
                }
                break;

            case R.id.factorial:
                if(result.getText().toString().equals("0")){
                    result.setText("1");
                }
                else{
                    Double value=Double.valueOf(result.getText().toString());
                    Integer a =value.intValue();
                    Double total=function.factorial(a);
                    temp[0]=total;
                    result.setText(temp[0].toString());
                }
                break;

            case R.id.equal:
                operation="";
                switch (calculation){

                    case "+":
                        Double value= Double.valueOf(result.getText().toString());
                        Double answer;
                        if(temp[0]==null){
                            answer=function.addition(value,value);
                        }
                        else{
                            answer=function.addition(temp[0],value);
                        }
                        result.setText(answer.toString());
                        temp[0]=null;
                        break;

                    case "-":
                        Double value1= Double.valueOf(result.getText().toString());
                        Double answer1;
                        if(temp[0]==null){
                            answer1=function.substraction(value1, value1);
                        }
                        else{
                            answer1=function.substraction(temp[0], value1);
                        }
                        result.setText(answer1.toString());
                        temp[0]=null;

                        break;

                    case "*":
                        Double value2= Double.valueOf(result.getText().toString());
                        Double answer2;
                        if(temp[0]==null){
                            answer2=function.multiplication(value2, value2);
                        }
                        else{
                            answer2=function.multiplication(temp[0], value2);
                        }
                        result.setText(answer2.toString());
                        temp[0]=null;
                        break;

                    case "/":
                        Double value3= Double.valueOf(result.getText().toString());
                        Double answer3;
                        if(temp[0]==null){
                            answer3=function.division(value3, value3);
                        }
                        else{
                            answer3=function.division(temp[0], value3);
                        }
                        result.setText(answer3.toString());
                        temp[0]=null;
                        break;

                    case "xpowy":
                        Double value4= Double.valueOf(result.getText().toString());
                        Double answer4;
                        if(temp[0]==null){
                            answer4=function.powerxy(value4, value4);
                        }
                        else{
                            answer4=function.powerxy(temp[0], value4);
                        }
                        result.setText(answer4.toString());
                        temp[0]=null;
                        break;

                    case "logy":
                        Double value5= Double.valueOf(result.getText().toString());
                        Double answer5;
                        if(temp[0]==null){
                            answer5=function.logy(value5, value5);
                        }
                        else{
                            answer5=function.logy(temp[0], value5);
                        }
                        result.setText(answer5.toString());
                        temp[0]=null;
                        break;

                    case "random":

                        Double value6= Double.valueOf(result.getText().toString());
                        Integer answer6;
                        answer6=function.randome(temp[0], value6);
                        result.setText(answer6.toString());
                        temp[0]=null;
                        break;

                    case "xyroot":

                        Double value7= Double.valueOf(result.getText().toString());
                        Double answer7;
                        if(temp[0]==null){
                            answer7=function.masterroot(value7, value7);
                        }
                        else{
                            answer7=function.masterroot(temp[0], value7);
                        }
                        result.setText(answer7.toString());
                        temp[0]=null;
                        break;

                    case "null":
                        break;
                }
                break;

            case R.id.radian:
                if(radtodeg.getText().toString().equals("Rad")) {
                    reddeg.setText("Degree");
                    radtodeg.setText("Deg");
                }
                else{
                    reddeg.setText("Radian");
                    radtodeg.setText("Rad");
                }
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {


        if(event.getAction() == MotionEvent.ACTION_DOWN){

            Button button = (Button)findViewById(v.getId());

            if(v.getId()==R.id.equal){
            }
            else {
                button.setBackgroundResource(R.color.verylightgrey);
            }
        }
        else if(event.getAction() == MotionEvent.ACTION_UP){
            Button button = (Button)findViewById(v.getId());
            if(v.getId()==R.id.equal){
            }
            else{
                button.setBackgroundResource(R.drawable.simple_calc_rectangle_button);
            }
        }
        return false;

    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.title_activity_scientific_cal_c);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }
}