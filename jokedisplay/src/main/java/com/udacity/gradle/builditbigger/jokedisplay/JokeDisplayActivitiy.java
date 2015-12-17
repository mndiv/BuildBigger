package com.udacity.gradle.builditbigger.jokedisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayActivitiy extends AppCompatActivity {

    public static final String JOKE_KEY = "com.udacity.gradle.builtitbigger.jokedisplay.msg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        Intent intent = getIntent();
        String jokeText = intent.getStringExtra(JOKE_KEY);

        TextView tv = (TextView) findViewById(R.id.jokeText);
        tv.setText(jokeText);

    }
}
