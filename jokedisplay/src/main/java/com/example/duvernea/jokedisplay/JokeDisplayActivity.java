package com.example.duvernea.jokedisplay;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class JokeDisplayActivity extends AppCompatActivity {
    private static final String TAG = JokeDisplayActivity.class.getSimpleName();

    public static final String JOKE_EXTRA = "joke_extra";

    private TextView mJokeTextView;
    private String mJokeString;
    private Context mContext;

    private static final String JOKE_STRING_KEY = "joke_string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        mContext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mJokeTextView = (TextView) findViewById(R.id.joke_textview);

        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            mJokeString = extras.getString(JOKE_EXTRA);
            Log.d(TAG, "From Intent extra: " + mJokeString);
            mJokeTextView.setText(mJokeString);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();

            }
        });
        if (savedInstanceState != null) {
            mJokeString = savedInstanceState.getString(JOKE_STRING_KEY);
            Log.d(TAG, "From savedInstanceState bundle: " + mJokeString);
            mJokeTextView.setText(mJokeString);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(JOKE_STRING_KEY, mJokeString);
    }
}
