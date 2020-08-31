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

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseConverter;
import com.campos.baseconverter.model.BaseInputDialogBuilder;
import com.campos.baseconverter.model.BaseNumber;
import com.campos.baseconverter.model.ConversionHistory;
import com.campos.baseconverter.model.InvalidBaseNumberException;
import com.campos.baseconverter.util.AlertHelper;
import com.campos.baseconverter.util.MyUtils;

import java.util.List;


public class MainBasesFragment extends Fragment {
    private View view;
//    private EditText tfBin, tfOct, tfDec, tfHex;
    private RecyclerView rv;
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_bases, container, false);
//        loadControls();
        loadRecycler();
        loadSpinner();
        return view;
    }

    public void loadRecycler() {
        rv = null;

    }

//    public void loadControls() {
//        tfBin = root.findViewById(R.id.tf_bin);
//        tfOct = root.findViewById(R.id.tf_oct);
//        tfDec = root.findViewById(R.id.tf_dec);
//        tfHex = root.findViewById(R.id.tf_hex);
//    }

    public void loadSpinner() {
        spinner = view.findViewById(R.id.spinner_main_bases);
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
//                clearFields();
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
            ConversionHistory.getHistory().add(baseNumber);
            ConversionHistory.save(getActivity());
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
    }

//    public void clearFields() {
//        EditText[] arr = loadOutputs();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i].getText().clear();
//        }
//    }
//
//    private EditText[] loadOutputs() {
//        return new EditText[]{tfBin, tfOct, tfDec, tfHex};
//    }
}