package com.campos.baseconverter.model;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputType;
import android.widget.EditText;

public class BaseInputField extends androidx.appcompat.widget.AppCompatEditText {
    public BaseInputField(Context context, Base convertFrom) {
        super(context);
//        super.setInputType(InputType.TYPE_CLASS_TEXT);
        super.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        this.setInputType(convertFrom);
    }

    public void setInputType(Base convertFrom) {
        if (convertFrom.getRadix() <= 10) {
            setInputType(InputType.TYPE_CLASS_NUMBER);
        } else {
            setInputType(InputType.TYPE_CLASS_TEXT);
        }
    }
}
