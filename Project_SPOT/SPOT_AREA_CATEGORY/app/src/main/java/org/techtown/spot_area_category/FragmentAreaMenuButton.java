package org.techtown.spot_area_category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentAreaMenuButton extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentAreaMenuButton = inflater.inflate(R.layout.fragment_areamenu_button, container, false);

        TextView txtSelectPlace = (TextView)fragmentAreaMenuButton.findViewById(R.id.txtSelectPlace);
        LinearLayout linearLayoutSelectPlace = (LinearLayout)fragmentAreaMenuButton.findViewById(R.id.layoutSelecPlace);

        //이러구 리스트 누르면 해당 txtSelectPlace값이 지역 이름으로 바뀌고, txtSelectPlace를 누르면 arealistview로돌아가구 btbSelectArea의 텍스트값 반환.


        return fragmentAreaMenuButton;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
