package com.hilfritz.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import java.util.Hashtable;

/**
 * Created by hilfritz
 */

public class FontCache {
    public static final String FONT_3DHANDDRAWNS =   "3DHandDrawns.ttf";
    public static final String FONT_GOTCHAGOTHIC_LIGHT =   "GotchaGothicLight.ttf";
    public static final String FONT_MARKINSON =   "Markinson.otf";

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