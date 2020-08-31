package com.campos.baseconverter.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.BaseNumber;
import static com.campos.baseconverter.util.Tag.TAG;

public class ShowAllBasesActivity extends AppCompatActivity {
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_bases);
        BaseNumber baseNumber = (BaseNumber) this.getIntent().getSerializableExtra("target");
        Log.d(TAG, "Showing all conversions for: " + baseNumber.toString());
    }
}