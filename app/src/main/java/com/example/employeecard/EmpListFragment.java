package com.example.employeecard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

public class EmpListFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emp_list, container, false);
        EmpListAdapter empListAdapter= new EmpListAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.recyler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(empListAdapter);
        return view;
    }
    public void replaceAdapter(){
        EmpDetailFragment empDetailFragment = new EmpDetailFragment();
        FragmentTransaction listFragment = getFragmentManager().beginTransaction();
        listFragment.replace(R.id.fragment_container,empDetailFragment).addToBackStack(null).commit();
    }
}
