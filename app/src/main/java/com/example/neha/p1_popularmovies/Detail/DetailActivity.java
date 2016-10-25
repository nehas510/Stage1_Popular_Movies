package com.example.neha.p1_popularmovies.Detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.neha.p1_popularmovies.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container, new DetailFragment())
                    .commit();
        }

    }

}


