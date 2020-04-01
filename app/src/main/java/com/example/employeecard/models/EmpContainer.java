package com.example.employeecard.models;


import androidx.core.util.Pair;

import com.example.employeecard.R;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpContainer {
    private List<CardData> dataset;
    private static EmpContainer empContainer;
    public static EmpContainer get() {
        if (empContainer == null) {
            empContainer = new EmpContainer();
        }
        return empContainer;
    }
    public EmpContainer() {
        dataset = new ArrayList<>();
        List<Pair<Integer,String>> skillsAndroid = new ArrayList<>();
        skillsAndroid.add(new Pair<>(8,"UI/UX"));
        skillsAndroid.add(new Pair<>(5,"Android Core"));
        skillsAndroid.add(new Pair<>(5,"Presentation"));
        List<Pair<Integer,String>> skillsIos = new ArrayList<>();
        skillsIos.add(new Pair<>(8,"UI/UX"));
        skillsIos.add(new Pair<>(5,"IOS Core"));
        skillsIos.add(new Pair<>(5,"Presentation"));
        CardData card1 = new CardData(R.drawable.emp_man_img,R.color.android,R.drawable.card_background_android, "Patrick Johannes","Rank 3 Android Developer",skillsAndroid);
        card1.setEmpDetail(empDetail);
        dataset.add(card1);
        CardData card2 = new CardData(R.drawable.emp_woman_img2,R.color.ios,R.drawable.card_backround_ios, "Veronika Zhangalova ","Rank 5 IOS Developer",skillsIos);
        card2.setEmpDetail(empDetail);
        dataset.add(card2);
        CardData card3 = new CardData(R.drawable.emp_man_img,R.color.front,R.drawable.card_background_front, "Samuel George Claflin","Rank 4 Front End Developer",skillsAndroid);
        card3.setEmpDetail(empDetail);
        dataset.add(card3);
        CardData card4 = new CardData(R.drawable.emp_woman_img2,R.color.back,R.drawable.card_background_back, "Farida Agzamova","Rank 5 Back End Developer",skillsAndroid);
        card4.setEmpDetail(empDetail);
        dataset.add(card4);
    }

    public List<CardData> getDataset() {
        return dataset;
    }

    private EmpDetail empDetail = new EmpDetail(new LocalDate(2020, 1, 31),27,"admin@gmail.com","+77057851992");
}
