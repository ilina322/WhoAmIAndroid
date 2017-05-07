package com.example.me.whoami;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    private static int ANIMATION_PERIOD = 1;
    private int RESTART_SECONDS = 5;
    private TextView txtRestarting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        txtRestarting = (TextView) findViewById(R.id.txt_restarting_in);

        countSeconds(ANIMATION_PERIOD);
    }

    private void countSeconds(final int periodInSeconds) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(RESTART_SECONDS == 0) {
                    restartApp();
                } else {
                    txtRestarting.setText(getString(R.string.restarting_in, RESTART_SECONDS));
                    RESTART_SECONDS--;
                    countSeconds(periodInSeconds);
                }
            }
        }, periodInSeconds * 1000);
    }

    private void restartApp() {
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }
}
