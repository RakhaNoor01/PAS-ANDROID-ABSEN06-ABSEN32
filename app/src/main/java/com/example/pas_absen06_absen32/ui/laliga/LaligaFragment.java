package com.example.pas_absen06_absen32.ui.laliga;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_absen06_absen32.R;
import com.example.pas_absen06_absen32.SportsDBApi;
import com.example.pas_absen06_absen32.adapter.LaligaAdapter;
import com.example.pas_absen06_absen32.response.LaligaResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LaligaFragment extends Fragment {
    private LaligaAdapter laligaAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laliga, container, false);

        // Set up RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.rvteams);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        laligaAdapter = new LaligaAdapter();
        recyclerView.setAdapter(laligaAdapter);

        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        // Set up Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create API instance
        SportsDBApi api = retrofit.create(SportsDBApi.class);

        // Make the API request
        api.getTeams().enqueue(new Callback<LaligaResponse>() {
            @Override
            public void onResponse(Call<LaligaResponse> call, Response<LaligaResponse> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    // Update the RecyclerView with the list of teams
                    laligaAdapter.setTeams(response.body().getTeams());
                } else {
                    Log.e("LaligaFragment", "Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<LaligaResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("LaligaFragment", "API call failed: " + t.getMessage());
            }
        });

        return view;
    }
}
