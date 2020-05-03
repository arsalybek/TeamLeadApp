package com.example.employeecard.models;

import org.joda.time.LocalDate;

import java.util.List;

public class Employee {
    public static final String TABLE_EMPLOYEE = "employee";

    public static final String EMP_ID = "emp_id";
    public static final String EMP_FULL_NAME = "emp_full_name";
    public static final String EMP_POSITION = "emp_position";
    public static final String EMP_IMAGE = "emp_img";
    public static final String EMP_IMAGE_BORDER = "emp_img_border";
    public static final String EMP_CARD_BACK = "emp_card_back";
    public static final String EMP_WORK_START = "emp_work_start";
    public static final String EMP_AGE = "emp_age";
    public static final String EMP_EMAIL = "emp_email";
    public static final String EMP_TEL_NUMBER = "emp_tel_number";

    public static final String CREATE_TABLE_EMPLOYEE =
            "CREATE TABLE " + TABLE_EMPLOYEE + "("
                    + EMP_ID + " INTEGER PRIMARY KEY,"
                    + EMP_FULL_NAME + " TEXT,"
                    + EMP_POSITION + " TEXT,"
                    + EMP_IMAGE + " INTEGER,"
                    + EMP_IMAGE_BORDER + " INTEGER,"
                    + EMP_CARD_BACK + " INTEGER,"
                    + EMP_WORK_START + " DATE,"
                    + EMP_AGE + " INTEGER,"
                    + EMP_EMAIL + " TEXT,"
                    + EMP_TEL_NUMBER + " TEXT"
                    + ")";

    private int emp_id;
    private String emp_full_name;
    private String emp_position;
    private int emp_img;
    private int emp_img_border;
    private int emp_card_back;
    private List<Skill> emp_skills;
    private LocalDate emp_work_start;
    private int emp_age;
    private String emp_email;
    private String emp_tel_number;

    public Employee() {
    }

    public Employee(int emp_id, String emp_full_name, String emp_position, int emp_img, int emp_img_border, int emp_card_back,LocalDate emp_work_start, int emp_age, String emp_email, String emp_tel_number) {
        this.emp_id = emp_id;
        this.emp_full_name = emp_full_name;
        this.emp_position = emp_position;
        this.emp_img = emp_img;
        this.emp_img_border = emp_img_border;
        this.emp_card_back = emp_card_back;
        this.emp_work_start = emp_work_start;
        this.emp_age = emp_age;
        this.emp_email = emp_email;
        this.emp_tel_number = emp_tel_number;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_full_name() {
        return emp_full_name;
    }

    public void setEmp_full_name(String emp_full_name) {
        this.emp_full_name = emp_full_name;
    }

    public String getEmp_position() {
        return emp_position;
    }

    public void setEmp_position(String emp_position) {
        this.emp_position = emp_position;
    }

    public int getEmp_img() {
        return emp_img;
    }

    public void setEmp_img(int emp_img) {
        this.emp_img = emp_img;
    }

    public int getEmp_img_border() {
        return emp_img_border;
    }

    public void setEmp_img_border(int emp_img_border) {
        this.emp_img_border = emp_img_border;
    }

    public int getEmp_card_back() {
        return emp_card_back;
    }

    public void setEmp_card_back(int emp_card_back) {
        this.emp_card_back = emp_card_back;
    }

    public List<Skill> getEmp_skills() {
        return emp_skills;
    }

    public void setEmp_skills(List<Skill> emp_skills) {
        this.emp_skills = emp_skills;
    }

    public LocalDate getEmp_work_start() {
        return emp_work_start;
    }

    public void setEmp_work_start(LocalDate emp_work_start) {
        this.emp_work_start = emp_work_start;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getEmp_tel_number() {
        return emp_tel_number;
    }

    public void setEmp_tel_number(String emp_tel_number) {
        this.emp_tel_number = emp_tel_number;
    }

    public String toString(){
        return "ID" + emp_id + "NAME" + emp_full_name;
    }
}