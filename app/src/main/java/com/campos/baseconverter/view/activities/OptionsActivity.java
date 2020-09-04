package com.campos.baseconverter.view.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.campos.baseconverter.R;
import com.campos.baseconverter.app.App;
import com.campos.baseconverter.model.NumSchemeChooser;
import com.campos.baseconverter.model.ThemeChooser;

import androidx.appcompat.app.AppCompatActivity;

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
        dialogBuilder.setSingleChoiceItems(R.array.theme_options, App.getThemeCode(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                themeCode = which;
            }
        });
        dialogBuilder.setPositiveButton(R.string.bt_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ThemeChooser.setTheme(c, themeCode);
                App.setThemeCode(themeCode);
                ThemeChooser.save(c, themeCode);
            }
        });
        dialogBuilder.setNegativeButton(R.string.bt_no, null);
        dialogBuilder.setCancelable(false);
        dialogBuilder.show();
    }

    public void chooseAppear(View v) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(R.string.str_num_scheme);
        dialogBuilder.setSingleChoiceItems(R.array.num_scheme_options, App.getNumSchemeCode(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                numSchemeCode = which;
            }
        });
        dialogBuilder.setPositiveButton(R.string.bt_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                NumSchemeChooser.setScheme(c, numSchemeCode);
                App.setNumSchemeCode(numSchemeCode);
                NumSchemeChooser.save(c, themeCode);
                String s = "Press the \"BACK\" button above to apply changes";
                Toast.makeText(c, s, Toast.LENGTH_LONG).show();
            }
        });
        dialogBuilder.setNegativeButton(R.string.bt_no, null);
        dialogBuilder.setCancelable(false);
        dialogBuilder.show();
    }
}