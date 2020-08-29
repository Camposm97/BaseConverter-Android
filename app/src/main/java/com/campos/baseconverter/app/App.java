package com.campos.baseconverter.app;

import android.app.Application;
import android.util.Log;

import com.campos.baseconverter.util.Tag;

public class App extends Application {
    public App() {
        Log.d(Tag.TAG, "Starting App...");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        
        Log.d(Tag.TAG, "onCreate() fired!");
    }
}
