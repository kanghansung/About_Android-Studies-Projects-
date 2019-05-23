package org.techtown.listview_makedata_by_dynamic;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private ArrayList<ListViewData> listViewItems = null;
    private LayoutInflater myinflater = null;

    Adapter(Context context){   //파라미터 값으로 왜 context를 넘기는가?
        listViewItems = new ArrayList<ListViewData>();  //여기서 꺽쇄안에 빈공간으로 나두어도 되지않나?
        myinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //각 i위치에 있는 화면을 출력 사용에 사용하는 view를 return 함.
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = myinflater.inflate(R.layout.listview_items, viewGroup,false);
        }
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView phone = (TextView) view.findViewById(R.id.phone);
        ListViewData listViewData = listViewItems.get(i);

        name.setText(listViewData.getName());
        phone.setText(listViewData.getPhoneNumber());

        return view;
    }

    //아이템 ID가 있을 경우 해당 위치 i에 대한 ID를 return. ......?
    @Override
    public long getItemId(int i) {
        return i;
    }

    //i위치에 있는 데이터를 return.
    @Override
    public Object getItem(int i) {
        return listViewItems.get(i);
    }

    @Override
    public int getCount() {
        return listViewItems.size();
    }

    public void addItem(String name, String phone){
        ListViewData listViewData = new ListViewData(name, phone);

        listViewItems.add(listViewData);
    }

}
