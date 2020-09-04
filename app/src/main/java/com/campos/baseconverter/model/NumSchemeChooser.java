package com.campos.baseconverter.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.campos.baseconverter.app.App;

public class NumSchemeChooser {
    public static void save(Context c, int code) {
        SharedPreferences pref = c.getSharedPreferences(App.SETTINGS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(App.NUM_SCHEME_KEY, code);
        editor.apply();
    }

    public static int load(Context c) {
        SharedPreferences pref = c.getSharedPreferences(App.SETTINGS_FILE, Context.MODE_PRIVATE);
        return pref.getInt(App.NUM_SCHEME_KEY, -1);
    }
}
