package com.example.blockchain_voting_app.utils;

import android.util.Log;

import com.example.blockchain_voting_app.models.DummyVotingSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiClient {

    public String API_KEY = "fc1f8e3ce67ae24e8a1b5afa0a02d6fd";
    public static String bearerToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYzFmOGUzY2U2N2FlMjRlOGExYjVhZmEwYTAyZDZmZCIsInN1YiI6IjYwZjU5Njc1ZjkwYjE5MDA3NDZjZDc3ZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.OhbdVV4drRNr4AWPC0UlG0hxAM6sJvSD77JBGevA4I8";
    public static String testUrl1 = "https://api.themoviedb.org/3/movie/now_playing";
    public static String getTestUrl2 = "https://api.themoviedb.org/3/movie/"; //add movie id
    public static OkHttpClient client = new OkHttpClient();

    public static List<DummyVotingSession> getVotingSessions() {
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
                votingSessions.add(new DummyVotingSession(title, description, (int) rating));
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
//    public static ArrayList<VotingSession> getVotingSessions(){
//        Request request = new Request.Builder()
//                .url(testUrl1)
//                .get()
//                .addHeader("accept", "application/json")
//                .addHeader("Authorization", "Bearer " + bearerToken)
//                .build();
//        try(Response response = client.newCall(request).execute()){
//            String responseBody = response.body().string();
//            Log.d("APIRESPONSE", responseBody);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return null;
//    }

    public static void vote(String votingSessionName, String option){
        //vote for an option in a voting session\
        //post
    }




}
