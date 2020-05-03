package com.example.employeecard.models;

public class Skill {
    public static final String TABLE_SKILL = "skill";

    public static final String SKILL_ID = "skill_id";
    public static final String SKILL_NAME = "skill_name";

    public static final String CREATE_TABLE_SKILL =
            "CREATE TABLE " + TABLE_SKILL + "("
                    + SKILL_ID + " INTEGER PRIMARY KEY,"
                    + SKILL_NAME + " TEXT"
                    + ")";

    private int skill_id;
    private String skill_name;
    private int skill_score;

    public Skill() {
    }

    public Skill(int skill_id, String skill_name) {
        this.skill_id = skill_id;
        this.skill_name = skill_name;
    }

    public Skill(String skill_name, int skill_score){
        this.skill_name = skill_name;
        this.skill_score = skill_score;
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

    public int getSkill_score() {
        return skill_score;
    }

    public void setSkill_score(int skill_score) {
        this.skill_score = skill_score;
    }
}
