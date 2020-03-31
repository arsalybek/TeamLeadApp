package com.example.employeecard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeecard.R;
import com.example.employeecard.activities.MainActivity;
import com.example.employeecard.adapters.EmpDetailAdapter;
import com.example.employeecard.models.CardData;

import org.jetbrains.annotations.NotNull;
import org.joda.time.DateTime;
import org.joda.time.Interval;

public class EmpDetailFragment extends Fragment {
    private CardData card;
    private ImageView mAvatar;
    private TextView mName,mPos,mExp,mAge,mEmail,mPhone;
    private ImageButton backBtn;
    private RecyclerView mRecyclerView;
    private EmpDetailAdapter mDetailAdapter;
    private Toolbar mToolbar;
    public static EmpDetailFragment newInstance(CardData card){
        EmpDetailFragment fragment = new EmpDetailFragment();
        fragment.card = card;
        return fragment;
    }
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_emp_detail, container, false);

        mRecyclerView = v.findViewById(R.id.m_recycler_detail);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mDetailAdapter = new EmpDetailAdapter(card.getM_emp_skills());
        mRecyclerView.setAdapter(mDetailAdapter);

        mAvatar = v.findViewById(R.id.m_avatar_detail);
        mAvatar.setImageResource(card.getM_emp_img());

        mName = v.findViewById(R.id.m_name_detail);
        mName.setText(card.getM_emp_fio().toUpperCase());

        mPos = v.findViewById(R.id.m_position_detail);
        mPos.setText(card.getM_emp_position().toUpperCase());

        mExp = v.findViewById(R.id.m_exp_detail);
        mExp.setText(getWorkExp(card.getEmpDetail().getEmp_work_start()));

        mAge = v.findViewById(R.id.m_age_detail);
        mAge.setText(String.valueOf(card.getEmpDetail().getM_emp_age()));

        mEmail = v.findViewById(R.id.m_email_detail);
        mEmail.setText(card.getEmpDetail().getM_emp_email());

        mPhone = v.findViewById(R.id.m_phone_detail);
        mPhone.setText(card.getEmpDetail().getEmp_tel_number());


        backBtn = v.findViewById(R.id.back_button_detail);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmpListFragment empDetailFragment = EmpListFragment.newInstance(card);
                MainActivity.fm.beginTransaction().replace(R.id.fragment_container,empDetailFragment).commit();
            }
        });

        return v;
    }
    private String getWorkExp(DateTime startDate){
        DateTime endDate = new DateTime();
        Interval interval = new Interval(startDate, endDate);
        long days = interval.toDuration().getStandardDays();
        int year = 0,month = 0;
//        if(days/365 > 0){
//            while(days!=0){
//                days-=365;
//                year++;
//            }
//        }
//        if(days/30 > 0){
//            while(days!=0){
//                days-=30;
//                month++;
//            }
//        }
        return "Years: " + year +" "+ " Months: " +  month + " " + " Days: " + days;
    }

}
