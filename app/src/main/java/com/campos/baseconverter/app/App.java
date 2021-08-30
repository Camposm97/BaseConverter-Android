package com.campos.baseconverter.app;

import android.app.Application;
import android.util.Log;

import com.campos.baseconverter.util.NumSchemeUtils;
import com.campos.baseconverter.util.ThemeUtils;
import com.campos.baseconverter.model.UserHistory;

import static com.campos.baseconverter.util.D.E;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private static final String SETTINGS_FILE = "settings";
    private static final String THEME_KEY = "theme_key";
    private static final String NUM_SCHEME_KEY = "num_scheme_key";
    public static int themeCode = -1;
    public static int numSchemeCode = -1;

/*
TODO:
    The way I'm seeing how to make my application more clean is that my navigation view will have 3 menu items to choose from
    which will be whole numbers, floating point numbers, and ieee754 for now.  When the user clicks on whole or floating point
    the way they will be displayed is it will show the main bases and in the settings it will have the option to display all the bases.
    IEEE754 will only be taking in hex, binary, and decimal as input.
 */

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(E, "Starting app...");
        themeCode = ThemeUtils.load(this);
        numSchemeCode = NumSchemeUtils.load(this);
        UserHistory.init(this);
        List list = new ArrayList();
        list.stream().count();

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
