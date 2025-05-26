package com.example.pas_absen06_absen32;


import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;

import com.example.pas_absen06_absen32.ui.anggotakelompok.KelompokFragment;
import com.example.pas_absen06_absen32.ui.country.CountryFragment;
import com.example.pas_absen06_absen32.ui.laliga.LaligaFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, new LaligaFragment())
                .commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_Laliga) {
                fragment = new LaligaFragment();
            } else if (itemId == R.id.nav_Country) {
                fragment = new CountryFragment();
            } else if (itemId == R.id.nav_Member) {
                fragment = new KelompokFragment();
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, fragment)
                        .commit();
                return true;
            }
            return false;
        });
    }
}