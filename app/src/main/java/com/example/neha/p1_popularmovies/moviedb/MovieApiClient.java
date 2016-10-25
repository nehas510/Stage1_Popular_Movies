package com.example.neha.p1_popularmovies.moviedb;

import com.example.neha.p1_popularmovies.Data.RealmInteger;
import com.example.neha.p1_popularmovies.Data.RealmTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;

import io.realm.RealmList;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

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
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(new TypeToken<RealmList<RealmInteger>>(){}.getType(),
                        RealmTypeAdapter.INSTANCE)
                .create();


        OkHttpClient okHttpClient = new OkHttpClient();

        RestAdapter restAdapter = new RestAdapter.Builder()

                .setEndpoint(MOVIE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(okHttpClient))
                .setConverter(new GsonConverter(gson))
                .build();

        MOVIE_API_SERVICE = restAdapter.create(MovieApiService.class);
          }



}
