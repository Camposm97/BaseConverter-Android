package com.campos.baseconverter.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.adapter.HistoryViewAdapter;
import com.campos.baseconverter.model.UserHistory;

import java.util.List;

public class HistoryFragment extends Fragment {
    private View root;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_history, container, false);
        loadRecyclerView();
        return root;
    }

    public void loadRecyclerView() {
        List<UserHistory.HistoryItem> list = UserHistory.getHistory().getList();
        HistoryViewAdapter adapter = new HistoryViewAdapter(getContext(), list);
        RecyclerView.ItemDecoration itemDecor = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rv = root.findViewById(R.id.recycler_show_history);
        rv.addItemDecoration(itemDecor);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}