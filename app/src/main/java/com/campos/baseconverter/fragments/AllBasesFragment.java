package com.campos.baseconverter.fragments;

import android.graphics.drawable.GradientDrawable;
import android.graphics.fonts.FontFamily;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.Base;

import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.List;

public class AllBasesFragment extends Fragment {
    private static final String TAG = AllBasesFragment.class.getSimpleName();
    private LinearLayout root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = (LinearLayout) inflater.inflate(R.layout.fragment_all_bases, container, false);
        fillRoot(root);
        return root;
    }

    public void fillRoot(LinearLayout root) {
        Spinner spinner = loadSpinner();
        root.addView(spinner);
        LinearLayout[] layouts = loadOutputFields();
        for (LinearLayout layout : layouts) {
            root.addView(layout);
        }
//        EditText[] fields = loadFields();
//        for (EditText field : fields) {
//            root.addView(field);
//        }
    }

    public Spinner loadSpinner() {
        Spinner spinner = new Spinner(getContext());
        List<String> list = loadItems();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return spinner;
    }

    public List<String> loadItems() {
        Base[] bases = Base.values();
        List<String> list = new LinkedList<>();
        list.add("Convert From");
        for (int i = 0; i < bases.length; i++) {
            String item = bases[i].toString();
            item = item.toLowerCase();
            item = Character.toUpperCase(item.charAt(0)) + item.substring(1);
            item = item.replace('_', ' ');
            list.add(item);
        }
        return list;
    }

    public LinearLayout[] loadOutputFields() {
        LinearLayout[] arr = new LinearLayout[Base.values().length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new LinearLayout(getContext());
            arr[i].setOrientation(LinearLayout.HORIZONTAL);
            TextView lbl = (TextView) TextView.inflate(getContext(), R.layout.my_text_view, null);
            EditText tf = (EditText) EditText.inflate(getContext(), R.layout.my_edit_text, null);
            arr[i].addView(lbl);
            arr[i].addView(tf);
        }
        return arr;
    }

//    public EditText[] loadFields() {
//        EditText[] arr = new EditText[Base.values().length];
//        for (int i = 0; i <arr.length; i++) {
//            arr[i] = (EditText) EditText.inflate(getContext(), R.layout.my_edit_text, null);
//        }
//        return arr;
//    }
}