package com.campos.baseconverter.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.campos.baseconverter.app.App;

import androidx.appcompat.app.AppCompatDelegate;

import static com.campos.baseconverter.util.D.E;

public class ThemeUtils {
    public static void setTheme(Context c, int code) {
        Log.d(E, "Setting theme...");
        Log.d(E, "code=" + code);
        switch (code) {
            case 0:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case 1:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case 2:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;
            default:
                Log.d(E, "Invalid theme code!");
        }
    }

    public static void save(Context c, int code) {
        SharedPreferences pref = c.getSharedPreferences(App.getSettingsFile(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(App.getThemeKey(), code);
        editor.apply();
    }

    public static int load(Context c) {
        SharedPreferences pref = c.getSharedPreferences(App.getSettingsFile(), Context.MODE_PRIVATE);
        int code = pref.getInt(App.getThemeKey(), -1);
        setTheme(c, code);
        return code;
    }
}
