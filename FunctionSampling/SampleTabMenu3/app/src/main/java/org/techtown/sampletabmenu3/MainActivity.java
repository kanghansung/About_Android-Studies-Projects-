package org.techtown.sampletabmenu3;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;

    FrameLayout container;
    ImageView tab1, tab2, tab3, tab4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        container = (FrameLayout)findViewById(R.id.container);

        tab1 = (ImageView)findViewById(R.id.tab1);
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tab1.setSelected(true);
                tab2.setSelected(false);
                tab3.setSelected(false);
                tab4.setSelected(false);
                changeFragment(0);


            }
        });
        tab2 = (ImageView)findViewById(R.id.tab2);
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tab1.setSelected(false);
                tab2.setSelected(true);
                tab3.setSelected(false);
                tab4.setSelected(false);

                changeFragment(1);
            }
        });
        tab3 = (ImageView)findViewById(R.id.tab3);
        tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tab1.setSelected(false);
                tab2.setSelected(false);
                tab3.setSelected(true);
                tab4.setSelected(false);

                changeFragment(2);
            }
        });
        tab4 = (ImageView)findViewById(R.id.tab4);
        tab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tab1.setSelected(false);
                tab2.setSelected(false);
                tab3.setSelected(false);
                tab4.setSelected(true);

                changeFragment(3);
            }
        });
    }

    private void changeFragment(int index){
        switch (index){
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment4).commit();
                break;
        }
    }
}
