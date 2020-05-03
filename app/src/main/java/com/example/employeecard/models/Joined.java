package com.example.employeecard.models;

import static com.example.employeecard.models.Employee.EMP_ID;
import static com.example.employeecard.models.Skill.SKILL_ID;

public class Joined {
    public static final String TABLE_EMP_SKILL = "emp_skill";

    public static final String JOINED_ID = "join_id";
    public static final String J_SKILL_SCORE = "skill_score";

    public static final String CREATE_TABLE_EMP_SKILL =
            "CREATE TABLE " + TABLE_EMP_SKILL + "("
                    + JOINED_ID + " INTEGER PRIMARY KEY ,"
                    + EMP_ID + " INTEGER REFERENCES TABLE_EMPLOYEE(EMP_ID) ON DELETE RESTRICT,"
                    + SKILL_ID + " INTEGER REFERENCES TABLE_SKILL(SKILL_ID) ON DELETE RESTRICT,"
                    + J_SKILL_SCORE + " INTEGER"
                    + ")";


    private int join_id;
    private int emp_id;
    private int skill_id;
    private int skill_score;

    public Joined() {
    }

    public Joined(int join_id, int emp_id, int skill_id, int skill_score) {
        this.join_id = join_id;
        this.emp_id = emp_id;
        this.skill_id = skill_id;
        this.skill_score = skill_score;
    }

    public int getJoin_id() {
        return join_id;
    }

    public void setJoin_id(int join_id) {
        this.join_id = join_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public int getSkill_score() {
        return skill_score;
    }

    public void setSkill_score(int skill_score) {
        this.skill_score = skill_score;
    }
}
