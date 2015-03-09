package com.sohilladhani.androidtaptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * This class is used to display splash screen right before main activity loads
 */
public class SplashScreen extends Activity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // and then MainActivity will be called.
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();

                // transition from splash to main activity
                overridePendingTransition(R.anim.activityfadein,R.anim.splashfadeout);


            }
        }, SPLASH_TIME_OUT);
    }

}
