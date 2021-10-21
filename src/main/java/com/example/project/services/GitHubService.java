package com.example.project.services;

import com.example.project.entities.Anime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubService {
    @GET("animes")
    Call<List<Anime>> allAnimes();
}
