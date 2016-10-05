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
        textScriptView.setText("ccc");
        textScriptView.setSubScriptText("ccc sub");
        textScriptView.setSuperScriptText("ccc sup");

        textScriptView.setTextColor(R.color.Navy);
        textScriptView.setSubScriptTextColor(R.color.Red);
        textScriptView.setSuperScriptTextColor(R.color.SpringGreen);

        textScriptView.getTextView().setTypeface(FontCache.get(FontCache.FONT_GOTCHAGOTHIC_LIGHT, this));
        textScriptView.getSuperscriptTextView().setTypeface(FontCache.get(FontCache.FONT_GOTCHAGOTHIC_LIGHT, this));
        textScriptView.getSubscriptTextView().setTypeface(FontCache.get(FontCache.FONT_GOTCHAGOTHIC_LIGHT, this));


        textScriptView2 = (TextScriptView) findViewById(R.id.textScriptView2);
        textScriptView2.setText("DDD");
        textScriptView2.setSubScriptText("DDD Sub");
        textScriptView2.setSuperScriptText("DDD Sup");

        textScriptView2.setTextColor(R.color.ForestGreen);
        textScriptView2.setSubScriptTextColor(R.color.Turquoise);
        textScriptView2.setSuperScriptTextColor(R.color.DimGray);


    }
}
