package com.example.joelfernandez.recipepuppyfinder.app.Viewholders;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.joelfernandez.recipepuppyfinder.R;
import com.example.joelfernandez.recipepuppyfinder.app.Models.Recipe;

/**
 * Created by Joel Fernandez on 29/07/2018.
 */

public class DetailRecipeSectionViewHolder extends RecyclerView.ViewHolder{

    /**
     * Item section name
     */
    public TextView sectionName;

    public DetailRecipeSectionViewHolder(View itemView) {
        super(itemView);
        sectionName = (TextView) itemView.findViewById(R.id.item_name);
    }
    public void populate(String item){
        sectionName.setText(Html.fromHtml(item));
    }
}

