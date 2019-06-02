package com.example.movie_app.UI;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.movie_app.DB.MovieRepository;
import com.example.movie_app.Model.Movie;
import com.example.movie_app.Model.MovieDatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    private MovieRepository movieRepository = new MovieRepository();
    private MutableLiveData<List<Movie>> movie = new MutableLiveData<>();
    private MutableLiveData<String> error = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getError() {
        return error;
    }
    public MutableLiveData<List<Movie>> getMovie() {
        return movie;
    }

    public void getMovies() {
        movieRepository
                .getMovies()
                .enqueue(new Callback<MovieDatabase>() {
                    @Override
                    public void onResponse(@NonNull Call<MovieDatabase> call, @NonNull Response<MovieDatabase> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            movie.setValue(response.body().getResults());
                        } else {
                            error.setValue("Api Error: " + response.message());
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<MovieDatabase> call, @NonNull Throwable t) {
                        error.setValue("Api Error: " + t.getMessage());
                    }
                });
    }
    public void getMovieYear(String year) {
        movieRepository
                .getMovieYear(year)
                .enqueue(new Callback<MovieDatabase>() {
                    @Override
                    public void onResponse(Call<MovieDatabase> call, Response<MovieDatabase> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            movie.setValue(response.body().getResults());
                        } else {
                            error.setValue("Api Error: " + response.message());
                        }
                    }
                    @Override
                    public void onFailure(Call<MovieDatabase> call, Throwable t) {
                        error.setValue("Api Error: " + t.getMessage());
                    }
                });
    }
}
