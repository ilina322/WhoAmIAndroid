package com.example.me.whoami;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class LevelActivity extends AppCompatActivity {

    private static final String TAG = "LevelActivity";
    public static final String EXTRA_LEVEL_INDEX = "level_index";

    private Level level;
    private int currentQuestionIndex = 0;
    private int levelIndex;

    //Views
    private ViewGroup grpQuestion;
    private VideoView videoView;
    private TextView txtQuestion;
    private List<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        levelIndex = getIntent().getIntExtra(EXTRA_LEVEL_INDEX, 0);
        this.level = LevelResolver.getLevelAt(levelIndex);
        initViews();
        initListeners();

        startVideo();
        setViews(currentQuestionIndex);
    }

    private void setViews(int questionIndex) {
        Question currentQuestion = level.getQuestions().get(questionIndex);
        txtQuestion.setText(currentQuestion.getText());
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setText(currentQuestion.getAnswerAt(i).getText());
        }
    }

    private void initListeners() {
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                onVideoEnd();
            }
        });
        for (final Button btn : buttons) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button clickedBtn = (Button) v;
                    int btnIndex = getBtnIndex(clickedBtn);
                    Question currentQuestion = level.getQuestions().get(currentQuestionIndex);
                    if (currentQuestion.getAnswerAt(btnIndex).isCorrect()) {
                        resolveAnswerCorrect();
                    } else {
                        startGameOver();
                    }
                }
            });
        }
    }

    private void startGameOver() {
        startActivity(new Intent(LevelActivity.this, GameOverActivity.class));
        finish();
    }

    private void resolveAnswerCorrect() {
        if (level.getQuestions().size() > currentQuestionIndex + 1) {
            currentQuestionIndex++;
            setViews(currentQuestionIndex);
        } else {
            startNextLevel();
        }
    }

    private void startNextLevel() {
        Intent intent = new Intent(this, LevelActivity.class);
        intent.putExtra(EXTRA_LEVEL_INDEX, levelIndex + 1);
        startActivity(intent);
        finish();
    }

    private int getBtnIndex(Button clickedBtn) {
        int index = 0;
        for (Button btn : buttons) {
            if (btn == clickedBtn) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private void onVideoEnd() {
        videoView.setVisibility(GONE);
        grpQuestion.setVisibility(View.VISIBLE);
    }

    private void startVideo() {
        grpQuestion.setVisibility(GONE);
        videoView.setVideoURI(Uri.parse(level.getVideoPath()));
        videoView.start();
    }

    private void initViews() {
        grpQuestion = (ViewGroup) findViewById(R.id.grp_question);
        txtQuestion = (TextView) findViewById(R.id.txt_question);
        videoView = (VideoView) findViewById(R.id.video_view);
        this.buttons = new ArrayList<>();
        buttons.add((Button) findViewById(R.id.btn_1));
        buttons.add((Button) findViewById(R.id.btn_2));
        buttons.add((Button) findViewById(R.id.btn_3));
        buttons.add((Button) findViewById(R.id.btn_4));
    }
}
