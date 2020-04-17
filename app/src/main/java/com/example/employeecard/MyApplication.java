package com.example.employeecard;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.employeecard.activities.MainActivity;
import com.example.employeecard.database.EmployeeBaseHelper;
import com.example.employeecard.models.EmpContainer;
import com.example.employeecard.models.EmployeeInfo;

import java.util.List;

public class MyApplication extends Application {

    public EmployeeBaseHelper db;

    public MyApplication(){ }
    @Override
    public void onCreate() {
        super.onCreate();
        db = EmployeeBaseHelper.getInstance(getApplicationContext());
        EmpContainer mContainer = EmpContainer.get(db);
        db.insertListOfEmployee(mContainer.getDataset());
        db.insertListOfSkill(mContainer.insertSkillstoDb());
        db.insertListOfJoined(mContainer.insertJoinDb());
    }
}
