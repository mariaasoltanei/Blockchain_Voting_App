package com.example.blockchain_voting_app.ui.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blockchain_voting_app.R;
import com.example.blockchain_voting_app.models.DummyVotingSession;
import com.example.blockchain_voting_app.models.VotingSession;
import com.example.blockchain_voting_app.utils.ApiClient;

import java.util.List;

public class VotingSessionItemAdapter extends RecyclerView.Adapter<VotingSessionItemAdapter.VotingSessionItemViewHolder>{
    private static boolean OnItemClickListener;
    private List<DummyVotingSession> votingSessions;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public VotingSessionItemAdapter(List<DummyVotingSession> votingSessions) {
        this.votingSessions = votingSessions;
    }
    @NonNull
    @Override
    public VotingSessionItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_voting_session, parent, false);
        return new VotingSessionItemViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull VotingSessionItemViewHolder holder, int position) {
        DummyVotingSession votingSession = votingSessions.get(position);
        holder.tvVotingSessionName.setText(votingSession.getName());
        holder.tvVotingSessionDescription.setText(votingSession.getDescription());
        holder.tvVotingSessionOptions.setText(String.valueOf(votingSession.getOptions()));//String.valueOf(votingSession.getOptions().length + 1)
    }

    @Override
    public int getItemCount() {
        return votingSessions.size();
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
    public void updateData(List<DummyVotingSession> newSessions) {
        votingSessions.clear();
        votingSessions.addAll(newSessions);
        notifyDataSetChanged();
    }

    public class VotingSessionItemViewHolder extends RecyclerView.ViewHolder{
        TextView tvVotingSessionName;
        TextView tvVotingSessionDescription;
        TextView tvVotingSessionOptions;

        public VotingSessionItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvVotingSessionName = itemView.findViewById(R.id.tv_vs_title);
            tvVotingSessionDescription = itemView.findViewById(R.id.tv_vs_description);
            tvVotingSessionOptions = itemView.findViewById(R.id.tv_vs_options);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (OnItemClickListener != false) {
                        int position = VotingSessionItemViewHolder.this.getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onItemClickListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
