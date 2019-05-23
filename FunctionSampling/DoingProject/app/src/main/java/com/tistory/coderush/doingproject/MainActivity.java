package com.tistory.coderush.doingproject;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tistory.coderush.doingproject.mainFrag.FragmentAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initInstance();
        eventListener();
    }

    private void initView(){
        tabLayout=findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.b1_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.b2_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.b3_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.b4_selector));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //initializing adapter
        viewPager=findViewById(R.id.viewPager);

    }
    private void initInstance(){
        //Creating adapter
        fragmentAdapter=new FragmentAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(fragmentAdapter);
        viewPager.beginFakeDrag();

        try{
            viewPager.addOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void eventListener(){
        tabLayout.addOnTabSelectedListener(tabSelectListener);


    }

    TabLayout.OnTabSelectedListener tabSelectListener=new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            Log.i("onTabSelected",""+tab.getPosition());
            viewPager.setCurrentItem(tab.getPosition(),false);
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };
}
