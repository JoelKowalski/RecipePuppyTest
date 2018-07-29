package com.example.joelfernandez.recipepuppyfinder.app.Fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.joelfernandez.recipepuppyfinder.R;
import com.example.joelfernandez.recipepuppyfinder.app.Activities.RecipeActivity;
import com.example.joelfernandez.recipepuppyfinder.app.Adapters.RecipeRecyclerViewAdapter;
import com.example.joelfernandez.recipepuppyfinder.app.Controllers.DataController;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by Joel Fernandez on 27/07/2018.
 */

public class RecipeListFragment extends MainFragment {

    /**
     * header back image
     */
    private ImageView backButton;

    /**
     * Header tittle
     */
    private TextView headerTittle;

    /**
     * Search EditText
     */
    private EditText search;

    /**
     * RecyclerView adapter
     */
    private RecyclerView recyclerView;

    /**
     * Adapter
     */
    private RecipeRecyclerViewAdapter adapter;

    /**
     * Loading progress bar
     */
    private ProgressBar loading;

    /**
     * DataController
     */
    private DataController dataController;

    /**
     * Realitive no data Container layout
     */
    private RelativeLayout noDataContainer;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //get content view
        View view = inflater.inflate(R.layout.recipe_fragment, container, false);

        dataController = new DataController();

        initView(view);

        getInfo();

        setListeners();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void getInfo() {
        setUpRecyclerView();
    }
    public void setListeners() {
        backButton.setOnClickListener(v -> onBackPressed());

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()>0){
                    callAdapter(editable.toString());
                    noDataContainer.setVisibility(GONE);
                    recyclerView.setVisibility(VISIBLE);
                }else{
                    noDataContainer.setVisibility(VISIBLE);
                    recyclerView.setVisibility(GONE);
                }
            }
        });
    }

    /**
     * Method to do an action when the user push back buttom
     */
    public void onBackPressed() {
        getActivity().finish();
    }

    protected void initView(View view) {
        loading = (ProgressBar) view.findViewById(R.id.loading);
        headerTittle = (TextView) view.findViewById(R.id.header_text);
        backButton = (ImageView) view.findViewById(R.id.back_image);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        search=(EditText)view.findViewById(R.id.input_et);

        noDataContainer=(RelativeLayout)view.findViewById(R.id.no_data_container);
        ((RecipeActivity)getActivity()).setTitle(getResources().getString(R.string.headertext));
    }

    /**
     * Method to init Linear layout manager
     */
    private void setUpRecyclerView() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void callAdapter(String request){
        loading.setVisibility(VISIBLE);
        dataController.getRecipes(getContext(),request, response -> {
            loading.setVisibility(GONE);
            adapter = new RecipeRecyclerViewAdapter(getContext(), response.getData());
            //add adapter to list
            recyclerView.setAdapter(adapter);
        });
    }
}