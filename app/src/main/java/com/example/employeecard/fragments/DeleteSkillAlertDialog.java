package com.example.employeecard.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;

import com.example.employeecard.DeleteSkillDialogListener;
import com.example.employeecard.R;
import com.example.employeecard.adapters.EmpDetailAdapter;

import java.util.List;

public class DeleteSkillAlertDialog extends DialogFragment {
    private int i;
    TextView okBtn,cancelBtn;
    private DeleteSkillDialogListener mListener;
    public DeleteSkillAlertDialog (DeleteSkillDialogListener mListener,int i){
        this.i =i;
        this.mListener = mListener;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view =  LayoutInflater.from(getContext()).inflate(R.layout.remove_skill_dialog,null);
        okBtn = view.findViewById(R.id.ok_btn_dialog_rem);
        cancelBtn = view.findViewById(R.id.close_btn_dialog_rem);

        builder.setView(view);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.positiveClick(i);
                DeleteSkillAlertDialog.this.dismiss();
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteSkillAlertDialog.this.dismiss();
            }
        });
//        builder.setMessage("Do you want to remove")
//                .setPositiveButton("Apply", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        mListener.positiveClick(i);
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
        return builder.create();
    }
}
