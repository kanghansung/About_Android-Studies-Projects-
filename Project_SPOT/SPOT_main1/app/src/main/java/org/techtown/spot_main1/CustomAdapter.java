package org.techtown.spot_main1;

import android.content.Context;
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
        myinflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        listViewItemList = new ArrayList<CustomData>();
    }

    //전체 사이즈 반환
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    //i 인덱스에 있는 값 반환.
    @Override
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }

    //i위치에 있는 데이터 return.
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null)
            view = myinflater.inflate(R.layout.main1_listview, viewGroup, false);
        TextView nameHotel = (TextView) view.findViewById(R.id.nameHotel);
        TextView money = (TextView) view.findViewById(R.id.money);
        TextView numberOfPerson = (TextView) view.findViewById(R.id.numberOfPerson);
        TextView duringDate = (TextView) view.findViewById(R.id.duringDate);

        CustomData customData = listViewItemList.get(i);

        duringDate.setText(customData.getDuringdate());
        nameHotel.setText(customData.getNameHotel());
        numberOfPerson.setText(customData.getNum());
        money.setText(customData.getMoney());

        return view;
    }

    public void addItem(String duringDate, String nameHotel, String numberOfPerson, String money){
        CustomData customData = new CustomData(duringDate, nameHotel, numberOfPerson, money);
        listViewItemList.add(customData);
    }
}
