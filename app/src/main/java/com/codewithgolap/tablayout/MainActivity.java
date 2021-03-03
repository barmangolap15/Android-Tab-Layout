package com.codewithgolap.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import com.kekstudio.dachshundtablayout.DachshundTabLayout;
import com.kekstudio.dachshundtablayout.HelperUtils;
import com.kekstudio.dachshundtablayout.indicators.DachshundIndicator;
import com.kekstudio.dachshundtablayout.indicators.LineFadeIndicator;
import com.kekstudio.dachshundtablayout.indicators.LineMoveIndicator;
import com.kekstudio.dachshundtablayout.indicators.PointFadeIndicator;
import com.kekstudio.dachshundtablayout.indicators.PointMoveIndicator;

public class MainActivity extends AppCompatActivity {

    private static final String TYPES[] = {"Android", "Play", "AudioBook", "Film", "Book","Favourite"};

    private ViewPager viewPager;
    private DachshundTabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

//    public void onClickDachshund(View view){
//        tabLayout.setAnimatedIndicator(new DachshundIndicator(tabLayout));
//    }
//
//    public void onClickPointMove(View view){
//        tabLayout.setAnimatedIndicator(new PointMoveIndicator(tabLayout));
//    }
//
//    public void onClickPointMoveAccelerate(View view){
//        PointMoveIndicator pointMoveIndicator = new PointMoveIndicator(tabLayout);
//        pointMoveIndicator.setInterpolator(new AccelerateInterpolator());
//        tabLayout.setAnimatedIndicator(pointMoveIndicator);
//    }
//
//    public void onClickLineMove(View view){
//        tabLayout.setAnimatedIndicator(new LineMoveIndicator(tabLayout));
//    }
//
//    public void onClickPointFade(View view){
//        tabLayout.setAnimatedIndicator(new PointFadeIndicator(tabLayout));
//    }
//
//    public void onClickLineFade(View view){
//        LineFadeIndicator lineFadeIndicator = new LineFadeIndicator(tabLayout);
//        tabLayout.setAnimatedIndicator(lineFadeIndicator);
//
//        lineFadeIndicator.setSelectedTabIndicatorHeight(HelperUtils.dpToPx(2));
//        lineFadeIndicator.setEdgeRadius(0);
//    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return new PageFragment();
        }

        @Override
        public int getCount() {
            return TYPES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TYPES[position];
        }
    }

    public static class PageFragment extends Fragment {

        public PageFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragemnt_page, container, false);
        }
    }
}