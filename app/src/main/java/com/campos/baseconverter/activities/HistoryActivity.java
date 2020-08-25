package com.campos.baseconverter.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.campos.baseconverter.R;

/**
 * Every time a user chooses a base to convert from, the HistoryActivity will
 * display what that user input and base he/she chose.  Display it as a list view or
 * whatever android provides to display it vertically.  The user can then click on that
 * base and input he/she chose and it will either display a dialog or a fragment to
 * show the bases.
 *
 * Maybe have it where when he/she clicks on the base and input, it will ask to
 * convert it to what which can make use of the BaseConverter class more.
 *
 * Credit goes to mi em oi
 */
public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }
}