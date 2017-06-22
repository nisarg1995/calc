package in.hiddenbrains.calc.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.hiddenbrains.calc.Model.NavDrawerItem;
import in.hiddenbrains.calc.R;

/**
 * Created by sunil on 11-03-2016.
 */
public class Convertor_NavDrawer_list_adapter extends BaseAdapter{

    private Context context;
    private ArrayList<NavDrawerItem> navDrawerItems;

    public Convertor_NavDrawer_list_adapter(Context context, ArrayList<NavDrawerItem> navDrawerItems){
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return  navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.drawer_list_item, parent, false);

        TextView tv=(TextView)view.findViewById(R.id.title);
        Typeface tf=Typeface.createFromAsset(context.getAssets(),"fonts/Righteous-Regular.ttf");
        tv.setTypeface(tf);
        final NavDrawerItem navDrawerItem = navDrawerItems.get(position);

        ImageView imageView = (ImageView)view.findViewById(R.id.image);
        imageView.setImageResource(navDrawerItem.getIcon());

        TextView name = (TextView)view.findViewById(R.id.title);
        name.setText(navDrawerItem.getTitle());

        return view;
    }
}