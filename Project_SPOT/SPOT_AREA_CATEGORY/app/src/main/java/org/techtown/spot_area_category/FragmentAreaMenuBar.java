package org.techtown.spot_area_category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentAreaMenuBar extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View fragmentAreaMenuBar = inflater.inflate(R.layout.fragment_menubar_area, container, false);

        final Button btnSelectArea = (Button)fragmentAreaMenuBar.findViewById(R.id.btnSelectArea);

        final Button btnCafe = (Button)fragmentAreaMenuBar.findViewById(R.id.btnCafe);
        final Button btnFood = (Button)fragmentAreaMenuBar.findViewById(R.id.btnFood);
        final Button btnPlace = (Button)fragmentAreaMenuBar.findViewById(R.id.btnPlace);

        btnCafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getActivity안되면 getConetxt()해보기.!!!!!!!!!!!!
                btnCafe.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.f_cafe0));
                btnFood.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.f_food1));
                btnPlace.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.f_place1));

                //TestCase ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragmentFirstorAreaorCategory, new TestExample());
//                fragmentTransaction.commit();
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

        //지역 고를때 화면값을 넘김.
        btnSelectArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ListFragment fragmentAreaMenu = new FragmentAreaMenu();
                Fragment fragmentSelectAreaMenuSelect = new FragmentAreaMenuSelect();
                Fragment fragmentSelectAreaTitle = new FragmentSelectAreaTitle();
                Fragment fragmentAreaMenuButton  = new FragmentAreaMenuButton();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentFirstorAreaorCategory, fragmentSelectAreaMenuSelect);//지역리스트
                fragmentTransaction.replace(R.id.fragmentMenuBar, fragmentSelectAreaTitle);
//                fragmentTransaction.replace(R.id.frameLayoutButton, fragmentAreaMenuButton);
                fragmentTransaction.commit();
            }
        });


        return fragmentAreaMenuBar;
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//        if(getActivity()!=null && getActivity()instanceof FragmentAreaMenuSelect){
//            userID = ((MainActivity)getActivity()).getData();
//        }
//    }
}
