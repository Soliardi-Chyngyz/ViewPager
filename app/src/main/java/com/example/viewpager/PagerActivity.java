package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class PagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    class FragmentAdapter extends FragmentPagerAdapter{

        public FragmentAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
//                    MainActivity mainActivity = new MainActivity();
//                    Bundle info = new Bundle();
//                    info.putInt("Текущая страница" , position);
//                    mainActivity.set
                    FirstFragment firstFragment = new FirstFragment();
                    Bundle info = new Bundle();
                    info.putInt("Текущая страница", position);
                    firstFragment.setArguments(info);
                    return firstFragment;
                case 1:
                    SecondFragment secondFragment = new SecondFragment();
                    Bundle info2 = new Bundle();
                    info2.putInt("Текущая страница", position);
                    secondFragment.setArguments(info2);
                    return secondFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}