package com.example.pas_absen06_absen32.ui.country;

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
import com.example.pas_absen06_absen32.adapter.CountryAdapter;
import com.example.pas_absen06_absen32.response.CountryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryFragment extends Fragment {
    private CountryAdapter countryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rvcountries);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        countryAdapter = new CountryAdapter();
        recyclerView.setAdapter(countryAdapter);

        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SportsDBApi api = retrofit.create(SportsDBApi.class);

        api.getCountry().enqueue(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null && response.body().getCountry() != null) {
                    countryAdapter.setCountries(response.body().getCountry());
                } else {
                    Toast.makeText(getContext(), "Failed to load countries", Toast.LENGTH_SHORT).show();
                    Log.e("CountryFragment", "Error: " + (response != null ? response.message() : "null response"));
                }
            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("CountryFragment", "API call failed: " + t.getMessage());
            }
        });

        return view;
    }
}
