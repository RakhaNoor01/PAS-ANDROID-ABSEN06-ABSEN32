package com.example.pas_absen06_absen32.ui.anggotakelompok;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_absen06_absen32.R;
import com.example.pas_absen06_absen32.adapter.MemberAdapter;
import com.example.pas_absen06_absen32.model.Member;

import java.util.Arrays;
import java.util.List;

public class KelompokFragment extends Fragment {
    private RecyclerView recyclerView;
    private MemberAdapter memberAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kelompok, container, false);

        recyclerView = view.findViewById(R.id.rvMembers);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Static list of group members
        List<Member> members = Arrays.asList(
                new Member("Azka El Fachrizy", "azkaelfachrizy@gmail.com", "085741505808", "06", "https://avatars.githubusercontent.com/u/107330423?v=4"),
                new Member("Rakha Noor A. Admaja", "rakhanoor12@gmail.com", "081334142387", "32", "https://avatars.githubusercontent.com/u/191069830?v=4")
                // Tambahkan anggota lain jika perlu
        );

        memberAdapter = new MemberAdapter(members);
        recyclerView.setAdapter(memberAdapter);

        return view;
    }
}