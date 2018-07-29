package com.example.joelfernandez.recipepuppyfinder.app.Controllers;

import com.example.joelfernandez.recipepuppyfinder.app.Fragments.MainFragment;
import com.example.joelfernandez.recipepuppyfinder.app.Fragments.RecipeListFragment;
import com.example.joelfernandez.recipepuppyfinder.app.Interfaces.MainInterfaces;

/**
 * Created by Joel Fernandez on 27/07/2018.
 */

public class NavigationController {

    /**
     * Fragment show into activity
     */
    private MainFragment fragment;

    /**
     * Indicate if go back navigation
     */
    protected static boolean goToBack;

    /**
     * Method to select a fragment and init view with him
     * @param listener
     */
    public void initNavigation(MainInterfaces.IFirstNavigation listener) {
        //create fragment
        fragment = new RecipeListFragment();
        //go to listener
        listener.initView(fragment);
    }

    public static boolean isGoToBack() {
        return goToBack;
    }
}