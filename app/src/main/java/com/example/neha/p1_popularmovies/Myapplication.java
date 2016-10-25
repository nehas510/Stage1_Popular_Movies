package com.example.neha.p1_popularmovies;

import android.app.Application;

import com.example.neha.p1_popularmovies.Data.PopularMovies;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by neha on 10/20/16.
 */

public class Myapplication extends Application {
    private Realm realm;
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        Realm.deleteRealm(realmConfig); // Delete Realm between app restarts.
        Realm.setDefaultConfiguration(realmConfig);
        realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                PopularMovies movieFav = realm.createObject(PopularMovies.class);
                movieFav.setType("favourites");
            }
        });

        realm.close();

    }

}
