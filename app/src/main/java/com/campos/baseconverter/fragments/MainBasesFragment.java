package com.campos.baseconverter.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextDirectionHeuristics;
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

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseOnKeyListener;


public class MainBasesFragment extends Fragment {
    private View view;
    private EditText tfBin, tfOct, tfDec, tfHex;
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_bases, container, false);
        loadControls();
        fillSpinner();
        return view;
    }

    public void loadControls() {
        spinner = view.findViewById(R.id.spinner_main_bases);
        tfBin = view.findViewById(R.id.tf_bin);
        tfOct = view.findViewById(R.id.tf_oct);
        tfDec = view.findViewById(R.id.tf_dec);
        tfHex = view.findViewById(R.id.tf_hex);
        loadFieldListeners();
    }

    public void fillSpinner() {
        String[] arr = {"Convert From", "Binary", "Octal", "Decimal", "Hexadecimal"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void loadFieldListeners() {
        /*
        Maybe I can have it where there's a combo box the user can choose from such as Binary,
        then the binary field will be editable and have a text change listener that takes the input
        from that field and convert them to the other fields.  Also the other fields are uneditable
        and can only be editable if the combo box is set to that base for that field to display
         */
        final EditText[] arr = loadFieldArr();
        tfBin.setOnKeyListener(new BaseOnKeyListener(tfBin, arr, Base.BINARY));
        tfOct.setOnKeyListener(new BaseOnKeyListener(tfOct, arr, Base.OCTAL));
        tfDec.setOnKeyListener(new BaseOnKeyListener(tfDec, arr, Base.DECIMAL));
        tfHex.setOnKeyListener(new BaseOnKeyListener(tfHex, arr, Base.HEXADECIMAL));
    }

    private EditText[] loadFieldArr() {
        return new EditText[] {tfBin, tfOct, tfDec, tfHex};
    }
}