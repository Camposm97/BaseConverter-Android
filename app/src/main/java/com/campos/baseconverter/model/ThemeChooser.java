package com.campos.baseconverter.model;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatDelegate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static com.campos.baseconverter.util.Tag.TAG;

public class ThemeChooser {
    private static final String FILE_NAME = "theme.dat";

    public static void setTheme(Context c, int code) {
        Log.d(TAG, "Setting theme...");
        Log.d(TAG, "code=" + code);
        switch (code) {
            case 0:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                saveTheme(c, code);
                break;
            case 1:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                saveTheme(c, code);
                break;
            case 2:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                saveTheme(c, code);
                break;
            default:
                Log.d(TAG, "Invalid theme code!");
        }
    }

    private static void saveTheme(Context c, int code) {
        try {
            FileOutputStream fis = c.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeInt(code);
            oos.close();
            Log.d(TAG, "Successfully saved theme!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int load(Context c) {
        int code = -1;
        try {
            FileInputStream fis = c.openFileInput(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            code = ois.readInt();
            ois.close();
            Log.d(TAG, "Successfully loaded theme!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            setTheme(c, code);
            return code;
        }
    }
}
