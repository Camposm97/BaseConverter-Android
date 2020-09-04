package com.campos.baseconverter.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.campos.baseconverter.app.App;

import androidx.appcompat.app.AppCompatDelegate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static com.campos.baseconverter.util.Tag.TAG;

public class ThemeChooser {
    private static final String FILE_NAME = "theme.dat";

    public static void setTheme(Context c, int code) {
        Log.d(TAG, "Setting theme...");
        Log.d(TAG, "code=" + code);
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
                Log.d(TAG, "Invalid theme code!");
        }
        App.themeCode = code;
        save(c, code);
    }

    private static void save(Context c, int code) {
        SharedPreferences pref = c.getSharedPreferences(App.SETTINGS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(App.THEME_KEY, code);
        editor.apply();
//        try {
//            FileOutputStream fis = c.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
//            ObjectOutputStream oos = new ObjectOutputStream(fis);
//            oos.writeInt(code);
//            oos.close();
//            Log.d(TAG, "Successfully saved theme!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static int load(Context c) {
        SharedPreferences pref = c.getSharedPreferences(App.SETTINGS_FILE, Context.MODE_PRIVATE);
        int code = pref.getInt(App.THEME_KEY, -1);
        if (code == -1) {
            Log.d(TAG, "Key doesn't exist");
        } else {
            Log.d(TAG, "Loaded Theme Code (" + code + ")");
        }
        setTheme(c, code);
        return code;
//        try {
//            FileInputStream fis = c.openFileInput(FILE_NAME);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            code = ois.readInt();
//            ois.close();
//            Log.d(TAG, "Successfully loaded theme!");
//        } catch (IOException e) {
//            Log.d(TAG, "Failed to load theme :(");
//        } finally {
//            setTheme(c, code);
//            return code;
//        }
    }
}
