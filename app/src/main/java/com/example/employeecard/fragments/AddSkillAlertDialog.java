package com.example.employeecard.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.employeecard.AddSkillDialogListener;
import com.example.employeecard.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddSkillAlertDialog extends DialogFragment {
    AddSkillDialogListener mListener;
    EditText skillName;
    TextView addBtn, cancelBtn;
    TextInputLayout textInput;

    public AddSkillAlertDialog(AddSkillDialogListener mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.add_skill_dialog, null);
       skillName = view.findViewById(R.id.m_skill_input);
        addBtn = view.findViewById(R.id.add_btn_dialog);
        cancelBtn = view.findViewById(R.id.close_btn_dialog);
        textInput = view.findViewById(R.id.text_input);

        builder.setView(view);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String skillNameStr = skillName.getText().toString();
                if (skillNameStr.equals("")) {
                    textInput.setErrorEnabled(true);
                    textInput.setError("This field cannot be blank");
                }
                else {
//                    textInput.setErrorEnabled(true);
//                    textInput.setError("This field cannot be blank");
//                   skillName.setError("This field cannot be blank");
                    textInput.setError(null);
                    mListener.positiveClick(skillNameStr);
                    AddSkillAlertDialog.this.dismiss();
                }

            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddSkillAlertDialog.this.dismiss();
            }
        });



//        builder.setPositiveButton("Apply", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        String skillNameStr = skillName.getText().toString();
//                        mListener.positiveClick(AddSkillAlertDialog.this,skillNameStr,1);
//
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

