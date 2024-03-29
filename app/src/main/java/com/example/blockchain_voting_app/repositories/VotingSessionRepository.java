package com.example.blockchain_voting_app.repositories;

import android.util.Log;

import com.example.blockchain_voting_app.models.DummyVotingSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class VotingSessionRepository {
    private final String API_KEY = "123";
    private final String bearerToken = "bearerToken";
    private final String testUrl1 = "https://api.themoviedb.org/3/movie/now_playing";
    private final String getTestUrl2 = "https://api.themoviedb.org/3/movie/"; //add movie id
    private final OkHttpClient client = new OkHttpClient();

    public List<DummyVotingSession> getVotingSessions() {
        Request request = new Request.Builder()
                .url(testUrl1)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + bearerToken)
                .build();
        List<DummyVotingSession> votingSessions = new ArrayList<>();
        try (Response response = client.newCall(request).execute()) {
            JSONObject jsonObject = new JSONObject(response.body().string());
            JSONArray responseBody = jsonObject.getJSONArray("results");
            for (int i = 0; i < responseBody.length(); i++) {
                JSONObject movie = responseBody.getJSONObject(i);
                String title = movie.getString("title");
                String description = movie.getString("overview");
                double rating = movie.getDouble("vote_average");
                //votingSessions.add(new DummyVotingSession(title, description, (int) rating));
                //DummyVotingSession session1 = new DummyVotingSession(title, description, (int) rating)
                Log.d("APIRESPONSE", String.valueOf(responseBody));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return votingSessions;
    }
}
