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
import android.widget.LinearLayout;

import com.ramotion.cardslider.CardSliderLayoutManager;
import com.ramotion.cardslider.CardSnapHelper;
import com.ramotion.expandingcollection.ECPagerView;

public class EmpListFragment extends Fragment {
    private ECPagerView ecPagerView;
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
        //LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

//       CardSliderLayoutManager cardSliderLayoutManager = new CardSliderLayoutManager(getActivity());
//        cardSliderLayoutManager.getActiveCardRight();
//        cardSliderLayoutManager.getCardWidth();

        CardSliderLayoutManager manager = new CardSliderLayoutManager(10, 300, 80F);
        manager.getCardsGap();
        recyclerView.setLayoutManager(manager);
        new CardSnapHelper().attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(empListAdapter);
        return view;
    }
}
