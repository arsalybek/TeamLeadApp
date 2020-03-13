package com.example.employeecard;

import com.ramotion.expandingcollection.ECCardData;

import java.util.List;

public class EmpInfo implements ECCardData<String> {
    private String fio;
    private String skills;
    private String position;
    private int javaScore;
    private int dbScore;
    private int angScore;

    public EmpInfo(String fio, String skills, String position, int javaScore, int dbScore, int angScore) {
        this.fio = fio;
        this.skills = skills;
        this.position = position;
        this.javaScore = javaScore;
        this.dbScore = dbScore;
        this.angScore = angScore;
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

    @Override
    public Integer getMainBackgroundResource() {
        return null;
    }

    @Override
    public Integer getHeadBackgroundResource() {
        return null;
    }

    @Override
    public List<String> getListItems() {
        return null;
    }
}
