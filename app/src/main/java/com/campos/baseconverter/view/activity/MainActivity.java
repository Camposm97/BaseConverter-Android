package com.campos.baseconverter.view.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.campos.baseconverter.R;

import com.campos.baseconverter.app.App;
import com.campos.baseconverter.util.NumSchemeUtils;
import com.campos.baseconverter.util.ThemeUtils;
import com.campos.baseconverter.view.fragment.AllBasesFragment;
import com.campos.baseconverter.view.fragment.HistoryFragment;
import com.campos.baseconverter.view.fragment.MainBasesFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private FragmentManager manager;
    private NavigationView navigationView;
    private Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initDisplay(savedInstanceState);
    }

    public void initControls() {
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.layout_drawer);
        manager = getSupportFragmentManager();
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.nav_open, R.string.nav_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        c = this;
    }

    public void initDisplay(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            manager.beginTransaction().replace(R.id.fragment_container, new MainBasesFragment()).commit();
            navigationView.setCheckedItem(R.id.item_main_bases);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_main_bases:
                setTitle(R.string.str_main_bases);
                manager.beginTransaction().replace(
                        R.id.fragment_container, new MainBasesFragment()).commit();
                break;
            case R.id.item_all_bases:
                setTitle(R.string.str_all_bases);
                manager.beginTransaction().replace(
                        R.id.fragment_container, new AllBasesFragment()).commit();
                break;
            case R.id.item_history:
                setTitle(R.string.history_name);
                manager.beginTransaction().replace(
                        R.id.fragment_container, new HistoryFragment()).commit();
                break;
            case R.id.item_theme:
                chooseTheme();
                break;
            case R.id.item_num_scheme:
                chooseAppearance();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void chooseTheme() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(R.string.str_theme);
        dialogBuilder.setSingleChoiceItems(R.array.theme_options, App.themeCode, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ThemeUtils.setTheme(c, which);
                App.themeCode = which;
                ThemeUtils.save(c, which);
                dialog.dismiss();
            }
        });
        dialogBuilder.setCancelable(true);
        dialogBuilder.show();
    }

    public void chooseAppearance() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(R.string.str_num_scheme);
        dialogBuilder.setSingleChoiceItems(R.array.num_scheme_options, App.numSchemeCode, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                App.numSchemeCode = which;
                NumSchemeUtils.save(c, which);
                dialog.dismiss();
            }
        });
        dialogBuilder.setCancelable(true);
        dialogBuilder.show();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}