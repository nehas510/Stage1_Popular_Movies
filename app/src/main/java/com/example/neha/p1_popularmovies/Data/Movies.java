package com.example.neha.p1_popularmovies.Data;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by neha on 7/14/16.
 */
public class Movies extends RealmObject {

    private Boolean adult;
    private String backdrop_path;
    private BelongsToCollection belongs_to_collection;
    private Integer budget;
    private RealmList<Genre> genres = new RealmList<>();
    private String homepage;

    private Integer id;
    private String imdbId;
    private String original_language;
    @PrimaryKey
    private String original_title;
    private String overview;
    private Double popularity;
    private String poster_path;
    private RealmList<ProductionCompany> production_companies = new RealmList<>();
    private RealmList<ProductionCountry> production_countries = new RealmList<>();
    private String release_date;
    private Integer revenue;
    private Integer runtime;
    private RealmList<SpokenLanguage> spoken_languages = new RealmList<>();
    private String status;
    private String tagline;
    private String title;
    private Boolean video;
    private Double vote_average;
    private Integer vote_count;
    private boolean favourite;
   // private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The adult
     */
    public Boolean getAdult() {
        return adult;
    }

    /**
     *
     * @param adult
     * The adult
     */
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    /**
     *
     * @return
     * The backdropPath
     */
    public String getBackdropPath() {
        return backdrop_path;
    }

    /**
     *
     * @param backdropPath
     * The backdrop_path
     */
    public void setBackdropPath(String backdropPath) {
        this.backdrop_path = backdropPath;
    }

    /**
     *
     * @return
     * The belongsToCollection
     */
    public BelongsToCollection getBelongsToCollection() {
        return belongs_to_collection;
    }

    /**
     *
     * @param belongsToCollection
     * The belongs_to_collection
     */
    public void setBelongsToCollection(BelongsToCollection belongsToCollection) {
        this.belongs_to_collection = belongsToCollection;
    }

    /**
     *
     * @return
     * The budget
     */
    public Integer getBudget() {
        return budget;
    }

    /**
     *
     * @param budget
     * The budget
     */
    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    /**
     *
     * @return
     * The genres
     */
    public List<Genre> getGenres() {
        return genres;
    }

    /**
     *
     * @param genres
     * The genres
     */
    public void setGenres(RealmList<Genre> genres) {
        this.genres = genres;
    }

    /**
     *
     * @return
     * The homepage
     */
    public String getHomepage() {
        return homepage;
    }

    /**
     *
     * @param homepage
     * The homepage
     */
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The imdbId
     */

    public String getImdbId() {
        return imdbId;
    }

    /**
     *
     * @param imdbId
     * The imdb_id
     */
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    /**
     *
     * @return
     * The originalLanguage
     */
    public String getOriginalLanguage() {
        return original_language;
    }

    /**
     *
     * @param originalLanguage
     * The original_language
     */
    public void setOriginalLanguage(String originalLanguage) {
        this.original_language = originalLanguage;
    }

    /**
     *
     * @return
     * The originalTitle
     */
    public String getOriginalTitle() {
        return original_title;
    }

    /**
     *
     * @param originalTitle
     * The original_title
     */
    public void setOriginalTitle(String originalTitle) {
        this.original_title = originalTitle;
    }

    /**
     *
     * @return
     * The overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     *
     * @param overview
     * The overview
     */

    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     *
     * @return
     * The popularity
     */
    public Double getPopularity() {
        return popularity;
    }

    /**
     *
     * @param popularity
     * The popularity
     */
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    /**
     *
     * @return
     * The posterPath
     */
    public String getPosterPath() {
        return poster_path;
    }

    /**
     *
     * @param posterPath
     * The poster_path
     */
    public void setPosterPath(String posterPath) {
        this.poster_path = posterPath;
    }

    /**
     *
     * @return
     * The productionCompanies
     */
    public RealmList<ProductionCompany> getProductionCompanies() {
        return production_companies;
    }

    /**
     *
     * @param productionCompanies
     * The production_companies
     */
    public void setProductionCompanies(RealmList<ProductionCompany> productionCompanies) {
        this.production_companies = productionCompanies;
    }

    /**
     *
     * @return
     * The productionCountries
     */
    public RealmList<ProductionCountry> getProductionCountries() {
        return production_countries;
    }

    /**
     *
     * @param productionCountries
     * The production_countries
     */
    public void setProductionCountries(RealmList<ProductionCountry> productionCountries) {
        this.production_countries = productionCountries;
    }

    /**
     *
     * @return
     * The releaseDate
     */
    public String getReleaseDate() {
        return release_date;
    }

    /**
     *
     * @param releaseDate
     * The release_date
     */
    public void setReleaseDate(String releaseDate) {
        this.release_date = releaseDate;
    }

    /**
     *
     * @return
     * The revenue
     */
    public Integer getRevenue() {
        return revenue;
    }

    /**
     *
     * @param revenue
     * The revenue
     */
    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    /**
     *
     * @return
     * The runtime
     */
    public Integer getRuntime() {
        return runtime;
    }

    /**
     *
     * @param runtime
     * The runtime
     */
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    /**
     *
     * @return
     * The spokenLanguages
     */
    public RealmList<SpokenLanguage> getSpokenLanguages() {
        return spoken_languages;
    }

    /**
     *
     * @param spokenLanguages
     * The spoken_languages
     */

    public void setSpokenLanguages(RealmList<SpokenLanguage> spokenLanguages) {
        this.spoken_languages = spokenLanguages;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The tagline
     */
    public String getTagline() {
        return tagline;
    }

    /**
     *
     * @param tagline
     * The tagline
     */
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The video
     */
    public Boolean getVideo() {
        return video;
    }

    /**
     *
     * @param video
     * The video
     */
    public void setVideo(Boolean video) {
        this.video = video;
    }

    /**
     *
     * @return
     * The voteAverage
     */
    public Double getVoteAverage() {
        return vote_average;
    }

    /**
     *
     * @param voteAverage
     * The vote_average
     */
    public void setVoteAverage(Double voteAverage) {
        this.vote_average = voteAverage;
    }

    /**
     *
     * @return
     * The voteCount
     */
    public Integer getVoteCount() {
        return vote_count;
    }

    /**
     *
     * @param voteCount
     * The vote_count
     */
    public void setVoteCount(Integer voteCount) {
        this.vote_count = voteCount;
    }


    public boolean getFavourite() {
        return favourite;
    }


    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }


//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}


