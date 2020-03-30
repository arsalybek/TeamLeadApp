package com.example.employeecard.models;


import androidx.core.util.Pair;

import java.util.List;

public class CardData {

    private int m_emp_img;
    private int m_emp_img_border;
    private int m_emp_card_back;
    private String m_emp_fio;
    private String m_emp_position;
    private List<Pair<Integer,String>> m_emp_skills;
    private EmpDetail mEmpDetail;

    public CardData(int m_emp_img,int m_emp_img_border,int m_emp_card_back, String m_emp_fio, String m_emp_position, List<Pair<Integer, String>> m_emp_skills) {
        this.m_emp_img = m_emp_img;
        this.m_emp_img_border = m_emp_img_border;
        this.m_emp_card_back = m_emp_card_back;
        this.m_emp_fio = m_emp_fio;
        this.m_emp_position = m_emp_position;
        this.m_emp_skills = m_emp_skills;
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

    public String getM_emp_position() {
        return m_emp_position;
    }

    public void setM_emp_position(String m_emp_position) {
        this.m_emp_position = m_emp_position;
    }

    public List<Pair<Integer, String>> getM_emp_skills() {
        return m_emp_skills;
    }
    public void setM_emp_skills(List<Pair<Integer, String>> m_emp_skills) {
        this.m_emp_skills = m_emp_skills;
    }

    public int getM_emp_card_back() {
        return m_emp_card_back;
    }

    public void setM_emp_card_back(int m_emp_card_back) {
        this.m_emp_card_back = m_emp_card_back;
    }

    public int getM_emp_img_border() {
        return m_emp_img_border;
    }

    public void setM_emp_img_border(int m_emp_img_border) {
        this.m_emp_img_border = m_emp_img_border;
    }

    public EmpDetail getEmpDetail() {
        return mEmpDetail;
    }

    public void setEmpDetail(EmpDetail empDetail) {
        mEmpDetail = empDetail;
    }
}