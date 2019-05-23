package org.techtown.sampletabmenu;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    private ViewpagerAdapter adapter;
    private MenuItem prevMenuItem;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.today:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.calender:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.note:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.my:
                    viewPager.setCurrentItem(3);
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewpager_id);
        navigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        adapter= new ViewpagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new Fragment1(), "frag1");
        adapter.AddFragment(new Fragment2(), "frag2");
        adapter.AddFragment(new Fragment3(), "frag3");
        adapter.AddFragment(new Fragment4(), "frag4");
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(prevMenuItem != null)
                    prevMenuItem.setChecked(false);
                else
                    navigationView.getMenu().getItem(0).setChecked(false);

                navigationView.getMenu().getItem(i).setChecked(true);
                prevMenuItem = navigationView.getMenu().getItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
