package com.campos.baseconverter.controller;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.adapter.AdapterType;
import com.campos.baseconverter.model.adapter.MasterBaseAdapter;
import com.campos.baseconverter.model.num.Base;
import com.campos.baseconverter.model.num.BaseNumber;

import java.util.function.Function;

public class SignedBinaryController {
    private View view;
    private RecyclerView rv;

    public SignedBinaryController(View view) {
        this.view = view;
        loadRecycler();
    }

    public void loadRecycler() {
        rv = view.findViewById(R.id.recycler_signed_numbers);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));

        MasterBaseAdapter adapter = new MasterBaseAdapter(
                view.getContext(), AdapterType.SIGNED_BINARY, getNumbers(), rv);
        rv.setAdapter(adapter);
//        Function<RecyclerView, Void> f = (x) -> {
//
//            return null;
//        };
    }



    public BaseNumber[] getNumbers() {
        BaseNumber dec = new BaseNumber(Base.BASE_10, "");
        BaseNumber binSignMag = new BaseNumber(Base.BASE_2, "");
        BaseNumber binOnes = new BaseNumber(Base.BASE_2, "");
        BaseNumber binTwos = new BaseNumber(Base.BASE_2, "");
        return new BaseNumber[] {dec,binSignMag,binOnes,binTwos};
    }
}
