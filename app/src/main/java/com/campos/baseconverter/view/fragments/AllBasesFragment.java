package com.campos.baseconverter.view.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
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
import com.campos.baseconverter.model.AllBasesViewAdapter;
import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseConverter;
import com.campos.baseconverter.model.BaseInputDialogBuilder;
import com.campos.baseconverter.model.BaseNumber;
import com.campos.baseconverter.model.ConversionHistory;
import com.campos.baseconverter.model.HistoryViewAdapter;
import com.campos.baseconverter.model.InvalidBaseNumberException;
import com.campos.baseconverter.util.AlertHelper;
import com.campos.baseconverter.util.MyUtils;

import java.util.LinkedList;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.campos.baseconverter.util.Tag.TAG;

public class AllBasesFragment extends Fragment {
    private View root;
    private RecyclerView rv;
    private Spinner spinner;
    private List<EditText> outputList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.root = inflater.inflate(R.layout.fragment_all_bases, container, false);
        this.outputList = new LinkedList<>();
        loadRecycler();
        loadSpinner();
//        loadViewsInRoot();
        return root;
    }

    public void loadRecycler() {
        AllBasesViewAdapter adapter = new AllBasesViewAdapter(getContext());
        RecyclerView.ItemDecoration itemDecor = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rv = root.findViewById(R.id.recycler_all_bases);
        rv.addItemDecoration(itemDecor);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void loadSpinner() {
        spinner = root.findViewById(R.id.spinner_all_bases);
        List<String> list = Base.loadSpinnerItemsAllBases();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                if (position != 0) {
//                    showBaseInputDialog(position);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

//    public void showBaseInputDialog(final int position) {
//        String chosenItem = (String) spinner.getItemAtPosition(position);
//        BaseInputDialogBuilder dialogBuilder = new BaseInputDialogBuilder(getContext(), chosenItem);
//        final EditText tfInput = dialogBuilder.getTfInput();
//        dialogBuilder.setPositiveButton("Convert", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Base convertFrom = Base.values()[position - 1];
//                String input = tfInput.getText().toString();
//                attemptBaseConversion(convertFrom, input);
//            }
//        });
//        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                clearFields();
//                spinner.setSelection(0);
//            }
//        });
//        dialogBuilder.show();
//    }

//    public void attemptBaseConversion(Base convertFrom, String input) {
//        try {
//            BaseNumber baseNumber = new BaseNumber(convertFrom, input);
//            BaseConverter baseConverter = new BaseConverter(baseNumber);
//            ConversionHistory.getHistory().add(baseNumber);
//            ConversionHistory.save(getActivity());
//            BaseNumber[] results = baseConverter.getAllResults();
//            for (int i = 0; i < outputList.size(); i++) {
//                if (i == 0) {
//                    outputList.get(i).setText(MyUtils.formatBinStr(results[i].getValue()));
//                } else {
//                    outputList.get(i).setText(results[i].getValue());
//                }
//            }
//        } catch (InvalidBaseNumberException e) {
//            AlertHelper.showInvalidBaseNumInput(getContext());
//        } finally {
//            spinner.setSelection(0);
//        }
//    }

//    public void loadViewsInRoot() {
//        LinearLayout layoutOutputField = root.findViewById(R.id.layout_output_field);
//        ConstraintLayout[] layouts = loadOutputLayouts();
//        for (int i = 0; i < layouts.length; i++) {
//            layoutOutputField.addView(layouts[i]);
//        }
//    }

//    public ConstraintLayout[] loadOutputLayouts() {
//        ConstraintLayout[] arr = new ConstraintLayout[Base.values().length];
//        for (int i = 0; i < arr.length; i++) {
//            Base base = Base.values()[i];
//            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
//                    LinearLayout.LayoutParams.MATCH_PARENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT);
//            layoutParams.setMargins(0, 0, 0, 10);
//
//            arr[i] = (ConstraintLayout) root.inflate(getContext(), R.layout.base_output_layout, null);
//            arr[i].setLayoutParams(layoutParams);
//
//            TextView lbl = (TextView) arr[i].getChildAt(0);
//            lbl.setText(Base.toTitle(base));
//
//            EditText tf = (EditText) arr[i].getChildAt(1);
//            outputList.add(tf);
//        }
//        return arr;
//    }

//    public void clearFields() {
//        for (EditText tf : outputList) {
//            tf.getText().clear();
//        }
//    }
}