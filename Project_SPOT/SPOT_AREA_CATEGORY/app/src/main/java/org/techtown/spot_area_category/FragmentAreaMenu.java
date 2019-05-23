package org.techtown.spot_area_category;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentAreaMenu extends ListFragment {

    private AreaMenuAdapter areaMenuAdapter;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View fragmentAreaMenu = inflater.inflate(R.layout.fragment_area_menu, container, false);
        listView = (ListView)fragmentAreaMenu.findViewById(R.id.listAreaMenu);  //수정부분 9.17 container. -> fragmentAreaMenu.

//        showListView();
        final AreaMenuAdapter areaMenuAdapter = new AreaMenuAdapter();
        setListAdapter(areaMenuAdapter);

//        //추가부분 9.17
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getContext(), FragmentMenuBar.class);
//                intent.putExtra("selectedArea", )
//            }
//        });

        areaMenuAdapter.addItem("강남역");
        areaMenuAdapter.addItem("홍대입구역");
        areaMenuAdapter.addItem("신촌역");
        areaMenuAdapter.addItem("이태원");
        areaMenuAdapter.addItem("산본역");
        areaMenuAdapter.addItem("도곡역");
        areaMenuAdapter.addItem("선릉역");

        areaMenuAdapter.addItem("산본역");
        areaMenuAdapter.addItem("수리산역");
        areaMenuAdapter.addItem("금정역");
        areaMenuAdapter.addItem("범계역");
        areaMenuAdapter.addItem("안양역");
        areaMenuAdapter.addItem("평촌역");
        areaMenuAdapter.addItem("과천정부청사");
        areaMenuAdapter.addItem("서울대공원");
        areaMenuAdapter.addItem("롯데월드");
        areaMenuAdapter.addItem("에버랜드");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//
//        super.onListItemClick(l, v, position, id);
//    }
}
