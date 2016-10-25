package com.example.neha.p1_popularmovies;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.neha.p1_popularmovies.Data.Movies;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by neha on 7/6/16.
 */
public class GridViewAdapter extends RecyclerView.Adapter<GridViewHolder> {
    List<Movies> titles;
  //  List<String> imgUrl;
    String BASE_IMG_URL = " http://image.tmdb.org/t/p/";
    String IMG_SIZE = "original";
    Fragment fragment;
    boolean isTab;
    String type;


    public interface Callback {
        /**
         * DetailFragmentCallback for when an item has been selected.
         * @param dateUri
         */
        public void onItemSelected(String dateUri);
    }

    public GridViewAdapter(Fragment fragment, List<Movies> title,boolean isTab,String type){
        this.fragment = fragment;
        this.titles = title;
        this.isTab = isTab;
        this.type = type;

    }
    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_image_view,parent,false);

        GridViewHolder gridViewHolder = new GridViewHolder(fragment,view);
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
  if((isTab && position==0) && type.contains("popular"))
{
    Context mycontext = holder.imageTitle.getContext();
    String url = BASE_IMG_URL+IMG_SIZE+(titles.get(position).getPosterPath());
    Picasso.with(mycontext)
            .load(url)
            .fit()
            .into(holder.imageTitle);

    holder.showData(titles.get(position));
   holder.handleSelectedItem(fragment);


}

else {
      Context mycontext = holder.imageTitle.getContext();
      String url = BASE_IMG_URL + IMG_SIZE + (titles.get(position).getPosterPath());
      Picasso.with(mycontext)
              .load(url)
              .fit()
              .into(holder.imageTitle);

      holder.showData(titles.get(position));
  }

    }


    @Override
    public int getItemCount() {
        return titles.size();
    }
}


class GridViewHolder extends RecyclerView.ViewHolder{
    ImageView imageTitle;
    Movies titleData;


    public void showData(Movies result){
        this.titleData = result;


    }

    public GridViewHolder(final Fragment mFragment, View view) {
        super(view);

        imageTitle = (ImageButton) view.findViewById(R.id.imageTitle);
        imageTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   Intent intent = new Intent(mFragment.getContext(), DetailActivity.class).putExtra(Intent.EXTRA_TEXT,String.valueOf(titleData.getId()));
                //   mFragment.startActivity(intent);

               handleSelectedItem(mFragment);


            }
        });
    }

        void handleSelectedItem(Fragment mFragment){

        ((GridViewAdapter.Callback) mFragment.getActivity()).onItemSelected(String.valueOf(titleData.getId()));

    }




}
