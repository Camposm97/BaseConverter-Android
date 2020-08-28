package com.campos.baseconverter.model;

import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ConversionHistory {
    private static final String TAG = ConversionHistory.class.getSimpleName();
    private static ConversionHistory history;

    public static void init(AssetManager assets) {
        try {
            history = load(assets);
        } catch (IOException e) {
            Log.d(TAG, "Failed to load file.  Generating a new history.");
            history = new ConversionHistory();
        }
    }

    private static ConversionHistory load(AssetManager assets) throws IOException{
        ConversionHistory history = null;
        FileInputStream fis = new FileInputStream(assets.toString());
        return history;
    }

    public static ConversionHistory getHistory() {
        return history;
    }


    private List<BaseNumber> list;

    private ConversionHistory() {
        this.list = new LinkedList<>();
    }

    public List<BaseNumber> getList() {
        return list;
    }
}
