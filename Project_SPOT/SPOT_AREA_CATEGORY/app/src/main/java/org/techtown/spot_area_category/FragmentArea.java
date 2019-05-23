package org.techtown.spot_area_category;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class FragmentArea extends Fragment {

    public FragmentArea(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        View fragmentArea = inflater.inflate(R.layout.fragment_area, container, false);
//        ListView listView = (ListView)fragmentArea.findViewById(R.id.listView);
//
//        CustomAdapter customAdapter = new CustomAdapter();
//        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", " 술집", "서울 마포구 망원동");
//        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", " 술집", "서울 마포구 망원동");
//        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", " 술집", "서울 마포구 망원동");
//        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", " 술집", "서울 마포구 망원동");
//        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "복덕방", "마포구", " 술집", "서울 마포구 망원동");

//        listView.setAdapter(customAdapter);


        return fragmentArea;
    }

}
