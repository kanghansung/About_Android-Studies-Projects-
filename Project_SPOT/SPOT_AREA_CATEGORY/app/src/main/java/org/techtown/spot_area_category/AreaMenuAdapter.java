package org.techtown.spot_area_category;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AreaMenuAdapter extends BaseAdapter /*implements AdapterView.OnClickListener*/{

//    private ArrayList<AreaMenuData> AreaMenuItemList = null;
    private  ArrayList<AreaMenuData> AreaMenuItemList = new ArrayList<>();
//    private LayoutInflater layoutInflater = null;

//    AreaMenuAdapter(Context context){
//        AreaMenuItemList = new ArrayList<AreaMenuData>();
//        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }

    AreaMenuAdapter(){

    }

    @Override
    public int getCount() {
        return AreaMenuItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return AreaMenuItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final  Context context = viewGroup.getContext();
        final  int pos = i;
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listitem_kindofarea, viewGroup, false);
        }
        //데이터 이름만 바뀌니 가져옴
        TextView nameArea = (TextView)view.findViewById(R.id.nameArea);
        //넣을 데이터를 new로 할당받아 list에 넣음.
        AreaMenuData areaMenuData = AreaMenuItemList.get(i);
        nameArea.setText(areaMenuData.getName());

        return view;
    }

    public void addItem(String nameArea){
         AreaMenuData areaMenuData = new AreaMenuData(nameArea);
         AreaMenuItemList.add(areaMenuData);
    }

//    @Override
//    public void onClick(View view) {
//
//    }
}
