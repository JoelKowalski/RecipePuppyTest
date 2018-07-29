package com.example.joelfernandez.recipepuppyfinder.app.Utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by Joel Fernandez on 27/07/2018.
 */

public class Utils {

    /**
     * Method to put any font in textView
     * @param context
     * @param view
     * @param font
     */
    public static void setTypefaceView(Context context, TextView view, String font) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), font);
        view.setTypeface(typeface);
    }
}
