package com.example.employeecard.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import com.example.employeecard.R;
import com.example.employeecard.AddSkillDialogListener;

public class AddSkillAlertDialog extends DialogFragment {
    AddSkillDialogListener mListener;
    EditText skillName;
    NumberPicker ratePicker;
    public AddSkillAlertDialog(AddSkillDialogListener mListener){
        this.mListener = mListener;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view =  LayoutInflater.from(getContext()).inflate(R.layout.add_skill_dialog,null);
        skillName = view.findViewById(R.id.m_skill_input);

        ratePicker = view.findViewById(R.id.m_rate_picker);
        ratePicker.setMaxValue(10);
        ratePicker.setMinValue(1);
        ratePicker.setValue(1);
        ratePicker.setWrapSelectorWheel(true);
        builder.setView(view);
        builder.setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String skillNameStr = skillName.getText().toString();
                        int skillRate = ratePicker.getValue();
                        mListener.positiveClick(AddSkillAlertDialog.this,skillNameStr,skillRate);

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}
