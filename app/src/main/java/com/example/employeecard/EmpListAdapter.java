package com.example.employeecard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
        holder.photo.setImageResource(R.drawable.ic_launcher_background);
        holder.mTextView.setText("Ayaulym");
        holder.mTextView2.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");

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
        ImageView photo;
        TextView mTextView,mTextView2;
        public EmpListHolder(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.profile_img);
            mTextView = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
        }
    }

}
