package com.example.employeecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeecard.models.EmpInfo;
import com.ramotion.expandingcollection.ECCardContentListItemAdapter;

import java.util.List;

public class CardListItemAdapter extends ECCardContentListItemAdapter<EmpInfo> {
    public CardListItemAdapter(@NonNull Context context,@NonNull List<EmpInfo> objects) {
        super(context, R.layout.fragment_emp_detail, objects);
    }
    @NonNull
    @Override
    public View getView(int i, @Nullable View convertView, @NonNull ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fragment_emp_detail, null);
            viewHolder = new ViewHolder();
            viewHolder.itemText = convertView.findViewById(R.id.list_item_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        final EmpInfo item = getItem(i);
        if (item != null) {
            viewHolder.itemText.setText(item.getDetail_info());
        }

        viewHolder.itemText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tapToRemoveText = "Tap again to remove!";
                TextView view = (TextView) v;
                if (view.getText().equals(tapToRemoveText)) {
                    v.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.colorPrimary));
                    CardListItemAdapter.this.remove(item);
                    CardListItemAdapter.this.notifyDataSetChanged();
                } else {
                    view.setText(tapToRemoveText);
                    v.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.colorAccent));
                }
            }
        });
        return convertView;
    }
    static class ViewHolder {
        TextView itemText;
    }
}
