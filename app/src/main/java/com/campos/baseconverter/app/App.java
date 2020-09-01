package com.campos.baseconverter.app;

import android.app.Application;
import android.util.Log;

import com.campos.baseconverter.model.ConversionHistory;

import static com.campos.baseconverter.util.Tag.TAG;

public class App extends Application {
    public App() {
        Log.d(TAG, "Starting App...");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ConversionHistory.init(this);
    }
}
