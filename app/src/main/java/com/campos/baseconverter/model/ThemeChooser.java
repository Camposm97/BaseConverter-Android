package com.campos.baseconverter.model;

import androidx.appcompat.app.AppCompatDelegate;

public class ThemeChooser {
    private static final String FILE_NAME = "theme.dat";

    public static void setTheme(int which) {
        switch (which) {
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
    }

    
}
