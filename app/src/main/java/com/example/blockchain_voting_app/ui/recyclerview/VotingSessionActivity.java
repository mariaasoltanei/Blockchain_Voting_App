package com.example.blockchain_voting_app.ui.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blockchain_voting_app.R;
import com.example.blockchain_voting_app.models.DummyVotingSession;
import com.example.blockchain_voting_app.ui.vsDetails.VotingSessionDetailsActivity;
import com.example.blockchain_voting_app.utils.SelectItemClick;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class VotingSessionActivity extends AppCompatActivity implements SelectItemClick {
    private RecyclerView votingSessionRV;
    private VotingSessionItemAdapter adapter;
    private List<DummyVotingSession> sessions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        votingSessionRV = findViewById(R.id.rv_voting_sessions);
        votingSessionRV.setHasFixedSize(true);
        votingSessionRV.setVisibility(RecyclerView.VISIBLE);
        votingSessionRV.setLayoutManager(new GridLayoutManager(this, 2));

        sessions = new ArrayList<>();
        ArrayList<String> options = new ArrayList<>();
        ArrayList<String> options2 = new ArrayList<>();
        options.add("Iohannis");
        options.add("Dancila");
        options.add("Barna");

        options2.add("Ciolacu");
        options2.add("Tuca");
        options2.add("Simion");
        sessions.add(new DummyVotingSession("Prezindentiale", "Dummy Voting Session Description", options, "@drawable/iohannis"));
        sessions.add(new DummyVotingSession("Europarlamentare", "Dummy Voting Session Description", options2, "@drawable/iohannis"));

        adapter = new VotingSessionItemAdapter(this, sessions, this);
        votingSessionRV.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(DummyVotingSession votingSession) {
        Toast.makeText(this, "Clicked on item " + votingSession.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, VotingSessionDetailsActivity.class);
        intent.putExtra("vs_name", votingSession.getName());
        intent.putExtra("vs_description", votingSession.getDescription());
        intent.putExtra("vs_options", votingSession.getOptions());
        startActivity(intent);
    }
}
