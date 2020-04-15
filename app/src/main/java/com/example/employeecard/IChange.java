package com.example.employeecard;

import android.util.Pair;


public interface IChange {
    void onRateChanged();
    void onDecBtnClicked(Pair<Integer,String> skill);
}
