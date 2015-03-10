package com.sohilladhani.androidtaptest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sohilladhani.utils.StopWatch;


public class MainActivity extends Activity {

    private Button tapButton;
    private Button resetButton;
    private int count = 1;
    private long elapsedTime = 0;
    private StopWatch stopWatch = new StopWatch();
    private TextView scoreText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tapButton = (Button) findViewById(R.id.tapBtn);
        resetButton = (Button) findViewById(R.id.resetBtn);
        scoreText = (TextView) findViewById(R.id.scoreText);

        tapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 1 && tapButton.isEnabled()) {
                    stopWatch.start();
                    count++;
                } else if (count >= 2 && count <= 9 && tapButton.isEnabled()) {
                    count++;
                } else {
                    elapsedTime = stopWatch.getElapsedTime();
                    stopWatch.stop();
                    stopWatch.reset();
                    tapButton.setEnabled(false);
                    if (!tapButton.isEnabled()) {
                        tapButton.setBackgroundColor(getResources().getColor(R.color.fbutton_color_asbestos));
                        tapButton.setClickable(false);
                        tapButton.setPressed(true);
                        tapButton.setText("WELL DONE!");
                    }
                    scoreText.setText("Your Score: " + Long.toString(elapsedTime) + " milliseconds (lesser the better)");
                    resetButton.setVisibility(View.VISIBLE);
                }

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toastIt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
