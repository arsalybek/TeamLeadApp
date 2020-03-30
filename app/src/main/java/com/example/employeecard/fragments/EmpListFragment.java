package com.example.employeecard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeecard.R;
import com.example.employeecard.adapters.EmpListAdapter;
import com.example.employeecard.models.CardData;
import com.example.employeecard.models.EmpContainer;

import java.util.Calendar;
import java.util.List;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;


public class EmpListFragment extends Fragment {
    CardData card;
    private EmpContainer mContainer = EmpContainer.get();
    public static EmpListFragment newInstance(CardData card){
        EmpListFragment fragment = new EmpListFragment();
        fragment.card = card;
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_emp_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        final EmpListAdapter adapter = new EmpListAdapter(mContainer.getDataset());
        recyclerView.setAdapter(adapter);
        new LinearSnapHelper().attachToRecyclerView(recyclerView);

        ScrollingPagerIndicator pagerIndicator = view.findViewById(R.id.pager_indicator);
        pagerIndicator.attachToRecyclerView(recyclerView);

//        TextView welcomeTxt = view.findViewById(R.id.welcome_txt);
//        welcomeTxt.setText(getWelcomeTxt());
        return view;

    }
    private String getWelcomeTxt() {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay < 12) {
            return "Good Morning";
        } else if (timeOfDay < 16) {
            return "Good Afternoon";
        } else if (timeOfDay < 21) {
            return "Good Evening";
        } else {
            return "Good Night";
        }
    }
}
