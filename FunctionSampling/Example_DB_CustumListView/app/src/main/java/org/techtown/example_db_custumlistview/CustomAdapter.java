package org.techtown.example_db_custumlistview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private ArrayList<CustomData> listViewItemList = null;
    private LayoutInflater myinflater = null;

    CustomAdapter(Context context){
        listViewItemList = new ArrayList<CustomData>();
        myinflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null)
        {
            view = myinflater.inflate(R.layout.customlistview, viewGroup, false);
        }
        TextView txtNameShop = (TextView)view.findViewById(R.id.txtNameShop);
        TextView txtPlace1 = (TextView)view.findViewById(R.id.txtPlace1);
        TextView txtKindOfShop = (TextView)view.findViewById(R.id.txtKindOfShop);
        TextView txtPlace2 = (TextView)view.findViewById(R.id.txtPlace2);

        CustomData customData = listViewItemList.get(i);

        txtKindOfShop.setText(customData.getKindOfShop());
        txtNameShop.setText(customData.getNameShop());
        txtPlace1.setText(customData.getPlace1());
        txtPlace2.setText(customData.getPlace2());

        return view;
    }
    public void addItem(String nameShop, String place1, String kindOfShop, String place2){
        CustomData customData = new CustomData(nameShop, place1, kindOfShop, place2);
        listViewItemList.add(customData);
    }
}
