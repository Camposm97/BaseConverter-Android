package com.campos.baseconverter.app;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;

import com.campos.baseconverter.model.ConversionHistory;
import com.campos.baseconverter.model.ThemeChooser;

import static com.campos.baseconverter.util.Tag.TAG;

public class App extends Application {
    public static int themeCode = -1;

    public App() {
        Log.d(TAG, "Starting App...");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        themeCode = ThemeChooser.load(this);
        ConversionHistory.init(this);
    }
}
