package com.example.blockchain_voting_app.ui.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blockchain_voting_app.R;
import com.example.blockchain_voting_app.models.DummyVotingSession;
import com.example.blockchain_voting_app.utils.SelectItemClick;

import java.util.List;

public class VotingSessionItemAdapter extends RecyclerView.Adapter<VotingSessionViewHolder>{
    private List<DummyVotingSession> votingSessions;
    Context context;
    private SelectItemClick selectItemClick;

    public VotingSessionItemAdapter(Context context, List<DummyVotingSession> votingSessions, SelectItemClick onClickListener) {
        this.votingSessions = votingSessions;
        this.context = context;
        this.selectItemClick = onClickListener;
    }
    @NonNull
    @Override
    public VotingSessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VotingSessionViewHolder(LayoutInflater.from(context).inflate(R.layout.item_voting_session, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull VotingSessionViewHolder holder, int position) {
        DummyVotingSession votingSession = votingSessions.get(position);
        holder.tvTitle.setText(votingSession.getName());
        holder.tvDescription.setText(votingSession.getDescription());
        holder.tvOptions.setText("Options: " + String.valueOf(votingSession.getOptions().size()));
        holder.cvVotingSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectItemClick != null) {
                    selectItemClick.onItemClicked(votingSessions.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return votingSessions.size();
    }

}
