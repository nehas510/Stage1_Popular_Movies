package com.example.neha.p1_popularmovies;

import android.content.Context;

import com.example.neha.p1_popularmovies.Data.Movies;
import com.example.neha.p1_popularmovies.Data.PopularMovies;
import com.example.neha.p1_popularmovies.Data.Reviews;
import com.example.neha.p1_popularmovies.Data.Videos;
import com.example.neha.p1_popularmovies.moviedb.MovieApiClient;

import retrofit.Callback;

/**
 * Created by neha on 7/10/16.
 */
public class MovieManager {
    public Context mContext;

    //IMPORTANT NOTE:
    // The API Key has been removed as it is Illegal to share the personal API Key, Please put in yours to test the app!
    private static String API_KEY = "";
    /**
     * Constructor
     */
    public MovieManager(Context context) {

       context = mContext;

    }

    /**
     * Constructor
     */
    public MovieManager(Context context, String url) {
      context = mContext;
        setUrl(url);

    }

    public void setUrl(String url) {
        MovieApiClient.init(url);

    }


    public void getMoviesPage(String type, Callback<PopularMovies> callback) {
        MovieApiClient.get().getMoviesPage(type,API_KEY,callback);

    }

    public void getMoviesbyId(String id, Callback<Movies> callback) {
        MovieApiClient.get().getMoviesbyId(id,API_KEY,callback);
    }

    public void getVideosbyId(String id, Callback<Videos> callback) {
        MovieApiClient.get().getVideosbyId(id,API_KEY,callback);
    }

    public void getReviews(String id, Callback<Reviews> callback) {
        MovieApiClient.get().getReviews(id,API_KEY,callback);
    }
}
