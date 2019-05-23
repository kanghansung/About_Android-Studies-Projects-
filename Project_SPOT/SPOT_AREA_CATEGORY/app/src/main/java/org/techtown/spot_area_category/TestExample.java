package org.techtown.spot_area_category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

public class TestExample extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_area, container, false);

        CustomAdapter customAdapter = new CustomAdapter();
        ListView listView = (ListView)view.findViewById(R.id.listView);

        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "강한성","마포구","술집", "사울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "강한성","마포구","술집", "사울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "강한성","마포구","술집", "사울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "강한성","마포구","술집", "사울 마포구 망원동");
        customAdapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.img), "강한성","마포구","술집", "사울 마포구 망원동");
        listView.setAdapter(customAdapter);

        return view;
    }
}
