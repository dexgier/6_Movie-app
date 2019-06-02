package com.example.movie_app.DB;

import com.example.movie_app.Model.Movie;
import com.example.movie_app.Model.MovieDatabase;

import retrofit2.Call;

public class MovieRepository {

    private MovieDatabaseApiService movieDatabaseApiService = MovieDatabaseApi.create();

    public Call<MovieDatabase> getMovies() {
        return movieDatabaseApiService.getMovies();
    }

    public Call<MovieDatabase> getMovieYear(String year) {
        return movieDatabaseApiService.getMovieYear(year);
    }
}