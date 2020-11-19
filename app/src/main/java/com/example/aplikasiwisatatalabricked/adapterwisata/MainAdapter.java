package com.example.aplikasiwisatatalabricked.adapterwisata;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiwisatatalabricked.activities.MainActivity;
import com.example.aplikasiwisatatalabricked.modelwisata.ModelMain;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {
    public MainAdapter(List<ModelMain> lsMainMenu, MainActivity mainActivity) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface onSelectData {
    }
}
