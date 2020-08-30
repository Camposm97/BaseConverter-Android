package com.campos.baseconverter.view.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.BaseConverter;
import com.campos.baseconverter.model.BaseNumber;
import com.campos.baseconverter.model.BaseNumberViewAdapter;
import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseInputDialogBuilder;
import com.campos.baseconverter.model.BaseNumberViewHolder;
import com.campos.baseconverter.model.ConversionHistory;
import com.campos.baseconverter.model.InvalidBaseNumberException;
import com.campos.baseconverter.util.AlertHelper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.campos.baseconverter.util.Tag.TAG;

public class AllBasesFragment extends Fragment {
    private View root;
    private RecyclerView rv;
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.root = inflater.inflate(R.layout.fragment_all_bases, container, false);
        loadRecycler();
        loadSpinner();
        return root;
    }

    public void loadRecycler() {
        List<String> listLbl = Arrays.asList(getResources().getStringArray(R.array.all_bases));
        List<String> listTf = Arrays.asList(getResources().getStringArray(R.array.all_bases));
//        RecyclerView.ItemDecoration itemDecor = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rv = root.findViewById(R.id.recycler_all_bases);
//        rv.addItemDecoration(itemDecor);
        rv.setAdapter(new BaseNumberViewAdapter(getContext(), listLbl, listTf));
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
                    showBaseInputDialog(position);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void showBaseInputDialog(final int position) {
        String chosenItem = (String) spinner.getItemAtPosition(position);
        final BaseInputDialogBuilder dialogBuilder = new BaseInputDialogBuilder(getContext(), chosenItem);
        dialogBuilder.setPositiveButton("Convert", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Base convertFrom = Base.values()[position - 1];
                String input = dialogBuilder.getTfInput().getText().toString();
                startBaseConversion(new BaseNumber(convertFrom, input));
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

    public void startBaseConversion(BaseNumber baseNumber) {
        try {
            BaseConverter baseConverter = new BaseConverter(baseNumber);
            ConversionHistory.getHistory().add(baseNumber);
            ConversionHistory.save(getActivity());
            BaseNumber[] resultsArr = baseConverter.getAllResults();
            List<String> listLbl = Arrays.asList(getResources().getStringArray(R.array.all_bases));
            List<String> listResult = new LinkedList<>();
            for (int i = 0; i < resultsArr.length; i++) {
                listResult.add(resultsArr[i].getValue());
            }
            BaseNumberViewAdapter adapter = new BaseNumberViewAdapter(getContext(), listLbl, listResult);
            rv.setAdapter(adapter);
        } catch (InvalidBaseNumberException e) {
            AlertHelper.showInvalidBaseNumInput(getContext());
        }
        finally {
            spinner.setSelection(0);
        }
    }

    public void clearFields() {
        Log.d(TAG, "Clearing fields...");
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.all_bases));
        rv.setAdapter(new BaseNumberViewAdapter(getContext(), list));
        Log.d(TAG, "Cleared fields!");
    }
}