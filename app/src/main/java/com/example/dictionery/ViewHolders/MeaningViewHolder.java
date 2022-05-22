package com.example.dictionery.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionery.R;

public class MeaningViewHolder extends RecyclerView.ViewHolder {

    public TextView textViewPartsOfSpeech;
    public RecyclerView recycler_definitions;

    public MeaningViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewPartsOfSpeech = itemView.findViewById(R.id.textViewPartsOfSpeech);
        recycler_definitions = itemView.findViewById(R.id.recycler_definitions);
    }
}
