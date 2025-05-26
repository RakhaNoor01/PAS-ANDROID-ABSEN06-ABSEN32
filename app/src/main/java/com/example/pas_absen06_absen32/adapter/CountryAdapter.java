package com.example.pas_absen06_absen32.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_absen06_absen32.R;
import com.example.pas_absen06_absen32.model.Country;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private List<Country> countries = new ArrayList<>();

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_itemlayout, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.countryName.setText(country.getNameEn()); // show country name
        String flagUrl = country.getFlagUrl();
        if (flagUrl != null && !flagUrl.isEmpty()) {
            Picasso.get().load(flagUrl).into(holder.countryImage);
        } else {
            holder.countryImage.setImageResource(R.drawable.ball2); // fallback image
        }
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
        notifyDataSetChanged();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView countryName;
        ImageView countryImage;

        public CountryViewHolder(View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.CountryName);
            countryImage = itemView.findViewById(R.id.CountryImage);
        }
    }
}
