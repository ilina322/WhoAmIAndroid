package com.example.me.whoami;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    private String text;
    private List<Answer> answers;

    public Question(String text, Answer...answers) {
        this.text = text;
        this.answers = Arrays.asList(answers);
    }

    public Answer getAnswerAt(int index){
        return answers.get(index);
    }

    public String getText() {
        return text;
    }
}
