package com.example.joelfernandez.recipepuppyfinder.app.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joelfernandez.recipepuppyfinder.R;
import com.example.joelfernandez.recipepuppyfinder.app.Controllers.DataController;
import com.example.joelfernandez.recipepuppyfinder.app.Controllers.NavigationController;
import com.example.joelfernandez.recipepuppyfinder.app.Fragments.MainFragment;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    /**
     * Actual Fragment
     */
    protected MainFragment fragment;

    /**
     * Header Button
     */
    protected ImageView headerButton;

    /**
     * Header Text
     */
    protected TextView headerText;

    /**
     * Navigation controller
     */
    protected NavigationController controller;

    /**
     * Data controller
     */
    protected DataController dataController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //set content

        setContentView(R.layout.activity_main);
        //init views
        initViews();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (NavigationController.isGoToBack()) {
            //set animation
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
        } else {
            //set animation
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * Method to get all views
     */
    protected void initViews(){

        headerText = (TextView) findViewById(R.id.header_text);
        headerButton = (ImageView) findViewById(R.id.back_image);
    }

    /**
     * Method to change fragment
     * @param fragment
     */
    public void changeFragment (MainFragment fragment, boolean pressBack){

        //get fragments manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        if(this.fragment!=null){
            //remove fragment
            fragmentManager.beginTransaction().remove(this.fragment).commit();
        }
        //save fragment
        this.fragment = fragment;
        //if fragment not null
        if (fragment != null) {
            //add transaction
            if(pressBack) {
                //set fragment
                fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_right).replace(R.id.fragment_container, fragment).commit();
            }else{
                fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left).replace(R.id.fragment_container, fragment).commit();
            }
        }
    }

    @Override
    public void onBackPressed() {
        //check fragment
        if(fragment!=null){
            fragment.onBackPressed();
        }else{
            super.onBackPressed();
        }
    }

    /**
     * Method to set section tittle
     */
    public void setTitle(String text){
        headerText.setVisibility(View.VISIBLE);
        //set text
        headerText.setText(text);
    }
}