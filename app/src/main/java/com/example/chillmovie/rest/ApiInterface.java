package com.example.chillmovie.rest;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/3/movie/{category}")
    Call<Response> getMovie(
            @Path("category") String category,
            @Path("api_key") String api_key,
            @Path("language") String language,
            @Path("age") int age
    );

}
