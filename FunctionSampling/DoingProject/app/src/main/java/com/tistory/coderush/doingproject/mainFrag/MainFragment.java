package com.tistory.coderush.doingproject.mainFrag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tistory.coderush.doingproject.R;

public class MainFragment extends Fragment {

    private ViewGroup root;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root= (ViewGroup) inflater.inflate(R.layout.fragment_main,container,false);




        return root;
    }
}
