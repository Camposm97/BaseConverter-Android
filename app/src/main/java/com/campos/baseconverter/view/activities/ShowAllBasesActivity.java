package com.campos.baseconverter.view.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.BaseConverter;
import com.campos.baseconverter.model.BaseNumber;
import com.campos.baseconverter.model.BaseNumberViewAdapter;
import com.campos.baseconverter.model.InvalidBaseNumberException;

public class ShowAllBasesActivity extends AppCompatActivity {
    private BaseNumber chosenNum;
    private BaseConverter bc;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_bases);
        loadBaseNum();
        loadRecycler();
    }

    public void loadBaseNum() {
        chosenNum = (BaseNumber) this.getIntent().getSerializableExtra("baseNumber");
        try {
            bc = new BaseConverter(chosenNum);
        } catch (InvalidBaseNumberException e) {
            e.printStackTrace();
        }
    }

    public void loadRecycler() {
        rv = findViewById(R.id.recycler_all_bases);
        rv.setAdapter(new BaseNumberViewAdapter(this, bc.getAllResults()));
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}