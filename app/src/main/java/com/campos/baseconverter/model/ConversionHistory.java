package com.campos.baseconverter.model;

import android.content.res.AssetManager;
import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

public class ConversionHistory {
    private static final String TAG = ConversionHistory.class.getSimpleName();
    private static ConversionHistory history;

    public static void init(AssetManager assets) {
        try {
            history = load(assets);
        } catch (IOException | ClassNotFoundException e)  {
            Log.d(TAG, "Failed to load file.  Generating a new history.");
            history = new ConversionHistory();
        }
    }

    private static ConversionHistory load(AssetManager assets) throws IOException, ClassNotFoundException {
        final String FILE_NAME = "history.dat";
        Log.d(TAG, assets.toString());
        InputStream is = assets.open(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(is);
        return (ConversionHistory) ois.readObject();
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
