package in.hiddenbrains.calc.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import in.hiddenbrains.calc.Adapters.SimpleCalCRecentTransactioncustomadapter;
import in.hiddenbrains.calc.Calculations.Keyboard;
import in.hiddenbrains.calc.DatabaseHandlers_DatabaseAccessObjects.RecentTransactionSimpleCalCDatabaseHandler;
import in.hiddenbrains.calc.Model.RecentTransactionSimpleCalC;
import in.hiddenbrains.calc.R;

public class SimpleCalCRecentTransActivity extends AppCompatActivity {

    private ListView listView;
    private List<RecentTransactionSimpleCalC> arrayList;
    private SimpleCalCRecentTransactioncustomadapter adapter;
    private RecentTransactionSimpleCalCDatabaseHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_cal_crecent_trans);
        Keyboard.setupUI(findViewById(R.id.parent), this);

        listView = (ListView)findViewById(R.id.listview);
        arrayList = new ArrayList<RecentTransactionSimpleCalC>();

        handler = new RecentTransactionSimpleCalCDatabaseHandler(this);
        arrayList =  handler.getAllTransactions();

        adapter = new SimpleCalCRecentTransactioncustomadapter(arrayList);
        listView.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.recent_transaction, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.ok){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.title_activity_simple_cal_crecent_trans);
    }


}
