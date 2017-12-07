package com.example.administrator.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

public class Main2Activity extends FragmentActivity {
    private SubFragment1 subFragment1;
    private SubFragment2 subFragment2;
    private SubFragment3 subFragment3;
    private PagerSlidingTabStrip tabs;
    private DisplayMetrics dm;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dm = getResources().getDisplayMetrics();
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabs.setViewPager(pager);
        setTabsValue();
    }

    private void setTabsValue() {
        tabs.setShouldExpand(true);
        tabs.setDividerColor(Color.TRANSPARENT);
        tabs.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        tabs.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, dm));
        tabs.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, dm));
        tabs.setIndicatorColor(Color.parseColor("#45c01a"));
        tabs.setTabBackground(0);
    }

    public class MyPagerAdapter extends FragmentStatePagerAdapter {
        private final String[] titles = {"音乐列表", "排行榜", "我"};
        SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            registeredFragments.put(position, fragment);
            return fragment;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            registeredFragments.remove(position);
            super.destroyItem(container, position, object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (null == subFragment1) {
                        subFragment1 = new SubFragment1();
                    }
                    return subFragment1;
                case 1:
                    if (null == subFragment2) {
                        subFragment2 = new SubFragment2();
                    }
                    return subFragment2;
                case 2:
                    if (null == subFragment3) {
                        subFragment3 = new SubFragment3();
                    }
                    return subFragment3;
                default:
                    return null;
            }
        }
    }
}