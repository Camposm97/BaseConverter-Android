package com.campos.baseconverter.model;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.LinearLayout;

import com.campos.baseconverter.model.num.Base;

public class BaseInputDialogBuilder extends AlertDialog.Builder {
    private BaseInputField tfInput;

    public BaseInputDialogBuilder(Context context, Base convertFrom) {
        super(context);
        super.setCancelable(false); // The user must hit the Cancel button to close this dialog
        super.setTitle("Converting from " + convertFrom.toString());
        super.setMessage("Please enter your number:");
        this.tfInput = new BaseInputField(context, convertFrom);
        super.setView(loadView(context));
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
