package com.campos.baseconverter.model;

import android.app.AlertDialog;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.widget.LinearLayoutCompat;

public class BaseInputDialogBuilder extends AlertDialog.Builder {
    private BaseInputField tfInput;

    public BaseInputDialogBuilder(Context context, String chosenItem, Base convertFrom) {
        super(context);
        super.setCancelable(false);
        super.setTitle("Convert From: " + chosenItem);
        super.setMessage("Please Enter Input:");
        this.tfInput = new BaseInputField(context, convertFrom);
        super.setView(loadView(context));

    }

    @Deprecated
    public void requestInputFocus() {
        InputMethodManager imm = (InputMethodManager) super.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(tfInput, InputMethodManager.SHOW_IMPLICIT);
        tfInput.requestFocus();
    }

    public String getInput() {
        return tfInput.getText().toString();
    }

    private LinearLayout loadView(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(20, 0, 20, 0);
        linearLayout.addView(tfInput);
        return linearLayout;
    }
}
