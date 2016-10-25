package com.example.neha.p1_popularmovies.Detail;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.neha.p1_popularmovies.Data.ReviewResult;
import com.example.neha.p1_popularmovies.R;

import java.util.List;

/**
 * Created by neha on 10/23/16.
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewHolder> {

    Fragment fragment;
    List<ReviewResult> results;

    public ReviewAdapter(Fragment fragment, List<ReviewResult> review){

        this.fragment = fragment;
        this.results = review;

    }


    @Override
    public ReviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_recycler,parent,false);

        ReviewHolder viewHolder = new ReviewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReviewHolder holder, int position) {

        holder.author.setText(results.get(position).getAuthor());
        holder.reviewsData.setText(results.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}

class ReviewHolder extends RecyclerView.ViewHolder{
 TextView author, reviewsData;

    public ReviewHolder(View view) {
        super(view);

        author = (TextView) view.findViewById(R.id.textViewAuthor);
        reviewsData = (TextView) view.findViewById(R.id.textViewReview);
    }
}