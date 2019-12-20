package com.example.user.grage_bisha;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Image_Ve extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image__ve);

        String b = getIntent().getStringExtra("image_v");//image

       ImageView image1s =(ImageView)findViewById(R.id.imageView2);
        Glide.with(Image_Ve.this)
                .load(b)
             //   .centerCrop()

                .into(image1s);


    }
}
