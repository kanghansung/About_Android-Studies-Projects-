package org.techtown.listview_customlistview;

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
        myinflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listViewItemList = new ArrayList<CustomData>();
    }
    //각 postion 화면 출력 사용 에 사용하는 view return
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = myinflater.inflate(R.layout.custom_listview_item, viewGroup, false);
        }
        TextView textView01 = (TextView) view.findViewById(R.id.custom_listview_item_txt1);
        TextView textView02 = (TextView) view.findViewById(R.id.custom_listview_item_txt2);
        CustomData customData = listViewItemList.get(i);

        //custom list view item textview에 각 값 입력.
        textView01.setText(customData.getTxt1());
        textView02.setText(customData.getTxt2());

        return view;
    }

    //postion 위치에 있는 데이터 return. 여기서 파라미터 int형 i인덱스에 있는 값 반환.
    @Override
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }

    //아이템 ID가 있을 경우 해당 position에 대한 ID를 return.
    @Override
    public long getItemId(int i) {
        return i;
    }

    //아이템 전체 사이즈 반환
    @Override
    public int getCount() {
        return listViewItemList.size();
    }
    //리스트뷰에 아이템 추가.
    public void addItem(String txt1, String txt2){
        CustomData customData = new CustomData(txt1, txt2);
        listViewItemList.add(customData);
    }
}
