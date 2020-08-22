package com.campos.baseconverter.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseConverter;
import com.campos.baseconverter.model.BaseOnKeyListener;
import com.campos.baseconverter.util.MyUtils;


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

    public void fillSpinner() { // Simplify code later
        String[] arr = {"Convert From", "Binary", "Octal", "Decimal", "Hexadecimal"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                if (position != 0) {
                    final EditText editText = new EditText(getContext());
                    editText.setInputType(InputType.TYPE_CLASS_TEXT);
                    editText.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getContext());
                    alertBuilder.setTitle("Convert From: " + spinner.getItemAtPosition(position));
                    alertBuilder.setMessage("Please Enter Input:");
                    alertBuilder.setView(editText);
                    alertBuilder.setPositiveButton("Convert", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String item = (String) spinner.getItemAtPosition(position);
                            Base convertFrom = Base.valueOf(item.toUpperCase());
                            String input = editText.getText().toString();
                            if (MyUtils.isValidBase(convertFrom, input)) {
                                BaseConverter baseConverter = new BaseConverter(input, convertFrom);
                                String[] results = baseConverter.getMainResults();
                                EditText[] arr = loadFieldArr();
                                for (int i = 0; i < results.length; i++) {
                                    arr[i].setText(results[i]);
                                }
                            }
                            spinner.setSelection(0);
                        }
                    });
                    alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            clearFields();
                            spinner.setSelection(0);
                        }
                    });
                    alertBuilder.show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void clearFields() {
        EditText[] arr = loadFieldArr();
        for (int i = 0; i < arr.length; i++) {
            arr[i].getText().clear();
        }
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