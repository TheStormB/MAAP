package com.example.lab_4.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.lab_4.Fragment1;
import com.example.lab_4.Fragment2;
import com.example.lab_4.Fragment3;
import com.example.lab_4.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private final Context mContext;
    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new Fragment2();
        }else{
            return new Fragment3();
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Fragment 1";
        }else{
            return "Fragment 2";
        }
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}