package com.example.employeecard.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeecard.R;
import com.example.employeecard.activities.MainActivity;
import com.example.employeecard.fragments.EmpDetailFragment;
import com.example.employeecard.models.Employee;

import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;


public class EmpListAdapter extends RecyclerView.Adapter<EmpListAdapter.EmpListHolder> {
    private List<Employee> mEmployeeInfoList;
    public EmpListAdapter(List<Employee> mEmployeeInfoList){
        this.mEmployeeInfoList = mEmployeeInfoList;
    }
    @NonNull
    @Override
    public EmpListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.emp_card_data_row,parent,false);
        return new EmpListHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull EmpListHolder holder, int i) {

        final Employee employeeInfo = mEmployeeInfoList.get(i);
        holder.avatar.setBorderColor(employeeInfo.getEmp_img_border());
        holder.avatar.setImageResource(employeeInfo.getEmp_img());
        holder.linearLayout.setBackgroundResource(employeeInfo.getEmp_card_back());
        holder.nameSur.setText(employeeInfo.getEmp_full_name());
        holder.position.setText(employeeInfo.getEmp_position());
        holder.levelRateOne.setText(String.valueOf(employeeInfo.getEmp_skills().get(0).getSkill_score()));
        holder.levelRateTwo.setText(String.valueOf(employeeInfo.getEmp_skills().get(1).getSkill_score()));
        holder.levelRateThree.setText(String.valueOf(employeeInfo.getEmp_skills().get(2).getSkill_score()));
        holder.skillOne.setText(employeeInfo.getEmp_skills().get(0).getSkill_name());
        holder.skillTwo.setText(employeeInfo.getEmp_skills().get(1).getSkill_name());
        holder.skillThree.setText(employeeInfo.getEmp_skills().get(2).getSkill_name());

        holder.curView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmpDetailFragment empDetailFragment = EmpDetailFragment.newInstance(employeeInfo);
                MainActivity.fm.beginTransaction().replace(R.id.fragment_container,empDetailFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEmployeeInfoList.size();
    }

    static class EmpListHolder extends RecyclerView.ViewHolder {
        CircleImageView avatar;
        TextView nameSur,position,levelRateOne,levelRateTwo,levelRateThree,skillOne,skillTwo,skillThree;
        View curView;
        LinearLayout linearLayout;
        EmpListHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.m_avatar);
            linearLayout = itemView.findViewById(R.id.card_view);
            nameSur = itemView.findViewById(R.id.m_name);
            position = itemView.findViewById(R.id.m_position);
            levelRateOne = itemView.findViewById(R.id.m_level_rate1);
            levelRateTwo = itemView.findViewById(R.id.m_level_rate2);
            levelRateThree = itemView.findViewById(R.id.m_level_rate3);
            skillOne = itemView.findViewById(R.id.m_skill1);
            skillTwo = itemView.findViewById(R.id.m_skill2);
            skillThree = itemView.findViewById(R.id.m_skill3);

            curView = itemView;
        }
    }
}
