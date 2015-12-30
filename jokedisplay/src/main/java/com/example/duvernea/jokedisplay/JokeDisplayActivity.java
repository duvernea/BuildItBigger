package com.example.duvernea.jokedisplay;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {
    private static final String TAG = JokeDisplayActivity.class.getSimpleName();

    public static final String JOKE_SETUP = "joke_setup";
    public static final String JOKE_PUNCHLINE = "joke_punchline";

    private static final int EXTRA_HEIGHT_ANIMATE = 30;

    private TextView mJokeSetupTextView;
    private TextView mJokePunchlineTextView;
    private String mJokeSetupString;
    private String mJokePunchlineString;
    private Context mContext;

    private Button mButton;

    private boolean mPunchlineRevealed = false;

    // Keys for saved instance state on rotate
    private static final String JOKE_STRING_SETUP_KEY = "joke_string_setup";
    private static final String JOKE_STRING_PUNCHLINE_KEY = "joke_string_punchline";
    private static final String PUNCHLINE_REVEALED_KEY = "punchline_revealed";
    private static final String PUNCHLINE_VIEW_HEIGHT_KEY = "punchline_view_height";

    private int mViewHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);


        mContext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mJokeSetupTextView = (TextView) findViewById(R.id.joke_setup_textview);
        mJokePunchlineTextView = (TextView) findViewById(R.id.joke_punchline_textview);

        ViewTreeObserver viewTreeObserver = mJokePunchlineTextView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    //mJokePunchlineTextView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    mViewHeight = mJokePunchlineTextView.getHeight();
                }
            });
        }

        int x = mJokePunchlineTextView.getHeight();

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
            mViewHeight = savedInstanceState.getInt(PUNCHLINE_VIEW_HEIGHT_KEY);
            mJokePunchlineTextView.setVisibility(View.VISIBLE);
            if (mPunchlineRevealed) {
                animateButtonObject(100);

            }
        }
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mPunchlineRevealed) {
                    animateButtonObject(1000);
                } else {
                    finish();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(JOKE_STRING_SETUP_KEY, mJokeSetupString);
        outState.putString(JOKE_STRING_PUNCHLINE_KEY, mJokePunchlineString);
        outState.putBoolean(PUNCHLINE_REVEALED_KEY, mPunchlineRevealed);
        outState.putInt(PUNCHLINE_VIEW_HEIGHT_KEY, mViewHeight);

    }
    public void animateButtonObject(int duration) {
        Log.d(TAG, "Animating button");
        mButton.clearAnimation();
        ObjectAnimator animX = ObjectAnimator.ofFloat(mButton, "translationY", mViewHeight+EXTRA_HEIGHT_ANIMATE);
        animX.setStartDelay(100);
        animX.setDuration(duration);
        animX.start();
        mJokePunchlineTextView.setVisibility(View.VISIBLE);
        animX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mButton.setText(getResources().getString(R.string.button_joke_done));
                mPunchlineRevealed = true;
            }

            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }
}
