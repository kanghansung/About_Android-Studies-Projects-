package org.techtown.spot_area_category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentSelectAreaTitle extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View fragmentSelectAreaTitle = inflater.inflate(R.layout.fragment_selectarea_title, container, false);

        ImageView cancel = (ImageView)fragmentSelectAreaTitle.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentMenuBar, new FragmentAreaMenuBar());
                fragmentTransaction.replace(R.id.fragmentFirstorAreaorCategory, new FragmentAreaListView());
                fragmentTransaction.commit();

            }
        });



        return fragmentSelectAreaTitle;
    }
}
