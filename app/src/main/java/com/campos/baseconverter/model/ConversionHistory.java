package com.campos.baseconverter.model;

import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ConversionHistory {
    private static final String TAG = ConversionHistory.class.getSimpleName();
    private static ConversionHistory history;

    public static void init() {
        try {
            history = load();
        } catch (IOException e) {
            Log.d(TAG, "Failed to load file.  Generating a new history.");
            history = new ConversionHistory();
        }
    }

    private static ConversionHistory load() throws IOException{
        ConversionHistory history;
        FileInputStream fis = new
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
