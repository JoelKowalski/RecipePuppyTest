package com.example.joelfernandez.recipepuppyfinder.app.Interfaces;

import com.example.joelfernandez.recipepuppyfinder.app.Fragments.MainFragment;
import com.example.joelfernandez.recipepuppyfinder.app.Models.Recipe;
import com.example.joelfernandez.recipepuppyfinder.app.Response.RecipeResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Joel Fernandez on 27/07/2018.
 */

public class MainInterfaces {

    /**
     * First navigation interface
     */
    public interface IFirstNavigation{
        public abstract void initView(MainFragment fragment);
    }

    /**
     * Interface to pass recipes between fragments
     */
    public interface IRecipeList{
        public abstract void getRecipe(RecipeResponse response);
    }
}
