package com.campos.baseconverter.app;

import android.app.Application;
import android.util.Log;

import com.campos.baseconverter.model.ConversionHistory;

import androidx.appcompat.app.AppCompatDelegate;

import static com.campos.baseconverter.util.Tag.TAG;

public class App extends Application {
    public App() {
        Log.d(TAG, "Starting App...");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // This is good to know! :D
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        ConversionHistory.init(this);
    }
}
