package org.techtown.spot_area_category;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<CustomData> areaListViewItemList = new ArrayList<>();

    ListViewAdapter(){

    }

    @Override
    public int getCount() {
        return areaListViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return areaListViewItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        final Context context = viewGroup.getContext();

        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.fragment_area, viewGroup, false);
        }

        ImageView iconDrawable = (ImageView) view.findViewById(R.id.iconDrawable);
        TextView nameShop = (TextView)view.findViewById(R.id.nameShop);
        TextView place1Shop = (TextView)view.findViewById(R.id.place1Shop);
        TextView kindOfShop = (TextView)view.findViewById(R.id.kindOfShop);
        TextView place2Shop = (TextView)view.findViewById(R.id.place2Shop);

        CustomData customData = areaListViewItemList.get(pos);

        iconDrawable.setImageDrawable(customData.getIconDrawable());
        nameShop.setText(customData.getNameShop());
        place1Shop.setText(customData.getPlace1Shop());
        kindOfShop.setText(customData.getKindOfShop());
        place2Shop.setText(customData.getPlace2Shop());


        return view;
    }
    public void addItem(Drawable iconDrawable, String nameShop, String place1Shop, String kindOfShop, String place2Shop){
        CustomData customData = new CustomData();

        customData.setIconDrawable(iconDrawable);
        customData.setNameShop(nameShop);
        customData.setPlace1Shop(place1Shop);
        customData.setKindOfShop(kindOfShop);
        customData.setPlace2Shop(place2Shop);

        areaListViewItemList.add(customData);
    }
}
