package com.campos.baseconverter.app;

import android.app.Application;
import android.util.Log;

import com.campos.baseconverter.model.NumSchemeUtils;
import com.campos.baseconverter.model.ThemeUtils;
import com.campos.baseconverter.model.UserHistory;

import static com.campos.baseconverter.util.Tag.TAG;

public class App extends Application {
    public static final String SETTINGS_FILE = "settings";
    public static final String THEME_KEY = "theme_key";
    public static final String NUM_SCHEME_KEY = "num_scheme_key";
    private static int themeCode = -1;
    private static int numSchemeCode = -1;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Starting app...");
        themeCode = ThemeUtils.load(this);
        numSchemeCode = NumSchemeUtils.load(this);
        UserHistory.init(this);
    }

    public static int getThemeCode() {
        return themeCode;
    }

    public static void setThemeCode(int themeCode) {
        App.themeCode = themeCode;
    }

    public static int getNumSchemeCode() {
        return numSchemeCode;
    }

    public static void setNumSchemeCode(int numSchemeCode) {
        App.numSchemeCode = numSchemeCode;
    }
}
