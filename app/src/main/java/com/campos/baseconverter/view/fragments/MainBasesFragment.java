package com.campos.baseconverter.view.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseConverter;
import com.campos.baseconverter.model.BaseInputDialogBuilder;
import com.campos.baseconverter.model.BaseNumber;
import com.campos.baseconverter.model.InvalidBaseNumberException;
import com.campos.baseconverter.util.AlertHelper;
import com.campos.baseconverter.util.MyUtils;

import java.util.List;


public class MainBasesFragment extends Fragment {
    private View root;
    private EditText tfBin, tfOct, tfDec, tfHex;
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main_bases, container, false);
        loadControls();
        loadSpinner();
        return root;
    }

    public void loadControls() {
        spinner = root.findViewById(R.id.spinner_main_bases);
        tfBin = root.findViewById(R.id.tf_bin);
        tfOct = root.findViewById(R.id.tf_oct);
        tfDec = root.findViewById(R.id.tf_dec);
        tfHex = root.findViewById(R.id.tf_hex);
    }

    public void loadSpinner() {
        List<String> list = Base.loadSpinnerItemMainBases();
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                if (position != 0) {
                    showBaseInputDialog(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void showBaseInputDialog(int position) {
        String chosenItem = (String) spinner.getItemAtPosition(position);
        final Base convertFrom = Base.valueOf(chosenItem.toUpperCase());
        BaseInputDialogBuilder dialogBuilder = new BaseInputDialogBuilder(getContext(), chosenItem);
        final EditText tfInput = dialogBuilder.getTfInput();
        dialogBuilder.setPositiveButton("Convert", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                attemptBaseConversion(convertFrom, tfInput.getText().toString());
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clearFields();
                spinner.setSelection(0);
            }
        });
        dialogBuilder.show();
    }

    public void attemptBaseConversion(Base convertFrom, String input) {
        try {
            BaseNumber baseNumber = new BaseNumber(convertFrom, input);
            BaseConverter baseConverter = new BaseConverter(baseNumber);
            BaseNumber[] results = baseConverter.getMainResults();
            EditText[] arr = loadOutputs();
            for (int i = 0; i < results.length; i++) {
                if (i == 0) {
                    arr[i].setText(MyUtils.formatBinStr(results[i].getValue()));
                } else {
                    arr[i].setText(results[i].getValue());
                }
            }
        } catch (InvalidBaseNumberException e) {
            AlertHelper.showInvalidBaseNumInput(getContext());
        } finally {
            spinner.setSelection(0);
        }
//        try {
//            BaseNumber baseNumber = new BaseNumber(convertFrom, input);
//            BaseConverter baseConverter = new BaseConverter(baseNumber);
//            String[] results = baseConverter.getMainResults();
//            EditText[] arr = loadOutputs();
//            for (int i = 0; i < results.length; i++) {
//                if (i == 0) {
//                    arr[i].setText(MyUtils.formatBinStr(results[i]));
//                } else {
//                    arr[i].setText(results[i]);
//                }
//            }
//        } catch (InvalidBaseNumberException e) {
//            Toast.makeText(getContext(), R.string.invalid_base_num_message, Toast.LENGTH_SHORT).show();
//        } finally {
//            spinner.setSelection(0);
//        }
    }

    public void clearFields() {
        EditText[] arr = loadOutputs();
        for (int i = 0; i < arr.length; i++) {
            arr[i].getText().clear();
        }
    }

    private EditText[] loadOutputs() {
        return new EditText[]{tfBin, tfOct, tfDec, tfHex};
    }
}