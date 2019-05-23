package org.techtown.spot_area_category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentAreaMenuSelect extends Fragment {
    public static String userID; //값을 어디든 전달하기 위하여 static으로 함.

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_areamenu_1, container, false);
        final View viewMenuBar = inflater.inflate(R.layout.fragment_menubar_area, container, false);

        final Button btnSelectArea = (Button)viewMenuBar.findViewById(R.id.btnSelectArea);

        ListView listView = (ListView)view.findViewById(R.id.listAreaMenu);

        final TextView txtSelectPlace = (TextView)view.findViewById(R.id.txtSelectPlace);
        LinearLayout layoutSelectPlace = (LinearLayout)view.findViewById(R.id.layoutSelecPlace);

        txtSelectPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedArea = (String) txtSelectPlace.getText();

                userID = getActivity().getIntent().getExtras().getString("userID");
                getActivity().getIntent().putExtra("userID", userID);
                Intent intent = new Intent(getActivity(), FragmentAreaMenuBar.class);


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentFirstorAreaorCategory, new FragmentAreaListView());
                fragmentTransaction.replace(R.id.fragmentMenuBar, new FragmentAreaMenuBar());
                fragmentTransaction.commit();
            }
        });

        final AreaMenuAdapter areaMenuAdapter = new AreaMenuAdapter();
        listView.setAdapter(areaMenuAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                int check_position = adapterView.getSelectedItemPosition();
//
//                txtSelectPlace.setText(selectedArea);
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


        return view;
    }
    public Object getData(){
        return userID;
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//        if(getActivity() != null && getActivity()instanceof )
//    }
}
