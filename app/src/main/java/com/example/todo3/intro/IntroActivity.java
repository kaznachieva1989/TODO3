package com.example.todo3.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.todo3.SharedPreference;
import com.example.todo3.main.MainActivity;
import com.example.todo3.R;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class IntroActivity extends AppCompatActivity {

    Button btnNext, btnSkip;
    ViewPager viewPager;
    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        SpringDotsIndicator springDotsIndicator = findViewById(R.id.spring_dots_indicator);



        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        springDotsIndicator.setViewPager(viewPager);

        btnNext = findViewById(R.id.btn_next);
        btnSkip = findViewById(R.id.btn_skip);

        pageChange();

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreference.getInstance(getApplicationContext()).saveShown();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }

    private void pageChange(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page = position;
                switch (position){
                    case 0:
                    case 1:
                        btnSkip.setVisibility(View.VISIBLE);
                        btnNext.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        btnNext.setText("Start");
                        btnNext.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SharedPreference.getInstance(getApplicationContext()).saveShown();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                        });
                        btnSkip.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void next(View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
    }
}
