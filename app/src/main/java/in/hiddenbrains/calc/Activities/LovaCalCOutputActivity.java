package in.hiddenbrains.calc.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import in.hiddenbrains.calc.Calculations.Keyboard;
import in.hiddenbrains.calc.R;

public class LovaCalCOutputActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView answer;
    private TextView quote;
    private TextView temp;
    private int number;
    private Random r;
    private String quoteoutput;
    private Button ok,home;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lova_cal_coutput);
        Keyboard.setupUI(findViewById(R.id.parent), this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int answer2 = bundle.getInt("answer");
        Log.e("asd", String.valueOf(answer2));
        answer = (TextView)findViewById(R.id.answer);
        temp = (TextView)findViewById(R.id.temp);
        temp.setText(String.valueOf(answer2));
        animateTextView(0 , answer2 , temp);
        animation = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.heartmovinganimation);
        answer.setAnimation(animation);

        r = new Random();
        quote = (TextView)findViewById(R.id.quote);
        Typeface tf=Typeface.createFromAsset(this.getAssets(),"fonts/Eutemia.ttf");
        quote.setTypeface(tf);
        //number = r.nextInt(10);
        number = 8;
        switch (number){

            case 0:
                quote.setText(getResources().getString(R.string.quote1));
                break;

            case 1:
                quote.setText(getResources().getString(R.string.quote2));
                break;

            case 2:
                quote.setText(getResources().getString(R.string.quote3));
                break;

            case 3:
                quote.setText(getResources().getString(R.string.quote4));
                break;

            case 4:
                quote.setText(getResources().getString(R.string.quote5));
                break;

            case 5:
                quote.setText(getResources().getString(R.string.quote6));
                break;

            case 6:
                quote.setText(getResources().getString(R.string.quote7));
                break;

            case 7:
                quote.setText(getResources().getString(R.string.quote8));
                break;

            case 8:
                quote.setText(getResources().getString(R.string.quote9));
                break;

            case 9:
                quote.setText(getResources().getString(R.string.quote10));
                break;

        }

        ok = (Button)findViewById(R.id.ok);
        home = (Button)findViewById(R.id.home);
        ok.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    public void animateTextView(int initialValue, int finalValue, final TextView textview) {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator(0.8f);
        int start = Math.min(initialValue, finalValue);
        int end = Math.max(initialValue, finalValue);
        int difference = Math.abs(finalValue - initialValue);
        Handler handler = new Handler();
        for (int count = start; count <= end; count++) {
            int time = Math.round(decelerateInterpolator.getInterpolation((((float) count) / difference)) * 75) * count;
            final int finalCount = ((initialValue > finalValue) ? initialValue - count : count);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    textview.setText(finalCount + "");
                }
            }, time);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.ok:
                finish();
                break;

            case R.id.home:
                Intent intent = new Intent(this , MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.title_activity_lova_cal_coutput);
    }


}
