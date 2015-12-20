package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.duvernea.jokedisplay.JokeDisplayActivity;
import com.example.duvernea.myapplication.backend.myApi.MyApi;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = MainActivity.class.getSimpleName();

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

//    class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
//        private MyApi myApiService = null;
//        private Context context;
//
//        private GetEndpointsTaskListener
//
//        public interface GetEndpointsTaskListener {
//
//        }
//
//        @Override
//        protected String doInBackground(Pair<Context, String>... params) {
//            if(myApiService == null) {  // Only do this once
//                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
//                        .setRootUrl("https://builditbigger-1155.appspot.com/_ah/api/");
//                // end options for devappserver
//
//                myApiService = builder.build();
//            }
//
//            context = params[0].first;
//            String name = params[0].second;
//
//            try {
//                return myApiService.getJoke(name).execute().getData();
//            } catch (IOException e) {
//                Log.d(TAG, "Exception: " + e.getMessage());
//                return e.getMessage();
//            }
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            Intent intent = new Intent(mContext, JokeDisplayActivity.class);
//            intent.putExtra(JokeDisplayActivity.JOKE_EXTRA, result);
//            startActivity(intent);
//
//        }
//    }

}
