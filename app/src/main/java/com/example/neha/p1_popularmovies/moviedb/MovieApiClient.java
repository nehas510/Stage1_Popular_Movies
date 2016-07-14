package com.example.neha.p1_popularmovies.moviedb;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by neha on 7/8/16.
 */
public class MovieApiClient {

    private static String MOVIE_URL = "";

    private static MovieApiService MOVIE_API_SERVICE;


    private MovieApiClient() {

    }

    public static void init(String movieUrl) {
        MOVIE_URL = movieUrl;
        setupClient();

    }


    public static MovieApiService get() {
        return MOVIE_API_SERVICE;
    }


    private static void setupClient() {


        OkHttpClient okHttpClient = new OkHttpClient();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(MOVIE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(okHttpClient))
                .build();

        MOVIE_API_SERVICE = restAdapter.create(MovieApiService.class);
    }



}
