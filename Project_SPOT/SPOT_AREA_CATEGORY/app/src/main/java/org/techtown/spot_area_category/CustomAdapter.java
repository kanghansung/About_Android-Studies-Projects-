package org.techtown.spot_area_category;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<CustomData> listViewItemList = new ArrayList<>();

    CustomAdapter(){

    }
    CustomAdapter(Context context){

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }

    //얘는어떨때 쓰는 걸까
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();

        if(view==null)
        {
            LayoutInflater myinflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = myinflater.inflate(R.layout.listitem, viewGroup, false);
        }

        ImageView iconDrawable = (ImageView) view.findViewById(R.id.iconDrawable);
        TextView nameShop = (TextView)view.findViewById(R.id.nameShop);
        TextView place1Shop = (TextView)view.findViewById(R.id.place1Shop);
        TextView kindOfShop = (TextView)view.findViewById(R.id.kindOfShop);
        TextView place2Shop = (TextView)view.findViewById(R.id.place2Shop);


        CustomData customData = listViewItemList.get(i);

        iconDrawable.setImageDrawable(customData.getIconDrawable());
        nameShop.setText(customData.getNameShop());
        place1Shop.setText(customData.getPlace1Shop());
        kindOfShop.setText(customData.getKindOfShop());
        place2Shop.setText(customData.getPlace2Shop());

        return view;
    }

    public void addItem(Drawable iconDrawable, String nameShop, String place1Shop, String kindOfShop, String place2Shop){
        CustomData customData = new CustomData(iconDrawable, nameShop, place1Shop, kindOfShop, place2Shop);
        listViewItemList.add(customData);
    }


}
