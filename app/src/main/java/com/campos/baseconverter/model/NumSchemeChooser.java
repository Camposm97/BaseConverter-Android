package com.campos.baseconverter.model;

import android.content.Context;
import android.util.Log;

import com.campos.baseconverter.app.App;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static com.campos.baseconverter.util.Tag.TAG;

public class NumSchemeChooser {
    private static final String FILE_NAME = "num_scheme.dat";

    public static void setScheme(Context c, int code) {
        Log.d(TAG, "Setting Number Scheme...");
        Log.d(TAG, "code=" + code);
        App.numSchemeCode = code;
        save(c, code);
    }

    private static void save(Context c, int code) {
        try {
            FileOutputStream fis = c.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeInt(code);
            oos.close();
            Log.d(TAG, "Successfully saved number scheme!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int load(Context c) {
        int code = -1;
        try {
            FileInputStream fis = c.openFileInput(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            code = ois.readInt();
            ois.close();
            Log.d(TAG, "Successfully loaded number scheme!");
        } catch (IOException e) {
            Log.d(TAG, "Failed t load nunber scheme :(");
        } finally {
            setScheme(c, code);
            return code;
        }
    }
}
