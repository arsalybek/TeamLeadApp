package com.example.employeecard.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import android.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeecard.DeleteSkillDialogListener;
import com.example.employeecard.IChange;
import com.example.employeecard.R;
import com.example.employeecard.activities.MainActivity;
import com.example.employeecard.fragments.DeleteSkillAlertDialog;
import com.example.employeecard.fragments.EmpDetailFragment;

import java.util.List;

public class EmpDetailAdapter extends RecyclerView.Adapter<EmpDetailAdapter.EmpDetailHolder> implements DeleteSkillDialogListener {
    public List<Pair<Integer,String>> mSkillList;
    IChange mIChange;
    public EmpDetailAdapter(List<android.util.Pair<Integer, String>> m_emp_skills, EmpDetailFragment mIChange){}
    public EmpDetailAdapter(List<Pair<Integer,String>> mSkillList,IChange mIChange){
        this.mSkillList = mSkillList;
        this.mIChange = mIChange;
    }
    @NonNull
    @Override
    public EmpDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.emp_detail_skill_row,parent,false);
        return new EmpDetailHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final EmpDetailHolder holder, int i) {
        final Pair<Integer,String> skill = mSkillList.get(i);
        holder.skill.setText(skill.second);
        holder.skillRate.setText(String.valueOf(skill.first));

        holder.incBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(holder.skillRate.getText().toString()).equals("10")) {
                    int s = Integer.parseInt(holder.skillRate.getText().toString()) + 1;
                    holder.skillRate.setText(String.valueOf(s));
                    mIChange.onRateChanged();
                    Log.e("EmpDetailAdapter","true");

                }
            }
        }
        );
        final DeleteSkillAlertDialog deleteSkillDialog = new DeleteSkillAlertDialog(this,i);
        holder.decBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(holder.skillRate.getText().toString()).equals("1")) {
                    int s = Integer.parseInt(holder.skillRate.getText().toString()) - 1;
                    holder.skillRate.setText(String.valueOf(s));
                    mIChange.onRateChanged();
                    Log.e("EmpDetailAdapter","true");
                }
                else{
                    deleteSkillDialog.showNow(MainActivity.fm,"delete");
                }

            }
        }
        );
    }

    @Override
    public int getItemCount() {
        return mSkillList.size();
    }

    @Override
    public void positiveClick(int i) {
        mIChange.onDecBtnClicked(mSkillList.get(i));
    }

    public class EmpDetailHolder extends RecyclerView.ViewHolder {
        TextView skill, skillRate;
        ImageButton incBtn, decBtn;
        Button saveBtn;

        public EmpDetailHolder(@NonNull View itemView) {
            super(itemView);
            skill = itemView.findViewById(R.id.m_skill_detail);
            skillRate = itemView.findViewById(R.id.m_skill_rate_detail);
            incBtn = itemView.findViewById(R.id.m_skill_inc);
            decBtn = itemView.findViewById(R.id.m_skill_dec);
        }
    }
}
