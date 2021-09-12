package com.campos.baseconverter.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.campos.baseconverter.app.App;

import androidx.appcompat.app.AppCompatDelegate;


public class ThemeUtils {
    public static void setTheme(Context c, int code) {
        System.out.println("Setting theme...");
        System.out.println("code=" + code);
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
                System.out.println("Invalid theme code!");
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
