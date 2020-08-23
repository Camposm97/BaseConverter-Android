package com.campos.baseconverter.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    private List<EditText> tfList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.root = inflater.inflate(R.layout.fragment_all_bases, container, false);
        this.inflater = inflater;
        this.tfList = new LinkedList<>();
        loadSpinner();
        loadViews();
        return root;
    }

    public void loadViews() {
        LinearLayout layoutOutputField = root.findViewById(R.id.layout_output_field);
        LinearLayout[] layouts = loadOutputFields();
        for (int i = 0; i < layouts.length; i++) {
            layoutOutputField.addView(layouts[i]);
        }
    }

    public void loadSpinner() {
        Spinner spinner = root.findViewById(R.id.spinner_all_bases);
        List<String> list = Base.loadSpinnerItemsAllBases();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Base convertFrom = Base.values()[position - 1];
                    Log.v(TAG, convertFrom.toString());

                    
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do Nothing
            }
        });
    }

    public LinearLayout[] loadOutputFields() {
        LinearLayout[] arr = new LinearLayout[Base.values().length];
        for (int i = 0; i < arr.length; i++) {
            Base base = Base.values()[i];
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 0, 0, 20);

            arr[i] = (LinearLayout) inflater.inflate(R.layout.base_output_field_layout, null);
            arr[i].setLayoutParams(layoutParams);

            TextView lbl = (TextView) arr[i].getChildAt(0);
            lbl.setText(Base.toTitle(base));

            EditText tf = (EditText) arr[i].getChildAt(1);
            tfList.add(tf);
        }
        return arr;
    }
}