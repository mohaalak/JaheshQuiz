package com.mohaalak.quiz.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mohaalak.quiz.R;
import com.mohaalak.quiz.models.Question;

public class QuizActiviy extends AppCompatActivity {

    Question[] questions = {
            new Question("Android is better than UX/UI", true),
            new Question("Erfan is a developer", true),
            new Question("Today is sunday", false)
    };

    int question_index = 0 ;
    int score = 0;

    TextView tv_question;
    TextView tv_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tv_question =(TextView)findViewById(R.id.activity_quiz_tv_question);
        tv_score =(TextView)findViewById(R.id.activity_quiz_tv_score);
        show();
    }

    private void show() {
        tv_score.setText(getString(R.string.score)+" : "+score);
        tv_question.setText(questions[question_index].getText());

    }
    private void next() {
        if(question_index +1 < questions.length) {
            question_index+=1;
            show();
        }else {
            Toast.makeText(this, "QUIZ FINISHED", Toast.LENGTH_SHORT).show();
        }
    }

    public void correct(View view) {
        if (questions[question_index].getAnswer() == true) {
            score += 1;
        }else {
            score -= 1;
        }
        next();
    }

    public void incorrect(View view) {
        if (questions[question_index].getAnswer() == false) {
            score += 1;
        }else {
            score -= 1;
        }
        next();
    }

}
