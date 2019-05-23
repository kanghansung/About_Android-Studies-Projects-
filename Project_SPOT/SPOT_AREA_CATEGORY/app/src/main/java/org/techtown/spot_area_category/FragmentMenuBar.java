package org.techtown.spot_area_category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentMenuBar extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        View fragmentMenuBar = inflater.inflate(R.layout.fragment_menubar, container,false);
        View fragmentMenuBar = inflater.inflate(R.layout.fragment_menubar, null);



//        return fragmentMenuBar;
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
