package com.example.neha.p1_popularmovies.Detail;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.neha.p1_popularmovies.Data.Movies;
import com.example.neha.p1_popularmovies.Data.PopularMovies;
import com.example.neha.p1_popularmovies.Data.ReviewResult;
import com.example.neha.p1_popularmovies.Data.Reviews;
import com.example.neha.p1_popularmovies.Data.Videos;
import com.example.neha.p1_popularmovies.Presenter.MoviePresenter;
import com.example.neha.p1_popularmovies.R;
import com.example.neha.p1_popularmovies.SpinnerProgressBar;
import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
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
    private ImageButton fav;
    private RecyclerView readReviews;
    private String videoKey;
    private Realm realm;
    private ReviewAdapter mAdapter;
    private LinearLayoutManager layoutManager;
    private List<ReviewResult>  reviewsList = new ArrayList<ReviewResult>();
    private boolean isTab ;


    public  DetailFragment(){}

    public  DetailFragment(String title,boolean isTablet){

        this.mTitle = title;
        this.isTab = isTablet;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.detail_fragment, container, false);
        presenter = new MoviePresenter(this);
        presenter.createManager(getActivity());
        presenter.setConfigDataURL();
        realm = Realm.getDefaultInstance();
        Intent intent = getActivity().getIntent();

        if(intent!=null && Intent.EXTRA_TEXT!=null) {
           if(!isTab)
            mTitle = intent.getStringExtra(Intent.EXTRA_TEXT);
            presenter.getMoviesbyId(mTitle, new Callback<Movies>() {
                @Override
                public void success(Movies movies, Response response) {

                   presenter.getReviews(mTitle, new Callback<Reviews>() {
                       @Override
                       public void success(Reviews reviews, Response response) {
                           initViews(rootView);
                           try {
                               updateData();
                           } catch (MalformedURLException e) {
                               e.printStackTrace();
                           }
                       }

                       @Override
                       public void failure(RetrofitError error) {
                           Toast.makeText(getContext(), "No Reviews", Toast.LENGTH_SHORT).show();

                       }
                   });

                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(getContext(), "Failed to fetch moveID!", Toast.LENGTH_SHORT).show();
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

    public void getReviews(List<ReviewResult> reviewResults){

      this.reviewsList = reviewResults;
    }


    public void updateRecyclerView(){

        mAdapter = new ReviewAdapter(this,reviewsList);
        layoutManager = new LinearLayoutManager(this.getActivity());
        readReviews.setLayoutManager(layoutManager);
        readReviews.setAdapter(mAdapter);


    }
    public void updateData() throws MalformedURLException {

        String BASE_IMG_URL = " http://image.tmdb.org/t/p/";
        String IMG_SIZE = "original";
        String URL = BASE_IMG_URL+IMG_SIZE+(movieData.getPosterPath());
        updateRecyclerView();
        orginalTitle.setText(movieData.getOriginalTitle());
        synopsis.setText (movieData.getOverview());
        ratings.setText(String.valueOf(movieData.getVoteAverage()));
        date.setText(movieData.getReleaseDate());
        Picasso.with(this.getContext())
                .load(URL)
                .fit()
                .into(poster);



        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View button) {
                  button.setSelected(true);
                  button.setEnabled(false);
                  realm.executeTransactionAsync(new Realm.Transaction() {
                      @Override
                      public void execute(Realm realm) {

                          PopularMovies favMovies = realm.where(PopularMovies.class).equalTo("type", "favourites").findFirst();
                          movieData.setFavourite(true);
                          favMovies.getResults().add(movieData);



                      }


                  });
              }
        });
        watchTrailer.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {


            presenter.playVideo(mTitle, new Callback<Videos>() {
                @Override
                public void success(Videos videos, Response response) {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoKey));
                    Intent webIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.youtube.com/watch?v=" + videoKey));

                    try {
                        intent.putExtra("VIDEO_ID", videoKey);
                        startActivity(intent);
                    } catch (ActivityNotFoundException ex) {
                        webIntent.putExtra("VIDEO_ID", videoKey);
                        startActivity(webIntent);
                    }


                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(getContext(), "No Trailers available!", Toast.LENGTH_SHORT).show();


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
        fav = (ImageButton) view.findViewById(R.id.radioButton);
        readReviews = (RecyclerView) view.findViewById(R.id.reviews);


    }


}
