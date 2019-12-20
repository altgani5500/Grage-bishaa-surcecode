package com.example.user.grage_bisha;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by kamran on 6/28/15.
 */
public class MyTextView2 extends android.support.v7.widget.AppCompatTextView {

    public MyTextView2(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }






    public MyTextView2(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public MyTextView2(Context context) {
        super(context);

    }



    
    private void init(AttributeSet attrs)
    {
        if (attrs!=null)
        {
            // TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomeFont);

            String fontName = "algzerabold.ttf";
            // if (Locale.getDefault().getDisplayLanguage().toString().equals("English"))
            //  //   fontName = a.getString(R.styleable.CustomeFont_DroidSansArabic);
            // else
            // fontName = a.getString(R.styleable.CustomeFont_DroidSansArabic);



            if (fontName!=null)
            {
                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(),fontName);
                setTypeface(myTypeface);
            }
            // a.recycle();
        }
    }

}