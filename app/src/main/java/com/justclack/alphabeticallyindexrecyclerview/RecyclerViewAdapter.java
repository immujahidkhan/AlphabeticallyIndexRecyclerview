package com.justclack.alphabeticallyindexrecyclerview;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements FastScrollRecyclerView.SectionedAdapter{

    private List<String> mDataArray;

    public RecyclerViewAdapter(List<String> dataset) {
        mDataArray = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_alphabet.setText(mDataArray.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataArray.size();
    }


    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public String getSectionName(int position) {
        return String.format("%d", position+1);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_alphabet;

        ViewHolder(View itemView) {
            super(itemView);
            tv_alphabet = itemView.findViewById(R.id.tv_alphabet);
        }
    }
}