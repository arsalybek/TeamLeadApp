package com.example.employeecard.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.employeecard.R;
import com.example.employeecard.models.EmpDetail;
import com.ramotion.expandingcollection.ECCardContentListItemAdapter;

import java.util.List;

public class EmpDetailAdapter extends ECCardContentListItemAdapter<EmpDetail> {
    public EmpDetailAdapter(@NonNull Context context,@NonNull List<EmpDetail> objects) {
        super(context, R.layout.emp_card_detail, objects);
    }
    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());

            rowView = inflater.inflate(R.layout.emp_card_detail, null);
            viewHolder = new ViewHolder();
            viewHolder.imgD = rowView.findViewById(R.id.emp_img_detail);
            viewHolder.fioD = rowView.findViewById(R.id.emp_fio_detail);
            viewHolder.workExpD = rowView.findViewById(R.id.emp_work_exp_detail);
            viewHolder.posD = rowView.findViewById(R.id.emp_pos_detail);
            viewHolder.empSkillsD = rowView.findViewById(R.id.emp_skills_detail);
            viewHolder.addSkill1D = rowView.findViewById(R.id.emp_add_skill1_detail);
            viewHolder.addSkill2D = rowView.findViewById(R.id.emp_add_skill2_detail);
            viewHolder.addSkill3D = rowView.findViewById(R.id.emp_add_skill3_detail);
            viewHolder.addSkill4D = rowView.findViewById(R.id.emp_add_skill4_detail);
            viewHolder.angularScore = rowView.findViewById(R.id.emp_angular_score);
            viewHolder.javaScore = rowView.findViewById(R.id.emp_java_score);
            viewHolder.dbScore = rowView.findViewById(R.id.emp_db_score);
            viewHolder.angIncBtn = rowView.findViewById(R.id.emp_angular_inc_btn);
            viewHolder.angDecBtn = rowView.findViewById(R.id.emp_angular_dec_btn);
            viewHolder.javaIncBtn = rowView.findViewById(R.id.emp_java_inc_btn);
            viewHolder.javaDecBtn = rowView.findViewById(R.id.emp_java_dec_btn);
            viewHolder.dbIncBtn = rowView.findViewById(R.id.emp_db_inc_btn);
            viewHolder.dbDecBtn = rowView.findViewById(R.id.emp_db_dec_btn);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        final EmpDetail detail = getItem(position);
        if (detail != null) {
            viewHolder.imgD.setImageResource(detail.getM_emp_img());
            viewHolder.fioD.setText(detail.getM_emp_fio());
            viewHolder.workExpD.setText(detail.getEmp_work_exp());
            viewHolder.posD.setText(detail.getM_emp_position());
            viewHolder.empSkillsD.setText(detail.getM_emp_skills());
            viewHolder.addSkill1D.setText(detail.getEmp_addSkill1());
            viewHolder.addSkill2D.setText(detail.getEmp_addSkill2());
            viewHolder.addSkill3D.setText(detail.getEmp_addSkill3());
            viewHolder.addSkill4D.setText(detail.getEmp_addSkill4());
            viewHolder.angularScore.setText(Integer.toString(detail.getM_emp_angScore()));
            viewHolder.javaScore.setText(Integer.toString(detail.getM_emp_javaScore()));
            viewHolder.dbScore.setText(Integer.toString(detail.getM_emp_dbScore()));

        }
        viewHolder.angIncBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!(viewHolder.angularScore.getText().toString()).equals("5")) {
                        int s = Integer.parseInt(viewHolder.angularScore.getText().toString()) + 1;
                        viewHolder.angularScore.setText(String.valueOf(s));
                    }
                }
            }
            );
        viewHolder.angDecBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!(viewHolder.angularScore.getText().toString()).equals("1")) {
                        int s = Integer.parseInt(viewHolder.angularScore.getText().toString()) - 1;
                        viewHolder.angularScore.setText(String.valueOf(s));
                    }
                }
        }
        );
        viewHolder.javaIncBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!(viewHolder.javaScore.getText().toString()).equals("5")) {
                        int s = Integer.parseInt(viewHolder.javaScore.getText().toString()) + 1;
                        viewHolder.javaScore.setText(String.valueOf(s));
                    }
                }
            }
        );
        viewHolder.javaDecBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!(viewHolder.javaScore.getText().toString()).equals("1")) {
                        int s = Integer.parseInt(viewHolder.javaScore.getText().toString()) - 1;
                        viewHolder.javaScore.setText(String.valueOf(s));
                    }
                }
            }
        );
        viewHolder.dbIncBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!(viewHolder.dbScore.getText().toString()).equals("5")) {
                        int s = Integer.parseInt(viewHolder.dbScore.getText().toString()) + 1;
                        viewHolder.dbScore.setText(String.valueOf(s));
                    }
                }
            }
        );
        viewHolder.dbDecBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!(viewHolder.dbScore.getText().toString()).equals("1")) {
                        int s = Integer.parseInt(viewHolder.dbScore.getText().toString()) - 1;
                        viewHolder.dbScore.setText(String.valueOf(s));
                    }
                }
            }
        );

        return rowView;
    }
    static class ViewHolder {
        ImageView imgD;
        TextView fioD, workExpD, posD, empSkillsD, addSkill1D,addSkill2D, addSkill3D, addSkill4D,
                angularScore,javaScore,dbScore;
        ImageButton angIncBtn, angDecBtn, javaIncBtn, javaDecBtn, dbIncBtn, dbDecBtn;
        Button saveBtn;
    }
}
