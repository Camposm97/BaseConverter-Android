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
        final String TAG = "BaseChecker";
        final BaseConverter bc = new BaseConverter();
        tfBin.addTextChangedListener(new BaseTextChangeListener() {
            @Override
            public void afterTextChanged(Editable s) {
                if (MyUtils.isBinary(s.toString())) {
                    Log.v(TAG, "Bin string matches");
                    bc.setConvertFrom(Base.BINARY);
                    bc.setInput(tfBin.getEditableText().toString());
                    String[] results = bc.getMainResults();
                    Log.v(TAG, Arrays.toString(results));
                    displayResults(results);
                }
            }
        });
        tfOct.addTextChangedListener(new BaseTextChangeListener() {
            @Override
            public void afterTextChanged(Editable s) {
                if (MyUtils.isOct(s.toString())) {
                    Log.v(TAG, "Oct string matches");
                }
            }
        });
        tfDec.addTextChangedListener(new BaseTextChangeListener() {
            @Override
            public void afterTextChanged(Editable s) {
                if (MyUtils.isDec(s.toString())) {
                    Log.v(TAG, "Dec string matches");
                }
            }
        });
        tfHex.addTextChangedListener(new BaseTextChangeListener() {
            @Override
            public void afterTextChanged(Editable s) {
                if (MyUtils.isHex(s.toString())) {
                    Log.v(TAG, "Hex string matches");
                }
            }
        });
    }

    private void displayResults(String[] results) {
        EditText[] arr = loadEditTextArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i].setText(results[i]);
        }
    }

    private EditText[] loadEditTextArray() {
        return new EditText[] {tfBin, tfOct, tfDec, tfHex};
    }
}