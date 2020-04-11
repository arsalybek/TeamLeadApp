package com.example.employeecard.fragments;

import androidx.core.util.Pair;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeecard.IChange;
import com.example.employeecard.IntervalConverter;
import com.example.employeecard.R;
import com.example.employeecard.AddSkillDialogListener;
import com.example.employeecard.adapters.EmpDetailAdapter;
import com.example.employeecard.models.CardData;

import org.jetbrains.annotations.NotNull;

public class EmpDetailFragment extends Fragment implements IChange, AddSkillDialogListener {
    private CardData card;
    private ImageView mAvatar;
    private TextView mName, mPos, mExp, mAge, mEmail, mPhone,addSkill;
    private ImageButton backBtn;
    private RecyclerView mRecyclerView;
    private EmpDetailAdapter mDetailAdapter;
    private Button saveChangesBtn;
    private LinearLayout layout;
    private NestedScrollView nestedView;
    public static EmpDetailFragment newInstance(CardData card) {
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

        mDetailAdapter = new EmpDetailAdapter(card.getM_emp_skills(), this);
        mRecyclerView.setAdapter(mDetailAdapter);

        mAvatar = v.findViewById(R.id.m_avatar_detail);
        mAvatar.setImageResource(card.getM_emp_img());

        mName = v.findViewById(R.id.m_name_detail);
        mName.setText(card.getM_emp_fio().toUpperCase());

        mPos = v.findViewById(R.id.m_position_detail);
        mPos.setText(card.getM_emp_position().toUpperCase());

        mExp = v.findViewById(R.id.m_exp_detail);
        mExp.setText(IntervalConverter.getWorkExp(card.getEmpDetail().getEmp_work_start()));

        mAge = v.findViewById(R.id.m_age_detail);
        mAge.setText(String.valueOf(card.getEmpDetail().getM_emp_age()));

        mEmail = v.findViewById(R.id.m_email_detail);
        mEmail.setText(card.getEmpDetail().getM_emp_email());

        mPhone = v.findViewById(R.id.m_phone_detail);
        mPhone.setText(card.getEmpDetail().getEmp_tel_number());

//        layout = v.findViewById(R.id.first_div);
//        nestedView = v.findViewById(R.id.nested_scroll_view);

        saveChangesBtn = v.findViewById(R.id.m_save_button);
        saveChangesBtn.setEnabled(false);
        saveChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Changes are applied",Toast.LENGTH_SHORT).show();
//                mDetailAdapter.notifyDataSetChanged();
            }
        });

//        backBtn = v.findViewById(R.id.back_button_detail);
//        final Fragment me = this;
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().popBackStack();
//            }
//        });
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
                            }
                        }catch (Exception e) {
                            // nothing
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                });

        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });

        addSkill = v.findViewById(R.id.add_skill_detail);
        final AddSkillAlertDialog skillAddDialog = new AddSkillAlertDialog(this);
        addSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skillAddDialog.showNow(getActivity().getSupportFragmentManager(), "dialog");
            }
        });

        return v;
    }
    @Override
    public void onRateChanged() {
        saveChangesBtn.setEnabled(true);
        saveChangesBtn.setBackgroundResource(R.color.colorBlue);
        saveChangesBtn.setText("Save changes");
    }

    @Override
    public void onDecBtnClicked(Pair<Integer, String> skill) {
        card.getM_emp_skills().remove(skill);
        mDetailAdapter.notifyDataSetChanged();
    }

    @Override
    public void positiveClick(String skillName) {
        card.getM_emp_skills().add(new Pair<>(1, skillName));
        mDetailAdapter.notifyDataSetChanged();
    }

}
