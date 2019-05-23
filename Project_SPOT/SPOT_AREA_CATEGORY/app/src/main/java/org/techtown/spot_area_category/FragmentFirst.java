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
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class FragmentFirst extends Fragment {

    public FragmentFirst(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View fragmentFirst = inflater.inflate(R.layout.fragment_first, container, false);

        LinearLayout kindOfCity = (LinearLayout)fragmentFirst.findViewById(R.id.kindOfCity);
        kindOfCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Fragment fragmentArea = new FragmentArea();
                final ListFragment fragmentAreaListView = new FragmentAreaListView();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentFirstorAreaorCategory, fragmentAreaListView);  //fragmentListView -> fragmentArea로 수정.안되면 다시 fragmentListView로 바꾸기
                fragmentTransaction.commit();
            }
        });
        return fragmentFirst;
    }
}
