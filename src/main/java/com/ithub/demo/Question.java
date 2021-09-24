package com.ithub.demo;

import java.util.Arrays;

public class Question extends AbstractQuestion{
    private static int c = 0;
    private final String question;
    private final String[] answers;
    private final String[] options;
    private final int ID;

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", options=" + Arrays.toString(options) +
                '}';
    }
    public static int initID(){
        return c++;
    }

    public int getID() {
        return ID;
    }
    public Question(String question, String[] options, String[] answers) {

        this.question = question;
        this.options = options;
        this.answers = answers;
        this.ID = initID();
    }
    @Override
    public String getQuestion() {
        return question;
    }
    @Override
    public String[] getAnswers() {
        return answers;
    }
    @Override
    public String[] getOptions() {
        return options;
    }

}
