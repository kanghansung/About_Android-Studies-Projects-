package org.techtown.spot_area_category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentCategory extends Fragment {

    public FragmentCategory(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View fragmentCategory = inflater.inflate(R.layout.fragment_category, container,false);

        LinearLayout cafe = (LinearLayout)fragmentCategory.findViewById(R.id.cafe);
        LinearLayout foodStore = (LinearLayout)fragmentCategory.findViewById(R.id.foodStore);
        LinearLayout place1 = (LinearLayout)fragmentCategory.findViewById(R.id.place1);
        LinearLayout place2 = (LinearLayout)fragmentCategory.findViewById(R.id.place2);
        TextView txtReset = (TextView)fragmentCategory.findViewById(R.id.txtReset);
        TextView txtAllow = (TextView)fragmentCategory.findViewById(R.id.txtAllow);

        return fragmentCategory;
    }
}
