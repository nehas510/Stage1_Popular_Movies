package com.example.neha.p1_popularmovies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.neha.p1_popularmovies.Data.PopularMovies;
import com.example.neha.p1_popularmovies.Data.Result;
import com.example.neha.p1_popularmovies.Presenter.MoviePresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;



public class MoviesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    protected SpinnerProgressBar spb;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

  //  String[] data= {"one","two","tgree","uiuo","you"};
  //  private  List<String> imgURL = new ArrayList<String>();
    private List<Result> results = new ArrayList<Result>();
    private MoviePresenter mPresenter;
    private RecyclerView recyclerView;
    private GridViewAdapter mAdapter;
    private String type;
    private RecyclerView.LayoutManager layoutManager;


   // private OnFragmentInteractionListener mListener;

    public MoviesFragment(String type) {
        this.type = type;

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment MoviesFragment.
     */
    // TODO: Rename and change types and number of parameters
 /*   public static MoviesFragment newInstance(String param1, String param2) {
        MoviesFragment fragment = new MoviesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setHasOptionsMenu(true);

    }

    public void showProgress(){

        spb = SpinnerProgressBar.show(getActivity());

    }

    public void hideProgress(){
        if (spb != null) {
            spb.dismiss();
        }
    }
    public void updateRecyclerView(View view){


        recyclerView = (RecyclerView) view.findViewById(R.id.gridRecycler);

        mAdapter = new GridViewAdapter(this,results);
        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);


    }

    public void getResults(List<Result> results){

        this.results = results;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmentView

        final View layoutInflater = inflater.inflate(R.layout.fragment_movies, container, false);
        mPresenter = new MoviePresenter(this);
        mPresenter.createManager(getActivity());
        mPresenter.setConfigDataURL();
        mPresenter.getMovieType(type, new Callback<PopularMovies>() {
                    @Override
                    public void success(PopularMovies popularMovies, Response response) {
                        updateRecyclerView(layoutInflater);

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getContext(), "Something is wrong!", Toast.LENGTH_SHORT).show();

                    }
                });

        return layoutInflater;
    }



}
