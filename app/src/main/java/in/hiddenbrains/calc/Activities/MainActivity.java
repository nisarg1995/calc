package in.hiddenbrains.calc.Activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Locale;

import in.hiddenbrains.calc.Adapters.CustomAdapter;
import in.hiddenbrains.calc.Calculations.Keyboard;
import in.hiddenbrains.calc.Model.CalculatorType;
import in.hiddenbrains.calc.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView gridView;
    CustomAdapter customAdapter;
    ArrayList<CalculatorType> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Keyboard.setupUI(findViewById(R.id.parent), this);

        arrayList = new ArrayList<CalculatorType>();
        arrayList.add(new CalculatorType(1, getString(R.string.simplecalc), R.drawable.simple_calc));
        arrayList.add(new CalculatorType(2,getString(R.string.scientificcalc), R.drawable.scientific_calc));
        arrayList.add(new CalculatorType(3,getString(R.string.lovecalc),R.drawable.love));
        arrayList.add(new CalculatorType(4,getString(R.string.interestcalc),R.drawable.interest_calc));
        arrayList.add(new CalculatorType(5,getString(R.string.mortgagecalc),R.drawable.mortgage_calc));
        arrayList.add(new CalculatorType(6,getString(R.string.convertorcalc),R.drawable.convertor_calc));
        arrayList.add(new CalculatorType(7,getString(R.string.healthcalc),R.drawable.health_calc));
        arrayList.add(new CalculatorType(8,getString(R.string.dayscalc),R.drawable.day_calc));

        gridView = (GridView)findViewById(R.id.grid);
        customAdapter = new CustomAdapter(MainActivity.this , arrayList);
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (arrayList.get(position).getId()){
            case 1:
                Intent intent1 = new Intent(getApplicationContext(),SimpleCalCActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;

            case 2:
                Intent intent2 = new Intent(getApplicationContext(),ScientificCalCActivity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;

            case 3:
                Intent intent3 = new Intent(getApplicationContext() , LoveCalCActivity.class);
                startActivity(intent3);
                break;

            case 4:
                Intent intent4 = new Intent(getApplicationContext() , InterestCalcActivity.class);
                startActivity(intent4);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;

            case 5:
                Intent intent5 = new Intent(getApplicationContext() , MortgageCalcActivity.class);
                startActivity(intent5);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;

            case 6:
                Intent intent6 = new Intent(getApplicationContext() , ConvertorCalcActivity.class);
                startActivity(intent6);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;

            case 7:
                Intent intent7 = new Intent(getApplicationContext() , HealthActivity.class);
                startActivity(intent7);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;

            case 8:
                Intent intent8 = new Intent(getApplicationContext() , TimeCalCActivity.class);
                startActivity(intent8);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;

        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.en:
                setLocale("en");
                break;

            case R.id.gj:
                setLocale("gj");
                break;

            case R.id.hi:
                setLocale("hi");
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(refresh);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.title_activity_main);
    }



}
