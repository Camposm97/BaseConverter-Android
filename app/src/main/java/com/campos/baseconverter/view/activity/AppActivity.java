package com.campos.baseconverter.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.campos.baseconverter.R;

/**
 * I named it to AppActivity instead of MainActivity so the file can be listed at the top
 * when you open the package folder.
 */
public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
    }
}