package com.example.employeecard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.github.glomadrian.roadrunner.IndeterminateRoadRunner;
import com.github.glomadrian.roadrunner.painter.indeterminate.IndeterminatePathPainter;
import com.jaredrummler.android.widget.AnimatedSvgView;


public class LoginFragment extends Fragment  {

    IndeterminateRoadRunner indeterminateRoadRunner;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);

        TextView login = view.findViewById(R.id.m_login_button_txt);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToList();
            }
        });
        AnimatedSvgView svgView = view.findViewById(R.id.m_tiger);
        svgView.start();
        return view;
    }
    public void switchToList(){
        EmpListFragment listFragment = new EmpListFragment();
        FragmentTransaction loginFragment = getFragmentManager().beginTransaction();
        loginFragment.replace(R.id.fragment_container,listFragment);
        loginFragment.commit();
    }
}
