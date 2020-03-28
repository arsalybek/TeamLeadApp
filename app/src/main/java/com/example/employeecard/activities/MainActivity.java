package com.example.employeecard.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.employeecard.R;
import com.example.employeecard.fragments.DisplayFragment;
import com.example.employeecard.fragments.EmpListFragment;
import com.example.employeecard.fragments.LoginFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;
    Fragment loginFragment = new LoginFragment();
    EmpListFragment mEmpListFragment = new EmpListFragment();
    DisplayFragment mDisplayFragment = new DisplayFragment();
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        launchLoginFragment();
        fm = getSupportFragmentManager();
        fragment = fm.findFragmentById(R.id.fragment_container);
        fm.beginTransaction().add(R.id.fragment_container,loginFragment).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_emp:
                        fragment = new EmpListFragment();
                        fm.beginTransaction()
                                .replace(R.id.fragment_container, fragment)
                                .commit();
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
    public void launchLoginFragment() {
        Fragment loginFragment = new LoginFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, loginFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
