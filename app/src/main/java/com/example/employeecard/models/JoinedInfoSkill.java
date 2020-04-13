package com.example.employeecard.models;

public class JoinedInfoSkill {
    private int join_id;
    private int emp_info_id;
    private int emp_skill_id;
    private int skill_score;

    public JoinedInfoSkill() { }
    public JoinedInfoSkill(int join_id, int emp_info_id, int skill_id, int skill_score) {
        this.join_id = join_id;
        this.emp_info_id = emp_info_id;
        this.emp_skill_id = skill_id;
        this.skill_score = skill_score;
    }
    public int getJoin_id() {
        return join_id;
    }

    public void setJoin_id(int join_id) {
        this.join_id = join_id;
    }

    public int getEmp_info_id() {
        return emp_info_id;
    }

    public void setEmp_info_id(int emp_info_id) {
        this.emp_info_id = emp_info_id;
    }

    public int getSkill_id() {
        return emp_skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.emp_skill_id = skill_id;
    }

    public int getSkill_score() {
        return skill_score;
    }

    public void setSkill_score(int skill_score) {
        this.skill_score = skill_score;
    }
}
