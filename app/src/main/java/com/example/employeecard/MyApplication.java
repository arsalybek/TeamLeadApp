package com.example.employeecard;

import android.app.Application;
import android.os.Handler;
import android.util.Pair;

import com.example.employeecard.database.EmployeeBaseHelper;
import com.example.employeecard.models.EmpContainer;
import com.example.employeecard.models.EmpDetail;
import com.example.employeecard.models.EmployeeInfo;
import com.example.employeecard.models.EmployeeSkill;
import com.example.employeecard.models.JoinedInfoSkill;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {
    public EmployeeBaseHelper db;

    public MyApplication(){ }
    @Override
    public void onCreate() {
        super.onCreate();
        db = EmployeeBaseHelper.getInstance(getApplicationContext());
//        db.removeAll();
        db.insertListOfSkill(insertSkillstoDb());
        db.insertListOfJoined(insertJoinDb());
        db.insertListOfEmployee(getDataset());
//        setSkills(db,getDataset());
    }

    public List<EmployeeSkill> insertSkillstoDb() {
        EmployeeSkill s1 = new EmployeeSkill(1, "UI/UX");
        EmployeeSkill s2 = new EmployeeSkill(2, "Android Core");
        EmployeeSkill s3 = new EmployeeSkill(3, "Presentation");
        EmployeeSkill s4 = new EmployeeSkill(4, "IOS Core");
        List<EmployeeSkill> skillList = new ArrayList<>();
        skillList.add(s1);
        skillList.add(s2);
        skillList.add(s3);
        skillList.add(s4);
        return skillList;
    }

    public List<JoinedInfoSkill> insertJoinDb() {
        JoinedInfoSkill j1 = new JoinedInfoSkill(1, 1, 8);
        JoinedInfoSkill j2 = new JoinedInfoSkill(1, 2, 5);
        JoinedInfoSkill j3 = new JoinedInfoSkill(1, 3, 5);
        JoinedInfoSkill j4 = new JoinedInfoSkill(2, 1, 8);
        JoinedInfoSkill j5 = new JoinedInfoSkill(2, 2, 10);
        JoinedInfoSkill j6 = new JoinedInfoSkill(2, 4, 6);
        JoinedInfoSkill j7 = new JoinedInfoSkill(3, 1, 8);
        JoinedInfoSkill j8 = new JoinedInfoSkill(3, 2, 10);
        JoinedInfoSkill j9 = new JoinedInfoSkill(3, 4, 6);

        List<JoinedInfoSkill> joinSkills = new ArrayList<>();
        joinSkills.add(j1);
        joinSkills.add(j2);
        joinSkills.add(j3);
        joinSkills.add(j4);
        joinSkills.add(j5);
        joinSkills.add(j6);
        joinSkills.add(j7);
        joinSkills.add(j8);
        joinSkills.add(j9);
        return joinSkills;
    }

    public List<EmployeeInfo> getDataset() {

        List<EmployeeInfo> dataset = new ArrayList<>();

        final EmployeeInfo card1 = new EmployeeInfo(1, R.drawable.emp_man_img, R.color.android, R.drawable.card_background_android, "Patrick Johannes", "Rank 3 Android Developer");
        card1.setEmpDetail(empDetail);

        final EmployeeInfo card2 = new EmployeeInfo(2, R.drawable.emp_woman_img2, R.color.ios, R.drawable.card_backround_ios, "Veronika Zhangalova ", "Rank 5 IOS Developer");
        card2.setEmpDetail(empDetail);

        EmployeeInfo card3 = new EmployeeInfo(3, R.drawable.emp_man_img, R.color.front, R.drawable.card_background_front, "Samuel George Claflin", "Rank 4 Front End Developer");
        card3.setEmpDetail(empDetail);

        EmployeeInfo card4 = new EmployeeInfo(4, R.drawable.emp_woman_img2, R.color.back, R.drawable.card_background_back, "Farida Agzamova", "Rank 5 Back End Developer");
        card4.setEmpDetail(empDetail);

        dataset.add(card1);
        dataset.add(card2);
        dataset.add(card3);
//        dataset.add(card4);
        return dataset;
    }
    private EmpDetail empDetail = new EmpDetail(new LocalDate(2020, 1, 31), 27, "admin@gmail.com", "+77057851992");

    public void setSkills(EmployeeBaseHelper db, List<EmployeeInfo> list) {

        for (EmployeeInfo e : list) {
            List<Pair<Integer, String>> skillList = new ArrayList<>(db.getEmployeeSkill(e.getM_emp_id()));
            e.setM_emp_skills(skillList);

        }
    }
}
