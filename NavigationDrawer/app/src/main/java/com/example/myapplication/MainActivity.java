package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        toolbar.setNavigationOnClickListener(view -> {
            drawerLayout.open();
        });

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(true);
            if(menuItem.getItemId() == R.id.home_item){
                //navigate to home
            }
            if(menuItem.getItemId() == R.id.profile_item){
                //navigate to profile
            }
            if(menuItem.getItemId() == R.id.settings_item){
                //navigate to settings
            }
            return true;
        });


    }
}