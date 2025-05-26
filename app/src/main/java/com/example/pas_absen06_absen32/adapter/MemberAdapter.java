package com.example.pas_absen06_absen32.adapter;
import android.view.LayoutInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_absen06_absen32.R;
import com.example.pas_absen06_absen32.model.Member;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberViewHolder> {
    private List<Member> members;

    public MemberAdapter(List<Member> members) {
        this.members = members;
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.member_itemlayout, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {
        Member member = members.get(position);
        holder.tvName.setText(member.getName());
        holder.tvEmail.setText(member.getEmail());
        holder.tvPhone.setText(member.getPhone());
        holder.tvAbsen.setText("Absen: " + member.getAbsen());
        Picasso.get()
                .load(member.getPhotoUrl())
                .placeholder(R.drawable.ball2)
                .error(R.drawable.ball2)
                .into(holder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    static class MemberViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;
        TextView tvName, tvEmail, tvPhone, tvAbsen;

        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.ivMemberPhoto);
            tvName = itemView.findViewById(R.id.tvMemberName);
            tvEmail = itemView.findViewById(R.id.tvMemberEmail);
            tvPhone = itemView.findViewById(R.id.tvMemberPhone);
            tvAbsen = itemView.findViewById(R.id.tvMemberAbsen);
        }
    }
}
