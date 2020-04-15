package com.example.employeecard.models;

import android.util.Pair;

import java.util.List;

public class EmployeeInfo {
    public static final String TABLE_EMPLOYEE = "employee_info";

    public static final String EMP_ID = "m_emp_id";
    public static final String EMP_FIO = "m_emp_fio";
    public static final String EMP_POSITION = "m_emp_position";
    public static final String EMP_AVATAR = "m_emp_img";

    public static final String CREATE_TABLE_EMPLOYEE =
            "CREATE TABLE " + TABLE_EMPLOYEE + "("
                    + EMP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + EMP_FIO + " TEXT,"
                    + EMP_POSITION + " TEXT,"
                    + EMP_AVATAR + " INTEGER"
                    + ")";


    private int m_emp_id;

    private int m_emp_img;
    private int m_emp_img_border;
    private int m_emp_card_back;
    private String m_emp_fio;
    private String m_emp_position;
    private List<Pair<Integer,String>> m_emp_skills;
    private EmpDetail mEmpDetail;

    public EmployeeInfo(){}
    public EmployeeInfo(int id, int avatar, String fio, String position) {
        this.m_emp_id = id;
        this.m_emp_img = avatar;
        this.m_emp_fio = fio;
        this.m_emp_position = position;
    }


    public EmployeeInfo(int id,int m_emp_img, int m_emp_img_border, int m_emp_card_back, String m_emp_fio, String m_emp_position) {
        this.m_emp_id = id;
        this.m_emp_img = m_emp_img;
        this.m_emp_img_border = m_emp_img_border;
        this.m_emp_card_back = m_emp_card_back;
        this.m_emp_fio = m_emp_fio;
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

    public int getM_emp_id() {
        return m_emp_id;
    }

    public void setM_emp_id(int m_emp_id) {
        this.m_emp_id = m_emp_id;
    }
}