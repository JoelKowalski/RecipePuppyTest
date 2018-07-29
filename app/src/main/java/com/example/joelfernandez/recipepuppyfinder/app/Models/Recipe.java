package com.example.joelfernandez.recipepuppyfinder.app.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Joel Fernandez on 27/07/2018.
 */

public class Recipe implements Serializable{
    /**
     * Recipe Tittle
     */
    @SerializedName("title")
    private String tittle;

    /**
     * Recipe Href
     */
    @SerializedName("href")
    private String href;

    /**
     * Recipe Ingredients
     */
    @SerializedName("ingredients")
    private String ingredients;

    /**
     * Recipe helper attribute to store ingredients as a list
     */
    private String[] ingredientsList = null;

    /**
     * Recipe Thumbnail
     */
    @SerializedName("thumbnail")
    private String thumbnail;

    /**
     * ingredient list visible
     */
    private boolean isIngredientsVisibles;

    public boolean isIngredientsVisibles() {
        return isIngredientsVisibles;
    }

    public void toogleIngredientsVisibility() {
        isIngredientsVisibles = !isIngredientsVisibles;
    }

    public String getTittle() {
        return tittle;
    }

    public String getHref() {
        return href;
    }

    public String[] getIngredientsAsArray() {
        if(ingredientsList == null)
            ingredientsList = ingredients.split(",");
        return ingredientsList;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
