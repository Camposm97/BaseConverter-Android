package com.campos.baseconverter.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.campos.baseconverter.fragments.MainBasesFragment;
import com.campos.baseconverter.R;
import com.campos.baseconverter.model.MyFragmentStatePageAdapter;

public class MainActivity extends AppCompatActivity {
    private final MyFragmentStatePageAdapter pageAdapter = new MyFragmentStatePageAdapter(getSupportFragmentManager(),  getLifecycle());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.main_linear_layout);
        final ViewPager2 view = (ViewPager2) findViewById(R.id.main_view_pager);
        Button btMainBases = findViewById(R.id.bt_Main);
        Button btAllBases =findViewById(R.id.bt_All);

        btMainBases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBasesFragment fragment = new MainBasesFragment();
                
            }
        });

        btAllBases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBasesFragment fragment = new MainBasesFragment();

            }
        });
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