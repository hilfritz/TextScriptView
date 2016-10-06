package com.hilfritz.textscriptview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hilfritz.library.textscriptview.TextScriptView;
import com.hilfritz.utils.FontCache;

public class MainActivity extends AppCompatActivity {
    TextScriptView textScriptView;
    TextScriptView textScriptView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textScriptView = (TextScriptView) findViewById(R.id.textScriptView);
        textScriptView.setText("E = MC");
        textScriptView.setSuperScriptText("2");

        textScriptView.setTextColor(R.color.Navy);
        textScriptView.setSubScriptTextColor(R.color.Red);
        textScriptView.setSuperScriptTextColor(R.color.Black);

        textScriptView.getTextView().setTypeface(FontCache.get(FontCache.FONT_RALEWAY_REGULAR, this));
        textScriptView.getSuperscriptTextView().setTypeface(FontCache.get(FontCache.FONT_LATO_REGULAR, this));
        textScriptView.getSubscriptTextView().setTypeface(FontCache.get(FontCache.FONT_OPENSANS_REGULAR, this));


        textScriptView2 = (TextScriptView) findViewById(R.id.textScriptView2);
        textScriptView2.setText("Registered Trademark");
        textScriptView2.setSuperScriptText("(R)");

        textScriptView2.setTextColor(R.color.ForestGreen);
        textScriptView2.setSubScriptTextColor(R.color.Turquoise);
        textScriptView2.setSuperScriptTextColor(R.color.DimGray);
        textScriptView2.getSuperscriptTextView().setTypeface(FontCache.get(FontCache.FONT_OPENSANS_REGULAR, this));
        textScriptView2.getTextView().setTypeface(FontCache.get(FontCache.FONT_OPENSANS_REGULAR, this));


    }
}
