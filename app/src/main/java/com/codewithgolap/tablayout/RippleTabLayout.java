package com.codewithgolap.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.codewithgolap.tablayout.Fragments.ChatsFragment;
import com.codewithgolap.tablayout.Fragments.HomeFragment;
import com.codewithgolap.tablayout.Fragments.SettingsFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class RippleTabLayout extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private HomeFragment homeFragment;
    private SettingsFragment settingsFragment;
    private ChatsFragment chatsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ripple_tab_layout);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        homeFragment = new HomeFragment();
        settingsFragment = new SettingsFragment();
        chatsFragment = new ChatsFragment();

        tabLayout.setupWithViewPager(viewPager);


        //create viewpager adapter
        //here we will create inner class for adapter
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);

        //add fragments and set the adapter
        viewPagerAdapter.addFragment(homeFragment,"");
        viewPagerAdapter.addFragment(settingsFragment,"");
        viewPagerAdapter.addFragment(chatsFragment,"");
        viewPager.setAdapter(viewPagerAdapter);

        //set the icons
        tabLayout.getTabAt(0).setIcon(R.drawable.android);
        tabLayout.getTabAt(1).setIcon(R.drawable.google_play);
        tabLayout.getTabAt(2).setIcon(R.drawable.heart);

        //set the badge
        BadgeDrawable badgeDrawable = tabLayout.getTabAt(0).getOrCreateBadge();
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(5);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitles = new ArrayList<>();


        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        //add fragment to the viewpager
        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            fragmentTitles.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        //to setup title of the tab layout
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }
    }
}