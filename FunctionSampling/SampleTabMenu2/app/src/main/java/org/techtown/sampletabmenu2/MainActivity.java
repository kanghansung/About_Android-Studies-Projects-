package org.techtown.sampletabmenu2;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    TabLayout allTabs;
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (FrameLayout)findViewById(R.id.container);
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();

        getAllWidgets();
        bindWidgetsWithAnEvent();
        setUpTabLayout();
    }

    private void getAllWidgets(){
        allTabs = (TabLayout)findViewById(R.id.tabLayout);
    }
    private void setUpTabLayout(){
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        allTabs.addTab(allTabs.newTab().setIcon(R.drawable.today_selector));
        allTabs.addTab(allTabs.newTab().setIcon(R.drawable.calender_selector));
        allTabs.addTab(allTabs.newTab().setIcon(R.drawable.note_selector));
        allTabs.addTab(allTabs.newTab().setIcon(R.drawable.my_selector));
    }
    private void bindWidgetsWithAnEvent(){
        allTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setCurrTabFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void setCurrTabFragment(int tabPosition){
        switch (tabPosition){
            case 0:
                replaceFragment(fragment1);
                break;
            case 1:
                replaceFragment(fragment2);
                break;
            case 2:
                replaceFragment(fragment3);
                break;
            case 3:
                replaceFragment(fragment4);
                break;
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
