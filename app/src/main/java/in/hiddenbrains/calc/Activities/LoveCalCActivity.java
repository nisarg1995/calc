package in.hiddenbrains.calc.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import in.hiddenbrains.calc.Calculations.Keyboard;
import in.hiddenbrains.calc.R;

public class LoveCalCActivity extends AppCompatActivity {
    private ImageView imageView;
    private static int splash_screen_time_out = 3000;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_cal_c);
        Keyboard.setupUI(findViewById(R.id.parent), this);

        imageView = (ImageView)findViewById(R.id.image);
        animation = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.zoominlovecalc);
        imageView.setAnimation(animation);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(1500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(getApplicationContext(),LovaCalCMainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timerThread.start();
    }



}
