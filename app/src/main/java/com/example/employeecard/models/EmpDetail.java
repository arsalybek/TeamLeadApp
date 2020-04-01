package com.example.employeecard.models;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.Date;

public class EmpDetail {
    private LocalDate m_emp_work_start;
    private int m_emp_age;
    private String m_emp_email;
    private String emp_tel_number;

    public EmpDetail(LocalDate m_emp_work_start, int m_emp_age, String m_emp_email, String emp_tel_number) {
        this.m_emp_work_start = m_emp_work_start;
        this.m_emp_age = m_emp_age;
        this.m_emp_email = m_emp_email;
        this.emp_tel_number = emp_tel_number;
    }

    public LocalDate getEmp_work_start() {
        return m_emp_work_start;
    }

    public int getM_emp_age() {
        return m_emp_age;
    }

    public String getM_emp_email() {
        return m_emp_email;
    }

    public String getEmp_tel_number() {
        return emp_tel_number;
    }
}
