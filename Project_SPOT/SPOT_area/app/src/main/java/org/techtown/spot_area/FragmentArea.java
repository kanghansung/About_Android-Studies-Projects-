package org.techtown.spot_area;


import android.app.FragmentManager;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentArea extends Fragment {


    public FragmentArea() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area, container, false);

        final Button btnSelectArea = (Button)view.findViewById(R.id.btnSelectArea);

        final Button btnCafe = (Button)view.findViewById(R.id.btnCafe);
        final Button btnFood = (Button)view.findViewById(R.id.btnFood);
        final Button btnPlace = (Button)view.findViewById(R.id.btnPlace);

        CustomAdapter customAdapter = new CustomAdapter();
        ListView listView = (ListView)view.findViewById(R.id.listView);

        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", "술집", "서울 마포구 망원동");

        listView.setAdapter(customAdapter);

        btnSelectArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //다이얼로그프래그먼트 공부해보기
            }
        });


        btnCafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getActivity안되면 getConetxt()해보기.!!!!!!!!!!!!
                btnCafe.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.f_cafe0));
                btnFood.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.f_food1));
                btnPlace.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.f_place1));
            }
        });
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnFood.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.f_food0));
                btnCafe.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.f_cafe1));
                btnPlace.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.f_place1));
            }
        });
        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPlace.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.f_place0));
                btnCafe.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.f_cafe1));
                btnFood.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.f_food1));
            }
        });


        return view;
    }

}
