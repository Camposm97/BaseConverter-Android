package com.campos.baseconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_main_menu, menu);
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