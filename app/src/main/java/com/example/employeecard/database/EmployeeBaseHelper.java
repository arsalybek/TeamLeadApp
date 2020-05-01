package com.example.employeecard.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.employeecard.models.EmployeeInfo;
import com.example.employeecard.models.EmployeeSkill;
import com.example.employeecard.models.JoinedInfoSkill;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;

import static com.example.employeecard.models.EmployeeInfo.EMP_ID;
import static com.example.employeecard.models.EmployeeInfo.TABLE_EMPLOYEE;
import static com.example.employeecard.models.EmployeeSkill.SKILL_NAME;
import static com.example.employeecard.models.EmployeeSkill.TABLE_SKILL;
import static com.example.employeecard.models.JoinedInfoSkill.*;
import static com.example.employeecard.models.JoinedInfoSkill.J_EMP_ID;
import static com.example.employeecard.models.JoinedInfoSkill.J_SKILL_SCORE;
import static com.example.employeecard.models.JoinedInfoSkill.TABLE_EMP_SKILL;


public class EmployeeBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 10;
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
        db.execSQL(EmployeeInfo.CREATE_TABLE_EMPLOYEE);
        db.execSQL(EmployeeSkill.CREATE_TABLE_SKILL);
        db.execSQL(CREATE_TABLE_EMP_SKILL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SKILL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMP_SKILL);
        onCreate(db);
    }

    public void insertListOfEmployee(List<EmployeeInfo> employeeInfoList) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values;

        for (int i = 0; i < employeeInfoList.size(); i++) {
            values = new ContentValues();
            values.put(EmployeeInfo.EMP_FIO, employeeInfoList.get(i).getM_emp_fio());
            values.put(EmployeeInfo.EMP_POSITION, employeeInfoList.get(i).getM_emp_position());
            values.put(EmployeeInfo.EMP_AVATAR, employeeInfoList.get(i).getM_emp_img());
            db.insert(TABLE_EMPLOYEE, null, values);
        }

        db.close();
    }

    public void insertListOfSkill(List<EmployeeSkill> employeeSkills) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values;

        for (int i = 0; i < employeeSkills.size(); i++) {
            values = new ContentValues();
            values.put(EmployeeSkill.SKILL_ID, employeeSkills.get(i).getSkill_id());
            values.put(EmployeeSkill.SKILL_NAME, employeeSkills.get(i).getSkill_name());
            db.insert(TABLE_SKILL, null, values);
        }
        db.close();
    }

    public void insertListOfJoined(List<JoinedInfoSkill> joinedInfoSkills) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values;

        for (int i = 0; i < joinedInfoSkills.size(); i++) {
            values = new ContentValues();
            values.put(J_SKILL_ID, joinedInfoSkills.get(i).getSkill_id());
            values.put(J_EMP_ID, joinedInfoSkills.get(i).getEmp_info_id());
            values.put(J_SKILL_SCORE, joinedInfoSkills.get(i).getSkill_score());
            db.insert(TABLE_EMP_SKILL, null, values);
        }
        db.close();
    }

    public List<EmployeeInfo> getAllNotes() {
        List<EmployeeInfo> list = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_EMPLOYEE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                EmployeeInfo employee = new EmployeeInfo();
                employee.setM_emp_fio(cursor.getString(cursor.getColumnIndex(EmployeeInfo.EMP_FIO)));
                employee.setM_emp_position(cursor.getString(cursor.getColumnIndex(EmployeeInfo.EMP_POSITION)));
                employee.setM_emp_img(cursor.getInt(cursor.getColumnIndex(EmployeeInfo.EMP_AVATAR)));
                employee.setM_emp_skills(getEmployeeSkill(cursor.getColumnIndex(EMP_ID)));
                Log.d("Database",getEmployeeSkill(cursor.getColumnIndex(EMP_ID)).toString());
                list.add(employee);
            } while (cursor.moveToNext());
        }

        db.close();
        return list;
    }

    public List<Pair<Integer, String>> getEmployeeSkill(int id) {
        List<Pair<Integer, String>> skillList = new ArrayList<>();

        String selectQuery = "SELECT " + TABLE_SKILL + "." + SKILL_NAME + ","
                + TABLE_EMP_SKILL + "." + J_SKILL_SCORE + " FROM "
                + TABLE_EMPLOYEE + "," + TABLE_SKILL + "," + TABLE_EMP_SKILL + " WHERE " + id + "=" +
                TABLE_EMPLOYEE + "." + EMP_ID + " AND " + TABLE_EMPLOYEE + "." + EMP_ID
                + "=" + TABLE_EMP_SKILL + "." + J_EMP_ID;

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                int pair1 = c.getInt(c.getColumnIndex(JoinedInfoSkill.J_SKILL_SCORE));
                String pair2 = c.getString(c.getColumnIndex(EmployeeSkill.SKILL_NAME));
                Pair<Integer, String> skillPair = new Pair<Integer, String>(pair1, pair2);

                skillList.add(skillPair);
            } while (c.moveToNext());
        }
        return skillList;
    }
}