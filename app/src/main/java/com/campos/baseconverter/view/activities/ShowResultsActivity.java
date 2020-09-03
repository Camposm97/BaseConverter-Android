package com.campos.baseconverter.view.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.BaseNumberViewAdapter;
import com.campos.baseconverter.model.UserHistory;

public class ShowResultsActivity extends AppCompatActivity {
    private UserHistory.HistoryItem item;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);
        loadExtra();
        loadRecycler();
    }

    public void loadExtra() {
        final String s1 = "selected_item";
        item = (UserHistory.HistoryItem) this.getIntent().getSerializableExtra(s1);
        setTitle("Selected Item: " + item.getInput().toSpanString());
    }

    public void loadRecycler() {
        rv = findViewById(R.id.recycler_all_bases);
        rv.setAdapter(new BaseNumberViewAdapter(this, item.getResultsArr()));
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}