package com.campos.baseconverter.view.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.campos.baseconverter.R;
import com.campos.baseconverter.view.fragment.AllBasesFragment;
import com.campos.baseconverter.view.fragment.MainBasesFragment;
import com.google.android.material.navigation.NavigationView;

/**
 * I named it to AppActivity instead of MainActivity so the file can be listed at the top
 * when you open this package folder.
 */
public class AppActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private FragmentManager manager;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
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
                R.string.bt_yes, R.string.bt_no);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
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
                manager.beginTransaction().replace(
                        R.id.fragment_container, new MainBasesFragment()).commit();
                break;
            case R.id.item_all_bases:
                manager.beginTransaction().replace(
                        R.id.fragment_container, new AllBasesFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}