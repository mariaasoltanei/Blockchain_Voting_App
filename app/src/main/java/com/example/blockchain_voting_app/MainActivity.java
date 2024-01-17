//package com.example.blockchain_voting_app;
//
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.blockchain_voting_app.models.DummyVotingSession;
//import com.example.blockchain_voting_app.models.User;
//import com.example.blockchain_voting_app.repositories.VotingSessionRepository;
//import com.example.blockchain_voting_app.ui.recyclerview.VotingSessionItemAdapter;
//import com.example.blockchain_voting_app.ui.recyclerview.VotingSessionViewModel;
//import com.example.blockchain_voting_app.utils.SharedPrefs;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity implements VotingSessionItemAdapter.OnItemClickListener {
//    TextView tvHelloUser;
//    private RecyclerView recyclerView;
//    private VotingSessionItemAdapter adapter;
//    private List<DummyVotingSession> sessions;
//    private VotingSessionRepository votingSessionRepository;
//    //private VotingSessionViewModel votingSessionViewModel;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        declareComponents();
//        User user = SharedPrefs.getUserFromSharedPrefs(getApplicationContext());
//        tvHelloUser.setText("Hello, " + user.getFirstName() + "!");
//        recyclerView = findViewById(R.id.rv_voting_sessions);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new VotingSessionItemAdapter(sessions);
//        recyclerView.setAdapter(adapter);
//        votingSessionRepository = new VotingSessionRepository();
//        DummyVotingSession dummyVotingSession = new DummyVotingSession("Dummy Voting Session", "Dummy Voting Session Description", 2);
//        //votingSessionViewModel = new ViewModelProvider(this).get(VotingSessionViewModel.class);
////        votingSessionViewModel.getVotingSessions().observe(this, new Observer<List<DummyVotingSession>>() {
////            @Override
////            public void onChanged(List<DummyVotingSession> dummyVotingSessions) {
////                adapter.updateData(dummyVotingSessions);
////            }
////        });
//        new FetchDataAsyncTask().execute();
//    }
//
//    private void declareComponents() {
//        tvHelloUser = findViewById(R.id.tv_hello_user);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        SharedPrefs.removeUserFromSharedPrefs(getApplicationContext());
//    }
//    void setLayoutVisibility() {
//        if (.isEmpty()) {
//            recyclerView.setVisibility(View.GONE);
//        } else {
//            recyclerView.setVisibility(View.VISIBLE);
//        }
//    }
//
//    @Override
//    public void onItemClick(int position) {
//        Toast.makeText(this, "Clicked on item " + position, Toast.LENGTH_SHORT).show();
//    }
//
//    private class FetchDataAsyncTask extends AsyncTask<Void, Void, ArrayList<DummyVotingSession>> {
//        @Override
//        protected ArrayList<DummyVotingSession> doInBackground(Void... voids) {
//            return (ArrayList<DummyVotingSession>) votingSessionRepository.getVotingSessions();
//            //return (ArrayList<DummyVotingSession>) votingSessionViewModel.getVotingSessions().getValue();
//        }
//
//        @Override
//        protected void onPostExecute(ArrayList<DummyVotingSession> votingSessions) {
//            votingSessionRepository.getVotingSessions();
//        }
//    }
//}