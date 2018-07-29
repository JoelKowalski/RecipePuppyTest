package com.example.joelfernandez.recipepuppyfinder.app.Viewholders;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.joelfernandez.recipepuppyfinder.R;
import com.example.joelfernandez.recipepuppyfinder.app.Models.Recipe;
import com.example.joelfernandez.recipepuppyfinder.app.Utils.Constants;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Joel Fernandez on 27/07/2018.
 */

public class RecipeSectionViewHolder extends RecyclerView.ViewHolder{

    /**
     * Item section name
     */
    public TextView sectionName;

    /**
     *Item ReciclerView
     */
    public RecyclerView ingredientRecyclerView;

    /**
     *Click LinearLayout
     */
    public LinearLayout textContainer;

    /**
     *Image item
     */
    public CircleImageView imageItem;

    /**
     *Link recipeWeb
     */
    public ImageView linkWeb;

    public RecipeSectionViewHolder(View itemView) {
        super(itemView);
        sectionName = (TextView) itemView.findViewById(R.id.item_name);
        ingredientRecyclerView =(RecyclerView)itemView.findViewById(R.id.ingredients_recycler_view);
        textContainer=(LinearLayout)itemView.findViewById(R.id.text_container);
        imageItem=(CircleImageView)itemView.findViewById(R.id.circleView);
        linkWeb=(ImageView)itemView.findViewById(R.id.recipe_link);
    }
    public void populate(Recipe item, Context context){
        sectionName.setText(Html.fromHtml(item.getTittle()));
        if(!item.getThumbnail().equals(Constants.EMPTY_STRING))
            Glide.with(context).load(item.getThumbnail()).into(imageItem);
    }
}
