package com.example.panagiotis.m_events;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;


public class CustomTextView extends TextView {

    public CustomTextView(Context context) {
        super(context);
        init();
    }


    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        //setBackgroundColor(Color.BLUE);
        setTextColor(Color.rgb(51,153,255));
    }

}
