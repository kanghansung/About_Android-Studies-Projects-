package org.techtown.spot_area_category;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

public class FragmentAreaListView extends ListFragment {

    CustomAdapter customAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentArea = inflater.inflate(R.layout.fragment_area, container, false);

//        ListView listView = (ListView)fragmentArea.findViewById(R.id.listView);
        customAdapter = new CustomAdapter();
        setListAdapter(customAdapter);
//        listView.setAdapter(customAdapter);

        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");

        return super.onCreateView(inflater, container, savedInstanceState);
//        return fragmentArea;
    }
    //Listfragment외부 즉 Activity에서 아이템 추가를 위한 함수 구현
    public void addItem(Drawable iconDrawable, String nameShop, String place1Shop, String kindOfShop, String place2Shop){
        customAdapter.addItem(iconDrawable, nameShop, place1Shop, kindOfShop, place2Shop);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


    }
}
