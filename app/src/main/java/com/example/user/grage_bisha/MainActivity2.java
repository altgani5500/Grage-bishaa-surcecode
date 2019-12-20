package com.example.user.grage_bisha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity2 extends Activity {
    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        // buclick();

        new android.os.Handler().postDelayed(new Runnable()


                                             {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                                                 @Override
                                                 public void run () {

                                                     // This method will be executed once the timer is over
                                                     // Start your app main activity

                                                     Intent i = new Intent(MainActivity2.this,Home.class);
                                                     startActivity(i);
                                                   //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                                                     // close this activity
                                                     finish();


                                                 }
                                             }

                ,SPLASH_TIME_OUT);



    }

}

