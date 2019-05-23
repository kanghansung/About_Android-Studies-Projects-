package org.techtown.myfragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    Button btnMainFragment, btnMenuFragment;
    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();
        menuFragment = new MenuFragment();


        btnMainFragment = (Button)findViewById(R.id.btnMainFragement);
        btnMainFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(0);
            }
        });

        btnMenuFragment = (Button)findViewById(R.id.btnMenuFragment);
        btnMenuFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(1);
            }
        });

    }
    public void ChangeFragment(int index){
        if (index == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
        } else if (index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
        }
    }
}
