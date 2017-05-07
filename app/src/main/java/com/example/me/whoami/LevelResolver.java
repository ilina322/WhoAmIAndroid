package com.example.me.whoami;


import java.util.ArrayList;
import java.util.List;

public class LevelResolver {
    private static List<Level> levels = new ArrayList<>();

    static {
        List<Question> level1Questions = new ArrayList<>();
        level1Questions.add(new Question("Why do I see blurry?",
                new Answer("Because I hit my head", false),
                new Answer("Because I usually wear glasses", true),
                new Answer("Because I am drunk", false),
                new Answer("placeholder", false)));
        level1Questions.add(new Question("How many are the tulips?",
                new Answer("9", true),
                new Answer("8", false),
                new Answer("6", false),
                new Answer("placeholder", false)));
        levels.add(new Level(R.raw.openingeyes, level1Questions));

        List<Question> level2Questions = new ArrayList<>();
        level2Questions.add(new Question("222222Why do I see blurry?",
                new Answer("Because I hit my head", false),
                new Answer("Because I usually wear glasses", true),
                new Answer("Because I am drunk", false),
                new Answer("placeholder", false)));
        level2Questions.add(new Question("222222How many are the tulips?",
                new Answer("9", true),
                new Answer("8", false),
                new Answer("6", false),
                new Answer("placeholder", false)));
        levels.add(new Level(R.raw.openingeyes, level2Questions));
    }

    public static Level getLevelAt(int index) {
        return levels.get(index);
    }
}
