package com.tistory.coderush.doingproject.mainFrag;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private int tabCount;

    public FragmentAdapter(FragmentManager fm,int tabCount) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                MainFragment mainFragment=new MainFragment();
                return mainFragment;
            case 1:
                CalendarFragment calendarFragment=new CalendarFragment();
                return calendarFragment;
            case 2:
                MemoFragment memoFragment=new MemoFragment();
                return memoFragment;
            case 3:
                ProfileFragment profileFragment=new ProfileFragment();
                return profileFragment;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
