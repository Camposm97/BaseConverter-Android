package com.campos.baseconverter.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.num.Base;
import com.campos.baseconverter.model.num.BaseConverter;
import com.campos.baseconverter.model.BaseInputDialogBuilder;
import com.campos.baseconverter.model.num.BaseNumber;
import com.campos.baseconverter.model.adapter.BaseNumberViewAdapter;
import com.campos.baseconverter.model.UserHistory;

import static com.campos.baseconverter.util.AlertUtils.showShortToast;

import java.util.List;

public class AllBasesFragment extends Fragment {
    private View root;
    private RecyclerView rv;
    private Spinner spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.root = inflater.inflate(R.layout.fragment_all_bases, container, false);
        loadViews();
        return root;
    }

    public void loadViews() {
        loadRecycler();
        loadSpinner();
    }

    public void loadRecycler() {
        rv = root.findViewById(R.id.recycler_all_bases);
        rv.setAdapter(new BaseNumberViewAdapter(getContext(), BaseNumber.getAll()));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void loadSpinner() {
        spinner = root.findViewById(R.id.spinner_all_bases);
        List<String> list = Base.loadSpinnerAllBases();
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
        final Base CONVERT_FROM = Base.values()[position - 1];
        final BaseInputDialogBuilder dialogBuilder = new BaseInputDialogBuilder(getContext(), CONVERT_FROM);
        dialogBuilder.setPositiveButton("Convert", (dialog, which) -> {
            String value = dialogBuilder.getInput();
            startBaseConversion(new BaseNumber(CONVERT_FROM, value));
        });
        dialogBuilder.setNegativeButton("Cancel", (dialog, which) -> {
            rv.setAdapter(new BaseNumberViewAdapter(getContext(), BaseNumber.getAll()));
            spinner.setSelection(0);
        });
        dialogBuilder.show();
    }

    public void startBaseConversion(BaseNumber baseNumber) {
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        BaseNumber[] resultsArr = baseConverter.getAllResults();
        if (resultsArr != null) {
            UserHistory.getHistory().add(baseNumber, resultsArr);
            UserHistory.save(getActivity());
            rv.setAdapter(new BaseNumberViewAdapter(getContext(), resultsArr));
        } else {
            showShortToast(getContext(), "Invalid Input!");
        }
        spinner.setSelection(0);
    }
}