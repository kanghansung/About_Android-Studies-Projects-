package org.techtown.spot_area_category;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private boolean isFragmentArea = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프래그먼트매니저를 생성하여 getSupportManager()로 능력을 할당 받고, fragmentFirstorAreaorCategory의 xml 공간에 FragmentFirst()를 넣어줌.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.TitleMenuBar, new FragmentTitleMenuBar());
        fragmentTransaction.add(R.id.fragmentMenuBar, new FragmentAreaMenuBar());
        fragmentTransaction.add(R.id.fragmentFirstorAreaorCategory, new FragmentFirst());
        fragmentTransaction.commit();
    }

    public void switchFragmentAreaOrCategory(){
        Fragment fr;
        Fragment menubar;
        Fragment titlemenubar;
        if(isFragmentArea){
            fr = new FragmentArea();
            menubar = new FragmentAreaMenuBar();
            titlemenubar = new FragmentTitleMenuBar();
        }
        else{
            fr = new FragmentCategory();
            menubar = new FragmentCategoryMenuBar();
            titlemenubar = new FragmentTitleMenuBar();
        }

        isFragmentArea = (isFragmentArea) ? false : true;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentFirstorAreaorCategory, fr);
        fragmentTransaction.replace(R.id.fragmentMenuBar, menubar);
        fragmentTransaction.replace(R.id.TitleMenuBar, titlemenubar);
        fragmentTransaction.commit();
    }
}