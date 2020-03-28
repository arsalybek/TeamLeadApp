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
import android.widget.LinearLayout;
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
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import java.util.Calendar;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;


public class EmpListFragment extends Fragment {
    private ECPagerView ecPagerView;
//    private CarouselView customCarouselView;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emp_list, container, false);
        ecPagerView = view.findViewById(R.id.m_pager_view);
        ecPagerView.setBackground(getResources().getDrawable(R.drawable.rounded_card));
        TextView welcomTxt = view.findViewById(R.id.welcome_txt);
        welcomTxt.setText(getWelcomeTxt()+ "leadName !");
//        customCarouselView = view.findViewById(R.id.carouselView);
//        customCarouselView.setPageCount(new EmpContainer().getDataset().size());
//        customCarouselView.setViewListener(viewListener);

        ECPagerViewAdapter ecPagerViewAdapter = new ECPagerViewAdapter(Objects.requireNonNull(getContext()), new EmpContainer().getDataset()) {
            @Override
            public void instantiateCard(LayoutInflater inflaterService, final ViewGroup head, final ListView list, ECCardData data) {

                CardData cardData = (CardData) data;


                EmpDetailAdapter empDetailAdapter = new EmpDetailAdapter(Objects.requireNonNull(getContext()), cardData.getListItems());
                list.setAdapter(empDetailAdapter);
                list.setDivider(getResources().getDrawable(R.drawable.list_divider));
                list.setDividerHeight((int) pxFromDp(getContext(), 0.5f));
                list.setSelector(R.color.transparent);
                list.setBackgroundColor(Color.WHITE);
                list.setCacheColorHint(Color.TRANSPARENT);


                final View cardView = inflaterService.inflate(R.layout.emp_card_data_new, head);


                CircleImageView avatar = cardView.findViewById(R.id.m_avatar);
                avatar.setBorderColor(getResources().getColor(cardData.getM_emp_img_border()));
                avatar.setImageResource(cardData.getM_emp_img());
                LinearLayout linearLayout = cardView.findViewById(R.id.card_view);
                linearLayout.setBackgroundResource(cardData.getM_emp_card_back());
                TextView nameSur = cardView.findViewById(R.id.m_name);
                nameSur.setText(cardData.getM_emp_fio());
                TextView position = cardView.findViewById(R.id.m_position);
                position.setText(cardData.getM_emp_position());
                TextView levelRateOne = cardView.findViewById(R.id.m_level_rate1);
                TextView levelRateTwo = cardView.findViewById(R.id.m_level_rate2);
                TextView levelRateThree = cardView.findViewById(R.id.m_level_rate3);
                TextView skillOne = cardView.findViewById(R.id.m_skill1);
                TextView skillTwo = cardView.findViewById(R.id.m_skill2);
                TextView skillThree = cardView.findViewById(R.id.m_skill3);
                levelRateOne.setText(String.valueOf(cardData.getM_emp_skills().get(0).first));
                levelRateTwo.setText(String.valueOf(cardData.getM_emp_skills().get(1).first));
                levelRateThree.setText(String.valueOf(cardData.getM_emp_skills().get(2).first));
                skillOne.setText(cardData.getM_emp_skills().get(0).second);
                skillTwo.setText(cardData.getM_emp_skills().get(1).second);
                skillThree.setText(cardData.getM_emp_skills().get(2).second);


                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        ecPagerView.toggle();
                    }
                });


            }
        };
        ecPagerView.setPagerViewAdapter(ecPagerViewAdapter);

        return view;

    }
//    ViewListener viewListener = new ViewListener() {
//        @Override
//        public View setViewForPosition(int position) {
//            return ecPagerView;
//        }
//    };
    private String getWelcomeTxt() {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay < 12) {
            return "Good Morning, ";
        } else if (timeOfDay < 16) {
            return"Good Afternoon, ";
        } else if (timeOfDay < 21) {
            return "Good Evening, ";
        } else {
            return"Good Night, ";
        }
    }

    public static float dpFromPx(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    private static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

}
