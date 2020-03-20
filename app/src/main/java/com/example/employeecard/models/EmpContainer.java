package com.example.employeecard.models;

import com.example.employeecard.R;
import com.ramotion.expandingcollection.ECCardData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmpContainer {
    private List<ECCardData> dataset;

    public EmpContainer() {
        dataset = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            CardData card = new CardData(R.drawable.employee_img, "Popova Natalya Aleksandrovna", "Visual Design Experience on strong UI/UX.Working knowledge" +
                    " of PhotoshopSketch", i+1 + ".Front End Developer");
            card.setListItems(mEmpDetailList());
            dataset.add(card);
        }
    }

    public List<ECCardData> getDataset() {
        return dataset;
    }

    private List<EmpDetail> mEmpDetailList() {
        List<EmpDetail> details = new ArrayList<>(Arrays.asList(
                new EmpDetail("Detail1 of Employee"),
                new EmpDetail("Detail2 of Employee"),
                new EmpDetail("Detail3 of Employee")
        ));
        return details;
    }

}
