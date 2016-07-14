package com.example.neha.p1_popularmovies.moviedb;

import com.example.neha.p1_popularmovies.Data.Movies;
import com.example.neha.p1_popularmovies.Data.PopularMovies;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by neha on 7/8/16.
 */
public interface MovieApiService {


    @GET("/3/movie/{movieType}")
    void getMoviesPage(@Path("movieType") String type, @Query("api_key") String API_KEY, Callback<PopularMovies> callback);

   @GET("/3/movie/{id}")
    void getMoviesbyId(@Path("id") String id, @Query("api_key") String API_KEY, Callback<Movies> callback);

}
