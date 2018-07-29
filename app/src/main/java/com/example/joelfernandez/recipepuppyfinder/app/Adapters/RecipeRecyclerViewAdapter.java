package com.example.joelfernandez.recipepuppyfinder.app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joelfernandez.recipepuppyfinder.R;
import com.example.joelfernandez.recipepuppyfinder.app.Interfaces.MainInterfaces;
import com.example.joelfernandez.recipepuppyfinder.app.Models.Recipe;
import com.example.joelfernandez.recipepuppyfinder.app.Utils.Constants;
import com.example.joelfernandez.recipepuppyfinder.app.Utils.Utils;
import com.example.joelfernandez.recipepuppyfinder.app.Viewholders.RecipeSectionViewHolder;

import java.util.ArrayList;

/**
 * Created by Joel Fernandez on 27/07/2018.
 */

public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeSectionViewHolder> {

    /**
     * Context
     */
    private Context context;

    /**
     * Item recycler list
     */
    private ArrayList<Recipe> itemList;


    public RecipeRecyclerViewAdapter(Context context, ArrayList<Recipe> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public RecipeSectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_section, parent, false);
        return new RecipeSectionViewHolder(view);
    }

    /**
     * Method to print ingredients list
     * @param recipe
     * @param holder
     */
    private void printIngredients(Recipe recipe,RecipeSectionViewHolder holder){
        boolean ingredientsVisible = recipe.isIngredientsVisibles();
        int visibility;
        if(ingredientsVisible) {
            holder.ingredientRecyclerView.setHasFixedSize(true);
            holder.ingredientRecyclerView.setNestedScrollingEnabled(false);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            holder.ingredientRecyclerView.setLayoutManager(linearLayoutManager);
            DetailRecipeRecyclerViewAdapter adapter = new DetailRecipeRecyclerViewAdapter(context, recipe.getIngredientsAsArray());
            holder.ingredientRecyclerView.setAdapter(adapter);
            visibility = View.VISIBLE;
        } else {
            visibility = View.GONE;
        }
        holder.ingredientRecyclerView.setVisibility(visibility);
    }

    @Override
    public void onBindViewHolder(RecipeSectionViewHolder holder, int position) {
        final Recipe sectionModel = itemList.get(position);
        Utils.setTypefaceView(context,holder.sectionName, Constants.ALEGREYASANS_MEDIUM_TYPEFACE);

        int ingredientsVisibility = sectionModel.isIngredientsVisibles() ? View.VISIBLE : View.GONE;
        holder.ingredientRecyclerView.setVisibility(ingredientsVisibility);

        int linkVisibility = sectionModel.getHref()!=Constants.EMPTY_STRING ? View.VISIBLE : View.GONE;
        holder.linkWeb.setVisibility(linkVisibility);

        holder.populate(sectionModel,context);
        printIngredients(sectionModel,holder);

        holder.textContainer.setOnClickListener(view -> {
            sectionModel.toogleIngredientsVisibility();
            printIngredients(sectionModel,holder);
        });

        holder.linkWeb.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(sectionModel.getHref()));
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
