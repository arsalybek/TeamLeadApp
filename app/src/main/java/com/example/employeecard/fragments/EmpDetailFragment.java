package com.example.employeecard.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeecard.AddSkillDialogListener;
import com.example.employeecard.IChange;
import com.example.employeecard.IntervalConverter;
import com.example.employeecard.R;
import com.example.employeecard.adapters.EmpDetailAdapter;
import com.example.employeecard.database.EmployeeBaseHelper;
import com.example.employeecard.models.Employee;
import com.example.employeecard.models.Skill;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EmpDetailFragment extends Fragment implements IChange, AddSkillDialogListener {
    private Employee card;
    private ImageView mAvatar;
    private TextView mName, mPos, mExp, mAge, mEmail, mPhone, addSkill;
    private ImageButton backBtn;
    private RecyclerView mRecyclerView;
    private EmpDetailAdapter mDetailAdapter;
    private Button saveChangesBtn;
    private DetailScrollView scrollView;

    private List<Skill> skillList = new ArrayList<>();
    private List<Employee> employeeList = new ArrayList<>();

    private EmployeeBaseHelper db = EmployeeBaseHelper.getInstance(getContext());

    public static EmpDetailFragment newInstance(Employee card) {
        EmpDetailFragment fragment = new EmpDetailFragment();
        fragment.card = card;
        return fragment;
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_emp_detail, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        mRecyclerView = v.findViewById(R.id.m_recycler_detail);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mDetailAdapter = new EmpDetailAdapter(card.getEmp_skills(), this);
        mRecyclerView.setAdapter(mDetailAdapter);

        mAvatar = v.findViewById(R.id.m_avatar_detail);
        mAvatar.setImageResource(card.getEmp_img());

        mName = v.findViewById(R.id.m_name_detail);
        mName.setText(card.getEmp_full_name().toUpperCase());

        mPos = v.findViewById(R.id.m_position_detail);
        mPos.setText(card.getEmp_position().toUpperCase());

        mExp = v.findViewById(R.id.m_exp_detail);
        mExp.setText(IntervalConverter.getWorkExp(card.getEmp_work_start()));

        mAge = v.findViewById(R.id.m_age_detail);
        mAge.setText(String.valueOf(card.getEmp_age()));

        mEmail = v.findViewById(R.id.m_email_detail);
        mEmail.setText(card.getEmp_email());

        mPhone = v.findViewById(R.id.m_phone_detail);
        mPhone.setText(card.getEmp_tel_number());


        scrollView = v.findViewById(R.id.nested_scroll_view);


        saveChangesBtn = v.findViewById(R.id.m_save_button);
        saveChangesBtn.setEnabled(false);
        saveChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skillList.addAll(db.getAllSkills());
                for( Skill s : card.getEmp_skills()){
                    for(Skill s1: skillList){
                        if(s.getSkill_name().equals(s1.getSkill_name())) {
                            db.updateSkillScore(card.getEmp_id(), s1.getSkill_id(), s.getSkill_score());
                            Log.d("Fragment", String.valueOf(s.getSkill_score()));
                        }
                    }
                }
                mDetailAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Changes are applied", Toast.LENGTH_SHORT).show();
            }
        });
        final GestureDetector gesture = new GestureDetector(v.getContext(),
                new GestureDetector.SimpleOnGestureListener() {

                    @Override
                    public boolean onDown(MotionEvent e) {
                        return true;
                    }

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                           float velocityY) {
                        final int SWIPE_MIN_DISTANCE = 200;
                        final int SWIPE_THRESHOLD_VELOCITY = 200;
                        try {
                            Log.e("EmpDetailFragmnt", "ongesture");
                            if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                                Log.e("EmpDetailFragmnt", "Left to right");
                                getActivity().getSupportFragmentManager().popBackStack();
                            }

                        } catch (Exception e) {
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                });
        scrollView.setDetector(gesture);

        addSkill = v.findViewById(R.id.add_skill_detail);
        final AddSkillAlertDialog skillAddDialog = new AddSkillAlertDialog(this);
        addSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skillAddDialog.showNow(getActivity().getSupportFragmentManager(), "dialog");
            }
        });
        skillList.addAll(db.getAllSkills());
        employeeList.addAll(db.getAllEmployees());
        return v;
    }

    @Override
    public void onRateChanged() {
        saveChangesBtn.setEnabled(true);
        saveChangesBtn.setBackgroundResource(R.color.colorBlue);
        saveChangesBtn.setText("Save changes");
    }

    @Override
    public void onDecBtnClicked(Skill skill) {
        card.getEmp_skills().remove(skill);
        skillList.addAll(db.getAllSkills());
        int res = 0;
        for( Skill s : skillList){
            if(s.getSkill_name().equals(skill.getSkill_name()))
                res = s.getSkill_id();
        }
        db.deleteSkill(card.getEmp_id(),res);
        mDetailAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSingleScoreChanged(int id, int score) {
//        int res = 0;
//        for( Skill s : skillList){
//            if(card.getEmp_skills().get(id).getSkill_name().equals(s.getSkill_name()))
//                res = s.getSkill_id();
//        }
//        db.updateSkillScore(card.getEmp_id(),res,score);
//        Log.d("TEST CARD", String.valueOf(card.getEmp_skills().get(id).getSkill_id()));
    }

    @Override
    public void positiveClick(String skillName) { ;
        int cnt=  0;
        for(Employee e : employeeList){
            cnt+=e.getEmp_skills().size();
        }
        Log.d("Fragment",skillList.toString());
        db.addSkill(cnt+1,card.getEmp_id(),skillList.size()+1,skillName);
        card.getEmp_skills().add(new Skill(skillName, 1));
        mDetailAdapter.notifyDataSetChanged();
    }
}
