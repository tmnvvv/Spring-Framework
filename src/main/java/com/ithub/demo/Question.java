package com.ithub.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class Question {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private int id;
    private String question;
    private String[] answers;
    private String answer;


    public Question(String question, String[] answers, String answer) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.question = question;
        this.answers = answers;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
