package com.mohaalak.quiz.models;

/**
 * Created by alibilly on 12/2/16.
 */

public class Question {

    boolean answer ;
    String text;

    public Question(String t, boolean ans) {
        text = t;
        answer = ans;
    }

    public String getText() {
        return text;
    }
    public boolean getAnswer() {
        return answer;
    }

}
