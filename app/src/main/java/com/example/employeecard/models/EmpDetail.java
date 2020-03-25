package com.example.employeecard.models;

public class EmpDetail {
    private int m_emp_img;
    private String m_emp_fio;
    private String emp_work_exp;
    private String m_emp_position;
    private String m_emp_skills;
    private String emp_addSkill1;
    private String emp_addSkill2;
    private String emp_addSkill3;
    private String emp_addSkill4;
    private int m_emp_javaScore;
    private int m_emp_dbScore;
    private int m_emp_angScore;

    public EmpDetail(int m_emp_img, String m_emp_fio, String emp_work_exp, String m_emp_position, String m_emp_skills, String emp_addSkill1, String emp_addSkill2, String emp_addSkill3, String emp_addSkill4, int m_emp_javaScore, int m_emp_dbScore, int m_emp_angScore) {
        this.m_emp_img = m_emp_img;
        this.m_emp_fio = m_emp_fio;
        this.emp_work_exp = emp_work_exp;
        this.m_emp_position = m_emp_position;
        this.m_emp_skills = m_emp_skills;
        this.emp_addSkill1 = emp_addSkill1;
        this.emp_addSkill2 = emp_addSkill2;
        this.emp_addSkill3 = emp_addSkill3;
        this.emp_addSkill4 = emp_addSkill4;
        this.m_emp_javaScore = m_emp_javaScore;
        this.m_emp_dbScore = m_emp_dbScore;
        this.m_emp_angScore = m_emp_angScore;
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

    public String getEmp_work_exp() {
        return emp_work_exp;
    }

    public void setEmp_work_exp(String emp_work_exp) {
        this.emp_work_exp = emp_work_exp;
    }

    public String getM_emp_position() {
        return m_emp_position;
    }

    public void setM_emp_position(String m_emp_position) {
        this.m_emp_position = m_emp_position;
    }

    public String getM_emp_skills() {
        return m_emp_skills;
    }

    public void setM_emp_skills(String m_emp_skills) {
        this.m_emp_skills = m_emp_skills;
    }

    public String getEmp_addSkill1() {
        return emp_addSkill1;
    }

    public void setEmp_addSkill1(String emp_addSkill1) {
        this.emp_addSkill1 = emp_addSkill1;
    }

    public String getEmp_addSkill2() {
        return emp_addSkill2;
    }

    public void setEmp_addSkill2(String emp_addSkill2) {
        this.emp_addSkill2 = emp_addSkill2;
    }

    public String getEmp_addSkill3() {
        return emp_addSkill3;
    }

    public void setEmp_addSkill3(String emp_addSkill3) {
        this.emp_addSkill3 = emp_addSkill3;
    }

    public String getEmp_addSkill4() {
        return emp_addSkill4;
    }

    public void setEmp_addSkill4(String emp_addSkill4) {
        this.emp_addSkill4 = emp_addSkill4;
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
}
