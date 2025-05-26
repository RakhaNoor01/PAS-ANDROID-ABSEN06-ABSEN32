package com.example.pas_absen06_absen32.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_absen06_absen32.R;
import com.example.pas_absen06_absen32.model.Laliga;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LaligaAdapter extends RecyclerView.Adapter<LaligaAdapter.TeamViewHolder> {
    private List<Laliga> teams = new ArrayList<>();

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_itemlayout, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Laliga team = teams.get(position);
        holder.teamName.setText(team.getStrTeam());
        Picasso.get().load(team.getStrBadge()).into(holder.teamBadge);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public void setTeams(List<Laliga> teams) {
        this.teams = teams;
        notifyDataSetChanged();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView teamName;
        ImageView teamBadge;

        public TeamViewHolder(View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.teamName);
            teamBadge = itemView.findViewById(R.id.teamBadge);
        }
    }
}
