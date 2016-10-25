package com.example.neha.p1_popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.neha.p1_popularmovies.Detail.DetailActivity;
import com.example.neha.p1_popularmovies.Detail.DetailFragment;

public class MainActivity extends ActionBarActivity implements GridViewAdapter.Callback{

private boolean isTablet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        if(findViewById(R.id.detail_container)!=null){

         isTablet = true;

            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.grid_container, new MoviesFragment("popular",isTablet))
                        .commit();


                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.detail_container, new DetailFragment())
                        .commit();
            }



        }
    else {
            isTablet = false;
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.grid_container, new MoviesFragment("popular"))
                        .commit();
            }

        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.popular) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.grid_container, new MoviesFragment("popular"))
                    .commit();
            return true;
        }

        else if(id == R.id.top_rated){
        getSupportFragmentManager().beginTransaction()
                .addToBackStack("popular")
                .replace(R.id.grid_container, new MoviesFragment("top_rated"))
                .commit();
            return true;
       }


        else if (id == R.id.upcoming){
                getSupportFragmentManager().beginTransaction()
                        .addToBackStack("popular")
                .replace(R.id.grid_container, new MoviesFragment("upcoming"))
                .commit();

            return true;
        }
        else if(id == R.id.now_playing){
                getSupportFragmentManager().beginTransaction()
                        .addToBackStack("popular")
                .replace(R.id.grid_container, new MoviesFragment("now_playing"))
                .commit();
            return true;
        }
        else if (id == R.id.favourites) {
            getSupportFragmentManager().beginTransaction()
                    .addToBackStack("popular")
                    .replace(R.id.grid_container, new MoviesFragment("favourites"))
                    .commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemSelected(String data) {
        if (isTablet)
        {

            getSupportFragmentManager().beginTransaction()
                                         .replace(R.id.detail_container,new DetailFragment(data,isTablet))
                                         .commit();
                     } else {
                         Intent intent = new Intent(this, DetailActivity.class).
                         putExtra(Intent.EXTRA_TEXT,data);
                         startActivity(intent);

                     }
             }

}
