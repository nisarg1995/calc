package in.hiddenbrains.calc.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.hiddenbrains.calc.Activities.MainActivity;
import in.hiddenbrains.calc.Model.CalculatorType;
import in.hiddenbrains.calc.R;

/**
 * Created by sunil on 09-03-2016.
 */
public class CustomAdapter extends BaseAdapter {

    ArrayList<CalculatorType> arrayList;

    public CustomAdapter(MainActivity mainactivity, ArrayList<CalculatorType> arrayofCalculatorTypes){

        this.arrayList = arrayofCalculatorTypes;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.customlayout, parent, false);

        final CalculatorType CalculatorTypes = arrayList.get(position);

        TextView name = (TextView)view.findViewById(R.id.calculatortype);
        name.setText(CalculatorTypes.getCalculatorName());

        ImageView img = (ImageView)view.findViewById(R.id.image);
        img.setImageResource(CalculatorTypes.getImgid());

        return view;
    }
}
