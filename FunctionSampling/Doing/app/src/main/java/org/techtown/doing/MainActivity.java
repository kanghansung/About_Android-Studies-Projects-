package org.techtown.doing;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.TableLayout;

public class MainActivity extends FragmentActivity {

//    private TabLayout tabLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.b1_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.b2_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.b3_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.b4_selector));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //initializing adapter
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        //Creating adapter
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.beginFakeDrag();          //이부분 성현이가 수정-> 뷰페이저를 손으로 드래그로 못넘기게 막음


        try{
            viewPager.addOnAdapterChangeListener((ViewPager.OnAdapterChangeListener) new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        } catch (Exception e){

        }
        //Set TabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(),false);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        viewPager

    }
}
