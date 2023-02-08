package com.dev.android.idictionary.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.android.idictionary.R;

public class MeaningViewHolder extends RecyclerView.ViewHolder {
    TextView textView_partsOfSpeech;
    RecyclerView recycler_definitions;
    public MeaningViewHolder(@NonNull View itemView) {
        super(itemView);

        textView_partsOfSpeech=itemView.findViewById(R.id.textView_partsOfSpeech);
        recycler_definitions=itemView.findViewById(R.id.recycler_definitions);

    }
}
