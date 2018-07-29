package com.example.joelfernandez.recipepuppyfinder.app.Controllers;


import android.content.Context;

import com.example.joelfernandez.recipepuppyfinder.app.Interfaces.APIClient;
import com.example.joelfernandez.recipepuppyfinder.app.Interfaces.APIInterfaces;
import com.example.joelfernandez.recipepuppyfinder.app.Interfaces.MainInterfaces;
import com.example.joelfernandez.recipepuppyfinder.app.Models.Recipe;
import com.example.joelfernandez.recipepuppyfinder.app.Response.RecipeResponse;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Joel Fernandez on 27/07/2018.
 */

public class DataController {

    APIInterfaces apiInterface;

    /**
     *Method to recive recipes from api
     */
    public void getRecipes(final Context context,String recipeInput, final MainInterfaces.IRecipeList listener){
        try{
            apiInterface = APIClient.getClient().create(APIInterfaces.class);

            /**
            GET List Recipes
            **/
            Call<RecipeResponse> call = apiInterface.doGetListRecipe(recipeInput);
            call.enqueue(new Callback<RecipeResponse>() {
                @Override
                public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                    if(response.isSuccessful()){
                        RecipeResponse recipeResponse=response.body();
                        listener.getRecipe(recipeResponse);
                    }
                }

                @Override
                public void onFailure(Call<RecipeResponse> call, Throwable t) {
                    call.cancel();
                }
            });
        } catch (Exception a) { }
    }
}
