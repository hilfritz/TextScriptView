package com.hilfritz.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import java.util.Hashtable;

/**
 * Created by hilfritz
 */

public class FontCache {
    public static final String FONT_OPENSANS_LIGHT =   "OpenSans-Light.ttf";
    public static final String FONT_OPENSANS_REGULAR =   "OpenSans-Regular.ttf";
    public static final String FONT_LATO_LIGHT =   "Lato-Light.ttf";
    public static final String FONT_LATO_REGULAR =   "Lato-Regular.ttf";
    public static final String FONT_RALEWAY_LIGHT =   "Raleway-Light.ttf";
    public static final String FONT_RALEWAY_REGULAR =   "Raleway-Regular.ttf";

    private static String getPath(String str){
        return str;
    }

    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();

    public static Typeface get(String name, Context context) {
        Typeface tf = fontCache.get(name);
        if(tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), getPath(name));
            }catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }

    public static void applyTypeFace(Context context, TextView tv, String name){
        tv.setTypeface(FontCache.get(name,context));
    }
}