package com.example.employeecard.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.employeecard.models.EmployeeInfo;
import com.example.employeecard.models.EmployeeSkill;
import com.example.employeecard.models.JoinedInfoSkill;

import java.util.ArrayList;
import java.util.List;


public class EmployeeBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "employee_db";


    private static final String TABLE_SKILL = "skills";
    private static final String TABLE_EMP_SKILL = "emp_skills";

    public static final String SKILL_ID = "skill_id";
    public static final String SKILL_NAME = "skill_name";

    public static final String JOINED_ID = "join_id";
    public static final String J_SKILL_ID = "emp_skill_id";
    public static final String J_EMP_ID = "emp_info_id";
    public static final String J_SKILL_SCORE = "skill_score";

    public static final String CREATE_TABLE_EMPLOYEE =
            "CREATE TABLE " + EmployeeInfo.TABLE_EMPLOYEE + "("
                    + EmployeeInfo.EMP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + EmployeeInfo.EMP_FIO + " TEXT,"
                    + EmployeeInfo.EMP_POSITION + " TEXT,"
                    + EmployeeInfo.EMP_AVATAR + " INTEGER"
                    + ")";
    public static final String CREATE_TABLE_SKILL =
            "CREATE TABLE " + TABLE_SKILL + "("
                    + SKILL_ID + "INTEGER,"
                    + SKILL_NAME + " TEXT"
                    + ")";
    public static final String CREATE_TABLE_EMP_SKILL =
            "CREATE TABLE " + TABLE_EMP_SKILL+ "("
                    + JOINED_ID + "INTEGER,"
                    + J_SKILL_ID + " INTEGER,"
                    + J_EMP_ID + " INTEGER,"
                    + J_SKILL_SCORE + " INTEGER"
                    + ")";

    public EmployeeBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EMPLOYEE);
        db.execSQL(CREATE_TABLE_SKILL);
        db.execSQL(CREATE_TABLE_EMP_SKILL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EmployeeInfo.TABLE_EMPLOYEE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SKILL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMP_SKILL);
        onCreate(db);
    }
    public void insertListOfEmployee(List<EmployeeInfo> employeeInfoList) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values;

        for(int i = 0; i < employeeInfoList.size(); i++) {
            values = new ContentValues();
            values.put(EmployeeInfo.EMP_FIO, employeeInfoList.get(i).getM_emp_fio());
            values.put(EmployeeInfo.EMP_POSITION, employeeInfoList.get(i).getM_emp_position());
            values.put(EmployeeInfo.EMP_AVATAR, employeeInfoList.get(i).getM_emp_img());
            db.insert(EmployeeInfo.TABLE_EMPLOYEE, null, values);
        }

        db.close();
    }

    public void insertListOfSkill(List<EmployeeSkill> employeeSkills) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values;

        for(int i = 0; i < employeeSkills.size(); i++) {
            values = new ContentValues();
            values.put(SKILL_ID,employeeSkills.get(i).getSkill_id());
            values.put(SKILL_NAME, employeeSkills.get(i).getSkill_name());
            db.insert(TABLE_SKILL, null, values);
        }
        db.close();
    }

    public void insertListOfJoined(List<JoinedInfoSkill> joinedInfoSkills) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values;

        for(int i = 0; i < joinedInfoSkills.size(); i++) {
            values = new ContentValues();
            values.put(JOINED_ID,joinedInfoSkills.get(i).getJoin_id());
            values.put(J_SKILL_ID, joinedInfoSkills.get(i).getSkill_id());
            values.put(J_EMP_ID, joinedInfoSkills.get(i).getEmp_info_id());
            values.put(J_SKILL_SCORE, joinedInfoSkills.get(i).getSkill_score());
        }

        db.close();
    }
    public List<EmployeeInfo> getAllNotes() {
        List<EmployeeInfo> list = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + EmployeeInfo.TABLE_EMPLOYEE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                EmployeeInfo employee = new EmployeeInfo();
                employee.setM_emp_fio(cursor.getString(cursor.getColumnIndex(EmployeeInfo.EMP_FIO)));
                employee.setM_emp_position(cursor.getString(cursor.getColumnIndex(EmployeeInfo.EMP_POSITION)));
                employee.setM_emp_img(cursor.getInt(cursor.getColumnIndex(EmployeeInfo.EMP_AVATAR)));
                list.add(employee);
            } while (cursor.moveToNext());
        }

        db.close();
        return list;
    }

}
