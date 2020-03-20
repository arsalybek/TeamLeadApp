package com.example.employeecard.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.employeecard.adapters.EmpDetailAdapter;
import com.example.employeecard.adapters.ItemsCountView;
import com.example.employeecard.models.CardData;
import com.example.employeecard.R;
import com.example.employeecard.models.EmpContainer;
import com.ramotion.expandingcollection.ECCardData;
import com.ramotion.expandingcollection.ECPagerView;
import com.ramotion.expandingcollection.ECPagerViewAdapter;

import java.util.Objects;


public class EmpListFragment extends Fragment {
    private ECPagerView ecPagerView;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emp_list, container, false);
        ecPagerView = view.findViewById(R.id.m_pager_view);

        ECPagerViewAdapter ecPagerViewAdapter = new ECPagerViewAdapter(Objects.requireNonNull(getContext()), new EmpContainer().getDataset()) {
            @Override
            public void instantiateCard(LayoutInflater inflaterService, ViewGroup head, final ListView list, ECCardData data) {
                // Data object for current card
                CardData cardData = (CardData) data;

                // Create adapter for list inside a card and set adapter to card content
                EmpDetailAdapter empDetailAdapter = new EmpDetailAdapter(Objects.requireNonNull(getContext()), cardData.getListItems());
                list.setAdapter(empDetailAdapter);
                list.setDivider(getResources().getDrawable(R.drawable.list_divider));
                list.setDividerHeight((int) pxFromDp(getContext(), 0.5f));
                list.setSelector(R.color.transparent);
                list.setBackgroundColor(Color.WHITE);
                list.setCacheColorHint(Color.TRANSPARENT);

                // Inflate main header layout and attach it to header root view
                inflaterService.inflate(R.layout.emp_card_data, head);

                // Set header data from data object
                ImageView avatar =  head.findViewById(R.id.m_emp_img);
                avatar.setImageResource(cardData.getM_emp_img());
                TextView nameSur = head.findViewById(R.id.m_emp_fio);
                nameSur.setText(cardData.getM_emp_fio());
                TextView skills =  head.findViewById(R.id.m_emp_skills);
                skills.setText(cardData.getM_emp_skills());
                TextView position =  head.findViewById(R.id.m_emp_pos);
                position.setText(cardData.getM_emp_position());

                // Add onclick listener to card header for toggle card state
                head.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        ecPagerView.toggle();
                    }
                });
            }
        };
        ecPagerView.setPagerViewAdapter(ecPagerViewAdapter);

//        final ItemsCountView itemsCountView = view.findViewById(R.id.items_count_view);
//        ecPagerView.setOnCardSelectedListener(new ECPagerView.OnCardSelectedListener() {
//            @Override
//            public void cardSelected(int newPosition, int oldPosition, int totalElements) {
//                itemsCountView.update(newPosition, oldPosition, totalElements);
//            }
//        });
        return view;
    }

    public static float dpFromPx(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
