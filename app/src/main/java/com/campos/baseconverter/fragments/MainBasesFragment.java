package com.campos.baseconverter.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseConverter;
import com.campos.baseconverter.model.BaseOnKeyListener;
import com.campos.baseconverter.model.BaseTextChangeListener;
import com.campos.baseconverter.util.MyUtils;

import java.util.Arrays;

public class MainBasesFragment extends Fragment {
    private View view;
    private EditText tfBin, tfOct, tfDec, tfHex;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_bases, container, false);
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
        final EditText[] arr = loadEditTextArray();
        tfBin.setOnKeyListener(new BaseOnKeyListener(tfBin, arr, Base.BINARY));
        tfOct.setOnKeyListener(new BaseOnKeyListener(tfOct, arr, Base.OCTAL));
        tfDec.setOnKeyListener(new BaseOnKeyListener(tfDec, arr, Base.DECIMAL));
        tfHex.setOnKeyListener(new BaseOnKeyListener(tfHex, arr, Base.HEXADECIMAL));
    }

    private EditText[] loadEditTextArray() {
        return new EditText[] {tfBin, tfOct, tfDec, tfHex};
    }
}