package com.campos.baseconverter.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseConverter;
import com.campos.baseconverter.model.BaseTextChangeListener;

public class MainBasesFragment extends Fragment {
    private View view;
    private EditText tfBin, tfOct, tfDec, tfHex;
    private BaseConverter baseConverter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_bases, container, false);
        baseConverter = new BaseConverter();
        loadControls();
        return view;
    }

    public void loadControls() {
        loadFields();
        loadFieldListeners();
    }

    public void loadFields() {
        tfBin = view.findViewById(R.id.tf_bin);
        tfOct = view.findViewById(R.id.tf_oct);
        tfDec = view.findViewById(R.id.tf_dec);
        tfHex = view.findViewById(R.id.tf_hex);
    }

    public void loadFieldListeners() {
        tfBin.addTextChangedListener(new BaseTextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean flag = s.toString().matches("[01]+");
                Log.v("APP", "Match? " + flag);
            }
        });
    }
}