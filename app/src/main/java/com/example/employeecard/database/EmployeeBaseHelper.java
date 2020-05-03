package com.example.employeecard.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Paint;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.employeecard.models.Employee;
import com.example.employeecard.models.Joined;
import com.example.employeecard.models.Skill;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import static com.example.employeecard.models.Employee.EMP_ID;
import static com.example.employeecard.models.Employee.TABLE_EMPLOYEE;
import static com.example.employeecard.models.Joined.CREATE_TABLE_EMP_SKILL;
import static com.example.employeecard.models.Joined.JOINED_ID;
import static com.example.employeecard.models.Joined.J_SKILL_SCORE;
import static com.example.employeecard.models.Joined.TABLE_EMP_SKILL;
import static com.example.employeecard.models.Skill.SKILL_ID;
import static com.example.employeecard.models.Skill.SKILL_NAME;
import static com.example.employeecard.models.Skill.TABLE_SKILL;


public class EmployeeBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 37;
    private static final String DATABASE_NAME = "employee_db";

    private static EmployeeBaseHelper mInstance = null;

    public static EmployeeBaseHelper getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new EmployeeBaseHelper(context);
        }
        return mInstance;
    }

    public EmployeeBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Employee.CREATE_TABLE_EMPLOYEE);
        db.execSQL(Skill.CREATE_TABLE_SKILL);
        db.execSQL(CREATE_TABLE_EMP_SKILL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SKILL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMP_SKILL);
        onCreate(db);
    }

    public void insertListOfEmployee(List<Employee> employeeList) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values;

        for (int i = 0; i < employeeList.size(); i++) {
            values = new ContentValues();
            values.put(Employee.EMP_ID, employeeList.get(i).getEmp_id());
            values.put(Employee.EMP_FULL_NAME, employeeList.get(i).getEmp_full_name());
            values.put(Employee.EMP_POSITION, employeeList.get(i).getEmp_position());
            values.put(Employee.EMP_IMAGE, employeeList.get(i).getEmp_img());
            values.put(Employee.EMP_IMAGE_BORDER, employeeList.get(i).getEmp_img_border());
            values.put(Employee.EMP_CARD_BACK, employeeList.get(i).getEmp_card_back());
            values.put(Employee.EMP_WORK_START, String.valueOf(employeeList.get(i).getEmp_work_start()));
            values.put(Employee.EMP_AGE, employeeList.get(i).getEmp_age());
            values.put(Employee.EMP_EMAIL, employeeList.get(i).getEmp_email());
            values.put(Employee.EMP_TEL_NUMBER, employeeList.get(i).getEmp_tel_number());

            db.insert(TABLE_EMPLOYEE, null, values);
        }
        db.close();
    }

    public void insertListOfSkill(List<Skill> employeeSkills) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values;

        for (int i = 0; i < employeeSkills.size(); i++) {
            values = new ContentValues();
            values.put(SKILL_ID,employeeSkills.get(i).getSkill_id());
            values.put(Skill.SKILL_NAME, employeeSkills.get(i).getSkill_name());
            db.insert(TABLE_SKILL, null, values);
        }
        db.close();
    }

    public void insertListOfJoined(List<Joined> joinedInfoSkills) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values;

        for (int i = 0; i < joinedInfoSkills.size(); i++) {
            values = new ContentValues();
            values.put(JOINED_ID,joinedInfoSkills.get(i).getJoin_id());
            values.put(Employee.EMP_ID, joinedInfoSkills.get(i).getEmp_id());
            values.put(Skill.SKILL_ID, joinedInfoSkills.get(i).getSkill_id());
            values.put(J_SKILL_SCORE, joinedInfoSkills.get(i).getSkill_score());
            db.insert(TABLE_EMP_SKILL, null, values);
        }
        db.close();
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_EMPLOYEE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Employee employee = new Employee();
                employee.setEmp_id(cursor.getInt(cursor.getColumnIndex(Employee.EMP_ID)));
                employee.setEmp_full_name(cursor.getString(cursor.getColumnIndex(Employee.EMP_FULL_NAME)));
                employee.setEmp_position(cursor.getString(cursor.getColumnIndex(Employee.EMP_POSITION)));
                employee.setEmp_img(cursor.getInt(cursor.getColumnIndex(Employee.EMP_IMAGE)));
                employee.setEmp_card_back(cursor.getInt(cursor.getColumnIndex(Employee.EMP_CARD_BACK)));
                employee.setEmp_work_start(LocalDate.parse(cursor.getString(cursor.getColumnIndex(Employee.EMP_WORK_START))));
                employee.setEmp_age(cursor.getInt(cursor.getColumnIndex(Employee.EMP_AGE)));
                employee.setEmp_email(cursor.getString(cursor.getColumnIndex(Employee.EMP_EMAIL)));
                employee.setEmp_tel_number(cursor.getString(cursor.getColumnIndex(Employee.EMP_TEL_NUMBER)));
                employee.setEmp_skills(getEmployeeSkill(cursor.getInt(cursor.getColumnIndex(Employee.EMP_ID))));
                list.add(employee);
            } while (cursor.moveToNext());
        }
        db.close();
        return list;
    }

    public List<Skill> getAllSkills(){
        List<Skill>skillList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_SKILL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Skill s = new Skill();
                s.setSkill_id(cursor.getInt(cursor.getColumnIndex(SKILL_ID)));
                s.setSkill_name(cursor.getString(cursor.getColumnIndex(SKILL_NAME)));
                skillList.add(s);
            } while (cursor.moveToNext());
        }
        db.close();
        return skillList;
    }


    private List<Skill> getEmployeeSkill(int id) {
        List<Skill> skillList = new ArrayList<>();

        String selectQuery = "SELECT " + TABLE_SKILL + "." + SKILL_NAME + ","
                + TABLE_EMP_SKILL + "." + J_SKILL_SCORE + " FROM "
                + TABLE_EMPLOYEE + "," + TABLE_SKILL + "," + TABLE_EMP_SKILL + " WHERE " + id + "=" +
                TABLE_EMPLOYEE + "." + Employee.EMP_ID + " AND " + TABLE_EMPLOYEE + "." + Employee.EMP_ID
                + "=" + TABLE_EMP_SKILL + "." + Employee.EMP_ID + " AND " +
                TABLE_SKILL + "." + SKILL_ID + "=" + TABLE_EMP_SKILL + "." + SKILL_ID;

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                int score = c.getInt(c.getColumnIndex(Joined.J_SKILL_SCORE));
                String name = c.getString(c.getColumnIndex(Skill.SKILL_NAME));
                Skill skill = new Skill(name,score);

                skillList.add(skill);
            } while (c.moveToNext());
        }
        return skillList;
    }

    public void removeAll() {
        SQLiteDatabase db = this.getWritableDatabase(); // helper is object extends SQLiteOpenHelper
        db.delete(TABLE_EMP_SKILL, null, null);
        db.delete(TABLE_SKILL, null, null);
        db.delete(TABLE_EMPLOYEE, null, null);
    }

    public void updateSkillScore(int emp_id,int skill_id, int score){
        String updateQuery = "UPDATE " + TABLE_EMP_SKILL + " SET "+
        J_SKILL_SCORE + "=" + score + " WHERE " +
                Employee.EMP_ID  + "=" + emp_id + " AND " +  SKILL_ID + "=" + skill_id;
        Log.d("TEST DB EMP_ID",String.valueOf(emp_id));
        Log.d("TEST DB SKILL_ID", String.valueOf(skill_id));
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(updateQuery);
    }

    public void deleteSkill(int emp_id,int skill_id){
        String deleteQuery = "DELETE FROM " + TABLE_EMP_SKILL +  " WHERE " +
                Employee.EMP_ID  + "=" + emp_id + " AND " +  SKILL_ID + "=" + skill_id;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(deleteQuery);
    }

    public void  addSkill(int join_id,int emp_id, int skill_id, String skill_name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues newSkill = new ContentValues();
        newSkill.put(SKILL_ID, skill_id);
        newSkill.put(SKILL_NAME, skill_name);

        db.insert(TABLE_SKILL, null, newSkill);
        Log.d("DB SKILL", String.valueOf(skill_id));
        Log.d("DB SKILL", skill_name);
        ContentValues newJoin = new ContentValues();
        newJoin.put(JOINED_ID,join_id);
        newJoin.put(EMP_ID,emp_id);
        newJoin.put(SKILL_ID,skill_id);
        newJoin.put(J_SKILL_SCORE,1);
        Log.d("DB JOIN", String.valueOf(join_id));
        Log.d("DB JOIN", String.valueOf(emp_id));
        Log.d("DB JOIN", String.valueOf(skill_id));
        db.insert(TABLE_EMP_SKILL,null,newJoin);
    }
}