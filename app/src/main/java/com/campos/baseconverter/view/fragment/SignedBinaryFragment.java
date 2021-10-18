package com.campos.baseconverter.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.campos.baseconverter.R;
import com.campos.baseconverter.controller.SignedBinaryController;

public class SignedBinaryFragment extends Fragment {
    private View view;
    private SignedBinaryController controller;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_signed_binary, container, false);
        this.controller = new SignedBinaryController(view);
        return view;
    }
}