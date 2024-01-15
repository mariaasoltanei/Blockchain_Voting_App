package com.example.blockchain_voting_app.ui.recyclerview;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.blockchain_voting_app.models.DummyVotingSession;
import com.example.blockchain_voting_app.repositories.VotingSessionRepository;

import java.util.ArrayList;
import java.util.List;

public class VotingSessionViewModel extends ViewModel {
    private VotingSessionRepository votingSessionRepository;
    private MutableLiveData<List<DummyVotingSession>> votingSessionsMLD;

    public VotingSessionViewModel(VotingSessionRepository votingSessionRepository) {
        this.votingSessionRepository = votingSessionRepository;
    }

    public MutableLiveData<List<DummyVotingSession>> getVotingSessions() {
        if (votingSessionsMLD == null) {
            votingSessionsMLD = new MutableLiveData<>();
            loadVotingSessions(); // You can perform the initial data loading here
        }
        return votingSessionsMLD;
    }
    private void loadVotingSessions() {
        ArrayList<DummyVotingSession> votingSessions = (ArrayList<DummyVotingSession>) votingSessionRepository.getVotingSessions();
        votingSessionsMLD.setValue(votingSessions);
    }
}
