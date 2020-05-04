package com.example.employeecard;

import android.app.Application;
import android.util.Log;

import com.example.employeecard.database.EmployeeBaseHelper;
import com.example.employeecard.models.Employee;
import com.example.employeecard.models.Joined;
import com.example.employeecard.models.Skill;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {
    public EmployeeBaseHelper db;

    public MyApplication() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        db = EmployeeBaseHelper.getInstance(getApplicationContext());
        db.insertListOfSkill(insertSkillsToDb());
        db.insertListOfEmployee(insertEmployeeToDb());
        db.insertListOfJoined(insertJoinedToDb());
    }

    public List<Skill> insertSkillsToDb() {
        Skill s1 = new Skill(1,"UI/UX");
        Skill s2 = new Skill(2,"Android Core");
        Skill s3 = new Skill(3, "Presentation");
        Skill s4 = new Skill(4, "IOS Core");
        List<Skill> skillList = new ArrayList<>();
        skillList.add(s1);
        skillList.add(s2);
        skillList.add(s3);
        skillList.add(s4);
        return skillList;
    }

    public List<Joined> insertJoinedToDb() {
        Joined j1 = new Joined(1,1, 1, 8);
        Joined j2 = new Joined(2,1, 2, 5);
        Joined j3 = new Joined(3,1, 3, 5);
        Joined j4 = new Joined(4,2, 1, 8);
        Joined j5 = new Joined(5,2, 2, 10);
        Joined j6 = new Joined(6,2, 4, 6);
        Joined j7 = new Joined(7,3, 1, 8);
        Joined j8 = new Joined(8,3, 2, 10);
        Joined j9 = new Joined(9,3, 4, 6);
        Joined j10 = new Joined(10,4, 1, 8);
        Joined j11 = new Joined(11,4, 2, 10);
        Joined j12 = new Joined(12,4, 4, 6);

        List<Joined> joinSkills = new ArrayList<>();
        joinSkills.add(j1);
        joinSkills.add(j2);
        joinSkills.add(j3);
        joinSkills.add(j4);
        joinSkills.add(j5);
        joinSkills.add(j6);
        joinSkills.add(j7);
        joinSkills.add(j8);
        joinSkills.add(j9);
        joinSkills.add(j10);
        joinSkills.add(j11);
        joinSkills.add(j12);
        return joinSkills;
    }

    public List<Employee> insertEmployeeToDb() {

        List<Employee> employeeList = new ArrayList<>();

        final Employee card1 = new Employee(1, "Patrick Johannes", "Rank 3 Android Developer", R.drawable.emp_man_img, R.color.android, R.drawable.card_background_android,
                new LocalDate(2020, 1, 31), 27, "admin@gmail.com", "+77057851992");

        final Employee card2 = new Employee(2, "Veronika Zhangalova ", "Rank 5 IOS Developer", R.drawable.emp_woman_img, R.color.ios, R.drawable.card_backround_ios,
                new LocalDate(2020, 1, 31), 27, "admin@gmail.com", "+77057851992");

        Employee card3 = new Employee(3, "Samuel George Claflin", "Rank 4 Front End Developer", R.drawable.emp_man_img, R.color.front, R.drawable.card_background_front,
                new LocalDate(2020, 1, 31), 27, "admin@gmail.com", "+77057851992");

        Employee card4 = new Employee(4, "Farida Agzamova", "Rank 5 Back End Developer", R.drawable.emp_woman_img, R.color.back, R.drawable.card_background_back,
                new LocalDate(2020, 1, 31), 27, "admin@gmail.com", "+77057851992");


        employeeList.add(card1);
        employeeList.add(card2);
        employeeList.add(card3);
        employeeList.add(card4);
        return employeeList;
    }
}
