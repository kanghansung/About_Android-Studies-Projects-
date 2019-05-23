package org.techtown.spot_area_category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentTitleMenuBar extends Fragment {
    private boolean isFragmentArea;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragmentTitleMenuBar = inflater.inflate(R.layout.fragment_menubar, container, false);

        final TextView txtBack  = (TextView)fragmentTitleMenuBar.findViewById(R.id.txtBack);
        final Button btnSelectKind = (Button)fragmentTitleMenuBar.findViewById(R.id.btnSelectKind);
        final TextView txtSearch = (TextView)fragmentTitleMenuBar.findViewById(R.id.txtSearch);

        btnSelectKind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnSelectKind.getText().equals("지역별 검색"))
                    btnSelectKind.setText("카테고리별 검색");
                else
                    btnSelectKind.setText("지역별 검색");
                switchFragmentAreaOrCategory();
            }
        });

        return fragmentTitleMenuBar;
    }


    public void switchFragmentAreaOrCategory(){
        Fragment menubar;
        ListFragment listFragment;

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(isFragmentArea){
            menubar = new FragmentAreaMenuBar();
            listFragment = new FragmentAreaListView();
        }
        else{
            menubar = new FragmentCategoryMenuBar();
            listFragment = new FragmentAreaListView(); //형틀로 임시방편으로해둠.
        }

        isFragmentArea = (isFragmentArea) ? false : true;

        fragmentTransaction.replace(R.id.fragmentMenuBar, menubar);
        fragmentTransaction.replace(R.id.fragmentFirstorAreaorCategory, listFragment);
        fragmentTransaction.commit();
    }
}
