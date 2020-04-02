package com.example.employeecard;

import androidx.core.util.Pair;

import com.example.employeecard.adapters.EmpDetailAdapter;

public interface IChange {
    void onRateChanged();
    void onDecBtnClicked(Pair<Integer,String> skill);
}
