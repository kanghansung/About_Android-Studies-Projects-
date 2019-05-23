package org.techtown.doing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    TabPagerAdapter(FragmentManager fragmentManager, int tabCount){
        super(fragmentManager);
        this.tabCount = tabCount;
    }
    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                Fragment1 fragment1 = new Fragment1();
                return fragment1;
            case 1:
                Fragment2 fragment2 = new Fragment2();
                return fragment2;
            case 2:
                Fragment3 fragment3 = new Fragment3();
                return fragment3;
            case 3:
                Fragment4 fragment4 = new Fragment4();
                return fragment4;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

}
