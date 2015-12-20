package com.udacity.gradle.builditbigger.free;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.duvernea.jokedisplay.JokeDisplayActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.GetEndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = MainActivityFragment.class.getSimpleName();

    private Context mContext;

    private Button mJokeButton;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mContext = getActivity();

        mJokeButton = (Button) root.findViewById(R.id.tell_joke_button);


        mJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetEndpointsAsyncTask task = new GetEndpointsAsyncTask();
                task.setListener(new GetEndpointsAsyncTask.GetEndpointsTaskListener() {
                    @Override
                    public void onComplete(String joke, Exception e) {
                        Intent intent = new Intent(mContext, JokeDisplayActivity.class);
                        intent.putExtra(JokeDisplayActivity.JOKE_EXTRA, joke);
                        startActivity(intent);
                    }
                });
                task.execute(new Pair<Context, String>(mContext, "Why did the chicken cross the road?"));

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
}
