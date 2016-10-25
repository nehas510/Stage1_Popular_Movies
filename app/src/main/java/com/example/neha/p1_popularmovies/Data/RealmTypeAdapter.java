package com.example.neha.p1_popularmovies.Data;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import io.realm.RealmList;

/**
 * Created by neha on 10/12/16.
 */

public class RealmTypeAdapter extends TypeAdapter<RealmList<RealmInteger>> {

    public static final TypeAdapter<RealmList<RealmInteger>> INSTANCE =
            new RealmTypeAdapter().nullSafe();


    @Override
    public void write(JsonWriter out, RealmList<RealmInteger> src) throws IOException {
        out.beginArray();
        for(RealmInteger realmInt : src) { out.value(realmInt.values); }
        out.endArray();

    }

    @Override
    public RealmList<RealmInteger> read(JsonReader in) throws IOException {
        RealmList<RealmInteger> realmInts = new RealmList<>();
        in.beginArray();
        while (in.hasNext()) {
            if(in.peek() == JsonToken.NULL) {
                in.nextNull();
            } else {
                RealmInteger realmInt = new RealmInteger();
                realmInt.values = in.nextInt();
                realmInts.add(realmInt);
            }
        }
        in.endArray();
        return realmInts;
    }

}
