package com.example.employeecard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeecard.R;
import com.example.employeecard.adapters.EmpListAdapter;
import com.example.employeecard.database.EmployeeBaseHelper;
import com.example.employeecard.models.EmployeeInfo;
import com.example.employeecard.models.EmpContainer;

import java.util.ArrayList;
import java.util.List;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;


public class EmpListFragment extends Fragment {
    private EmpContainer mContainer = EmpContainer.get();

    private List<EmployeeInfo> list = new ArrayList<>();
    private EmployeeBaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_emp_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
//        final EmpListAdapter adapter = new EmpListAdapter(mContainer.getDataset());
//        recyclerView.setAdapter(adapter);

        db = new EmployeeBaseHelper(getContext());
        db.insertListOfEmployee(mContainer.getDataset());
        list.addAll(db.getAllNotes());
        EmpListAdapter adapter = new EmpListAdapter(list);
        recyclerView.setAdapter(adapter);

        new LinearSnapHelper().attachToRecyclerView(recyclerView);
        ScrollingPagerIndicator pagerIndicator = view.findViewById(R.id.pager_indicator);
        pagerIndicator.attachToRecyclerView(recyclerView);

        return view;
    }
}
