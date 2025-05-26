package com.example.pas_absen06_absen32.response;
import com.example.pas_absen06_absen32.model.Country;

import java.util.List;

public class CountryResponse {
    private List<Country> countries;

    public List<Country> getCountry() {
        return countries;
    }

    public void setCountry(List<Country> countries) {
        this.countries = countries;
    }
}
