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


public class MainBasesFragment extends Fragment {
    private View view;
    private RecyclerView rv;
    private Spinner spinner;

    @Nullable
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
        final Base CONVERT_FROM = Base.parse((String) spinner.getItemAtPosition(position));
        final BaseInputDialogBuilder dialogBuilder = new BaseInputDialogBuilder(getContext(), CONVERT_FROM);
        dialogBuilder.setPositiveButton("Convert", (dialog, which) -> {
            String value = dialogBuilder.getInput();
            attemptBaseConversion(new BaseNumber(CONVERT_FROM, value));
        });
        dialogBuilder.setNegativeButton("Cancel", (dialog, which) -> {
            rv.setAdapter(new BaseNumberViewAdapter(getContext(), BaseNumber.getMain()));
            spinner.setSelection(0);
        });
        dialogBuilder.show();
    }

    public void attemptBaseConversion(BaseNumber baseNumber) {
        System.out.println("attempting to convert to main bases: " + baseNumber.toString());
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        BaseNumber[] resultsArr = baseConverter.getMainResults();
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