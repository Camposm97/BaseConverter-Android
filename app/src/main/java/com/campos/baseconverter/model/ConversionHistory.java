package com.campos.baseconverter.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;

import com.campos.baseconverter.util.Tag;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.Inflater;

public class ConversionHistory implements Serializable {
    private static ConversionHistory history;

    public static void init(Activity activity) {
        try {
            history = load(activity);
            Log.d(Tag.TAG, "Loaded history! :D");
            Log.d(Tag.TAG, history.getList().toString());
        } catch (IOException | ClassNotFoundException e)  {
            Log.d(Tag.TAG, "Failed to load file.  Generating a new history.");
            history = new ConversionHistory();
        }
    }

    public static void save(Activity a) {
        final String FILE_NAME = "history.dat";
        try {
            FileOutputStream fos = a.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(history);
            oos.close();
            Log.d(Tag.TAG, "Save successful! :D");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(Tag.TAG, "Failed to save");
        }
    }

    private static ConversionHistory load(Activity a) throws IOException, ClassNotFoundException {
        final String FILE_NAME = "history.dat";
        FileInputStream fis = a.openFileInput(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ConversionHistory history = (ConversionHistory) ois.readObject();
        ois.close();
        return history;
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
