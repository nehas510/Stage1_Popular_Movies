package com.example.neha.p1_popularmovies;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new MoviesFragment("popular"))
                    .commit();
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
                    .replace(R.id.container, new MoviesFragment("popular"))
                    .commit();
            return true;
        }

        else if(id == R.id.top_rated){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MoviesFragment("top_rated"))
                .commit();
            return true;
       }


        else if (id == R.id.upcoming){
                getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MoviesFragment("upcoming"))
                .commit();

            return true;
        }
        else if(id == R.id.now_playing){
                getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MoviesFragment("now_playing"))
                .commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
