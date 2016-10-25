package com.example.neha.p1_popularmovies.Data;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by neha on 10/23/16.
 */

public class Reviews extends RealmObject{

    private Integer id;
    private Integer page;
    private RealmList<ReviewResult> results = new RealmList<>();
    private Integer totalPages;
    private Integer totalResults;

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
     * @return The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * @param page The page
     */

    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * @return The results
     */
    public RealmList<ReviewResult> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(RealmList<ReviewResult> results) {
        this.results = results;
    }

    /**
     * @return The totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * @param totalPages The total_pages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * @return The totalResults
     */
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * @param totalResults The total_results
     */
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

}