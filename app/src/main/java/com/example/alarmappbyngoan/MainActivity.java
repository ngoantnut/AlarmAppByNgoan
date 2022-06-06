package com.example.alarmappbyngoan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlarmManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mybottomNavigationView;
    private Toolbar mToolbar;
    AlarmFragment alarmFragment= new AlarmFragment();
    CountDown_Fragment countDown_fragment =new CountDown_Fragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.main_page_toolbar);
        mybottomNavigationView= findViewById(R.id.menu_navigation);


        mToolbar.setTitle("Báo thức");
        getSupportFragmentManager().beginTransaction().replace(R.id.container,alarmFragment ).commit();

        mybottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_alarm:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,alarmFragment).commit();
                    case R.id.menu_look_time:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,countDown_fragment).commit();

                }
                return false;
            }
        });


    }
}