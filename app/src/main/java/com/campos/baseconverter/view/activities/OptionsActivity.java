package com.campos.baseconverter.view.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.campos.baseconverter.R;

import static com.campos.baseconverter.util.Tag.TAG;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void chooseTheme(View v) {
        Log.d(TAG, "Choosing Theme...");
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        
        alert.show();
    }
}