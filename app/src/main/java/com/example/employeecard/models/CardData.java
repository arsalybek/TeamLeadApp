package com.example.employeecard.models;

import com.ramotion.expandingcollection.ECCardData;

import java.util.List;

public class CardData implements ECCardData<EmpDetail> {

    private int m_emp_img;
    private String m_emp_fio;
    private String m_emp_skills;
    private String m_emp_position;
    private int m_emp_javaScore;
    private int m_emp_dbScore;
    private int m_emp_angScore;
    private List<EmpDetail> mEmpDetailList;

    public CardData(int m_emp_img, String m_emp_fio, String m_emp_skills, String m_emp_position) {
        this.m_emp_img = m_emp_img;
        this.m_emp_fio = m_emp_fio;
        this.m_emp_skills = m_emp_skills;
        this.m_emp_position = m_emp_position;
    }

    public int getM_emp_img() {
        return m_emp_img;
    }

    public void setM_emp_img(int m_emp_img) {
        this.m_emp_img = m_emp_img;
    }

    public String getM_emp_fio() {
        return m_emp_fio;
    }

    public void setM_emp_fio(String m_emp_fio) {
        this.m_emp_fio = m_emp_fio;
    }

    public String getM_emp_skills() {
        return m_emp_skills;
    }

    public void setM_emp_skills(String m_emp_skills) {
        this.m_emp_skills = m_emp_skills;
    }

    public String getM_emp_position() {
        return m_emp_position;
    }

    public void setM_emp_position(String m_emp_position) {
        this.m_emp_position = m_emp_position;
    }

    public int getM_emp_javaScore() {
        return m_emp_javaScore;
    }

    public void setM_emp_javaScore(int m_emp_javaScore) {
        this.m_emp_javaScore = m_emp_javaScore;
    }

    public int getM_emp_dbScore() {
        return m_emp_dbScore;
    }

    public void setM_emp_dbScore(int m_emp_dbScore) {
        this.m_emp_dbScore = m_emp_dbScore;
    }

    public int getM_emp_angScore() {
        return m_emp_angScore;
    }

    public void setM_emp_angScore(int m_emp_angScore) {
        this.m_emp_angScore = m_emp_angScore;
    }

    @Override
    public List<EmpDetail> getListItems() {
        return mEmpDetailList;
    }

    public void setListItems(List<EmpDetail> listItems) {
        this.mEmpDetailList = listItems;
    }



    @Override
    public Integer getMainBackgroundResource() {
        return null;
    }

    @Override
    public Integer getHeadBackgroundResource() {
        return null;
    }

}