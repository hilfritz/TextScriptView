# TextScriptView

A view that implements a textview with subscript and superscript support.
![alt tag](https://github.com/hilfritz/TextScriptView/blob/master/screenshot.png)


Attributes

 * normalText = the main text
 * subText = the subscript text
 * superText = the superscript text
 * normalTextColor = resource for the color of normal text
 * subTextColor  = resource for the color of subscript text
 * superTextColor  = resource for the color of superscript text
 * normalTextSize = resource for the color of normal size
 * subTextSize  = resource for the color of subscript size
 * superTextSize  = resource for the color of superscript size
 * normalBetweenScriptMargin = the horizontal distance between the superscript/subscript to the main text
 * moveSuperUp = moves the superscript up (this is a dimension resource )
 * moveSubDown = moves the subscript up (this is a dimension resource )
 *

Public Methods

 * getTextView() = returns the textView for the main text
 * getSubscriptTextView() = returns the textview for the subscript text
 * getSuperscriptTextView() = returns the textview for the superscript text

Sample usage!

```xml

<com.hilfritz.library.textscriptview.TextScriptView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:normalText="Bicarbonate - HC"
        app:subText="3"
        app:normalTextColor="@color/Black"
        app:subTextColor="@color/Black"
        android:layout_marginTop="@dimen/margin_d"
        app:normalBetweenScriptMargin="1dp"
        />

```

Adding font/typeface:

```java

	textScriptView = (TextScriptView) findViewById(R.id.textScriptView);
    textScriptView.setText("E = MC");
    textScriptView.setSuperScriptText("2");
    textScriptView.setTextColor(R.color.Navy);
    textScriptView.setSubScriptTextColor(R.color.Red);
    textScriptView.setSuperScriptTextColor(R.color.Black);
 //ADDING THE TYPEFACE
 textScriptView.getTextView().setTypeface(FontCache.get(FontCache.FONT_GOTCHAGOTHIC_LIGHT, this));        textScriptView.getSuperscriptTextView().setTypeface(FontCache.get(FontCache.FONT_GOTCHAGOTHIC_LIGHT, this));
 textScriptView.getSubscriptTextView().setTypeface(FontCache.get(FontCache.FONT_GOTCHAGOTHIC_LIGHT, this));


```
