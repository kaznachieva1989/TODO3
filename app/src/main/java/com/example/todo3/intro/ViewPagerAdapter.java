package com.example.todo3.intro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.todo3.intro.IntroFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        IntroFragment introFragment = new IntroFragment();
        introFragment.setArguments(bundle);
        return introFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
