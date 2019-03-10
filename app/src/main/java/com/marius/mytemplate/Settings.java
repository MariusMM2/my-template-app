package com.marius.mytemplate;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatDelegate;

public class Settings {
    private static Settings instance;

    public static Settings getInstance(Context context) {
        if (instance == null) instance = new Settings(context);
        return instance;
    }

    private static class Key {
        private static final String NIGHT_MODE = "nightMode";
    }

    public boolean nightMode;

    private Settings(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
        nightMode = prefs.getBoolean(Key.NIGHT_MODE, false);
    }

    public void save(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putBoolean(Key.NIGHT_MODE, nightMode);

        editor.apply();
    }

    public void refreshTheme() {
        AppCompatDelegate.setDefaultNightMode(nightMode ?
                AppCompatDelegate.MODE_NIGHT_YES :
                AppCompatDelegate.MODE_NIGHT_NO);
    }
}
