package com.udacity.gradle.builditbigger.free;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.duvernea.jokedisplay.JokeDisplayActivity;
import com.example.duvernea.myapplication.backend.myApi.model.MyBean;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.GetEndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = MainActivityFragment.class.getSimpleName();

    private Context mContext;

    private Button mJokeButton;
    private MyBean mJoke;
    private boolean adLoaded=false;

    private ProgressBar mProgressBar;

    InterstitialAd mInterstitialAd;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mContext = getActivity();
        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar1);
        mProgressBar.setVisibility(View.GONE);

        mInterstitialAd = new InterstitialAd(mContext);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.banner_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Log.d(TAG, "Ad closed");
                if (mJoke != null) {
                    startNewActivity(mJoke);
                } else {
                    // joke string still not retrieved.
                    // app will continue waiting for async to finish, then start new activity in onComplete
                    adLoaded = false;
                }
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                adLoaded = false;
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                adLoaded = true;

            }
        });
        requestNewInterstitial();


        mJokeButton = (Button) root.findViewById(R.id.tell_joke_button);


        mJokeButton.setOnClickListener(new View.OnClickListener() {
            // TODO - CHECK NETWORK CONNECTIVITY
            @Override
            public void onClick(View v) {
                if (adLoaded) {
                    mProgressBar.setVisibility(View.GONE);
                    mInterstitialAd.show();
                }
                GetEndpointsAsyncTask task = new GetEndpointsAsyncTask();
                task.setListener(new GetEndpointsAsyncTask.GetEndpointsTaskListener() {
                    @Override
                    public void onComplete(MyBean joke, Exception e) {
                        mJoke = joke;
                        if (!adLoaded) {
                            startNewActivity(joke);
                        }
                    }
                });
                task.execute(new Pair<Context, String>(mContext, ""));
                mProgressBar.setVisibility(View.VISIBLE);



            }
        });
        // Log.d(TAG, "Java return int: " + a);


        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);


        return root;
    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("09D2B50A10F6ADFF6D26D972FD91F05C")
                //.addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
    private void startNewActivity(MyBean joke) {
        mProgressBar.setVisibility(View.GONE);
        Intent intent = new Intent(mContext, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.JOKE_SETUP, joke.getSetup());
        intent.putExtra(JokeDisplayActivity.JOKE_PUNCHLINE, joke.getPunchline());
        mProgressBar.setVisibility(View.GONE);
        startActivity(intent);
    }
}

