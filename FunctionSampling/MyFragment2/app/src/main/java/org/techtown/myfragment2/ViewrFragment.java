package org.techtown.myfragment2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewrFragment extends Fragment {

    MainActivity activity;
    ImageView imageView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_viewr, container, false);

        imageView = (ImageView)rootView.findViewById(R.id.imageView);


        return rootView;
    }

    public void setImage(int index){
        if(index == 0){
            imageView.setImageResource(R.drawable.google);
        } else if(index == 1){
            imageView.setImageResource(R.drawable.twitter);
        } else if(index == 2){
            imageView.setImageResource(R.drawable.facebook);
        }
    }
}
