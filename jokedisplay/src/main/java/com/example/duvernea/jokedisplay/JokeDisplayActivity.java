package com.example.duvernea.jokedisplay;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {
    private static final String TAG = JokeDisplayActivity.class.getSimpleName();

    public static final String JOKE_SETUP = "joke_setup";
    public static final String JOKE_PUNCHLINE = "joke_punchline";

    private TextView mJokeSetupTextView;
    private TextView mJokePunchlineTextView;
    private String mJokeSetupString;
    private String mJokePunchlineString;
    private Context mContext;

    private Button mButton;

    private boolean mPunchlineRevealed = false;

    private static final String JOKE_STRING_SETUP_KEY = "joke_string_setup";
    private static final String JOKE_STRING_PUNCHLINE_KEY = "joke_string_punchline";
    private static final String PUNCHLINE_REVEALED_KEY = "punchline_revealed";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        mContext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mJokeSetupTextView = (TextView) findViewById(R.id.joke_setup_textview);
        mJokePunchlineTextView = (TextView) findViewById(R.id.joke_punchline_textview);
        mJokePunchlineTextView.setVisibility(View.GONE);
        mButton = (Button) findViewById(R.id.button);
        mButton.setText(getResources().getString(R.string.button_get_joke_punchline));

        setSupportActionBar(toolbar);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            mJokeSetupString = extras.getString(JOKE_SETUP);
            mJokeSetupTextView.setText(mJokeSetupString);

            mJokePunchlineString = extras.getString(JOKE_PUNCHLINE);
            mJokePunchlineTextView.setText(mJokePunchlineString);
        }
        if (savedInstanceState != null) {
            mJokeSetupString = savedInstanceState.getString(JOKE_STRING_SETUP_KEY);
            mJokeSetupTextView.setText(mJokeSetupString);
            mJokePunchlineString = savedInstanceState.getString(JOKE_STRING_PUNCHLINE_KEY);
            mJokePunchlineTextView.setText(mJokePunchlineString);

            mPunchlineRevealed = savedInstanceState.getBoolean(PUNCHLINE_REVEALED_KEY);
            if (mPunchlineRevealed) {
                mJokePunchlineTextView.setVisibility(View.VISIBLE);
                mButton.setText(getResources().getString(R.string.get_joke_button_text));
            }

        }
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mJokePunchlineTextView.setVisibility(View.VISIBLE);
                mButton.setText(getResources().getString(R.string.get_joke_button_text));
                mPunchlineRevealed = true;
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(JOKE_STRING_SETUP_KEY, mJokeSetupString);
        outState.putString(JOKE_STRING_PUNCHLINE_KEY, mJokePunchlineString);
        outState.putBoolean(PUNCHLINE_REVEALED_KEY, mPunchlineRevealed);

    }
}
