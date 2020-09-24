package com.campos.baseconverter.app;

import android.app.Application;
import android.util.Log;

import com.campos.baseconverter.util.NumSchemeUtils;
import com.campos.baseconverter.util.ThemeUtils;
import com.campos.baseconverter.model.UserHistory;

import static com.campos.baseconverter.util.D.E;

public class App extends Application {
    private static final String SETTINGS_FILE = "settings";
    private static final String THEME_KEY = "theme_key";
    private static final String NUM_SCHEME_KEY = "num_scheme_key";
    public static int themeCode = -1;
    public static int numSchemeCode = -1;

/*
TODO:
        
 */

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(E, "Starting app...");
        themeCode = ThemeUtils.load(this);
        numSchemeCode = NumSchemeUtils.load(this);
        UserHistory.init(this);
    }

    public static String getSettingsFile() {
        return SETTINGS_FILE;
    }

    public static String getThemeKey() {
        return THEME_KEY;
    }

    public static String getNumSchemeKey() {
        return NUM_SCHEME_KEY;
    }
}
