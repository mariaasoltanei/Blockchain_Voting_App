package com.example.blockchain_voting_app.ui.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blockchain_voting_app.R;

public class VotingSessionViewHolder extends RecyclerView.ViewHolder{
    public TextView tvTitle, tvDescription, tvOptions;
    CardView cvVotingSession;

    public VotingSessionViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_vs_title);
        tvDescription = itemView.findViewById(R.id.tv_vs_description);
        tvOptions = itemView.findViewById(R.id.tv_vs_options);
        cvVotingSession = itemView.findViewById(R.id.cardView_vs);
    }
}
