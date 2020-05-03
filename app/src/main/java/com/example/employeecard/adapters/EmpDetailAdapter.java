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
import com.example.employeecard.database.EmployeeBaseHelper;
import com.example.employeecard.fragments.DeleteSkillAlertDialog;
import com.example.employeecard.fragments.EmpDetailFragment;
import com.example.employeecard.models.Skill;

import java.util.List;

public class EmpDetailAdapter extends RecyclerView.Adapter<EmpDetailAdapter.EmpDetailHolder> implements DeleteSkillDialogListener {
    public List<Skill> skillList;
    IChange mIChange;
    public EmpDetailAdapter(List<Skill> skillList,IChange mIChange){
        this.skillList = skillList;
        this.mIChange = mIChange;
    }
    @NonNull
    @Override
    public EmpDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.emp_detail_skill_row,parent,false);
        return new EmpDetailHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final EmpDetailHolder holder, final int i) {
        final Skill skill = skillList.get(i);
        holder.skill.setText(skill.getSkill_name());
        holder.skillRate.setText(String.valueOf(skill.getSkill_score()));

        holder.incBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(holder.skillRate.getText().toString()).equals("10")) {
                    int s = Integer.parseInt(holder.skillRate.getText().toString()) + 1;
                    holder.skillRate.setText(String.valueOf(s));
                    skill.setSkill_score(s);
//                    mIChange.onSingleScoreChanged(i,s);
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
                    skill.setSkill_score(s);
//                    mIChange.onSingleScoreChanged(i,s);
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
        return skillList.size();
    }

    @Override
    public void positiveClick(int i) {
        mIChange.onDecBtnClicked(skillList.get(i));
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
