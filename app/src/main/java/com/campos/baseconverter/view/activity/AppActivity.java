package com.campos.baseconverter.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.campos.baseconverter.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

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
                0, 0);
//        drawer.addDrawerListener(toggle); // Not sure what this does, but program runs fine without it
        toggle.syncState(); // Displays toggle switch on toolbar
    }

    public void initDisplay(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
//            manager.beginTransaction().replace(R.id.fragment_container, new FragmentA()).commit();
//            navigationView.setCheckedItem(R.id.fragment_a);
        }
    }

    @Override // Do something if an item is clicked in drawer
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

        }
        drawer.closeDrawer(GravityCompat.START); // Closes drawer after an item is selected
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