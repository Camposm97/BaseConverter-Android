package com.campos.baseconverter.view.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseConverter;
import com.campos.baseconverter.model.BaseInputDialogBuilder;
import com.campos.baseconverter.model.BaseNumber;
import com.campos.baseconverter.model.BaseNumberViewAdapter;
import com.campos.baseconverter.model.ConversionHistory;
import com.campos.baseconverter.model.InvalidBaseNumberException;
import com.campos.baseconverter.util.AlertHelper;

import java.util.List;

import static com.campos.baseconverter.util.Tag.TAG;

public class MainBasesFragment extends Fragment {
    private View view;
    private RecyclerView rv;
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_bases, container, false);
        loadRecycler();
        loadSpinner();
        return view;
    }

    public void loadRecycler() {
        rv = view.findViewById(R.id.recycler_main_bases);
        rv.setAdapter(new BaseNumberViewAdapter(getContext(), BaseNumber.getMain()));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

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
        final String chosenItem = (String) spinner.getItemAtPosition(position);
        final BaseInputDialogBuilder dialogBuilder = new BaseInputDialogBuilder(getContext(), chosenItem);
        dialogBuilder.setPositiveButton("Convert", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Base convertFrom = Base.valueOf(chosenItem.toUpperCase());
                String value = dialogBuilder.getTfInput().getText().toString();
                attemptBaseConversion(new BaseNumber(convertFrom, value));
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                rv.setAdapter(new BaseNumberViewAdapter(getContext(), BaseNumber.getMain()));
                spinner.setSelection(0);
            }
        });
        dialogBuilder.show();
    }

    public void attemptBaseConversion(BaseNumber baseNumber) {
        try {
            Log.d(TAG, baseNumber.toString());
            BaseConverter baseConverter = new BaseConverter(baseNumber);
            ConversionHistory.getHistory().add(baseNumber);
            ConversionHistory.save(getActivity());
            BaseNumber[] resultsArr = baseConverter.getMainResults();
            rv.setAdapter(new BaseNumberViewAdapter(getContext(), resultsArr));
        } catch (InvalidBaseNumberException e) {
            AlertHelper.showInvalidBaseNumInput(getContext());
        } finally {
            spinner.setSelection(0);
        }
    }
}