package org.techtown.spot_area;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    private ArrayList<CustomData> listViewItemList = new ArrayList<>();
//    private LayoutInflater myinflater = null;

    CustomAdapter(){

    }
    CustomAdapter(Context context){
//        myinflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//        listViewItemList = new ArrayList<CustomData>();
    }

//    사이즈반환
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

//    i위치에 있는값 반환
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
        Context context = viewGroup.getContext();
        if(view==null){
            LayoutInflater myinflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = myinflater.inflate(R.layout.area_listview, viewGroup, false);
        }

        TextView nameShop = (TextView)view.findViewById(R.id.nameShop);
        TextView place1Shop = (TextView)view.findViewById(R.id.place1Shop);
        TextView place2Shop = (TextView)view.findViewById(R.id.place2Shop);
        TextView kindOfShop = (TextView)view.findViewById(R.id.kindOfShop);

        CustomData customData = listViewItemList.get(i);

        nameShop.setText(customData.getNameShop());
        place1Shop.setText(customData.getPlace1Shop());
        place2Shop.setText(customData.getPlace2Shop());
        kindOfShop.setText(customData.getKindOfShop());

        return view;
    }

    public void addItem(Drawable iconDrawable, String nameShop, String place1Shop, String kindOfShop, String place2Shop){
        CustomData customData = new CustomData(iconDrawable, nameShop, place1Shop, kindOfShop, place2Shop);
        listViewItemList.add(customData);
    }
}
