package com.example.pas_absen06_absen32.response;
import com.example.pas_absen06_absen32.model.Laliga;

import java.util.List;
public class LaligaResponse {
    private List<Laliga> teams;

    public List<Laliga> getTeams() {
        return teams;
    }

    public void setTeams(List<Laliga> teams) {
        this.teams = teams;
    }
}
