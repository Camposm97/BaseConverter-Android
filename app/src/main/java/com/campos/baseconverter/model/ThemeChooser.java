package com.campos.baseconverter.model;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatDelegate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.campos.baseconverter.util.Tag.TAG;

public class ThemeChooser {
    private static final String FILE_NAME = "theme.dat";

    public static void setTheme(Context c, int code) {
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
        }
        saveTheme(c, code);
    }

    private static void saveTheme(Context c, int code) {
        try {
            FileOutputStream fis = c.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fis.write(code);
            fis.close();
            Log.d(TAG, "Successfully saved theme!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static int load(Context c) {
        int code = -1;
        try {
            FileInputStream fis = c.openFileInput(FILE_NAME);
            code = fis.read();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            setTheme(c, code);
            return code;
        }
    }
}
