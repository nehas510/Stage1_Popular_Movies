package com.example.neha.p1_popularmovies.Data;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by neha on 9/26/16.
 */



public class Videos extends RealmObject{


    private Integer id;
    private RealmList<VideoResult> results = new RealmList<>();
  //  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The id
     */

    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The results
     */
    public RealmList<VideoResult> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(RealmList<VideoResult> results) {
        this.results = results;
    }

//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
}

