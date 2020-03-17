package com.example.employeecard.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.employeecard.R;
import com.ramotion.foldingcell.FoldingCell;

public class EmpListFragment extends Fragment {
    FoldingCell fc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emp_list, container, false);

        fc =  view.findViewById(R.id.folding_cell);
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });
//        EmpListAdapter empListAdapter= new EmpListAdapter();
//        RecyclerView recyclerView = view.findViewById(R.id.recyler_view);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(empListAdapter);
        return view;
    }
}
