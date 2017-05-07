package com.example.me.whoami;


import java.util.ArrayList;
import java.util.List;

public class QuestionResolver {
    private static List<Question> questions = new ArrayList<>();

    static {
        questions.add(new Question("Why do I see blurry?", R.raw.openingeyes,
                new Answer("Because I hit my head", false),
                new Answer("Because I usually wear glasses", true),
                new Answer("Because I am drunk", false),
                new Answer("placeholder", false)));
        questions.add(new Question("How many are the tulips?", R.raw.openingeyes,
                new Answer("9", true),
                new Answer("8", false),
                new Answer("6", false),
                new Answer("placeholder", false)));
    }

    public static Question getQuestionAt(int index){
        return questions.get(index);
    }
}
