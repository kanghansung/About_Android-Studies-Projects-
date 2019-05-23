package org.techtown.spot_place_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private ArrayList<CustomData> listViewItemList = null;
    private LayoutInflater myinflater = null;

    CustomAdapter(Context context){
        listViewItemList = new ArrayList<CustomData>();
        myinflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //전체 사이즈.
    @Override
    public int getCount() {
        return listViewItemList.size();
    }
    //i 위치에있는 값 return
    @Override
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }
    //id가 있을 경우 해당 위치 ID를 return
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
            view = myinflater.inflate(R.layout.place_list_listview, viewGroup, false);

        TextView shopName = (TextView) view.findViewById(R.id.shopName);
        TextView shopPlace_1 = (TextView) view.findViewById(R.id.shopPlace_1);
        TextView shopPlace_2 = (TextView) view.findViewById(R.id.shopPlace_2);
        TextView kindOfShop = (TextView) view.findViewById(R.id.kindOfShop);

        CustomData customData = listViewItemList.get(i);

        shopName.setText(customData.getShopName());
        shopPlace_1.setText(customData.getShopPlace_1());
        shopPlace_2.setText(customData.getShopPlace_2());
        kindOfShop.setText(customData.getKindOfShop());

        return view;
    }

    public void addItem(String shopName, String shopPlace_1, String shopPlace_2, String kindOfShop){
        CustomData customData = new CustomData(shopName, shopPlace_1, shopPlace_2, kindOfShop);
        listViewItemList.add(customData);
    }
}
