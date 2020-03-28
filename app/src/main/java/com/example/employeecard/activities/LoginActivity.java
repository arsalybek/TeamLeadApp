package com.example.employeecard.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.employeecard.R;
import com.example.employeecard.fragments.EmpListFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ConstraintLayout login = findViewById(R.id.m_login_button);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switchToList();
//            }
//        });
        
        
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
//    private void switchToList(){
//        EmpListFragment listFragment = new EmpListFragment();
//        FragmentTransaction loginFragment = getFragmentManager().beginTransaction();
//        loginFragment.replace(R.id.fragment_container, listFragment)
//        loginFragment.commit();
//    }
}
