package com.mohaalak.quiz.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mohaalak.quiz.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    SharedPreferences quiz_pref;

    TextView highscore_tv;
    Button play_btn;
    EditText name_et;

    int highscore  = 0;
    String name = "";

    View.OnClickListener onclick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            name = name_et.getText().toString();

            SharedPreferences.Editor editor = quiz_pref.edit();
            editor.putString(getString(R.string.namePref), name);
            editor.apply();

            Intent intent = new Intent(getApplicationContext(), QuizActiviy.class);
            startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        highscore_tv = (TextView) findViewById(R.id.activity_main_tv_highscore);
        play_btn = (Button) findViewById(R.id.activity_main_btn_play);
        name_et = (EditText) findViewById(R.id.activity_main_et_name);

        quiz_pref = getSharedPreferences("sharepref", MODE_PRIVATE);


        play_btn.setOnClickListener(onclick);
    }



    @Override
    protected void onResume() {
        super.onResume();

        highscore = quiz_pref.getInt(getString(R.string.highscorePref), 0);
        name = quiz_pref.getString(getString(R.string.namePref), "");

        name_et.setText(name);
        highscore_tv.setText(getString(R.string.highscore) + " : " + highscore);
    }


}
