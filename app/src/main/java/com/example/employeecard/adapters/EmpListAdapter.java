package com.example.employeecard.adapters;

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

import com.example.employeecard.R;
import com.example.employeecard.fragments.EmpDetailFragment;

public class EmpListAdapter {

//    ECPagerViewAdapter adapter = new ECPagerViewAdapter(this, new ExampleDataset().getDataset()) {
//        @Override
//        public void instantiateCard(LayoutInflater inflaterService, ViewGroup head, ListView list, final ECCardData data) {
//            final CardData cardData = (CardData) data;
//
//            // Create adapter for list inside a card and set adapter to card content
//            CommentArrayAdapter commentArrayAdapter = new CommentArrayAdapter(getApplicationContext(), cardData.getListItems());
//            list.setAdapter(commentArrayAdapter);
//            list.setDivider(getResources().getDrawable(R.drawable.list_divider));
//            list.setDividerHeight((int) pxFromDp(getApplicationContext(), 0.5f));
//            list.setSelector(R.color.transparent);
//            list.setBackgroundColor(Color.WHITE);
//            list.setCacheColorHint(Color.TRANSPARENT);
//
//            // Add gradient to root header view
//            View gradient = new View(getApplicationContext());
//            gradient.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT));
//            gradient.setBackgroundDrawable(getResources().getDrawable(R.drawable.card_head_gradient));
//            head.addView(gradient);
//
//            // Inflate main header layout and attach it to header root view
//            inflaterService.inflate(R.layout.simple_head, head);
//
//            // Set header data from data object
//            TextView title = (TextView) head.findViewById(R.id.title);
//            title.setText(cardData.getHeadTitle());
//            ImageView avatar = (ImageView) head.findViewById(R.id.avatar);
//            avatar.setImageResource(cardData.getPersonPictureResource());
//            TextView name = (TextView) head.findViewById(R.id.name);
//            name.setText(cardData.getPersonName() + ":");
//            TextView message = (TextView) head.findViewById(R.id.message);
//            message.setText(cardData.getPersonMessage());
//            TextView viewsCount = (TextView) head.findViewById(R.id.socialViewsCount);
//            viewsCount.setText(" " + cardData.getPersonViewsCount());
//            TextView likesCount = (TextView) head.findViewById(R.id.socialLikesCount);
//            likesCount.setText(" " + cardData.getPersonLikesCount());
//            TextView commentsCount = (TextView) head.findViewById(R.id.socialCommentsCount);
//            commentsCount.setText(" " + cardData.getPersonCommentsCount());
//
//            // Add onclick listener to card header for toggle card state
//            head.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(final View v) {
//                    ecPagerView.toggle();
//                }
//            });
//        }
//    };

}
