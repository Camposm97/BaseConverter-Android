package com.campos.baseconverter.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.campos.baseconverter.R;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.main_linear_layout);
        View fragmentMain = findViewById(R.id.main_fragment);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_settings:
                settingsClicked();
                break;
            case R.id.mi_about:
                aboutClicked();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void settingsClicked() {
        // Display settings that allows the user to switch to a unsigned, sign/magnitude, and two's complement
        startActivity(new Intent(this, SettingsActivity.class));
    }


    public void aboutClicked() {
        /*
        Display an about dialog where the it tells the purpose of the program
         */
    }
}