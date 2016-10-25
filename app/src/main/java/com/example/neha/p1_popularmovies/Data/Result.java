package com.example.neha.p1_popularmovies.Data;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by neha on 7/9/16.
 */
public class Result extends RealmObject{

    private String poster_path;
    private Boolean adult;
    private String overview;
    private String release_date;
    private RealmList<RealmInteger> genre_ids = new RealmList<>();
    @PrimaryKey
    private Integer id;
    private String original_title;
    private String original_language;
    private String title;
    private String backdrop_path;
    private Double popularity;
    private Integer vote_count;
    private Boolean video;
    private Double vote_average;

    //  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The posterPath
     */
    public String getPosterPath() {
        return poster_path;
    }

    /**
     * @param posterPath The poster_path
     */
    public void setPosterPath(String posterPath) {
        this.poster_path = posterPath;
    }

    /**
     * @return The adult
     */
    public Boolean getAdult() {
        return adult;
    }

    /**
     * @param adult The adult
     */
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    /**
     * @return The overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * @param overview The overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * @return The releaseDate
     */
    public String getReleaseDate() {
        return release_date;
    }

    /**
     * @param releaseDate The release_date
     */
    public void setReleaseDate(String releaseDate) {
        this.release_date = releaseDate;
    }

    /**
     * @return The genreIds
     */
    public RealmList<RealmInteger> getGenreIds() {
        return genre_ids;
    }

    /**
     * @param genreIds The genre_ids
     */

    public void setGenreIds(RealmList<RealmInteger> genreIds) {
        this.genre_ids = genreIds;
    }

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
     * @return The originalTitle
     */
    public String getOriginalTitle() {
        return original_title;
    }

    /**
     * @param originalTitle The original_title
     */
    public void setOriginalTitle(String originalTitle) {
        this.original_title = originalTitle;
    }

    /**
     * @return The originalLanguage
     */
    public String getOriginalLanguage() {
        return original_language;
    }

    /**
     * @param originalLanguage The original_language
     */
    public void setOriginalLanguage(String originalLanguage) {
        this.original_language = originalLanguage;
    }

    /**
     * @return The title
     */

    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The backdropPath
     */
    public String getBackdropPath() {
        return backdrop_path;
    }

    /**
     * @param backdropPath The backdrop_path
     */
    public void setBackdropPath(String backdropPath) {
        this.backdrop_path = backdropPath;
    }

    /**
     * @return The popularity
     */
    public Double getPopularity() {
        return popularity;
    }

    /**
     * @param popularity The popularity
     */
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    /**
     * @return The voteCount
     */
    public Integer getVoteCount() {
        return vote_count;
    }

    /**
     * @param voteCount The vote_count
     */

    public void setVoteCount(Integer voteCount) {
        this.vote_count = voteCount;
    }

    /**
     * @return The video
     */

    public Boolean getVideo() {
        return video;
    }

    /**
     * @param video The video
     */

    public void setVideo(Boolean video) {
        this.video = video;
    }

    /**
     * @return The voteAverage
     */

    public Double getVoteAverage() {
        return vote_average;
    }

    /**
     * @param voteAverage The vote_average
     */
    public void setVoteAverage(Double voteAverage) {
        this.vote_average = voteAverage;
    }



//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}