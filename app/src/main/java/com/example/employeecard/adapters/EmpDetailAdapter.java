package com.example.employeecard.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.employeecard.R;
import com.example.employeecard.models.EmpDetail;
import com.ramotion.expandingcollection.ECCardContentListItemAdapter;

import java.util.List;

public class EmpDetailAdapter extends ECCardContentListItemAdapter<EmpDetail> {
    public EmpDetailAdapter(@NonNull Context context,@NonNull List<EmpDetail> objects) {
        super(context, R.layout.emp_card_detail, objects);
    }
    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());

            rowView = inflater.inflate(R.layout.emp_card_detail, null);
            viewHolder = new ViewHolder();
            viewHolder.detail = (TextView) rowView.findViewById(R.id.emp_detail_info);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        final EmpDetail objectItem = getItem(position);
        if (objectItem != null) {
            viewHolder.detail.setText(objectItem.getEmp_detail_info() + ":");
        }

        return rowView;
    }
    static class ViewHolder {
        TextView detail;
    }
}
