package com.campos.baseconverter.model;

import android.content.Context;
import android.util.Log;

import com.campos.baseconverter.util.Tag;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ConversionHistory implements Serializable {
    private static final String FILE_NAME = "history.dat";
    private static ConversionHistory history;

    public static void init(Context context) {
        try {
            history = load(context);
            Log.d(Tag.TAG, "Loaded history! :D");
            Log.d(Tag.TAG, history.list.toString());
        } catch (IOException | ClassNotFoundException e)  {
            Log.d(Tag.TAG, "Failed to load file.  Generating a new history.");
            history = new ConversionHistory();
        }
    }

    public static void save(Context c) {
        try {
            FileOutputStream fos = c.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(history);
            oos.close();
            Log.d(Tag.TAG, "Save successful! :D");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(Tag.TAG, "Failed to save");
        }
    }

    private static ConversionHistory load(Context c) throws IOException, ClassNotFoundException {
        FileInputStream fis = c.openFileInput(FILE_NAME);
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

    public BaseNumber[] toArray() {
        return Arrays.copyOf(list.toArray(), list.toArray().length, BaseNumber[].class);
    }

    public void add(BaseNumber baseNumber) {
        list.addFirst(baseNumber);
    }
}
