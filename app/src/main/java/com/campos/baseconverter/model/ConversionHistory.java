package com.campos.baseconverter.model;

import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.Inflater;

public class ConversionHistory implements Serializable {
    private static final String TAG = ConversionHistory.class.getSimpleName();
    private static ConversionHistory history;

    public static void init(Activity activity) {
        try {
            history = load(activity);
            Log.d(TAG, "Loaded history! :D");
            Log.d(TAG, history.getList().toString());
        } catch (IOException | ClassNotFoundException e)  {
            Log.d(TAG, "Failed to load file.  Generating a new history.");
            history = new ConversionHistory();
        }
    }

    private static ConversionHistory load(Activity activity) throws IOException, ClassNotFoundException {
        final String FILE_NAME = "history.dat";
        FileInputStream fis = activity.openFileInput(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (ConversionHistory) ois.readObject();
    }

    public static ConversionHistory getHistory() {
        return history;
    }


    private LinkedList<BaseNumber> list;

    private ConversionHistory() {
        this.list = new LinkedList<>();
    }

    public List<BaseNumber> getList() {
        return list;
    }

    public void add(BaseNumber baseNumber) {
        list.addFirst(baseNumber);
    }
}
