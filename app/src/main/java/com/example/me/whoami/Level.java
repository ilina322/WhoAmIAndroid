package com.example.me.whoami;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Me on 7.5.2017 г..
 */

public class Level {

    private String videoPath;
    private List<Question> questions;

    public Level(int videoRes, List<Question> questions) {
        this.videoPath = "android.resource://" + App.getContext().getPackageName() + "/" + videoRes;
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getVideoPath() {
        return videoPath;
    }
}
