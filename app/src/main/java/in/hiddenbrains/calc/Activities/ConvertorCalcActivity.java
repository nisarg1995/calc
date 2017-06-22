package in.hiddenbrains.calc.Activities;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import in.hiddenbrains.calc.Adapters.Convertor_NavDrawer_list_adapter;
import in.hiddenbrains.calc.Fragments.HomeFragmentForConversionCalC;
import in.hiddenbrains.calc.Model.NavDrawerItem;
import in.hiddenbrains.calc.R;

public class ConvertorCalcActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;

    private CharSequence mTitle;

    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private Convertor_NavDrawer_list_adapter adapter;

    private TextView mainview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor_calc);

        mTitle = mDrawerTitle = getTitle();

        mainview = (TextView)findViewById(R.id.mainview);
        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.convertor_calc_nav_items);

        // nav drawer icons from resources
        navMenuIcons = getResources()
                .obtainTypedArray(R.array.navdrawerimages);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        for(int i=0;i<16;i++) {
            navDrawerItems.add(new NavDrawerItem(navMenuTitles[i], navMenuIcons.getResourceId(i, -1)));
        }

        navMenuIcons.recycle();

        adapter = new Convertor_NavDrawer_list_adapter(getApplicationContext() , navDrawerItems);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                null,
                R.string.app_name,
                R.string.app_name
        ){
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(R.string.app_name);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {

        }
    }


    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        switch (position){

            case 0:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 0);
                fragment.setArguments(bundle);
                break;

            case 1:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 1);
                fragment.setArguments(bundle);
                break;

            case 2:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 2);
                fragment.setArguments(bundle);
                break;

            case 3:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 3);
                fragment.setArguments(bundle);
                break;

            case 4:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 4);
                fragment.setArguments(bundle);
                break;

            case 5:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 5);
                fragment.setArguments(bundle);
                break;

            case 6:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 6);
                fragment.setArguments(bundle);
                break;

            case 7:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 7);
                fragment.setArguments(bundle);
                break;

            case 8:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 8);
                fragment.setArguments(bundle);
                break;

            case 9:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 9);
                fragment.setArguments(bundle);
                break;

            case 10:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 10);
                fragment.setArguments(bundle);
                break;

            case 11:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 11);
                fragment.setArguments(bundle);
                break;

            case 12:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 12);
                fragment.setArguments(bundle);
                break;

            case 13:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 13);
                fragment.setArguments(bundle);
                break;

            case 14:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 14);
                fragment.setArguments(bundle);
                break;

            case 15:
                fragment = new HomeFragmentForConversionCalC();
                bundle.putInt("id" , 15);
                fragment.setArguments(bundle);
                break;
        }

        if(fragment != null){

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.frame_container , fragment).commit();
            mainview.setText("");
            mainview.setBackground(null);
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        }
        else
        {
            Log.e("ConvertorCalC","Error retrieving fragment....");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.title_activity_convertor_calc);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }
}