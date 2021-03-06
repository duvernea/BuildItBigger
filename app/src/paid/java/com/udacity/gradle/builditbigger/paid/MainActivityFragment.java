package com.udacity.gradle.builditbigger.paid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.duvernea.jokedisplay.JokeDisplayActivity;
import com.example.duvernea.myapplication.backend.myApi.MyApi;


import com.example.duvernea.myapplication.backend.myApi.model.MyBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.GetEndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;

import java.io.IOException;



/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = MainActivityFragment.class.getSimpleName();

    private Context mContext;

    private Button mJokeButton;
    private ProgressBar mProgressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mContext = getActivity();
        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar1);
        mProgressBar.setVisibility(View.GONE);

        mJokeButton = (Button) root.findViewById(R.id.tell_joke_button);

        mJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo netInfo = cm.getActiveNetworkInfo();
                if (netInfo != null && netInfo.isConnectedOrConnecting()) {

                    GetEndpointsAsyncTask task = new GetEndpointsAsyncTask();
                    task.setListener(new GetEndpointsAsyncTask.GetEndpointsTaskListener() {
                        @Override
                        public void onComplete(MyBean joke, Exception e) {
                            Intent intent = new Intent(mContext, JokeDisplayActivity.class);
                            intent.putExtra(JokeDisplayActivity.JOKE_SETUP, joke.getSetup());
                            intent.putExtra(JokeDisplayActivity.JOKE_PUNCHLINE, joke.getPunchline());
                            mProgressBar.setVisibility(View.GONE);
                            startActivity(intent);
                        }
                    });
                    task.execute(new Pair<Context, String>(mContext, ""));
                    mProgressBar.setVisibility(View.VISIBLE);
                }
                else {
                    Toast.makeText(mContext, getResources().getString(R.string.no_network_message), Toast.LENGTH_LONG).show();
                }
            }
        });
        return root;
    }
}

