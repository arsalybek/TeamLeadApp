package com.example.employeecard.models;

public class JoinedInfoSkill {
    public static final String TABLE_EMP_SKILL = "emp_skills";

    public static final String JOINED_ID = "join_id";
    public static final String J_SKILL_ID = "emp_skill_id";
    public static final String J_EMP_ID = "emp_info_id";
    public static final String J_SKILL_SCORE = "skill_score";

    public static final String CREATE_TABLE_EMP_SKILL =
            "CREATE TABLE " + TABLE_EMP_SKILL + "("
                    + JOINED_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + J_SKILL_ID + " INTEGER,"
                    + J_EMP_ID + " INTEGER,"
                    + J_SKILL_SCORE + " INTEGER"
                    + ")";

    private int join_id;
    private int emp_info_id;
    private int emp_skill_id;
    private int skill_score;

    public JoinedInfoSkill() { }
    public JoinedInfoSkill(int emp_info_id, int skill_id, int skill_score) {
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
