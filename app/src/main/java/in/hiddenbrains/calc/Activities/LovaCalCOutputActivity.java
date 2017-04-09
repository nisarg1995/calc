package in.hiddenbrains.calc.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import in.hiddenbrains.calc.R;

public class LovaCalCOutputActivity extends AppCompatActivity {

    private TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lova_cal_coutput);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int answer2 = bundle.getInt("answer");
        Log.e("asd", String.valueOf(answer2));
        answer = (TextView)findViewById(R.id.answer);
        answer.setText(String.valueOf(answer2));

    }

}
