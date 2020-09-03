package com.campos.baseconverter.view.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.campos.baseconverter.R;
import com.campos.baseconverter.app.App;
import com.campos.baseconverter.model.NumSchemeChooser;
import com.campos.baseconverter.model.ThemeChooser;

public class OptionsActivity extends AppCompatActivity {
    private Context c;
    private int themeCode;
    private int numSchemeCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        this.c = this;
    }

    public void chooseTheme(View v) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(R.string.str_theme);
        dialogBuilder.setSingleChoiceItems(R.array.theme_options, App.themeCode, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                themeCode = which;
            }
        });
        dialogBuilder.setPositiveButton(R.string.bt_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ThemeChooser.setTheme(c, themeCode);
            }
        });
        dialogBuilder.setNegativeButton(R.string.bt_no, null);
        dialogBuilder.setCancelable(false);
        dialogBuilder.show();
    }

    public void chooseAppear(View v) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(R.string.str_num_scheme);
        dialogBuilder.setSingleChoiceItems(R.array.num_scheme_options, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                numSchemeCode = which;
            }
        });
        dialogBuilder.setPositiveButton(R.string.bt_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NumSchemeChooser.setScheme(c, numSchemeCode);
            }
        });
        dialogBuilder.setNegativeButton(R.string.bt_no, null);
        dialogBuilder.setCancelable(false);
        dialogBuilder.show();
    }
}