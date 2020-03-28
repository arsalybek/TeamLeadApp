package com.example.employeecard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.employeecard.R;

public class LoginFragment extends Fragment  {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        ConstraintLayout login = view.findViewById(R.id.m_login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToList();
            }
        });

        return view;
    }
    private void switchToList(){
        EmpListFragment listFragment = new EmpListFragment();
        FragmentTransaction loginFragment = getFragmentManager().beginTransaction();
        loginFragment.replace(R.id.fragment_container,listFragment);
        loginFragment.commit();
    }
}
