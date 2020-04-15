package com.example.employeecard.models;

public class EmployeeSkill {
    public static final String TABLE_SKILL = "skills";

    public static final String SKILL_ID = "skill_id";
    public static final String SKILL_NAME = "skill_name";

    public static final String CREATE_TABLE_SKILL =
            "CREATE TABLE " + TABLE_SKILL + "("
                    + SKILL_ID + " INTEGER,"
                    + SKILL_NAME + " TEXT"
                    + ")";

    private int skill_id;
    private String skill_name;

    public EmployeeSkill(){}
    public EmployeeSkill(int skill_id, String skill_name) {
        this.skill_id = skill_id;
        this.skill_name = skill_name;
    }

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

}
