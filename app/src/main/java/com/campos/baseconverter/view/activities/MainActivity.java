package com.campos.baseconverter.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.MyFragmentStateAdapter;
import com.campos.baseconverter.view.fragments.AllBasesFragment;
import com.campos.baseconverter.view.fragments.MainBasesFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadViewPager();
        loadButtons();
    }

    public void loadViewPager() {
        viewPager = findViewById(R.id.main_view_pager);
        MyFragmentStateAdapter adapter = new MyFragmentStateAdapter(getSupportFragmentManager(), getLifecycle());
        adapter.addFragment(new MainBasesFragment(), "MainBasesFragment");
        adapter.addFragment(new AllBasesFragment(), "AllBasesFragment");
        viewPager.setAdapter(adapter);
        viewPager.setUserInputEnabled(false);
        viewPager.setOffscreenPageLimit(1);
    }

    public void setViewPagerCurrentItem(int position) {
        viewPager.setCurrentItem(position);
    }

    public void showMainBases(View v) {
        viewPager.setCurrentItem(0);
    }

    public void showAllBases(View v) {
        viewPager.setCurrentItem(1);
    }

    public void loadButtons() {
        Button btMainBases = findViewById(R.id.bt_Main);
        Button btAllBases = findViewById(R.id.bt_All);
        btMainBases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setViewPagerCurrentItem(0);
            }
        });
        btAllBases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setViewPagerCurrentItem(1);
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
            case R.id.mi_History:
                startActivity(new Intent(this, HistoryActivity.class));
                break;
            case R.id.mi_settings:
                startActivity(new Intent(this, OptionsActivity.class));
                break;
            case R.id.mi_about:
                aboutClicked();
        }
        return super.onOptionsItemSelected(item);
    }

    public void aboutClicked() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.about_name);
        alert.setMessage("The purpose of this program is to convert bases"); // Put message in strings.xml
        alert.setPositiveButton("OK", null);
        alert.show();
    }
}