package com.example.joelfernandez.recipepuppyfinder.app.Activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ProgressBar;

import com.example.joelfernandez.recipepuppyfinder.R;
import com.example.joelfernandez.recipepuppyfinder.app.Controllers.DataController;
import com.example.joelfernandez.recipepuppyfinder.app.Controllers.NavigationController;
import com.example.joelfernandez.recipepuppyfinder.app.Fragments.MainFragment;
import com.example.joelfernandez.recipepuppyfinder.app.Interfaces.MainInterfaces;

/**
 * Created by Joel Fernandez on 27/07/2018.
 */

public class RecipeActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set content
        setContentView(R.layout.recipe_activity);
        //get views
        initViews();
        //create controllers
        controller = new NavigationController();
        dataController = new DataController();
        //initNavigation
        initNavigation();
    }
    @Override
    protected void initViews(){
        super.initViews();
    }

    @Override
    public void setTitle(String text) {
        //set color
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // only for gingerbread and newer versions
            headerText.setTextColor(getResources().getColor(R.color.white));
        }else {
            headerText.setTextColor(ContextCompat.getColor(this, R.color.white));
        }
        super.setTitle(text);
    }

    private void initNavigation(){
        controller.initNavigation(fragment -> {
            //change fragment
            changeFragment(fragment,false);
        });
    }
}
