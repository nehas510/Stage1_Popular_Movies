package com.example.neha.p1_popularmovies.Presenter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.neha.p1_popularmovies.Data.Movies;
import com.example.neha.p1_popularmovies.Data.PopularMovies;
import com.example.neha.p1_popularmovies.Data.Videos;
import com.example.neha.p1_popularmovies.Detail.DetailFragment;
import com.example.neha.p1_popularmovies.MovieManager;
import com.example.neha.p1_popularmovies.MoviesFragment;

import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by neha on 7/12/16.
 */
public class MoviePresenter {

    private MovieManager movieManager;
    private static final String TAG = "Movie Presenter";
    Fragment mView;

    public MoviePresenter(Fragment view) {

        mView = view;
    }

    public MovieManager getMovieManager(){

        return movieManager;
    }

    public void createManager(Context context){

        movieManager = new MovieManager(context);
    }

    public void setConfigDataURL(){

        movieManager.setUrl("http://api.themoviedb.org/");
    }


    public void getMoviesbyId(final String ids, final Callback<Movies> callback){
        ((DetailFragment)mView).showProgress();

        getMovieManager().getMoviesbyId(ids, new Callback<Movies>() {
            @Override
            public void success(Movies movies, retrofit.client.Response response) {
                if(callback!=null) {
                    if (mView instanceof DetailFragment) {
                        ((DetailFragment)mView).hideProgress();
                        ((DetailFragment) mView).getTitleData(movies);
                        callback.success(movies,response);
                    }
                }

            }

            @Override
            public void failure(RetrofitError error) {
                if(callback!=null) {
                    ((DetailFragment)mView).hideProgress();
                    Toast.makeText(mView.getContext(), "something is not right ", Toast.LENGTH_SHORT).show();
                    callback.failure(error);
                }
            }
        });

    }


    public void playVideo(final String ids, final Callback<Videos> callback){
        ((DetailFragment)mView).showProgress();
        getMovieManager().getVideosbyId(ids, new Callback<Videos>() {
            @Override
            public void success(Videos video, retrofit.client.Response response) {

                if(callback!=null) {
                    if (mView instanceof MoviesFragment) {
                        ((DetailFragment)mView).hideProgress();
                        ((DetailFragment) mView).getVideoKey(video.getResults().get(2).getKey());
                        callback.success(video,response);
                    }
                }

            }

            @Override
            public void failure(RetrofitError error) {
                if (callback != null) {
                    ((DetailFragment)mView).hideProgress();
                    Toast.makeText(mView.getContext(), "something is not right ", Toast.LENGTH_SHORT).show();
                    callback.failure(error);

                }
            }
        });

    }
    public void getMovieType(final String type, final Callback<PopularMovies> callback){
        ((MoviesFragment)mView).showProgress();
        getMovieManager().getMoviesPage(type, new Callback<PopularMovies>() {
            @Override
            public void success(PopularMovies popularMovies, retrofit.client.Response response) {

             if(callback!=null) {
                 if (mView instanceof MoviesFragment) {
                     ((MoviesFragment)mView).hideProgress();
                     ((MoviesFragment) mView).getResults(popularMovies.getResults());
                     callback.success(popularMovies,response);
                 }
             }

            }

            @Override
            public void failure(RetrofitError error) {
                if (callback != null) {
                    ((MoviesFragment)mView).hideProgress();
                    Toast.makeText(mView.getContext(), "something is not right ", Toast.LENGTH_SHORT).show();
                    callback.failure(error);

                }
            }
        });

    }

}
