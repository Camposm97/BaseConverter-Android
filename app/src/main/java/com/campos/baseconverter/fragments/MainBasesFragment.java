package com.campos.baseconverter.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseConverter;
import com.campos.baseconverter.model.BaseTextChangeListener;
import com.campos.baseconverter.util.MyUtils;

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
        final String TAG = "BaseChecker";
        tfBin.addTextChangedListener(new BaseTextChangeListener() {
            @Override
            public void afterTextChanged(Editable s) {
                if (MyUtils.isBinary(s.toString())) {
                    Log.v(TAG, "Binary string matches");
                } else {
                    Log.v(TAG, "Binary string does NOT match");
                }
            }
        });
        tfOct.addTextChangedListener(new BaseTextChangeListener() {
            @Override
            public void afterTextChanged(Editable s) {
                if (MyUtils.isOctal(s.toString())) {
                    Log.v(TAG, "Octal string matches");
                } else {
                    Log.v(TAG, "Octal string does NOT match");
                }
            }
        });
        tfDec.addTextChangedListener(new BaseTextChangeListener() {
            @Override
            public void afterTextChanged(Editable s) {
                if (MyUtils.isDec(s.toString())) {
                    Log.v(TAG, "Decimal string matches");
                } else {
                    Log.v(TAG, "Decimal string does NOT match");
                }
            }
        });
        tfHex.addTextChangedListener(new BaseTextChangeListener() {
            @Override
            public void afterTextChanged(Editable s) {
                if (MyUtils.isBase(Base.HEXADECIMAL, s.toString())) {
                    Log.v(TAG, "Hex string matches");
                }
            }
        });
    }
}