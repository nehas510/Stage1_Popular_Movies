package com.example.neha.p1_popularmovies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.neha.p1_popularmovies.Data.Movies;
import com.example.neha.p1_popularmovies.Data.PopularMovies;
import com.example.neha.p1_popularmovies.Presenter.MoviePresenter;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MoviesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    protected SpinnerProgressBar spb;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private List<Movies> results = new ArrayList<Movies>();
    private MoviePresenter mPresenter;
    private RecyclerView recyclerView;
    private GridViewAdapter mAdapter;
    private String type;
    private RecyclerView.LayoutManager layoutManager;
    private Realm realm;
    private boolean isTab;
  //  private TextView emptyView;




    // private OnFragmentInteractionListener mListener;

    public MoviesFragment(String type) {
        this.type = type;



        // Required empty public constructor
    }


    public MoviesFragment(String type,boolean isTablet) {
        this.type = type;
        this.isTab = isTablet;



        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setHasOptionsMenu(true);
        realm = Realm.getDefaultInstance();


    }


    public void showProgress(){

        spb = SpinnerProgressBar.show(getActivity());

    }

    public void hideProgress(){
        if (spb != null) {
            spb.dismiss();
        }
    }
    public void updateRecyclerView(View view,String type){


            recyclerView = (RecyclerView) view.findViewById(R.id.gridRecycler);
        mAdapter = new GridViewAdapter(this, results,isTab,type);
        layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        //    emptyView = (TextView) view.findViewById(R.id.empty_view);

   /*     if (results.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        }
        else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);

        }


*/

    }

    public void getResults(List<Movies> results){

        this.results = results;
    }


    public void setRealmData(PopularMovies popularMovies){


        realm.beginTransaction();
        realm.copyToRealmOrUpdate(popularMovies);
        realm.commitTransaction();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmentView

        final View layoutInflater = inflater.inflate(R.layout.fragment_movies, container, false);
        mPresenter = new MoviePresenter(this);
        mPresenter.createManager(getActivity());
        mPresenter.setConfigDataURL();

        if(type.contains("favourites")){
            realm = Realm.getDefaultInstance();
            realm.beginTransaction();

            RealmResults<PopularMovies> popularMovies = realm.where(PopularMovies.class).equalTo("type","favourites").findAll();
           List<Movies> movies = popularMovies.get(0).getResults().where().distinct("original_title");
            realm.commitTransaction();
            getResults(movies);
            updateRecyclerView(layoutInflater,type);



        }
else {
            mPresenter.getMovieType(type, new Callback<PopularMovies>() {
                @Override
                public void success(PopularMovies popularMovies, Response response) {
                    updateRecyclerView(layoutInflater,type);
                    setRealmData(popularMovies);

                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(getContext(), "Failed fetching the movieType!", Toast.LENGTH_SHORT).show();

                }
            });

        }
        return layoutInflater;


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }


}
