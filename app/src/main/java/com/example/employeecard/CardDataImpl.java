package com.example.employeecard;

import com.example.employeecard.models.EmpInfo;
import com.ramotion.expandingcollection.ECCardData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardDataImpl implements ECCardData<EmpInfo> {

    private String cardTitle;
    private Integer mainBackgroundResource;
    private Integer headBackgroundResource;
    private List<EmpInfo> mEmpInfoList;

    private String fio;
    private String skills;
    private String position;
    private int javaScore;
    private int dbScore;
    private int angScore;

    public CardDataImpl(String cardTitle, Integer mainBackgroundResource, Integer headBackgroundResource, List<EmpInfo> listItems) {
        this.mainBackgroundResource = mainBackgroundResource;
        this.headBackgroundResource = headBackgroundResource;
        this.mEmpInfoList = listItems;
        this.cardTitle = cardTitle;
    }
    public String getCardTitle() {
        return cardTitle;
    }

    @Override
    public Integer getMainBackgroundResource() {
        return mainBackgroundResource;
    }

    @Override
    public Integer getHeadBackgroundResource() {
        return headBackgroundResource;
    }

    @Override
    public List<EmpInfo> getListItems() {
        return mEmpInfoList;
    }

    public void setListItems(List<EmpInfo> listItems) {
        this.mEmpInfoList = listItems;
    }

    public void setJavaScore(int javaScore) {
        this.javaScore = javaScore;
    }

    public void setDbScore(int dbScore) {
        this.dbScore = dbScore;
    }

    public void setAngScore(int angScore) {
        this.angScore = angScore;
    }

    public String getFio() {
        return fio;
    }
    public String getSkills() {
        return skills;
    }
    public String getPosition() {
        return position;
    }

    public int getJavaScore() {
        return javaScore;
    }

    public int getDbScore() {
        return dbScore;
    }

    public int getAngScore() {
        return angScore;
    }

    public static List<ECCardData> generateExampleData() {
        List<ECCardData> list = new ArrayList<>();
        list.add(new CardDataImpl("Card 1", R.color.colorGray, R.drawable.employee_img, createItemsList("Card 1")));
        list.add(new CardDataImpl("Card 2", R.color.colorGray, R.drawable.employee_img, createItemsList("Card 2")));
        list.add(new CardDataImpl("Card 3", R.color.colorGray, R.drawable.employee_img, createItemsList("Card 3")));
        return list;
    }

    private static List<EmpInfo> createItemsList(String cardName) {
        ArrayList<EmpInfo> list = new ArrayList<>();
        list.addAll(Arrays.asList(
                new EmpInfo(cardName + "Detail1"),
                new EmpInfo(cardName + "Detail2"),
                new EmpInfo(cardName + "Detail3"),
                new EmpInfo(cardName + "Detail4")
        ));
        return list;
    }
}
