package com.example.joelfernandez.recipepuppyfinder.app.Response;

import com.example.joelfernandez.recipepuppyfinder.app.Models.Recipe;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Joel Fernandez on 27/07/2018.
 */

public class RecipeResponse {

    /**
     * Data response
     */
    @SerializedName("results")
    private ArrayList<Recipe> data;

    public ArrayList<Recipe> getData() {
        return data;
    }

    public void setData(ArrayList<Recipe> data) {
        this.data = data;
    }
}
