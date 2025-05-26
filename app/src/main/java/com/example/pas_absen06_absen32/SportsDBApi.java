package com.example.pas_absen06_absen32;
import com.example.pas_absen06_absen32.response.CountryResponse;
import com.example.pas_absen06_absen32.response.LaligaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
public interface SportsDBApi {
    @GET("/api/v1/json/3/search_all_teams.php?s=Soccer&c=Spain\n")
    Call<LaligaResponse> getTeams();

    @GET("/api/v1/json/3/all_countries.php")
    Call<CountryResponse> getCountry();
}