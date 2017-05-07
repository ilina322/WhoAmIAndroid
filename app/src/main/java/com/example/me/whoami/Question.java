package com.example.me.whoami;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    private String text;
    private List<Answer> answers;
    private String videoPath;

    public Question(String text, int videoRes , Answer...answers) {
        this.text = text;
        this.videoPath = "android.resource://" + App.getContext().getPackageName() + "/" + videoRes;
        this.answers = Arrays.asList(answers);
    }

    public String getVideoPath() {
        return videoPath;
    }

    public String getText() {
        return text;
    }
}
