package com.example.employeecard;

import com.example.employeecard.models.Skill;


public interface IChange {
    void onRateChanged();
    void onDecBtnClicked(Skill skill);
    void onSingleScoreChanged(int id, int score);
}
