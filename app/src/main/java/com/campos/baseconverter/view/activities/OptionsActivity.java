package com.campos.baseconverter.view.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
//        String[] choices = getResources().getStringArray(R.array.themes);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setSingleChoiceItems(R.array.themes, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, "which=" + which);
            }
        });
//        final View view = getLayoutInflater().inflate(R.layout.theme_chooser_layout, null);
//        alert.setView(view);
//        alert.setPositiveButton(R.string.app_name, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Log.d(TAG, "which=" + which);
//            }
//        });
//        alert.setNegativeButton(R.string.bt_no, null);
        alert.show();
    }
}