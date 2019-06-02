package com.example.movie_app.DB;

import com.example.movie_app.BuildConfig;
import com.example.movie_app.Model.MovieDatabase;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieDatabaseApiService {

    String apiKey = BuildConfig.apiKey;

    @GET("movie?api_key=" + apiKey + "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=true&with_original_language=en")
    Call<MovieDatabase> getMovies();

    @GET("movie?api_key=" + apiKey + "&language=en-US&sort_by=popularity.desc&with_original_language=en")
    Call<MovieDatabase> getMovieYear(@Query("year") String year);
}
