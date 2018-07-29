package com.example.joelfernandez.recipepuppyfinder.app.Interfaces;

import com.example.joelfernandez.recipepuppyfinder.app.Response.RecipeResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Joel Fernandez on 27/07/2018.
 */

public interface APIInterfaces {
    @GET("api/?")
    Call<RecipeResponse> doGetListRecipe(@Query("q") String input);
}
