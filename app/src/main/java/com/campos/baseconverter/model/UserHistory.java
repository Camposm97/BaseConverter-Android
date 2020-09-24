package com.campos.baseconverter.model;

import android.content.Context;
import android.util.Log;

import com.campos.baseconverter.util.D;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class UserHistory implements Serializable {
    private static final String FILE_NAME = "history.dat";
    private static UserHistory history;

    public static void init(Context context) {
        try {
            history = load(context);
            Log.d(D.E, "Loaded history! :D");
            Log.d(D.E, history.list.toString());
        } catch (IOException | ClassNotFoundException e)  {
            Log.d(D.E, "Failed to load file.  Generating a new history.");
            history = new UserHistory();
        }
    }

    public static void save(Context c) {
        try {
            FileOutputStream fos = c.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(history);
            oos.close();
            Log.d(D.E, "Save successful! :D");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(D.E, "Failed to save");
        }
    }

    private static UserHistory load(Context c) throws IOException, ClassNotFoundException {
        FileInputStream fis = c.openFileInput(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis);
        UserHistory history = (UserHistory) ois.readObject();
        ois.close();
        return history;
    }

    public static UserHistory getHistory() {
        return history;
    }

    private LinkedList<HistoryItem> list;

    private UserHistory() {
        this.list = new LinkedList<>();
    }

    public List<HistoryItem> getList() {
        return list;
    }

    public void add(BaseNumber input, BaseNumber[] resultsArr) {
        list.addFirst(new HistoryItem(input, resultsArr));
    }

    public class HistoryItem implements Serializable {
        private BaseNumber input;
        private BaseNumber[] resultsArr;

        public HistoryItem(BaseNumber input, BaseNumber[] resultsArr) {
            this.input = input;
            this.resultsArr = resultsArr;
        }

        public BaseNumber getInput() {
            return input;
        }

        public BaseNumber[] getResultsArr() {
            return resultsArr;
        }
    }
}
