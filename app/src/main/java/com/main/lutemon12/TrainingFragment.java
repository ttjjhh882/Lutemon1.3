package com.main.lutemon12;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// TrainingFragment.java
public class TrainingFragment extends Fragment {
    private RecyclerView recyclerView;
    private TrainingAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_training, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewTraining);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 获取所有可训练的Lutemon
        ArrayList<Lutemon> lutemons = Storage.getInstance().getAllLutemons();
        adapter = new TrainingAdapter(lutemons, requireContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
