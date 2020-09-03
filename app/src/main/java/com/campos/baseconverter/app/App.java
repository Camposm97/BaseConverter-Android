package com.campos.baseconverter.app;

import android.app.Application;
import android.util.Log;

import com.campos.baseconverter.model.NumSchemeChooser;
import com.campos.baseconverter.model.ThemeChooser;
import com.campos.baseconverter.model.UserHistory;

import static com.campos.baseconverter.util.Tag.TAG;

public class App extends Application {
    private static final String PREF_FILE = "options.properties";
    public static int themeCode = -1;
    public static int numSchemeCode = -1;

    public App() {
        Log.d(TAG, "Starting App...");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        themeCode = ThemeChooser.load(this);
        numSchemeCode = NumSchemeChooser.load(this);
        UserHistory.init(this);
        /*
        SharedPreferences - something I can use in the future instead of saving dat files
        I can make the program run faster if I save history with not only the BaseNumber, but
        with all of it's results: BaseNumber[]
         */
    }

    public static String getPrefFile() {
        return PREF_FILE;
    }
}
