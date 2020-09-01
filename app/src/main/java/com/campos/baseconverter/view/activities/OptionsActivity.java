package com.campos.baseconverter.view.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.campos.baseconverter.R;

import static com.campos.baseconverter.util.Tag.TAG;

public class OptionsActivity extends AppCompatActivity {
    private int themeChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void chooseTheme(View v) {
        Log.d(TAG, "Choosing Theme...");
        final String[] themeArr = getResources().getStringArray(R.array.themes);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.str_theme);
        alert.setSingleChoiceItems(R.array.themes, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                themeChoice = which;
                switch (themeChoice) {
                    case 0:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        break;
                    case 1:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        break;
                    case 2:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                        break;
                }
            }
        });
//        alert.setPositiveButton(R.string.bt_yes, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                switch (themeChoice) {
//                    case 0:
//                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                        break;
//                    case 1:
//                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                        break;
//                    case 2:
//                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
//                        break;
//                }
//            }
//        });
//        alert.setNegativeButton(R.string.bt_no, null);
        alert.show();
    }
}