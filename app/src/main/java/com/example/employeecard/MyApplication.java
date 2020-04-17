package com.example.employeecard;

import android.app.Application;

import com.example.employeecard.activities.MainActivity;
import com.example.employeecard.database.EmployeeBaseHelper;
import com.example.employeecard.models.EmpContainer;
import com.example.employeecard.models.EmployeeInfo;

import java.util.List;

public class MyApplication extends Application {

    public EmployeeBaseHelper db = EmployeeBaseHelper.getInstance(getApplicationContext());
    private EmpContainer mContainer = EmpContainer.get(db);
    @Override
    public void onCreate() {
        super.onCreate();
        db.insertListOfEmployee(mContainer.getDataset());
        db.insertListOfSkill(mContainer.insertSkillstoDb());
        db.insertListOfJoined(mContainer.insertJoinDb());
    }

    public List<EmployeeInfo> getList(){
        return db.getAllNotes();
    }
}
