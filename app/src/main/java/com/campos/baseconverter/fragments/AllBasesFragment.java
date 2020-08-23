package com.campos.baseconverter.fragments;

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

import androidx.fragment.app.Fragment;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.Base;

import java.util.LinkedList;
import java.util.List;

public class AllBasesFragment extends Fragment {
    private static final String TAG = AllBasesFragment.class.getSimpleName();
    private View root;
    private LayoutInflater inflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.root = inflater.inflate(R.layout.fragment_all_bases, container, false);
        this.inflater = inflater;
//        fillSpinner();
        fillRoot(root);
        return root;
    }

    public void fillRoot(LinearLayout root) {
//        fillSpinner();
        LinearLayout[] layouts = loadOutputFields();
        for (int i = 0; i < layouts.length; i++) {
            root.addView(layouts[i]);
        }
    }

    public void fillSpinner() {
        Spinner spinner = root.findViewById(R.id.spinner_all_bases);
        List<String> list = loadItems();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
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
        Base[] bases = Base.values();
        LinearLayout[] arr = new LinearLayout[Base.values().length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (LinearLayout) inflater.inflate(R.layout.base_output_field_layout, null);
            TextView lbl = (TextView) inflater.inflate(R.layout.my_text_view_layout, null);
            String title = bases[i].toString();
            Log.v(TAG, title);
            lbl.setText(title);
            EditText tf = (EditText) inflater.inflate(R.layout.my_edit_text_layout, null);
            arr[i].addView(lbl);
            arr[i].addView(tf);
        }
        return arr;
    }

//    public EditText[] loadFields() {
//        EditText[] arr = new EditText[Base.values().length];
//        for (int i = 0; i <arr.length; i++) {
//            arr[i] = (EditText) EditText.inflate(getContext(), R.layout.my_edit_text_layout, null);
//        }
//        return arr;
//    }
}