package com.example.employeecard.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.employeecard.R;
import com.example.employeecard.fragments.DisplayFragment;
import com.example.employeecard.fragments.EmpListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity  {
    public static FragmentManager fm;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fragment = fm.findFragmentById(R.id.fragment_container);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar);

        final Fragment fragmentList = new EmpListFragment();
        fm.beginTransaction().add(R.id.fragment_container,fragmentList, "1").addToBackStack("list").commit();
        Log.e("MainActivity",fm.getFragments().toString());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_emp:
                        fragment = new EmpListFragment();
                        fm.beginTransaction().show(fragmentList).addToBackStack(null).commit();
                        break;

                    case R.id.action_display:
                    fragment = new DisplayFragment();
                    fm.beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();
                    break;
                }
                return false;
            }
        });
        if(savedInstanceState == null){
            bottomNavigationView.setSelectedItemId(R.id.action_emp);
       }
    }

    public FragmentManager getFmanager() {
        return fm;
    }
}
