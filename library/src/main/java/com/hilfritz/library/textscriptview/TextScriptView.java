package com.hilfritz.library.textscriptview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DimenRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by hilfritz on 3/10/16.
 * http://trickyandroid.com/protip-inflating-layout-for-your-custom-view/
 */
public class TextScriptView extends RelativeLayout {

    //THE ATTRIBUTES
    int normalTextColor;
    int superTextColor;
    float superTextSize ;
    float subTextSize;
    float normalTextSize;
    int subTextColor;
    int showScript;
    float normalBetweenScriptMargin = 0;
    String normalText;
    String superText;
    String subText;

    //THE VIEWS
    TextView normalTextView;
    TextView subscriptTextView;
    TextView superscriptTextView;




    public TextScriptView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TextScriptView,
                0, 0);


        try {
            normalTextSize = a.getDimension(R.styleable.TextScriptView_normalTextSize, getResources().getDimension(R.dimen.normal_text_size));
            superTextSize = a.getDimension(R.styleable.TextScriptView_superTextSize, getResources().getDimension(R.dimen.super_text_size));
            subTextSize = a.getDimension(R.styleable.TextScriptView_subTextSize, getResources().getDimension(R.dimen.sub_text_size));

            normalTextColor = a.getColor(R.styleable.TextScriptView_normalTextColor, ContextCompat.getColor(getContext(), R.color.Black));
            superTextColor = a.getColor(R.styleable.TextScriptView_superTextColor, ContextCompat.getColor(getContext(), R.color.Black));
            subTextColor = a.getColor(R.styleable.TextScriptView_subTextColor, ContextCompat.getColor(getContext(), R.color.Black));

            normalText = a.getString(R.styleable.TextScriptView_normalText);
            superText =  a.getString(R.styleable.TextScriptView_superText);
            subText =  a.getString(R.styleable.TextScriptView_subText);


            //showScript = a.getInteger(R.styleable.TextScriptView_showScript, 0);

            normalBetweenScriptMargin = a.getDimension(R.styleable.TextScriptView_normalBetweenScriptMargin, getResources().getDimension(R.dimen.margin_aa));


        } finally {
            a.recycle();
        }

        init();

    }


    public TextScriptView(Context context) {
        super(context);
        init();
    }

    public TextScriptView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        //INITIALIZE THE VIEWS
        inflate(getContext(), R.layout.layout_text_script, this);
        normalTextView = (TextView) findViewById(R.id.normalTextView);
        subscriptTextView = (TextView) findViewById(R.id.subscriptTextView);
        superscriptTextView = (TextView) findViewById(R.id.superscriptTextView);

        //INITIALIZE THE TEXT COLORS
        setTextColor(R.color.Black);
        setSubScriptTextColor(R.color.Black);
        setSuperScriptTextColor(R.color.Black);

        //ADD THE STYLES
        normalTextView.setTextColor(normalTextColor);
        subscriptTextView.setTextColor(subTextColor);
        superscriptTextView.setTextColor(superTextColor);


        //
        normalTextView.setText("");
        subscriptTextView.setText("");
        superscriptTextView.setText("");


        //ADD THE TEXT SIZE
        addTextSize(normalTextView, normalTextSize);
        addTextSize(subscriptTextView, subTextSize);
        addTextSize(superscriptTextView, superTextSize);

        //ADD THE TEXT
        addText(normalTextView, normalText);
        addText(superscriptTextView, superText);
        addText(subscriptTextView, subText);

        //ADD THE SPACE MARGIN



        RelativeLayout.LayoutParams layoutParams = (LayoutParams) normalTextView.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, Math.round(normalBetweenScriptMargin), layoutParams.bottomMargin);
        normalTextView.requestLayout();


    }

    private void addTextSize(TextView textView, float textSize) {
        if (textSize!=0){
            textView.setTextSize(textSize);
        }
    }

    public void addText(TextView textView, String text){
        if (TextUtils.isEmpty(text)){
            //textView.setVisibility(GONE);
            textView.setText("");
        }else{
            textView.setVisibility(VISIBLE);
            textView.setText(text);
        }
    }

    public void setText(String str){
        normalTextView.setText(str);
    }
    public void setSuperScriptText(String str){
        superscriptTextView.setText(str);
    }
    public void setSubScriptText(String str){
        subscriptTextView.setText(str);
    }
    public void setTextColor(int textColor){
        normalTextView.setTextColor(ContextCompat.getColor(getContext(), textColor));
    }
    public void setSuperScriptTextColor(int textColor){
        superscriptTextView.setTextColor(ContextCompat.getColor(getContext(), textColor));
    }
    public void setSubScriptTextColor(int textColor){
        subscriptTextView.setTextColor(ContextCompat.getColor(getContext(), textColor));
    }

    /**
     *
     * @param dimen int - the id of the resource like R.dimen.myDimen
     */
    public void setSpaceInBetween(@DimenRes int dimen){
            RelativeLayout.LayoutParams layoutParams = (LayoutParams) normalTextView.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, Math.round(getResources().getDimension(dimen)), layoutParams.bottomMargin);

    }

    /**
     *
     * @param dimen float - this is the value from getResources().getDimen(R.dimen.myDimen)
     */
    public void setSpaceInBetween(float dimen){
            RelativeLayout.LayoutParams layoutParams = (LayoutParams) normalTextView.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, Math.round(dimen), layoutParams.bottomMargin);
    }
}
