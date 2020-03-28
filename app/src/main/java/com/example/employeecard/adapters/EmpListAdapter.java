package com.example.employeecard.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeecard.R;
import com.example.employeecard.fragments.EmpDetailFragment;
import com.example.employeecard.models.CardData;
import com.example.employeecard.models.EmpContainer;
import com.ramotion.expandingcollection.ECCardData;
import com.ramotion.expandingcollection.ECPagerViewAdapter;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class EmpListAdapter {

//    ECPagerViewAdapter ecPagerViewAdapter = new ECPagerViewAdapter((getContext()), new EmpContainer().getDataset()) {
//        @Override
//        public void instantiateCard(LayoutInflater inflaterService, final ViewGroup head, final ListView list, ECCardData data) {
//            // Data object for current card
//            CardData cardData = (CardData) data;
//
//            // Create adapter for list inside a card and set adapter to card content
//            EmpDetailAdapter empDetailAdapter = new EmpDetailAdapter((getContext()), cardData.getListItems());
//            list.setAdapter(empDetailAdapter);
//            list.setDivider(getResources().getDrawable(R.drawable.list_divider));
//            list.setDividerHeight((int) pxFromDp(getContext(), 0.5f));
//            list.setSelector(R.color.transparent);
//            list.setBackgroundColor(Color.WHITE);
//            list.setCacheColorHint(Color.TRANSPARENT);
//
//            // Inflate main header layout and attach it to header root view
//            final View cardView = inflaterService.inflate(R.layout.emp_card_data_new, head);
//
//            // Set header data from data object
//            CircleImageView avatar = cardView.findViewById(R.id.m_avatar);
//            avatar.setBorderColor(getResources().getColor(cardData.getM_emp_img_border()));
//            avatar.setImageResource(cardData.getM_emp_img());
//            LinearLayout linearLayout = cardView.findViewById(R.id.card_view);
//            linearLayout.setBackgroundResource(cardData.getM_emp_card_back());
//            TextView nameSur = cardView.findViewById(R.id.m_name);
//            nameSur.setText(cardData.getM_emp_fio());
//            TextView position = cardView.findViewById(R.id.m_position);
//            position.setText(cardData.getM_emp_position());
//            TextView levelRateOne = cardView.findViewById(R.id.m_level_rate1);
//            TextView levelRateTwo = cardView.findViewById(R.id.m_level_rate2);
//            TextView levelRateThree = cardView.findViewById(R.id.m_level_rate3);
//            TextView skillOne = cardView.findViewById(R.id.m_skill1);
//            TextView skillTwo = cardView.findViewById(R.id.m_skill2);
//            TextView skillThree = cardView.findViewById(R.id.m_skill3);
//            levelRateOne.setText(String.valueOf(cardData.getM_emp_skills().get(0).first));
//            levelRateTwo.setText(String.valueOf(cardData.getM_emp_skills().get(1).first));
//            levelRateThree.setText(String.valueOf(cardData.getM_emp_skills().get(2).first));
//            skillOne.setText(cardData.getM_emp_skills().get(0).second);
//            skillTwo.setText(cardData.getM_emp_skills().get(1).second);
//            skillThree.setText(cardData.getM_emp_skills().get(2).second);
//
//            // Add onclick listener to card header for toggle card state
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(final View v) {
//                    ecPagerView.toggle();
//                }
//            });
//
//
//        }
//    };

}
