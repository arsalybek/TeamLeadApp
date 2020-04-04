package com.example.employeecard;

import androidx.fragment.app.DialogFragment;

public interface AddSkillDialogListener {
    void positiveClick(DialogFragment dialog,String skillName,int skillRate);
}
