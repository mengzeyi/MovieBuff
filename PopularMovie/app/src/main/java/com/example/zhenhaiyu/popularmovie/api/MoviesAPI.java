package com.example.zhenhaiyu.popularmovie.api;

import com.example.zhenhaiyu.popularmovie.model.Movie;
import com.example.zhenhaiyu.popularmovie.model.MovieListResponse;
import com.example.zhenhaiyu.popularmovie.model.ReviewResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * ref: http://blog.robinchutaux.com/blog/a-smart-way-to-use-retrofit/
 */
public interface MoviesAPI {
    // Top 20 movies sorted by specified criteria
    @GET("/discover/movie")
    void discoverMoviesByPref(
            @Query("sort_by") String sortBy,
//            @Query("api_key") String apiKey,
            Callback<MovieListResponse> cb);


    //pages of movies sorted by popularity
    @GET("/movie/popular")
    void discoverPopularMovies(
            @Query("page") int page,
            Callback<List<Movie>> cb);

    // pages of movies sorted by rating
    @GET("/movie/top_rated")
    void discoverHighestRatedMovies(
             @Query("page") int page,
             Callback<MovieListResponse> cb);

    // Get movie details by id
    @GET("/movie/{id}")
    void getMovie(
            @Path("id") int movieId,
            Callback<Movie> cb);

    @GET("/movie/{id}/videos")
    void getVideos(
            @Path("id") long movieId,
            Callback<MovieListResponse> cb);

    @GET("/movie/{id}/reviews")
    void getReviews(
            @Path("id") long movieId,
            Callback<ReviewResponse> cb);
}
