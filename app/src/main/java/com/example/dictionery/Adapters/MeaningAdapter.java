package com.example.dictionery.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.contentcapture.ContentCaptureCondition;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionery.Models.Meanings;
import com.example.dictionery.R;
import com.example.dictionery.ViewHolders.MeaningViewHolder;

import java.security.acl.Group;
import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningViewHolder> {
    Context context;
    protected List<Meanings> meaningsList;

    public MeaningAdapter(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningViewHolder(LayoutInflater.from(context).inflate(R.layout.meanins_list_items, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MeaningViewHolder holder, int position) {
        holder.textViewPartsOfSpeech.setText("Parts Of Speech: " + meaningsList.get(position).getPartOfSpeech());
        holder.recycler_definitions.setHasFixedSize(true);
        holder.recycler_definitions.setLayoutManager(new GridLayoutManager(context,1));
        DefinitionAdapter definitionAdapter = new DefinitionAdapter(context,meaningsList.get(position).getDefinitions());
        holder.recycler_definitions.setAdapter(definitionAdapter);
    }


    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
