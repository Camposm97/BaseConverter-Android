package com.campos.baseconverter.model;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputType;

import com.campos.baseconverter.model.num.Base;

public class BaseInputField extends androidx.appcompat.widget.AppCompatEditText {
    public BaseInputField(Context context, Base convertFrom) {
        super(context);
//        super.setInputType(InputType.TYPE_CLASS_TEXT);
        super.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        this.setInputType(convertFrom);
    }

    public void setInputType(Base convertFrom) {
        if (convertFrom.getRadix() < 10) {
            setInputType(InputType.TYPE_CLASS_NUMBER);
        } else if (convertFrom.getRadix() == 10) {
            setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
        } else {
            setInputType(InputType.TYPE_CLASS_TEXT);
        }
    }
}
