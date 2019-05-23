package org.techtown.spot_area;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Adapter_areaMenu extends BaseAdapter {

    private ArrayList<AreaMenuData> areaMenuDataArrayList = null;
    private LayoutInflater layoutInflater = null;

    Adapter_areaMenu(Context context){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        areaMenuDataArrayList = new ArrayList<AreaMenuData>();
    }

    @Override
    public int getCount() {
        return areaMenuDataArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return areaMenuDataArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view = layoutInflater.inflate(R.layout.area_menu, viewGroup,false);

        TextView nameArea = (TextView)view.findViewById(R.id.nameShop);

        AreaMenuData areaMenuData = areaMenuDataArrayList.get(i);

        nameArea.setText(areaMenuData.getNameArea());

        return view;
    }

    public void addItem(String nameArea){
        AreaMenuData areaMenuData = new AreaMenuData(nameArea);
        areaMenuDataArrayList.add(areaMenuData);
    }
}
