package com.example.me.whoami;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import java.util.TimerTask;

import static android.view.View.GONE;

public class LevelActivity extends AppCompatActivity {

    private static final String TAG = "LevelActivity";
    public static final String EXTRA_LEVEL_INDEX = "level_index";
    private Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        int levelIndex = getIntent().getIntExtra(EXTRA_LEVEL_INDEX, 0);
        this.question = QuestionResolver.getQuestionAt(levelIndex);
        final ViewGroup grpQuestion = (ViewGroup) findViewById(R.id.grp_question);
        grpQuestion.setVisibility(GONE);
        final VideoView view = (VideoView) findViewById(R.id.video_view);
        view.setVideoURI(Uri.parse(question.getVideoPath()));
        view.start();

        Log.e(TAG, "duration video:" + view.getDuration());

        view.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                view.setVisibility(GONE);
                grpQuestion.setVisibility(View.VISIBLE);
            }
        });
    }
}
