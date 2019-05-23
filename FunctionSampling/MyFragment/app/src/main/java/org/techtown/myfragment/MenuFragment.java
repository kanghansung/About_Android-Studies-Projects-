package org.techtown.myfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment {
    MainActivity activity;
    Button btnToMainFragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        activity = null;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_menu, container, false);

        btnToMainFragment = (Button)rootView.findViewById(R.id.btnToMainFragment);
        btnToMainFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.ChangeFragment(0);
            }
        });

        return rootView;

    }
}
