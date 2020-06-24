package com.example.todo3.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.example.todo3.R;
import com.example.todo3.SharedPreference;
import com.example.todo3.intro.IntroActivity;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    List<String> list = new ArrayList<>();
    ArrayAdapter<String> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isShown = SharedPreference.getInstance(this).isShown();
        if (!isShown) {
            startActivity(new Intent(this, IntroActivity.class));
            finish();
            return;
        }
        spinner = (Spinner) findViewById(R.id.spinner_services);
        spinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        list.add("Type");
        list.add("Board games");
        list.add("Card games");
        list.add("Dice games");
        list.add("Strategy games");

        spinnerAdapter.addAll(list);
        spinnerAdapter.notifyDataSetChanged();

        final CrystalRangeSeekbar rangeSeekbar = findViewById(R.id.rangeSeekbar3);
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
            }
        });

        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                //Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int selectedPosition = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
