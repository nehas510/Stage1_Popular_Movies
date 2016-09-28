package com.example.neha.p1_popularmovies.Detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.neha.p1_popularmovies.Data.Movies;
import com.example.neha.p1_popularmovies.Data.Videos;
import com.example.neha.p1_popularmovies.Presenter.MoviePresenter;
import com.example.neha.p1_popularmovies.R;
import com.example.neha.p1_popularmovies.SpinnerProgressBar;
import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DetailFragment extends Fragment {
protected  SpinnerProgressBar spb;
    private String mTitle;
    private MoviePresenter presenter;
    private TextView orginalTitle, synopsis,ratings,date;
    private ImageView poster;
    private Movies movieData;
    private Button watchNow, watchTrailer;
    private RadioButton fav;
    private RecyclerView readReviews;
    private String videoKey;
    private String videoUrl;

    public  DetailFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.detail_fragment, container, false);
        presenter = new MoviePresenter(this);
        presenter.createManager(getActivity());
        presenter.setConfigDataURL();
        Intent intent = getActivity().getIntent();

        if(intent!=null && Intent.EXTRA_TEXT!=null) {

            mTitle = intent.getStringExtra(Intent.EXTRA_TEXT);
            presenter.getMoviesbyId(mTitle, new Callback<Movies>() {
                @Override
                public void success(Movies movies, Response response) {
                    initViews(rootView);
                    try {
                        updateData();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(getContext(), "Something is wrong!", Toast.LENGTH_SHORT).show();
                }
            });


        }


        return rootView;


    }

    public void showProgress(){

        spb = SpinnerProgressBar.show(getActivity());

    }

    public void hideProgress(){
        if (spb != null) {
            spb.dismiss();
        }
    }
 public void getTitleData(Movies movies){


     this.movieData = movies;

}


    public void getVideoKey(String key){

        this.videoKey = key;
    }

    public void updateData() throws MalformedURLException {

        String BASE_IMG_URL = " http://image.tmdb.org/t/p/";
        String IMG_SIZE = "original";
        String URL = BASE_IMG_URL+IMG_SIZE+(movieData.getPosterPath());
        orginalTitle.setText(movieData.getOriginalTitle());
        synopsis.setText (movieData.getOverview());
        ratings.setText(String.valueOf(movieData.getVoteAverage()));
        date.setText(movieData.getReleaseDate());
        Picasso.with(this.getContext())
                .load(URL)
                .fit()
                .into(poster);

        watchTrailer.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {


            presenter.playVideo(mTitle, new Callback<Videos>() {
                @Override
                public void success(Videos videos, Response response) {

                    String domain = "www.youtube.com/watch?v=";
                    videoUrl = domain+videoKey;

                    Intent intent = new  Intent(Intent.ACTION_VIEW);

                    intent.setPackage("com.google.android.youtube");
                    intent.setData(Uri.parse(videoUrl));

                    startActivity(intent);

                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(getContext(), "Something is wrong!", Toast.LENGTH_SHORT).show();


                }
            });




            }
        } );

    }

    public void initViews(View view){

        orginalTitle = (TextView) view.findViewById(R.id.textViewTitle);
        synopsis = (TextView) view.findViewById(R.id.textViewSynopis);
        ratings = (TextView) view.findViewById(R.id.textViewRatings);
        date = (TextView) view.findViewById(R.id.textViewDate);
        poster = (ImageView) view.findViewById(R.id.imageViewPoster);
        watchNow = (Button) view.findViewById(R.id.buttonNow);
        watchTrailer = (Button) view.findViewById(R.id.buttonTrailer);
      //  fav = (RadioButton) view.findViewById(R.id.radioButton);


    }


}
