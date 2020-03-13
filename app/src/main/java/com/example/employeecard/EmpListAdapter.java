package com.example.employeecard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class EmpListAdapter extends RecyclerView.Adapter<EmpListAdapter.EmpListHolder> {
    @NonNull
    @Override
    public EmpListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.emp_row_list,parent,false);
        return new EmpListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpListHolder holder, int position) {
        holder.emp_img.setImageResource(R.drawable.employee_img);
        holder.emp_fio.setText("Popova Natalya\n" +
                "  Esentayevna\n");
        holder.emp_pos.setText("Front End Developer\n");
        holder.emp_skills.setText("Visual Design Experience on strong UI/UX.\n" +
                "Working knowledge of Photoshop/Sketch\n");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new EmpDetailFragment();
                FragmentTransaction empListFragment = activity.getSupportFragmentManager().beginTransaction();
                        empListFragment.replace(R.id.fragment_container, myFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class EmpListHolder extends RecyclerView.ViewHolder {
        ImageView emp_img;
        TextView emp_fio,emp_pos,emp_skills;
        CardView emp_card;
        public EmpListHolder(@NonNull View itemView) {
            super(itemView);
            emp_img = itemView.findViewById(R.id.m_emp_img);
            emp_fio = itemView.findViewById(R.id.m_emp_fio);
            emp_pos = itemView.findViewById(R.id.m_emp_pos);
            emp_skills = itemView.findViewById(R.id.m_emp_skills);
            emp_card = itemView.findViewById(R.id.m_cardview);
        }
    }

}
