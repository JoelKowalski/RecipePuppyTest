package com.example.joelfernandez.recipepuppyfinder.app.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joelfernandez.recipepuppyfinder.R;
import com.example.joelfernandez.recipepuppyfinder.app.Utils.Constants;
import com.example.joelfernandez.recipepuppyfinder.app.Utils.Utils;
import com.example.joelfernandez.recipepuppyfinder.app.Viewholders.DetailRecipeSectionViewHolder;

/**
 * Created by Joel Fernandez on 28/07/2018.
 */

public class DetailRecipeRecyclerViewAdapter extends  RecyclerView.Adapter<DetailRecipeSectionViewHolder>{

    /**
     * Context
     */
    private Context context;

    /**
     * Ingredients list
     */
    private String[] itemList;

    public DetailRecipeRecyclerViewAdapter(Context context,String[]itemList){
        this.context=context;
        this.itemList=itemList;
    }

    @Override
    public DetailRecipeSectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_section, parent, false);
        return new DetailRecipeSectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailRecipeSectionViewHolder holder, int position) {
        final String sectionModel = itemList[position];
        Utils.setTypefaceView(context,holder.sectionName, Constants.ALEGREYASANS_MEDIUM_TYPEFACE);
        holder.populate(sectionModel);
    }

    @Override
    public int getItemCount() {
        return itemList.length;
    }
}
