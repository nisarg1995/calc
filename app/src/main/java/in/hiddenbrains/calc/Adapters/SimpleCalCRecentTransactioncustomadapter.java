package in.hiddenbrains.calc.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.hiddenbrains.calc.Activities.MainActivity;
import in.hiddenbrains.calc.Model.CalculatorType;
import in.hiddenbrains.calc.Model.RecentTransactionSimpleCalC;
import in.hiddenbrains.calc.R;

/**
 * Created by sunil on 31-03-2016.
 */
public class SimpleCalCRecentTransactioncustomadapter extends BaseAdapter{


        List<RecentTransactionSimpleCalC> arrayList;

        public SimpleCalCRecentTransactioncustomadapter( List<RecentTransactionSimpleCalC> arrayofRecentTransaction){

            this.arrayList = arrayofRecentTransaction;
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
            View view = inflater.inflate(R.layout.simple_calc_recent_transaction_custom_adapter, parent, false);

            RecentTransactionSimpleCalC rs = arrayList.get(arrayList.size() - position - 1);

            TextView stringtoevaluate = (TextView)view.findViewById(R.id.stringtoevaluate);
            stringtoevaluate.setText(rs.getEvaluationString() + rs.getAnswer());

            return view;
        }
}

