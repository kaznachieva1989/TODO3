package com.example.todo3;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    private static volatile SharedPreference instance;

    private SharedPreferences preferences;

    public SharedPreference(Context context) {
        instance = this;
        preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    public static SharedPreference getInstance(Context context) {
        if (instance == null) new SharedPreference(context);
        return instance;
    }

    public boolean isShown() {
        return preferences.getBoolean("isShown", false);
    }

    public void saveShown() {
        preferences.edit().putBoolean("isShown", true).apply();
    }
}
