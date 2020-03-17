package com.example.employeecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.employeecard.models.EmpInfo;
import com.ramotion.expandingcollection.ECCardContentListItemAdapter;

import java.util.List;

//public class EmpInfoAdapter extends ECCardContentListItemAdapter<EmpInfo> {
//    public EmpInfoAdapter(@NonNull Context context, @NonNull List<EmpInfo> objects) {
//        super(context, R.layout.emp_row_list, objects);
//    }

//    @NonNull
//    @Override
//    public View getView(int i, @Nullable View convertView, @NonNull ViewGroup viewGroup) {
////      viewGroup  ViewHolder viewHolder;
////        View rowView = convertView;
////
////        if (rowView == null) {
////            LayoutInflater inflater = LayoutInflater.from(getContext());
////
////            rowView = inflater.inflate(R.layout.emp_row_list, null);
////            // configure view holder
////            viewHolder = new ViewHolder();
////            viewHolder.date = (TextView) rowView.findViewById(R.id.firstLineDate);
////            viewHolder.line1 = (TextView) rowView.findViewById(R.id.firstLine);
////            viewHolder.line2 = (TextView) rowView.findViewById(R.id.secondLine);
////            viewHolder.icon = (ImageView) rowView.findViewById(R.id.icon);
////            rowView.setTag(viewHolder);
////        } else {
////            viewHolder = (ViewHolder) rowView.getTag();
////        }
////
////        final Comment objectItem = getItem(position);
////        if (objectItem != null) {
////            viewHolder.line1.setText(objectItem.getCommentPersonName() + ":");
////            viewHolder.line2.setText(objectItem.getCommentText());
////            viewHolder.date.setText(objectItem.getCommentDate());
////            viewHolder.icon.setImageResource(objectItem.getCommentPersonPictureRes());
////        }
////        return rowView;
////    }
////    static class ViewHolder {
////        TextView line;
////    }

