package com.example.employeecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ramotion.expandingcollection.ECCardContentListItemAdapter;

import java.util.List;

public class CardListItemAdapter extends ECCardContentListItemAdapter<String> {
    public CardListItemAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View rowView = view;
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            rowView = inflater.inflate(R.layout.emp_row_list, null);
            viewHolder = new ViewHolder();
            viewHolder.itemText = (TextView) rowView.findViewById(R.id.m_emp_name);
            viewHolder.itemText.setText("Ayaulym");
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }
        return rowView;
    }
    static class ViewHolder {
        TextView itemText;
    }
}
