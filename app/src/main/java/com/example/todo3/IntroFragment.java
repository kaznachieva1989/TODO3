package com.example.todo3;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class IntroFragment extends Fragment {
    public ViewPager viewPager;


    public IntroFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textTitle = view.findViewById(R.id.textTitle);
        viewPager = view.findViewById(R.id.viewPager);

        final int pos = getArguments().getInt("pos");
        switch (pos) {
            case 0:
                textTitle.setText("Привет");
                break;
            case 1:
                textTitle.setText("Как дела");
                break;
            case 2:
                textTitle.setText("Отлично");
                break;
        }
    }
}
