package org.techtown.myfragment2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ListFragment extends Fragment {

    MainActivity activity;
    Button button, button2, button3;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_list, container, false);

        button = (Button)rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.ChangeImage(0);
            }
        });
        button2 = (Button)rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.ChangeImage(1);
            }
        });
        button3 = (Button)rootView.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.ChangeImage(2);
            }
        });

        return rootView;
    }
}
